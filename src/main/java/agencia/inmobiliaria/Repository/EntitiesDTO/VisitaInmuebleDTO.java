package agencia.inmobiliaria.Repository.EntitiesDTO;

import java.time.LocalTime;
import java.util.Date;

import agencia.inmobiliaria.Repository.Entities.Cliente;
import agencia.inmobiliaria.Repository.Entities.Inmueble;
import agencia.inmobiliaria.Repository.Entities.Oficina;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class VisitaInmuebleDTO {
    
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private Date fecha;

    @NotEmpty(message = "no puede estar vacio")
    private LocalTime hora;

    @NotEmpty(message = "no puede estar vacio")
    private Boolean realizada;

    @NotEmpty(message = "no puede estar vacio")
    private String comentario;

    private Oficina oficina;

    private Cliente cliente;
    
    private Inmueble inmueble;

}
