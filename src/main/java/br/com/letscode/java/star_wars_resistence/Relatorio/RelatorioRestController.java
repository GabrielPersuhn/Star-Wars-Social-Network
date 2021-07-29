package br.com.letscode.java.star_wars_resistence.Relatorio;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/relatorio")
public class RelatorioRestController {

    private final RelatorioService relatorioService;

    @SneakyThrows
    @GetMapping("/relatorio/traidores")
    public String traidores() {
        return relatorioService.getTraidores();
    }

    @SneakyThrows
    @GetMapping("/relatorio/rebeldes")
    public String rebeldes() {
        return relatorioService.getRebeldes();
    }

    @SneakyThrows
    @GetMapping("/relatorio/mediaRecursos")
    public String mediaRecursos() {
        return relatorioService.mediaRecursos();
    }

    @SneakyThrows
    @GetMapping("/relatorio/pontosPerdidos")
    public String pontosPerdidos() {
        return "O numero de pontos perdidos é: " + relatorioService.scorePerdidos();
    }

}
