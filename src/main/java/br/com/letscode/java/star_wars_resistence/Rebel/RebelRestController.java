package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/rebelde")
@RestController
@RequiredArgsConstructor
public class RebelRestController {

    private final RebelServices rebeldeService;

    @PostConstruct
    @GetMapping("/explicacaoAplicacao")
    public String explicacao() {
        return "EXPLICAÇÕES DA APLICAÇÃO:\n\n\n" +

                "Essa API REST foi desenvolvida para ajudar acompartilhar recursos entre a Resistência, " +
                "pensando na negociação entre os Rebeldes\n\n" +

                "Para adicionar um rebelde, acesse http://localhost:8080/rebelde e com um método Post, " +
                "insira as informações do novo integrante da resistência. :)\n" +
                "Cada rebelde deve ter um nome, idade, gênero, localização (latitude, longitude e nome da base ao qual faz parte). " +
                "além de seu inventário com os recursos em sua posse. \n\n" +
                "Para visualizar todos os rebeldes, com seus respectivos atributos, acesse http://localhost:8080/rebelde/listarTodos\n" +

                "Cada rebelde pode atualizar sua localização, para contatar a resistência caso precise de algo" +
                "Para atualizá-la, acesse http://localhost:8080/rebelde/{id}/atualizaLocal e insira sua nova localização. \n\n" +

                " Para negociar recursos, vocês rebeldes devem acessar http://localhost:8080/negociacao/ e inserir os recursos que desejam trocar." +
                "Vale lembrar que as trocas devem respeitar a pontuação de cada item, representada abaixo:\n" +

                "1 Arma 4 pontos\n" +
                "1 Munição 3 pontos\n" +
                "1 Água 2 pontos\n" +
                "1 Comida 1 ponto\n\n" +

                "Sabemos que alguns de nós podem se aliar ao Império, tornando se um TRAIDOR. Por isso, caso deseje, " +
                "você pode reportar um rebelde, para ajudar a resistência a identificar os traidores." +
                "Isso, é muito importante, porque caso um rebelde receba três reportes, " +
                "automaticamente nós o consideramos como um traidor, e bloqueamos todas as suas funcionalidades." +
                "Para reportar um rebelde, insira o respectivo id na requisição em http://localhost:8080/reportar \n\n  " +

                "Por fim, também é possível acessar 4 relatórios sobre a API. Eles são:\n" +

                "-> Porcentagem de traidores. --- Acesse http://localhost:8080/relatorio/traidores/\n" +
                "-> Porcentagem de rebeldes. --- Acesse http://localhost:8080/relatorio/rebeldes/\n" +
                "-> Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde). --- Acesse http://localhost:8080/relatorio/mediaRecursos/\n" +
                "-> Pontos perdidos devido a traidores. --- Acesse http://localhost:8080/relatorio/pontosPerdidos/\n\n" +

                "Aproveite a API e lembre-se de ajudar a Resistência nesta batalha. \n Que a força esteja com você !"
                ;
    }

    @GetMapping("/rebelde/listarTodos")
    public List<Rebel> listarTodos() throws IOException {
        return rebeldeService.listAll();
    }

    @PostMapping
    public Rebel adicionarRebelde(@Valid @RequestBody Rebel rebelde) throws IOException {
        return rebeldeService.createRebel(rebelde);
    }

    @PatchMapping("/{id}/atualizaLocal")
    public Optional<Rebel> atualizarLocalizacao(@PathVariable String id, @RequestBody Localizacao localizacao) throws IOException {
        return rebeldeService.updateLocalization(id, localizacao);
    }

}
