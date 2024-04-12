package agencia.inmobiliaria.Repository.EntitiesDTO;

import agencia.inmobiliaria.Repository.Entities.Inmueble.TipoInmueble;
import agencia.inmobiliaria.Repository.Entities.Oficina;
import agencia.inmobiliaria.Repository.Entities.Zona;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class InmuebleDTO {
    

    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    private Long numeroReferencia;

    @NotEmpty(message = "no puede estar vacio")
    private String nombrePropietario;

    @NotEmpty(message = "no puede estar vacio")
    private String telefonoPropietario;

    @NotEmpty(message = "no puede estar vacio")
    private Integer superficie;

    private TipoInmueble tipoInmueble;

    @NotEmpty(message = "no puede estar vacio")
    private Integer tamanoParcela;

    @NotEmpty(message = "no puede estar vacio")
    private String urbanizacion;

    private Oficina oficina;

    private Zona zona;





}
