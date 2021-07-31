package br.com.letscode.java.star_wars_resistence.Rebel;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import br.com.letscode.java.star_wars_resistence.Localizacao.Localizacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NotNull
    private String nome;

    @NotNull
    private GeneroEnum generoEnum;

    @NotNull
    private Integer idade;

    @NotNull
    private Localizacao localizacao;

    @NotNull
    private Recursos recursos;

    @JsonIgnore
    private IsTraitorEnum isTraitorEnum;

    @JsonIgnore
    private Integer reports = 0;

}
