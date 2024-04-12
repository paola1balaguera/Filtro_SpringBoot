package agencia.inmobiliaria.Repository.EntitiesDTO;

import agencia.inmobiliaria.Repository.Entities.Inmueble;
import agencia.inmobiliaria.Repository.Entities.TipoEstancia;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TipoEstanciaInmuebleDTO {
    
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private Integer cantidad;

    private Inmueble inmueble;
    
    private TipoEstancia tipoEstancia;
}
