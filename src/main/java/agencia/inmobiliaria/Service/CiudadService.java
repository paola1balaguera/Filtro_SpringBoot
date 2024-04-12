package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.CiudadDTO;


public interface CiudadService {

    public CiudadDTO save(CiudadDTO ciudadDTO);

    public CiudadDTO update(Long id, CiudadDTO ciudadDTO );

    void deleteById(Long id);

    List<CiudadDTO> findAll();
}
