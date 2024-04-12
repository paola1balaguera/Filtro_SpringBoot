package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.InmuebleDTO;

public interface InmuebleService {

    
    public InmuebleDTO save(InmuebleDTO inmuebleDTO);

    public InmuebleDTO update(Long id, InmuebleDTO inmuebleDTO );

    void deleteById(Long id);

    List<InmuebleDTO> findAll();
}
