package com.laboratorio.cenefco.domain.exception;

import lombok.Getter;

/*
 *----------------------------------------
 *   Código de Aplicación:
 *   Código de Objeto:
 *   Descripción:
 *   Author Prog: Jorge Luis Choque Callizaya
 *----------------------------------------
 *   Fecha | Autor | Comentario
 *   01.07.2026 | Jorge Luis Choque Callizaya | Creación Inicial
 *----------------------------------------
 */
@Getter
public class OperationException extends RuntimeException {

    private final String code;
    private final String message;

    public OperationException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public OperationException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
