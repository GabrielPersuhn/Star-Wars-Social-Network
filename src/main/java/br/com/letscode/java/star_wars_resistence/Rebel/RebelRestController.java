package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/rebelde")
@RestController
@RequiredArgsConstructor
public class RebelRestController {

    private final RebelServices rebeldeService;

    @GetMapping
    public List<Rebel> listarTodos() throws IOException {
        System.out.println("Explicações da aplicação"); //TODO comentarios sobe a aplicação em geral
        return rebeldeService.listAll();
    }


    @PostMapping
    public Rebel adicionarRebelde(@Valid @RequestBody Rebel rebelde) throws IOException {
        return rebeldeService.createRebel(rebelde);
    }

    @PatchMapping("/{id}/atualizaLocal")
    public Optional<Rebel> atualizarLocalizacao(@PathVariable String id, @RequestBody Localizacao localizacao) throws IOException {
        return rebeldeService.updateLocalization(id, localizacao);
    }

}
