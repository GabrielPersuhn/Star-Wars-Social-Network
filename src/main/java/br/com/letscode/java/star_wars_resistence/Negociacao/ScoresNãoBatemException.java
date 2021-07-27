package br.com.letscode.java.star_wars_resistence.Negociacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ScoresNaoBatemException extends RuntimeException{
    public ScoresNaoBatemException() {
        super("As pontuações nessa negociação não estão adequadas! \n " +
                "Confira a pontuação de cada item: \n" +
                "Arma -> 4 pontos\n" +
                "Munição -> 3 pontos\n" +
                "Água -> 2 pontos\n" +
                "Comida -> 1 ponto");
    }

}
