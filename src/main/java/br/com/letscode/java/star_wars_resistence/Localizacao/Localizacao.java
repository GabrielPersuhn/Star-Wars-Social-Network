package br.com.letscode.java.star_wars_resistence.Localizacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Localizacao {
    @NotNull
    private Long latitude;
    @NotNull
    private Long longitude;
    @NotNull
    private String BaseNaGalaxia;

    @Override
    public String toString() {
        return BaseNaGalaxia +
                "," + latitude +
                "," + longitude;
    }

}
