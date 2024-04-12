package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.ZonaDTO;

public interface ZonaService {

    public ZonaDTO save(ZonaDTO zonaDTO);

    public ZonaDTO update(Long id, ZonaDTO zonaDTO );

    void deleteById(Long id);

    List<ZonaDTO> findAll();
    
}
