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

//    private final RebelServices rebeldeService;
//
//    public String getTraidores() throws IOException {
//        var qtdeRebeldes = rebeldeService.listAll().
//        var qtdeTraidores = (double) rebeldeService.listAll().stream()
//                .filter(Rebel::getIsTraitorEnum).collect(Collectors.toList()).size();
//        var traidoresPercent = (qtdeTraidores*100)/(qtdeRebeldes);
//        return String.format("Porcentagem de traidores: %.2f%%", traidoresPercent);
//    }
//
//    public String getRebeldes() throws IOException {
//        var rebeldePercent = 100 - getTraidores;
//        return String.format("Porcentagem de rebeldes: %.2f%%", rebeldePercent);
//    }
//
//    public String pontosReport() throws IOException {
//        List<Rebelde> listaTraidores = rebeldeService.listAll().stream()
//                .filter(Rebelde::isTraitor).collect(Collectors.toList());
//        int pontosPerdidos = 0;
//        for (Rebelde rebelde : listaTraidores) {
//            pontosPerdidos += rebeldeService.valorInventario(rebelde.getInventario());
//        }
//        return "Foram perdidos "+pontosPerdidos+" pontos devido a traidores";
//    }
//
//    public String recursosReport() throws IOException {
//        List<Rebelde> listaRebeldes = rebeldeService.listAll().stream()
//                .filter(Rebelde -> !Rebelde.isTraitor()).collect(Collectors.toList());
//        float mediaArma = 0, mediaMunicao = 0, mediaAgua = 0, mediaComida = 0;
//        for (Rebelde rebelde : listaRebeldes) {
//            mediaArma += rebelde.getInventario().getArma();
//            mediaMunicao += rebelde.getInventario().getMunicao();
//            mediaAgua += rebelde.getInventario().getAgua();
//            mediaComida += rebelde.getInventario().getComida();
//        }
//        var listSize = listaRebeldes.size();
//        mediaArma /= listSize;
//        mediaMunicao /= listSize;
//        mediaAgua /= listSize;
//        mediaComida /= listSize;
//        return String.format("Relatório de items:\n%.2f armas por rebelde,\n" +
//                        "%.2f munições por rebelde,\n%.2f aguas por rebelde,\n%.2f comidas por rebelde."
//                ,mediaArma,mediaMunicao,mediaAgua,mediaComida);
//    }
}
