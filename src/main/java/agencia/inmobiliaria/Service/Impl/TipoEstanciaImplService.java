package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agencia.inmobiliaria.Configurationn.TipoEstanciaConversion;
import agencia.inmobiliaria.Exeptions.NombreInvalidoException;
import agencia.inmobiliaria.Exeptions.NotFoundElementsException;
import agencia.inmobiliaria.Repository.TipoEstanciaRepository;
import agencia.inmobiliaria.Repository.Entities.TipoEstancia;
import agencia.inmobiliaria.Repository.EntitiesDTO.TipoEstanciaDTO;
import agencia.inmobiliaria.Service.TipoEstanciaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoEstanciaImplService implements TipoEstanciaService{
        
    @Autowired
    private TipoEstanciaRepository tipoEstanciaRepository;
    private TipoEstanciaConversion tipoEstanciaConversion;

    @Override
    @Transactional


    public TipoEstanciaDTO save(TipoEstanciaDTO tipoEstanciaDTO) {
        String nombreTipoEstancia = tipoEstanciaDTO.getNombre();
        if (!nombreTipoEstancia.matches("[a-zA-Z]+")) {
            throw new NombreInvalidoException("El nombre de el tipo estancia solo debe contener letras");
        }
    
        TipoEstancia tipoEstancia = tipoEstanciaConversion.convertirDTOATipoEstancia(tipoEstanciaDTO);
        tipoEstanciaRepository.save(tipoEstancia);
        return tipoEstanciaConversion.convertirTipoEstanciaADTO(tipoEstancia);
    }

public TipoEstanciaDTO update(Long id, TipoEstanciaDTO tipoEstanciaDTO){
    Optional<TipoEstancia> tipoEstanciaCurrentOptional = tipoEstanciaRepository.findById(id);
    if(tipoEstanciaCurrentOptional.isPresent()){
        TipoEstancia tipoEstanciaCurrent = tipoEstanciaConversion.convertirDTOATipoEstancia(tipoEstanciaDTO);

        tipoEstanciaCurrent.setId(id);
        tipoEstanciaCurrent.setNombre(tipoEstanciaDTO.getNombre());

        tipoEstanciaRepository.save(tipoEstanciaCurrent);

            return tipoEstanciaConversion.convertirTipoEstanciaADTO(tipoEstanciaCurrent);


    }
    return null;
}

@Override
public void deleteById(Long id){
    tipoEstanciaRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<TipoEstanciaDTO> findAll() {
    List<TipoEstancia> tipoEstancias = (List<TipoEstancia>) tipoEstanciaRepository.findAll();
    if (tipoEstancias.isEmpty()) {
        throw new NotFoundElementsException("No se encontraron ciudades");
    }
    return tipoEstancias.stream()
                   .map(tipoEstanciitaa-> tipoEstanciaConversion.convertirTipoEstanciaADTO(tipoEstanciitaa))
                   .toList();
}
}
