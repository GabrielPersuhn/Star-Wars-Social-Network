package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class RebelRepository {
    private final String caminho = "src/main/resources/dados/rebelde.csv";

    private Path pathRebeldes;

    @PostConstruct
    public void init() {
        try {
            pathRebeldes = Paths.get(caminho);
            if (!pathRebeldes.toFile().exists()) {
                Files.createFile(pathRebeldes);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Rebel inserirArquivo(Rebel rebelde) throws IOException {
        write(format(rebelde), StandardOpenOption.APPEND);
        return rebelde;
    }

    private Rebel converterLinhaParaRebel(String linha) {
        StringTokenizer token = new StringTokenizer(linha, ",");
        var rebelde = Rebel.builder()
                .id(token.nextToken())
                .nome(token.nextToken())
                .generoEnum(GeneroEnum.valueOf(token.nextToken()))
                .idade(Integer.valueOf(token.nextToken()))
                .reports(Integer.valueOf(token.nextToken()))
                .isTraitorEnum(IsTraitorEnum.valueOf(token.nextToken()))
                .localizacao(Localizacao.builder()
                        .latitude(Long.valueOf(token.nextToken()))
                        .longitude(Long.valueOf(token.nextToken()))
                        .BaseNaGalaxia(token.nextToken())
                        .build())
                .recursos((Recursos.builder())
                        .arma(Integer.parseInt(token.nextToken()))
                        .municao(Integer.parseInt(token.nextToken()))
                        .agua(Integer.parseInt(token.nextToken()))
                        .comida(Integer.parseInt(token.nextToken()))
                        .build())
                .build();
//        List<Recursos> recursosList = new ArrayList<>();
//        while (token.hasMoreTokens()) {
//            var recursos = Recursos.builder()
//                    .arma(Integer.parseInt(token.nextToken()))
//                    .municao(Integer.parseInt(token.nextToken()))
//                    .agua(Integer.parseInt(token.nextToken()))
//                    .comida(Integer.parseInt(token.nextToken()))
//                    .build();
//            recursosList.add(recursos);
//        }
//        rebelde.setRecursos(recursosList);
        return rebelde;
    }

    private String format(Rebel rebelde) {
        return String.format("%s,%s,%d,%s,%d,%s,%s,%s\r\n",
                rebelde.getId(),
                rebelde.getNome(),
                rebelde.getIdade(),
                rebelde.getGeneroEnum(),
                rebelde.getReports(),
                rebelde.getIsTraitorEnum(),
                rebelde.getLocalizacao(),
                rebelde.getRecursos().toString().replace("[", "").trim().replace("]", "").trim());
    }

    private void write(String clienteStr, StandardOpenOption option) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(pathRebeldes, option)) {
            bf.flush();
            bf.write(clienteStr);
        }
    }

    public List<Rebel> listAll() throws IOException {
        List<Rebel> rebeldes;
        try (BufferedReader br = Files.newBufferedReader(pathRebeldes)) {
            rebeldes = br.lines().filter(Objects::nonNull)
                    .filter(Predicate.not(String::isEmpty))
                    .map(this::converterLinhaParaRebel)
                    .collect(Collectors.toList());
        }
        return rebeldes;
    }

    public void reescreverArquivo(List<Rebel> listaRebeldes) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (Rebel rebeldeBuilder : listaRebeldes) {
            builder.append(format(rebeldeBuilder));
        }
        write(builder.toString(), StandardOpenOption.CREATE);
    }

}
