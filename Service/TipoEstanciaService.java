package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.TipoEstanciaDTO;

public interface TipoEstanciaService {

    public TipoEstanciaDTO save(TipoEstanciaDTO tipoEstanciaDTO);

    public TipoEstanciaDTO update(Long id, TipoEstanciaDTO tipoEstanciaDTO );

    void deleteById(Long id);

    List<TipoEstanciaDTO> findAll();
    
}
