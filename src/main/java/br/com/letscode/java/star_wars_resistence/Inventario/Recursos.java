package br.com.letscode.java.star_wars_resistence.Inventario;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class Recursos {

    @NotNull
    private Item item;

    @NotEmpty
    private int qtde;

    @Override
    public String toString() {
        return item + "," + qtde;
    }

//    public int getScoreArma(){
//        return this.arma * 4;
//    }
//
//    public int getScoreMunicao(){
//        return this.municao * 3;
//    }
//
//    public int getScoreAgua(){
//        return this.agua * 2;
//    }
//
//    public int getScoreComida(){
//        return this.comida;
//    }

}
