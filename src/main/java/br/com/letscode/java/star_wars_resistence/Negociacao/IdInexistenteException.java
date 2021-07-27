package br.com.letscode.java.star_wars_resistence.Negociacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdInexistenteException extends RuntimeException {
    public IdInexistenteException() {
        super("Não há rebeldes com esse nome !");
    }

}
