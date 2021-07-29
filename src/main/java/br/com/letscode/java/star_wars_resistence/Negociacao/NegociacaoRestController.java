package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Rebel.RebelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/negociacao")
@RestController
@RequiredArgsConstructor
public class NegociacaoRestController {

    private final NegociacaoService negociacaoService;
    private final RebelServices rebeldeService;

    @GetMapping()
    public String init() {
        return "Explicação" ; }

    @PostMapping()
    public String newNegociacao(@RequestBody Negociacao negociacao ) throws IOException {
        return negociacaoService.negociacaoDeItens(negociacao);
    }

}
