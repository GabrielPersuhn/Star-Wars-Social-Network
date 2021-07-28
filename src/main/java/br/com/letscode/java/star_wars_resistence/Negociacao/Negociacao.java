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
    public int getScoreFirst() {
        int agua = this.firstRecursos.getAgua();
        int arma = this.firstRecursos.getArma();
        int comida = this.firstRecursos.getComida();
        int municao = this.firstRecursos.getMunicao();
        return ((agua * 2) + (arma * 4) + (municao * 3) + comida);
    }

    @JsonIgnore
    public int getScoreSecond() {
        int agua = this.secondRecursos.getAgua();
        int arma = this.secondRecursos.getArma();
        int comida = this.secondRecursos.getComida();
        int municao = this.secondRecursos.getMunicao();
        return ((agua * 2) + (arma * 4) + (municao * 3) + comida);
    }

    public boolean equalsScore(){
        return Objects.equals(getScoreFirst(), getScoreSecond());
    }

}
