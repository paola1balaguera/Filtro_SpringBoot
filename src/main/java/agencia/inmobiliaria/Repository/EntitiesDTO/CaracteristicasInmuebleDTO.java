package agencia.inmobiliaria.Repository.EntitiesDTO;

import agencia.inmobiliaria.Repository.Entities.Caracteristicas;
import agencia.inmobiliaria.Repository.Entities.Inmueble;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CaracteristicasInmuebleDTO {
    
    private Long id;
    
    @NotEmpty(message = "no puede estar vacio")
    private Integer cantidad;

    private Inmueble inmueble;
    
    private Caracteristicas caracteristicas;
}
