package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agencia.inmobiliaria.Configurationn.OficinaConversion;
import agencia.inmobiliaria.Exeptions.NombreInvalidoException;
import agencia.inmobiliaria.Exeptions.NotFoundElementsException;
import agencia.inmobiliaria.Repository.OficinaRepository;
import agencia.inmobiliaria.Repository.Entities.Oficina;
import agencia.inmobiliaria.Repository.EntitiesDTO.OficinaDTO;
import agencia.inmobiliaria.Service.OficinaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OficinaImplService implements OficinaService {
    @Autowired
    private OficinaRepository oficinaRepository;
    private OficinaConversion oficinaConversion;

    @Override
    @Transactional
    public OficinaDTO save(OficinaDTO oficinaDTO) {
        String nombreDireccion = oficinaDTO.getDireccion();
        if (!nombreDireccion.matches("[a-zA-Z]+")) {
            throw new NombreInvalidoException("El nombre de laOficina solo debe contener letras");
        }
    
       Oficina oficina = oficinaConversion.convertirDTOAOficina(oficinaDTO);
        oficinaRepository.save(oficina);
        return oficinaConversion.convertirOficinaADto(oficina);
    }

public OficinaDTO update(Long id, OficinaDTO oficinaDTO){
    Optional<Oficina> oficinaCurrentOptional = oficinaRepository.findById(id);
    if(oficinaCurrentOptional.isPresent()){
       Oficina oficinaCurrent = oficinaConversion.convertirDTOAOficina(oficinaDTO);

        oficinaCurrent.setId(id);
        oficinaCurrent.setDireccion(oficinaDTO.getDireccion());

        oficinaRepository.save(oficinaCurrent);
        return oficinaConversion.convertirOficinaADto(oficinaCurrent);
    }
    return null;
}

@Override
public void deleteById(Long id){
    oficinaRepository.deleteById(id);
}

@Override
@Transactional(readOnly = true)
public List<OficinaDTO> findAll() {
    List<Oficina> oficinas = (List<Oficina>) oficinaRepository.findAll();
    if (oficinas.isEmpty()) {
        throw new NotFoundElementsException("No se encontraron oficinas");
    }
    return oficinas.stream()
                   .map(oficinita -> oficinaConversion.convertirOficinaADto(oficinita))
                   .toList();
}

}
