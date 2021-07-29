package br.com.letscode.java.star_wars_resistence.Inventario;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    public int getScore() {
        int agua = this.getAgua();
        int arma = this.getArma();
        int comida = this.getComida();
        int municao = this.getMunicao();
        return ((agua * 2) + (arma * 4) + (municao * 3) + comida);
    }

    @Override
    public String toString() {
        return arma + "," +
                municao + "," +
                agua + "," +
                comida;
    }

}
