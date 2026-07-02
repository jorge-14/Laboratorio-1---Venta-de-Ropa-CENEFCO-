package com.laboratorio.cenefco.infrastructure.util;

import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePage<T> {

    private List<T> content;
    private Pageable pageable;
    private boolean last;
    private int totalPages;
    private long totalElements;
    private Sort sort;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    private boolean empty;
}
