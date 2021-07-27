package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Rebel.Rebel;
import br.com.letscode.java.star_wars_resistence.Rebel.RebelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/negociacao")
@RestController
@RequiredArgsConstructor
public class NegociacaoController {

    private final NegociacaoService negociacaoService;
    private final RebelServices rebeldeService;

    @GetMapping()
    public List<Rebel> listAll() throws IOException {
        return rebeldeService.listAll();
    }

    @PostMapping("{id}")
    public String addNegociacao(@PathVariable String id, @RequestBody List<Recursos> inventario) throws IOException {
        return negociacaoService.checkTrade(id, inventario);
    }
}
