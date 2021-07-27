package br.com.letscode.java.star_wars_resistence.Negociacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class NegociacaoComTraitorException extends RuntimeException{
    public NegociacaoComTraitorException() {
        super("Há um traidor negociando!! Não permitiremos que traidores realizem nenhuma negociação! \n" +
                "Verifique o relatório de traidores para mais informações!");
    }

}
