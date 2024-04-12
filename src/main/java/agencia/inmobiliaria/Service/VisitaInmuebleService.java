package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.VisitaInmuebleDTO;

public interface VisitaInmuebleService {
    

    public VisitaInmuebleDTO save(VisitaInmuebleDTO visitaInmuebleDTO);

    public VisitaInmuebleDTO update(Long id, VisitaInmuebleDTO visitaInmuebleDTO );

    void deleteById(Long id);

    List<VisitaInmuebleDTO> findAll();
}
