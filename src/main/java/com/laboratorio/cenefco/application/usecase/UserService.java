package com.laboratorio.cenefco.application.usecase;

import com.laboratorio.cenefco.application.dto.request.CreateUserRequestDto;
import com.laboratorio.cenefco.application.dto.request.UpdateUserRequestDto;
import com.laboratorio.cenefco.application.dto.response.CreateUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.InformationUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.UpdateUserResponseDto;

import java.util.List;

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
public interface UserService {

    CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
    List<InformationUserResponseDto> getInformationUser();
    Boolean deletedUser(Long id);
    UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto);
    Boolean existUser(String email, String password);
}
