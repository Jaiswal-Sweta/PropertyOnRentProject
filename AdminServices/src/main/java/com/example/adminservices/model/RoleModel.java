package com.example.adminservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int role_id;

    @Column(nullable = false)
    private String role_name;
}
