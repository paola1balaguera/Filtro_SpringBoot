package agencia.inmobiliaria.Repository.EntitiesDTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteDTO {
    
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private String apellido;

    @NotEmpty(message = "no puede estar vacio")
    private Long telefono;

    @NotEmpty(message = "no puede estar vacio")
    private Long cedula;

    @NotEmpty(message = "no puede estar vacio")
    private String email;




}
