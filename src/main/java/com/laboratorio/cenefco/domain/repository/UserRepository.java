package com.laboratorio.cenefco.domain.repository;

import com.laboratorio.cenefco.application.dto.response.InformationUserResponseDto;
import com.laboratorio.cenefco.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
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
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT NEW com.laboratorio.cenefco.application.dto.response.InformationUserResponseDto(u) " +
            "FROM User u " +
            "WHERE u.deleted = false ")
    List<InformationUserResponseDto> listInformationUser();

}
