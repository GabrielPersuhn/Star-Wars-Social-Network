package br.com.letscode.java.star_wars_resistence.Inventario;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Item {

    ARMA("Arma"),
    MUNICAO("Munição"),
    AGUA("Água"),
    COMIDA("Comida");

    private final String description;


}
