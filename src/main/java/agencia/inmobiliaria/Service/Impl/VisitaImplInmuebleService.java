package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import agencia.inmobiliaria.Configurationn.VisitaInmuebleConversion;
import agencia.inmobiliaria.Repository.VisitaInmuebleRepository;
import agencia.inmobiliaria.Repository.Entities.VisitaInmueble;
import agencia.inmobiliaria.Repository.EntitiesDTO.VisitaInmuebleDTO;
import agencia.inmobiliaria.Service.VisitaInmuebleService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class VisitaImplInmuebleService implements VisitaInmuebleService{
    
    @Autowired
    private VisitaInmuebleRepository visitaInmuebleRepository;
    private VisitaInmuebleConversion visitaInmuebleConversion;

    @Override
    @Transactional
    public VisitaInmuebleDTO save(VisitaInmuebleDTO visitaInmuebleDTO) {
        VisitaInmueble visitaInmueble = visitaInmuebleConversion.convertirDTOAVisitaInmueble(visitaInmuebleDTO);
        visitaInmuebleRepository.save(visitaInmueble);
        return visitaInmuebleConversion.convertirVisitaInmuebleADTO(visitaInmueble);
    }

    public VisitaInmuebleDTO update(Long id, VisitaInmuebleDTO visitaInmuebleDTO){
        Optional<VisitaInmueble> visitaInmuebleCurrentOptional = visitaInmuebleRepository.findById(id);
        if(visitaInmuebleCurrentOptional.isPresent()){
            VisitaInmueble visitaInmuebleCurrent =  visitaInmuebleConversion.convertirDTOAVisitaInmueble(visitaInmuebleDTO);
            
    
            
            visitaInmuebleCurrent.setId(visitaInmuebleDTO.getId());
            visitaInmuebleCurrent.setFecha(visitaInmuebleDTO.getFecha());
            visitaInmuebleCurrent.setHora(visitaInmuebleDTO.getHora());
            visitaInmuebleCurrent.setRealizada(visitaInmuebleDTO.getRealizada());
            visitaInmuebleCurrent.setComentario(visitaInmuebleDTO.getComentario());
            visitaInmuebleCurrent.setOficina(visitaInmuebleDTO.getOficina());
            visitaInmuebleCurrent.setCliente(visitaInmuebleDTO.getCliente());
            visitaInmuebleCurrent.setInmueble(visitaInmuebleDTO.getInmueble());
    


            visitaInmuebleRepository.save(visitaInmuebleCurrent);
            
            return visitaInmuebleConversion.convertirVisitaInmuebleADTO(visitaInmuebleCurrent);
        }
        return null;
    }

    @Override
    public void deleteById(Long id){
        visitaInmuebleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VisitaInmuebleDTO> findAll(){
        List<VisitaInmueble> vinmuebles = (List<VisitaInmueble>) visitaInmuebleRepository.findAll();
        return vinmuebles.stream()
                    .map(inmueblesitos -> visitaInmuebleConversion.convertirVisitaInmuebleADTO(inmueblesitos))
                    .toList();
        }
}
