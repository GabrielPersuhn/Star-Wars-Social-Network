package br.com.letscode.java.star_wars_resistence.Reporte;

import br.com.letscode.java.star_wars_resistence.Rebel.IsTraitorEnum;
import br.com.letscode.java.star_wars_resistence.Rebel.Rebel;
import br.com.letscode.java.star_wars_resistence.Rebel.RebelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final RebelRepository rebeldeRepository;

    public String reportarRebelde(Reporte reporte) throws IOException {
        List<Rebel> rebeldesList = rebeldeRepository.listAll();
        //if (checarSeJaFoiReportado(reporte)){
       //    throw new RebeldeReportadoAnteriormenteException(reportar.getIdTraidor());
        //}
        for (Rebel rebelde : rebeldesList) {
            if (reporte.getIdTraidor().equals(rebelde.getId())) {
                rebelde.setReports(rebelde.getReports() + 1);
                if (rebelde.getReports() == 3) {
                    rebelde.setIsTraitorEnum(IsTraitorEnum.TRAITOR);
                }
            }
        }
        //rebeldeRepository.reescreverArquivo(rebeldesList);
        //inserirArquivo(reportar);
        return "rebelde reportado.";
    }

}
