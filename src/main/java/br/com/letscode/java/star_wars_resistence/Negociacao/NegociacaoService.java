package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Rebel.IdInvalidoException;
import br.com.letscode.java.star_wars_resistence.Rebel.RebelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NegociacaoService {

    final NegociacaoRepository negociacaoRepository;

    final RebelServices rebeldeService;

    public String checkTrade(String id, List<Recursos> inventario) throws IOException {
        if (rebeldeService.verificarId(id)) {
            if (CheckListNotNull(id, inventario)) {
                if (compareTrade(id, inventario)) {
                    //TODO implementar atualização dos inventarios
                    negociacaoRepository.clearNegociacao(); //Limpa o arquivo de negociacao após o termino
                    return "Negociação realizada! Iventários atualizados com os novos itens.";
                }
                return "A negociação não é equivalente!";
            }
            return "Nova negociação solicitada!";
        }
        throw new IdInvalidoException(id);
    }

    public boolean CheckListNotNull(String id, List<Recursos> inventario) throws IOException {
        if (negociacaoRepository.listAll().size() == 0) { //Se a lista de negociacao for vazia, cria uma nova negociação
            createTrade(id, inventario);
            return false;
        }
        return true;
    }

    public void createTrade(String id, List<Recursos> inventario) throws IOException {
        negociacaoRepository.inserirArquivo(id, inventario);
    }

    public boolean compareTrade(String nome, List<Recursos> inventario) throws IOException {
        var listNegociacao = negociacaoRepository.listAll();
        //TODO implementar verificação de pontos
        //TODO realizar a comparação, caso os pontos sejam equivalentes: realiza a troca, caso negativo: não realiza
        return false;
    }

}
