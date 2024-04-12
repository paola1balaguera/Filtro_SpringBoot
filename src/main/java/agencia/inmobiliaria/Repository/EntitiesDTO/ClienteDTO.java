package agencia.inmobiliaria.Repository.EntitiesDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteDTO {
    
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private String apellido;

    @NotNull(message = "no puede estar vacio")
    private Long telefono;

    @NotNull(message = "no puede estar vacio")
    private Long cedula;

    @NotEmpty(message = "no puede estar vacio")
    private String email;




}
