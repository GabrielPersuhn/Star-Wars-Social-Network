package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RebelServices {

    private final RebelRepository rebeldeRepository;

    public Rebel createRebel(Rebel rebelde) throws IOException {
        rebelde.setId(UUID.randomUUID().toString());
        rebelde.setIsTraitorEnum(isTraitorEnum.REBEL);
        return rebeldeRepository.inserirArquivo(rebelde);
    }

    public boolean verificarId(String id) throws IOException {
        List<Rebel> listaRebeldes = listAll();
        Optional<Rebel> rebelde = listaRebeldes.stream().
                filter(rebeldeSearch -> rebeldeSearch.getId().equals(id)).findFirst();
        return rebelde.isPresent();
    }

    public List<Rebel> listAll() throws IOException {
        return rebeldeRepository.listAll();
    }

    public Optional<Rebel> updateLocalization(String id, Localizacao localizacao) throws IOException {
        List<Rebel> listaRebeldes = filtrarRebeldes();
        Optional<Rebel> rebelde = listaRebeldes.stream().
                filter(rebeldeSearch -> rebeldeSearch.getId().equals(id)).findFirst();
        if(rebelde.isPresent()) {
            rebelde.get().setLocalizacao(localizacao);
            rebeldeRepository.reescreverArquivo(listaRebeldes);
        } else {
            throw new IdInvalidoException(id);
        }
        return rebelde;
    }

    public List<Rebel> filtrarRebeldes() throws IOException {
        List<Rebel> listRebel = listAll();
        return listRebel.stream().filter(t -> (t.getIsTraitorEnum().equals(isTraitorEnum.REBEL))).collect(Collectors.toList());
    }

    public List<Rebel> filtrarTraidores() throws IOException {
        List<Rebel> listTraitor = listAll();
        return listTraitor.stream().filter(t -> (t.getIsTraitorEnum().equals(isTraitorEnum.REBEL))).collect(Collectors.toList());
    }

}
