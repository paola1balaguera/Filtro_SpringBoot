package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.OficinaDTO;


public interface OficinaService {

    public OficinaDTO save(OficinaDTO oficinaDTO);

    public OficinaDTO update(Long id, OficinaDTO oficinaDTO );

    void deleteById(Long id);

    List<OficinaDTO> findAll();
}