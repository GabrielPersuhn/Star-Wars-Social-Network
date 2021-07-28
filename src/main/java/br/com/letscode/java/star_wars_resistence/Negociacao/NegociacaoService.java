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

        Recursos itensDeTrocaRebeldeUm = negociacao.getFirstRecursos();
        Recursos itensDeTrocaRebeldeDois = negociacao.getSecondRecursos();

        Optional<Rebel> rebeldeUm = rebelRepository.listAll().stream()
                .filter(r -> r.getId().equals(negociacao.getFirstId()))
                .findFirst();

        Optional<Rebel> rebeldeDois = rebelRepository.listAll().stream()
                .filter(r -> r.getId().equals(negociacao.getSecondId()))
                .findFirst();

        if (rebeldeUm.isPresent() && rebeldeDois.isPresent()) {
            if (rebeldeUm.get().getIsTraitorEnum().equals(IsTraitorEnum.TRAITOR) ||
                    rebeldeDois.get().getIsTraitorEnum().equals(IsTraitorEnum.TRAITOR)) {
                throw new NegociacaoComTraitorException();
            }

            if (!negociacao.equalsScore()) {
                throw new ScoresDiferemException();
            }
            transferenciaRecursos(rebeldeUm, itensDeTrocaRebeldeUm, rebeldeDois, itensDeTrocaRebeldeDois);

            List<Rebel> itensTrocaUm = rebelRepository.listAll();
            List<Rebel> itensTrocaDois = rebelRepository.listAll();

            rebelRepository.reescreverArquivo(itensTrocaUm);
            rebelRepository.reescreverArquivo(itensTrocaDois);

            return "Negociação dos itens realizada com sucesso !";
        }
        throw new IdInexistenteException();
    }

    private void transferenciaRecursos(Optional<Rebel> rebelde1, Recursos listaDoRebelde1, Optional<Rebel> rebelde2, Recursos listaDoRebelde2){
        rebelde1.get().getRecursos().setAgua(Math.toIntExact(rebelde1.get().getRecursos().getAgua() + listaDoRebelde2.getAgua() - listaDoRebelde1.getAgua()));
        rebelde1.get().getRecursos().setMunicao(Math.toIntExact(rebelde1.get().getRecursos().getMunicao() + listaDoRebelde2.getMunicao() - listaDoRebelde1.getMunicao()));
        rebelde1.get().getRecursos().setComida(Math.toIntExact(rebelde1.get().getRecursos().getComida() + listaDoRebelde2.getComida() - listaDoRebelde1.getComida()));
        rebelde1.get().getRecursos().setArma(Math.toIntExact(rebelde1.get().getRecursos().getArma() + listaDoRebelde2.getArma() - listaDoRebelde1.getArma()));

        rebelde2.get().getRecursos().setAgua(Math.toIntExact(rebelde2.get().getRecursos().getAgua() + listaDoRebelde1.getAgua() - listaDoRebelde2.getAgua()));
        rebelde2.get().getRecursos().setArma(Math.toIntExact(rebelde2.get().getRecursos().getArma() + listaDoRebelde1.getArma() - listaDoRebelde2.getArma()));
        rebelde2.get().getRecursos().setMunicao(Math.toIntExact(rebelde2.get().getRecursos().getMunicao() + listaDoRebelde1.getMunicao() - listaDoRebelde2.getMunicao()));
        rebelde2.get().getRecursos().setComida(Math.toIntExact(rebelde2.get().getRecursos().getComida() + listaDoRebelde1.getComida() - listaDoRebelde2.getComida()));

    }

}
