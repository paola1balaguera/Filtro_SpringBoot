package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import agencia.inmobiliaria.Repository.Entities.VisitaInmueble;
import agencia.inmobiliaria.Repository.EntitiesDTO.VisitaInmuebleDTO;


@Component
public class VisitaInmuebleConversion {
    
        @Autowired
    private ModelMapper dbm;

    public VisitaInmueble convertirDTOAVisitaInmueble(VisitaInmuebleDTO visitaInmuebleDTO){
        return dbm.map(visitaInmuebleDTO,VisitaInmueble.class);

    }

    public VisitaInmuebleDTO convertirVisitaInmuebleADTO(VisitaInmueble visitaInmueble){
        VisitaInmuebleDTO visitaInmuebleDTO = dbm.map(visitaInmueble, VisitaInmuebleDTO.class);

        visitaInmuebleDTO.setId(visitaInmueble.getId());
        visitaInmuebleDTO.setFecha(visitaInmueble.getFecha());
        visitaInmuebleDTO.setHora(visitaInmueble.getHora());
        visitaInmuebleDTO.setRealizada(visitaInmueble.getRealizada());
        visitaInmuebleDTO.setComentario(visitaInmueble.getComentario());
        visitaInmuebleDTO.setOficina(visitaInmueble.getOficina());
        visitaInmuebleDTO.setCliente(visitaInmueble.getCliente());
        visitaInmuebleDTO.setInmueble(visitaInmueble.getInmueble());

        return visitaInmuebleDTO;
    }
}
