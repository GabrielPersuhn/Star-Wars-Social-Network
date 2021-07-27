package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Rebel.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NegociacaoService {

    private final RebelServices rebeldeService;

    public String negociacaoDeItens(Negociacao negociacao) throws IOException {

        Recursos itensDeTrocaRebelde1 = negociacao.getFirstRecursos();
        Recursos itensDeTrocaRebelde2 = negociacao.getSecondRecursos();

        Optional<Rebel> rebelde1 = rebeldeService.listAll().stream()
                .filter(r -> r.getId().equals(negociacao.getFirstId()))
                .findFirst();
        Optional<Rebel> rebelde2 = rebeldeService.listAll().stream()
                .filter(r -> r.getId().equals(negociacao.getSecondId()))
                .findFirst();

        if (rebelde1.isPresent() && rebelde2.isPresent()) {
            if (rebelde1.get().getIsTraitorEnum().equals(IsTraitorEnum.TRAITOR) ||
                    rebelde2.get().getIsTraitorEnum().equals(IsTraitorEnum.TRAITOR)) {
                throw new NegociacaoComTraitorException();
            }
            if (negociacao.equalsScore()) {
                throw new ScoresNaoBatemException();
            }
            return "Negociação dos itens realizada com sucesso !";
        }
        throw new IdInexistenteException();
    }

}
