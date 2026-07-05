package com.laboratorio.cenefco.application.dto.response;

import com.laboratorio.cenefco.domain.model.User;
import lombok.*;

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
public class UpdateUserResponseDto {

    private Long id;
    private String name;
    private String surnamePaternal;
    private String surnameMaternal;
    private String ci;
    private String email;
    private String password;

    public UpdateUserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surnamePaternal = user.getSurnamePaternal();
        this.surnameMaternal = user.getSurnameMaternal();
        this.ci = user.getCi();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
