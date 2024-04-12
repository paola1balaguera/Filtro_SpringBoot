package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agencia.inmobiliaria.Repository.Entities.Inmueble;
import agencia.inmobiliaria.Repository.EntitiesDTO.InmuebleDTO;

@Component
public class InmuebleConversion {
    @Autowired
    private ModelMapper dbm;

    public Inmueble convertirDTOAInmueble(InmuebleDTO inmuebleDTO){
        return dbm.map(inmuebleDTO,Inmueble.class);
    }

    public InmuebleDTO convertirInmuebleADto(Inmueble inmueble){
        InmuebleDTO inmuebleDTO = dbm.map(inmueble, InmuebleDTO.class);

        inmuebleDTO.setId(inmueble.getId());
        inmuebleDTO.setNumeroReferencia(inmueble.getNumeroReferencia());
        inmuebleDTO.setNombrePropietario(inmueble.getNombrePropietario());
        inmuebleDTO.setTelefonoPropietario(inmueble.getTelefonoPropietario());
        inmuebleDTO.setSuperficie(inmueble.getSuperficie());
        inmuebleDTO.setTipoInmueble(inmueble.getTipoInmueble());
        inmuebleDTO.setTamanoParcela(inmueble.getTamanoParcela());
        inmuebleDTO.setUrbanizacion(inmueble.getUrbanizacion());
        inmuebleDTO.setOficina(inmueble.getOficina());
        inmuebleDTO.setZona(inmueble.getZona());
        inmuebleDTO.setVenta(inmueble.getVenta());
        inmuebleDTO.setAlquiler(inmueble.getAlquiler());
        inmuebleDTO.setValorVenta(inmueble.getValorVenta());
        inmuebleDTO.setValorAlquiler(inmueble.getValorAlquiler());

        return inmuebleDTO;
    } 
}
