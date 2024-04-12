package agencia.inmobiliaria.Repository.EntitiesDTO;

import java.util.List;

import agencia.inmobiliaria.Repository.Entities.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    @NotNull(message = "no puede estar vacio")
    private Long cedula;
    private String email;
    private List<Role> roles;
    
}
