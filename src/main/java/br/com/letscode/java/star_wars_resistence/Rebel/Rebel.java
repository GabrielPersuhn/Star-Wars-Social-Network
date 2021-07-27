package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rebel {

    private String id;
    @NotNull(message = "O atributo Nome é obrigatória")
    private String nome;
    @NotNull(message = "O atributo Gênero é obrigatório")
    private GeneroEnum generoEnum;
    @NotNull(message = "O atributo Idade é obrigatório")
    private Integer idade;
    @NotNull(message = "O atributo Localização é obrigatório")
    private Localizacao localizacao;

    @JsonIgnore
    private IsTraitorEnum isTraitorEnum;
    @JsonIgnore
    private Integer reports = 0;

    @NotNull(message = "O atributo Recursos é obrigatório")
    private List<Recursos> recursos;



}
