package com.laboratorio.cenefco.infrastructure.persistence;

import com.laboratorio.cenefco.application.dto.request.CreateUserRequestDto;
import com.laboratorio.cenefco.application.dto.request.UpdateUserRequestDto;
import com.laboratorio.cenefco.application.dto.response.CreateUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.InformationUserResponseDto;
import com.laboratorio.cenefco.application.dto.response.UpdateUserResponseDto;
import com.laboratorio.cenefco.application.usecase.UserService;
import com.laboratorio.cenefco.domain.exception.OperationException;
import com.laboratorio.cenefco.domain.model.User;
import com.laboratorio.cenefco.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        try {

            User user = User.builder()
                    .name(createUserRequestDto.getName() != null ? createUserRequestDto.getName().trim() : null)
                    .surnamePaternal(createUserRequestDto.getSurnamePaternal())
                    .surnameMaternal(createUserRequestDto.getSurnameMaternal())
                    .ci(createUserRequestDto.getCi())
                    .email(createUserRequestDto.getEmail())
                    .password(createUserRequestDto.getPassword())
                    .roleUser(createUserRequestDto.getRoleUser())
                    .build();
            userRepository.save(user);

            return new CreateUserResponseDto(user);
        } catch (OperationException e) {
            log.info("Error al crear el usuario {}", e.getCode());
            throw e;
        } catch (Exception e) {
            log.info("Error al crear un usuario: {}", e.getMessage(), e);
            throw new OperationException("500", "Error al crear el usuario", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationUserResponseDto> getInformationUser() {
        try {
            List<InformationUserResponseDto> list = userRepository.listInformationUser();
            return list;
        } catch (OperationException e) {
            log.info("Error al obtener la lista {} {}", e.getCode(), e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error inesperado al lista los usuarios {}", e.getMessage(), e);
            throw new OperationException("500", "Error inesperado", e);
        }
    }

    @Override
    @Transactional
    public Boolean deletedUser(Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new OperationException("404", "Usuario no encontrado"));

            user.setDeleted(true);
            userRepository.save(user);
            return true;
        } catch (OperationException e) {
            log.error("Error controlado de eliminar {} {}", e.getCode(), e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {

        User userModel = userRepository.findById(id)
                .orElseThrow(() -> new OperationException("404", "Usuario no encontrado"));

        userModel.setName(updateUserRequestDto.getName());
        userModel.setSurnameMaternal(updateUserRequestDto.getSurnameMaternal());
        userModel.setSurnamePaternal(updateUserRequestDto.getSurnamePaternal());
        userModel.setCi(userModel.getCi());
        userModel.setEmail(userModel.getEmail());
        userModel.setPassword(userModel.getPassword());
        userModel.setRoleUser(userModel.getRoleUser());

        userRepository.save(userModel);

        return new UpdateUserResponseDto(userModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existUser(String email, String password) {
        return userRepository.existUser(email,password);
    }
}
