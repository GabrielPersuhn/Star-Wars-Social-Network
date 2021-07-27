package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class NegociacaoRepository {

    private Path pathNegociacao;

    @PostConstruct
    public void init() {
        try {
            String caminho = "src/main/resources/dados/negociacao.csv";
            pathNegociacao = Paths.get(caminho);
            if (!pathNegociacao.toFile().exists()) {
                Files.createFile(pathNegociacao);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void inserirArquivo(String id, List<Recursos> inventario) throws IOException {
        write(format(id, inventario), StandardOpenOption.APPEND);
    }

    private void write(String clienteStr, StandardOpenOption option) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(pathNegociacao, option)) {
            bf.flush();
            bf.write(clienteStr);
        }
    }

    public List<Recursos> listAll() throws IOException {
        List<Recursos> inventarios;
        try (BufferedReader br = Files.newBufferedReader(pathNegociacao)) {
            inventarios = br.lines().filter(Objects::nonNull)
                    .filter(Predicate.not(String::isEmpty))
                    .map(this::converterLinhaEmRecursos)
                    .collect(Collectors.toList());
        }
        return inventarios;
    }

    private String format(String id, List<Recursos> inventario) {
        return String.format("%s,%s\r\n",
                id,
                inventario.toString().replace("[", "").trim().replace("]", "").trim());
    }

    private Recursos converterLinhaEmRecursos(String linha) {
        // TODO converter linha em pontuação de recursos
        return null;
    }

    public void clearNegociacao() throws IOException {
        Files.newBufferedWriter(pathNegociacao , StandardOpenOption.TRUNCATE_EXISTING);
    }

}
