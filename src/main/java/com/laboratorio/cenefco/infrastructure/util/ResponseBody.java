package com.laboratorio.cenefco.infrastructure.util;

import lombok.*;

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
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> {

    private String code = "000";
    private String message;
    private T data;

    public static <T> ResponseBody<T> ok(T data) {
        return ResponseBody.<T>builder()
                .code("000")
                .message("Operación exitosa")
                .data(data)
                .build();
    }

    public static <T> ResponseBody<T> ok(String message, T data) {
        return ResponseBody.<T>builder()
                .code("000")
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseBody<T> error(String code, String message) {
        return ResponseBody.<T>builder()
                .code(code)
                .message(message)
                .build();
    }
}
