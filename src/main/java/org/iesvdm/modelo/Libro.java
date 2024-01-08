package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
}
