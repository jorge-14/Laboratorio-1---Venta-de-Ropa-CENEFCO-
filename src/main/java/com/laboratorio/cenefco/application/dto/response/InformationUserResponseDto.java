package com.laboratorio.cenefco.application.dto.response;

import com.laboratorio.cenefco.domain.model.User;
import lombok.*;

import java.time.LocalDateTime;

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
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationUserResponseDto {

    private Long id;
    private String name;
    private String surnamePaternal;
    private String surnameMaternal;
    private String ci;
    private String email;
    private String password;
    private String roleUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;

    public InformationUserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surnamePaternal = user.getSurnamePaternal();
        this.surnameMaternal = user.getSurnameMaternal();
        this.ci = user.getCi();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleUser = user.getRoleUser();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deleted = user.getDeleted();
    }
}
