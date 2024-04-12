package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agencia.inmobiliaria.Repository.Entities.Oficina;
import agencia.inmobiliaria.Repository.EntitiesDTO.OficinaDTO;

@Component
public class OficinaConversion {
    
    @Autowired
    private ModelMapper dbm;

    public Oficina convertirDTOAOficina(OficinaDTO oficinaDTO){
        return dbm.map(oficinaDTO,Oficina.class);
    }

    public OficinaDTO convertirOficinaADto(Oficina oficina){
        OficinaDTO oficinaDTO = dbm.map(oficina, OficinaDTO.class);

        oficinaDTO.setId(oficina.getId());
        oficinaDTO.setDireccion(oficina.getDireccion());




        return oficinaDTO;
    } 
}
