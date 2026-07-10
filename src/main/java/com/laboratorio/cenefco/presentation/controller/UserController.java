package com.laboratorio.cenefco.presentation.controller;

import com.laboratorio.cenefco.application.dto.request.CreateUserRequestDto;
import com.laboratorio.cenefco.application.dto.request.UpdateUserRequestDto;
import com.laboratorio.cenefco.application.dto.response.CreateUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.InformationUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.UpdateUserResponseDto;
import com.laboratorio.cenefco.application.usecase.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.laboratorio.cenefco.infrastructure.util.ResponseBody;

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
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<ResponseBody<CreateUserResponseDto>> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        CreateUserResponseDto user = userService.createUser(createUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseBody.ok("El usuario creado exitosamente", user));
    }

    @GetMapping("/list-information-user")
    public ResponseEntity<ResponseBody<List<InformationUserResponseDto>>> listUser(){
        List<InformationUserResponseDto> user = userService.getInformationUser();
        return ResponseEntity.ok(ResponseBody.ok("Lista de usuario obtenida exitosamente", user));
    }

    @PutMapping("/delete-user/{id}")
    public ResponseEntity<ResponseBody<Boolean>> deleteUser(@PathVariable("id") Long id ){
        Boolean result = userService.deletedUser(id);
        return ResponseEntity.ok(ResponseBody.ok("Usuario eliminado", result));
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<ResponseBody<UpdateUserResponseDto>> updateUser(@PathVariable("id") Long id,
                                                                          @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        UpdateUserResponseDto updateUser = userService.updateUser(id, updateUserRequestDto);
        return ResponseEntity.ok(ResponseBody.ok("Usuario actualizado correctamente", updateUser));
    }

    @PutMapping("/verification-user/{password}/{email}")
    public ResponseEntity<ResponseBody<Boolean>> existUser(
            @PathVariable String password,
            @PathVariable String email) {

        Boolean user = userService.existUser(email, password);
        return ResponseEntity.ok(ResponseBody.ok("Verificación usuario", user));
    }
}
