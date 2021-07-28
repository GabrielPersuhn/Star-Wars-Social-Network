package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
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

    @NotNull(message = "O atributo Recursos é obrigatório")
    private Recursos recursos;

    @JsonIgnore
    private IsTraitorEnum isTraitorEnum;
    @JsonIgnore
    private Integer reports = 0;

}
