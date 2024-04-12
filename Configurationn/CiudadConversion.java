package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agencia.inmobiliaria.Repository.Entities.Ciudad;
import agencia.inmobiliaria.Repository.EntitiesDTO.CiudadDTO;

@Component
public class CiudadConversion {
    @Autowired
    private ModelMapper dbm;

    public Ciudad convertirDTOACiudad(CiudadDTO ciudadDTO){
        return dbm.map(ciudadDTO,Ciudad.class);
    }

    public CiudadDTO convertirCiudadADto(Ciudad ciudad){
        CiudadDTO ciudadDTO = dbm.map(ciudad, CiudadDTO.class);

        ciudadDTO.setId(ciudad.getId());
        ciudadDTO.setNombre(ciudad.getNombre());



        return ciudadDTO;
    } 
        
}