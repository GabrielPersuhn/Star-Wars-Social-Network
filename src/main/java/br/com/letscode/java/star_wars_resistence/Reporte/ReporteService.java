package br.com.letscode.java.star_wars_resistence.Reporte;

import br.com.letscode.java.star_wars_resistence.Rebel.IsTraitorEnum;
import br.com.letscode.java.star_wars_resistence.Rebel.Rebel;
import br.com.letscode.java.star_wars_resistence.Rebel.RebelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final RebelRepository rebelRepository;

    public String reportarRebelde(String id) throws IOException {
        List<Rebel> listaRebeldes = rebelRepository.listAll();
        Optional<Rebel> rebeldesList = listaRebeldes
                .stream()
                .filter(rebeldeSearch -> rebeldeSearch.getId().equals(id))
                .findFirst();

        if (rebeldesList.isEmpty()){
            throw new RebeldeInexistenteException();

        } else if (rebeldesList.get().getIsTraitorEnum().equals(IsTraitorEnum.TRAITOR)){
            throw new RebeldeJaTraidorException();

        } else {
            rebeldesList.get().setReports(rebeldesList.get().getReports() + 1);

            if (rebeldesList.get().getReports() == 3) {
                rebeldesList.get().setIsTraitorEnum(IsTraitorEnum.TRAITOR);
            }
        }
        rebelRepository.reescreverArquivo(listaRebeldes);
        return "Rebelde reportado com sucesso !";
    }

}
