package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agencia.inmobiliaria.Configurationn.ZonaConversion;
import agencia.inmobiliaria.Exeptions.NombreInvalidoException;
import agencia.inmobiliaria.Exeptions.NotFoundElementsException;
import agencia.inmobiliaria.Repository.ZonaRepository;
import agencia.inmobiliaria.Repository.Entities.Zona;
import agencia.inmobiliaria.Repository.EntitiesDTO.ZonaDTO;
import agencia.inmobiliaria.Service.ZonaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZonaImplService implements ZonaService {
    @Autowired
    private ZonaRepository zonaRepository ;
    private ZonaConversion zonaConversion;

    @Override
    @Transactional
    public ZonaDTO save(ZonaDTO zonaDTO) {
        String nombreZona = zonaDTO.getNombre();
        if (!nombreZona.matches("[a-zA-Z]+")) {
            throw new NombreInvalidoException("El nombre de la zona solo debe contener letras");
        }
    
        Zona zona = zonaConversion.convertirDTOAZona(zonaDTO);
        zonaRepository .save(zona);
        return zonaConversion.convertirZonaADto(zona);
    }


public ZonaDTO update(Long id, ZonaDTO zonaDTO){
    Optional<Zona> zonaCurrentOptional = zonaRepository .findById(id);
    if(zonaCurrentOptional.isPresent()){
        Zona zonaCurrent = zonaConversion.convertirDTOAZona(zonaDTO);

        zonaCurrent.setId(id);
        zonaCurrent.setNombre(zonaDTO.getNombre());
        zonaCurrent.setCiudad(zonaDTO.getCiudad());

        zonaRepository .save(zonaCurrent);
        return zonaConversion.convertirZonaADto(zonaCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    zonaRepository .deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<ZonaDTO> findAll() {
    List<Zona> zonas = (List<Zona>) zonaRepository .findAll();
    if (zonas.isEmpty()) {
        throw new NotFoundElementsException("No se encontraron zonas");
    }
    return zonas.stream()
                   .map(zonitaa -> zonaConversion.convertirZonaADto(zonitaa))
                   .toList();
}

}

