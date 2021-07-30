package br.com.letscode.java.star_wars_resistence.Negociacao;

public class RebeldeSemRecursosException extends RuntimeException {
    public RebeldeSemRecursosException(){
        super("Atenção ! Um dos rebelde inseridos não possui tais itens em seu inventário. " +
                "Por favor, verifique se a lista de recursos de cada rebelde, e tente novamente :)");
    }
}
