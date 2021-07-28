package br.com.letscode.java.star_wars_resistence.Reporte;

public class RebeldeInexistenteException extends RuntimeException {
    public RebeldeInexistenteException() {
        super("O rebelde informado não existe no nosso banco de dados");
    }
}
