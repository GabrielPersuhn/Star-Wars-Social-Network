package br.com.letscode.java.star_wars_resistence.Rebel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdInvalidoException extends RuntimeException {
    public IdInvalidoException(String id) {
        super("O id " + id + " informado não consta no nosso banco de dados ou é um traidor");
    }

}
