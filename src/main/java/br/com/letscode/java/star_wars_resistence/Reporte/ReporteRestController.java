package br.com.letscode.java.star_wars_resistence.Reporte;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reportar")
public class ReporteRestController {

    private final ReporteService rebelService;

    @PostMapping
    public String reportarRebelde(@RequestParam Reporte idReportado) throws IOException {
        return rebelService.reportarRebelde(idReportado);
    }

}
