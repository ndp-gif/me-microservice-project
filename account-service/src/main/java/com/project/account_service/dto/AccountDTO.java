package com.project.account_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String role;
    private String departmentName;
    private int departmentId;
}
