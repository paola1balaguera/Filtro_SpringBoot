package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agencia.inmobiliaria.Repository.Entities.Zona;
import agencia.inmobiliaria.Repository.EntitiesDTO.ZonaDTO;

@Component
public class ZonaConversion {
     @Autowired
    private ModelMapper dbm;

    public Zona convertirDTOAZona(ZonaDTO zonaDTO){
        return dbm.map(zonaDTO,Zona.class);
    }

    public ZonaDTO convertirZonaADto(Zona zona){
        ZonaDTO zonaDTO = dbm.map(zona, ZonaDTO.class);

        zonaDTO.setId(zona.getId());
        zonaDTO.setNombre(zona.getNombre());
        zonaDTO.setCiudad(zona.getCiudad());



        return zonaDTO;
    } 
}
