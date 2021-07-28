package br.com.letscode.java.star_wars_resistence.Reporte;

import br.com.letscode.java.star_wars_resistence.Rebel.Rebel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {

    private Rebel rebeldeDenunciante;
    private Rebel rebeldeReportado;

}
