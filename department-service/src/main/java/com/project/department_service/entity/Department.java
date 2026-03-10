package com.project.department_service.entity;

import com.project.department_service.utils.DepartmentType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
@Getter
public class Department extends Abstract<Integer> implements Serializable {

    @Column(name = "name",length = 100, unique = true, nullable = false)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "type", columnDefinition = "ENUM('DEV','TEST','SCRUM_MASTER','PM')")
    @Enumerated(EnumType.STRING)
    private DepartmentType type;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
