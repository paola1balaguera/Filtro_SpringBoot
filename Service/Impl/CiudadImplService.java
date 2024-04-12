package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agencia.inmobiliaria.Configurationn.CiudadConversion;
import agencia.inmobiliaria.Exeptions.NombreInvalidoException;
import agencia.inmobiliaria.Exeptions.NotFoundElementsException;
import agencia.inmobiliaria.Repository.CiudadRepository;
import agencia.inmobiliaria.Repository.Entities.Ciudad;
import agencia.inmobiliaria.Repository.EntitiesDTO.CiudadDTO;
import agencia.inmobiliaria.Service.CiudadService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadImplService implements CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;
    private CiudadConversion ciudadConversion;

    @Override
    @Transactional
    public CiudadDTO save(CiudadDTO ciudadDTO) {
        String nombreCiudad = ciudadDTO.getNombre();
        if (!nombreCiudad.matches("[a-zA-Z]+")) {
            throw new NombreInvalidoException("El nombre de la ciudad solo debe contener letras");
        }
    
        Ciudad ciudad = ciudadConversion.convertirDTOACiudad(ciudadDTO);
        ciudadRepository.save(ciudad);
        return ciudadConversion.convertirCiudadADto(ciudad);
    }

public CiudadDTO update(Long id, CiudadDTO ciudadDTO){
    Optional<Ciudad> ciudadCurrentOptional = ciudadRepository.findById(id);
    if(ciudadCurrentOptional.isPresent()){
        Ciudad ciudadCurrent = ciudadConversion.convertirDTOACiudad(ciudadDTO);

        ciudadCurrent.setId(id);
        ciudadCurrent.setNombre(ciudadDTO.getNombre());

        ciudadRepository.save(ciudadCurrent);
        return ciudadConversion.convertirCiudadADto(ciudadCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    ciudadRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<CiudadDTO> findAll() {
    List<Ciudad> ciudades = (List<Ciudad>) ciudadRepository.findAll();
    if (ciudades.isEmpty()) {
        throw new NotFoundElementsException("No se encontraron ciudades");
    }
    return ciudades.stream()
                   .map(ciudad -> ciudadConversion.convertirCiudadADto(ciudad))
                   .toList();
}

}
