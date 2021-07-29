package br.com.letscode.java.star_wars_resistence.Relatorio;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Rebel.Rebel;
import br.com.letscode.java.star_wars_resistence.Rebel.RebelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final RebelServices rebeldeService;

    public String getTraidores() throws IOException {
        var qtdeTraidores = rebeldeService.filtrarTraidores().size();
        long traidoresPercent = (qtdeTraidores* 100L)/(rebeldeService.listAll().size());
        return "Porcentagem de traidores: " + traidoresPercent + "%";
    }

    public String getRebeldes() throws IOException {
        var qtdeRebelde = rebeldeService.filtrarRebeldes().size();
        long rebeldePercent = (qtdeRebelde* 100L)/(rebeldeService.listAll().size());
        return String.format("Porcentagem de rebeldes: %.2f%%", rebeldePercent);
    }

    public String mediaRecursos() throws IOException {
        var rebelList = rebeldeService.filtrarRebeldes();

        int qtdeArma = 0;
        int qtdeMunicao = 0;
        int qtdeComida = 0;
        int qtdeAgua = 0;

        for (Rebel rebel : rebelList) {
            qtdeAgua += rebel.getRecursos().getAgua();
            qtdeArma += rebel.getRecursos().getArma();
            qtdeComida += rebel.getRecursos().getComida();
            qtdeMunicao += rebel.getRecursos().getMunicao();
        }

        long mediaArma = qtdeArma / rebeldeService.listAll().size();
        long mediaMunicao = qtdeMunicao / rebeldeService.listAll().size();
        long mediaComida = qtdeComida / rebeldeService.listAll().size();
        long mediaAgua = qtdeAgua / rebeldeService.listAll().size();


        return String.format("Média de Arma: %.2d \n " +
                "Media de Munição: %.2d \n" +
                "Media de Comida: %.2d \n" +
                "Media de Água: %.2d", mediaArma, mediaMunicao, mediaComida, mediaAgua);
    }

    public int scorePerdidos() throws IOException {
        var traitorList = rebeldeService.filtrarTraidores();
        var recursosPerdidos = new Recursos();

        int qtdeArma = 0;
        int qtdeMunicao = 0;
        int qtdeComida = 0;
        int qtdeAgua = 0;

        for (Rebel rebel : traitorList) {
            qtdeAgua += rebel.getRecursos().getAgua();
            qtdeArma += rebel.getRecursos().getArma();
            qtdeComida += rebel.getRecursos().getComida();
            qtdeMunicao += rebel.getRecursos().getMunicao();
        }

        recursosPerdidos.setArma(qtdeArma);
        recursosPerdidos.setMunicao(qtdeMunicao);
        recursosPerdidos.setAgua(qtdeAgua);
        recursosPerdidos.setComida(qtdeComida);

        return recursosPerdidos.getScore();
    }

}
