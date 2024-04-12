package agencia.inmobiliaria.Repository.EntitiesDTO;

import agencia.inmobiliaria.Repository.Entities.Ciudad;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ZonaDTO {
    
        private Long id;

        @NotEmpty(message = "no puede estar vacio")
        private String nombre;

        private Ciudad ciudad;
}
