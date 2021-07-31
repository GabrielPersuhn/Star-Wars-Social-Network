package br.com.letscode.java.star_wars_resistence.Negociacao;

import br.com.letscode.java.star_wars_resistence.Inventario.Recursos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@AllArgsConstructor
@Data
public class Negociacao {

    @NotEmpty
    private String firstId;

    @NotEmpty
    private String secondId;

    @NotEmpty
    private Recursos firstRecursos;

    @NotEmpty
    private Recursos secondRecursos;

    @JsonIgnore
    public boolean equalsScore(){
        return Objects.equals(firstRecursos.getScore(), secondRecursos.getScore());
    }

}
