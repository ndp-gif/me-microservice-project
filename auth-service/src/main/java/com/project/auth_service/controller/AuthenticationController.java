package com.project.auth_service.controller;

import com.project.auth_service.dto.request.LoginRequestDTO;
import com.project.auth_service.dto.request.RegisterRequestDTO;
import com.project.auth_service.dto.response.AuthenticationResponseDTO;
import com.project.auth_service.dto.response.RegisterResponseDTO;
import com.project.auth_service.exception.CustomException;
import com.project.auth_service.user.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) throws Exception {
        RegisterResponseDTO registerResponseDTO = authenticationService.register(registerRequestDTO);
        return ResponseEntity.status(registerResponseDTO.getStatus()).body(registerResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequest) throws Exception {
        log.info("Password: {}", loginRequest.getPassword());
        log.info("Username: {}", loginRequest.getUsername());
        AuthenticationResponseDTO authenticationResponse = authenticationService.login(loginRequest);
        return ResponseEntity
                .status(authenticationResponse.getStatus())
                .body(authenticationResponse);
    }

    @PostMapping("/refresh-token")
    public AuthenticationResponseDTO refreshToken(HttpServletRequest req, HttpServletResponse resp) throws ValidationException, CustomException {
        return authenticationService.refreshToken(req,resp);
    }
}
