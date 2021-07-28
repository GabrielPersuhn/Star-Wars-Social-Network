package br.com.letscode.java.star_wars_resistence.Inventario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recursos {

    @NotNull
    private int arma;
    @NotNull
    private int municao;
    @NotNull
    private int agua;
    @NotNull
    private int comida;

    @Override
    public String toString() {
        return arma + "," +
                municao + "," +
                agua + "," +
                comida;
    }

}
