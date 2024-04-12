package agencia.inmobiliaria.Repository.EntitiesDTO;

import agencia.inmobiliaria.Repository.Entities.Inmueble.TipoInmueble;
import agencia.inmobiliaria.Repository.Entities.Oficina;
import agencia.inmobiliaria.Repository.Entities.Zona;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InmuebleDTO {
    

    private Long id;

    @NotNull(message = "no puede estar vacio")
    private Long numeroReferencia;

    @NotEmpty(message = "no puede estar vacio")
    private String nombrePropietario;

    @NotEmpty(message = "no puede estar vacio")
    private String telefonoPropietario;

    @NotNull(message = "no puede estar vacio")
    private Integer superficie;

    private TipoInmueble tipoInmueble;

    private Integer tamanoParcela;

    private String urbanizacion;

    private Oficina oficina;

    private Zona zona;





}
