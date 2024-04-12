package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agencia.inmobiliaria.Repository.Entities.TipoEstancia;
import agencia.inmobiliaria.Repository.EntitiesDTO.TipoEstanciaDTO;

@Component
public class TipoEstanciaConversion {
    
    @Autowired
    private ModelMapper dbm;

    public TipoEstancia convertirDTOATipoEstancia(TipoEstanciaDTO tipoEstanciaDTO){
        return dbm.map(tipoEstanciaDTO,TipoEstancia.class);

    }

    public TipoEstanciaDTO convertirTipoEstanciaADTO(TipoEstancia tipoEstancia){
        TipoEstanciaDTO tipoEstanciaDTO = dbm.map(tipoEstancia, TipoEstanciaDTO.class);

        tipoEstanciaDTO.setId(tipoEstancia.getId());
        tipoEstanciaDTO.setNombre(tipoEstancia.getNombre());

        return tipoEstanciaDTO;
    }


}
