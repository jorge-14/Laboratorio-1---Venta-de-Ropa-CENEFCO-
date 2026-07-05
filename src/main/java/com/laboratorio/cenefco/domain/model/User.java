package com.laboratorio.cenefco.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

/*
 *----------------------------------------
 *   Código de Aplicación:
 *   Código de Objeto:
 *   Descripción:
 *   Author Prog: Jorge Luis Choque Callizaya
 *----------------------------------------
 *   Fecha | Autor | Comentario
 *   04.07.2026 | Jorge Luis Choque Callizaya | Creación Inicial
 *----------------------------------------
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AuditableEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_USER_ID_GENERATOR", sequenceName = "SEQ_USER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ID_GENERATOR")
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "surname_paternal", nullable = false)
    private String surnamePaternal;

    @Basic
    @Column(name = "surname_maternal", nullable = false)
    private String surnameMaternal;

    @Basic
    @Column(nullable = false)
    private String ci;

    @Basic
    @Column(nullable = false)
    private String email;

    @Basic
    @Column(nullable = false)
    private String password;

    @Basic
    @Column(name = "role_user")
    private String roleUser;
}
