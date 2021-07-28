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

    private final RebelRepository rebelRepository;

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

    private void transferenciaRecursos(Optional<Rebel> rebeldeUm, Recursos listaDoRebeldeUm, Optional<Rebel> rebeldeDois, Recursos listaDoRebeldeDois){
        recursosRebeldeUm(rebeldeUm, listaDoRebeldeUm, listaDoRebeldeDois);
        recursosRebeldeDois(listaDoRebeldeUm, rebeldeDois, listaDoRebeldeDois);
    }

    private void recursosRebeldeDois(Recursos listaDoRebeldeUm, Optional<Rebel> rebeldeDois, Recursos listaDoRebeldeDois) {
        rebeldeDois.get().getRecursos().setAgua(Math.toIntExact(rebeldeDois.get().getRecursos().getAgua()
                + listaDoRebeldeUm.getAgua() - listaDoRebeldeDois.getAgua()));
        rebeldeDois.get().getRecursos().setArma(Math.toIntExact(rebeldeDois.get().getRecursos().getArma()
                + listaDoRebeldeUm.getArma() - listaDoRebeldeDois.getArma()));
        rebeldeDois.get().getRecursos().setMunicao(Math.toIntExact(rebeldeDois.get().getRecursos().getMunicao()
                + listaDoRebeldeUm.getMunicao() - listaDoRebeldeDois.getMunicao()));
        rebeldeDois.get().getRecursos().setComida(Math.toIntExact(rebeldeDois.get().getRecursos().getComida()
                + listaDoRebeldeUm.getComida() - listaDoRebeldeDois.getComida()));
    }

    private void recursosRebeldeUm(Optional<Rebel> rebeldeUm, Recursos listaDoRebeldeUm, Recursos listaDoRebeldeDois) {
        rebeldeUm.get().getRecursos().setAgua(Math.toIntExact(rebeldeUm.get().getRecursos().getAgua()
                - listaDoRebeldeUm.getAgua() + listaDoRebeldeDois.getAgua()));
        rebeldeUm.get().getRecursos().setArma(Math.toIntExact(rebeldeUm.get().getRecursos().getArma()
                - listaDoRebeldeUm.getArma() + listaDoRebeldeDois.getArma()));
        rebeldeUm.get().getRecursos().setMunicao(Math.toIntExact(rebeldeUm.get().getRecursos().getMunicao()
                - listaDoRebeldeUm.getMunicao() + listaDoRebeldeDois.getMunicao()));
        rebeldeUm.get().getRecursos().setComida(Math.toIntExact(rebeldeUm.get().getRecursos().getComida()
                - listaDoRebeldeUm.getComida() + listaDoRebeldeDois.getComida()));
    }

}
