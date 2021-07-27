package br.com.letscode.java.star_wars_resistence.Inventario;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class Recursos {

    @NotEmpty
    private int arma;

    @NotEmpty
    private int municao;

    @NotEmpty
    private int agua;

    @NotEmpty
    private int comida;

    @Override
    public String toString() {
        return "Armas: " + arma + "," +
                "Municao: " + municao + "," +
                "Aguas: " + agua + "," +
                "Comidas: " + comida;
    }

    public int getScoreArma(){
        return this.arma * 4;
    }

    public int getScoreMunicao(){
        return this.municao * 3;
    }

    public int getScoreAgua(){
        return this.agua * 2;
    }

    public int getScoreComida(){
        return this.comida;
    }

}
