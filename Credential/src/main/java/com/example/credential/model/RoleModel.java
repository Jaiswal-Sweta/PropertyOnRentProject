package com.example.credential.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue
    private int roleId;
    private String roleName;
}
