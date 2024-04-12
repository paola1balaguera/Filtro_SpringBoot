package agencia.inmobiliaria.Repository.EntitiesDTO;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TipoEstanciaDTO {
    
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;
}
