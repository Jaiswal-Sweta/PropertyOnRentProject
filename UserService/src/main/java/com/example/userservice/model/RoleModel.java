package com.example.userservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue
    private int roleId;
    private String roleName;
}
