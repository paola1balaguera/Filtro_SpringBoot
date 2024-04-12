package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import agencia.inmobiliaria.Repository.Entities.Inmueble;
import agencia.inmobiliaria.Repository.EntitiesDTO.InmuebleDTO;

public class InmuebleConversion {
    @Autowired
    private ModelMapper dbm;

    public Inmueble convertirDTOAInmueble(InmuebleDTO inmuebleDTO){
        return dbm.map(inmuebleDTO,Inmueble.class);
    }

    public InmuebleDTO convertirClienteADto(Inmueble inmueble){
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


        return inmuebleDTO;
    } 
}
