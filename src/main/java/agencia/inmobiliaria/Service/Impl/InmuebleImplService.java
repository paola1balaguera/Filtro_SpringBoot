package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agencia.inmobiliaria.Configurationn.InmuebleConversion;
import agencia.inmobiliaria.Repository.InmuebleRepository;
import agencia.inmobiliaria.Repository.Entities.Inmueble;
import agencia.inmobiliaria.Repository.EntitiesDTO.InmuebleDTO;
import agencia.inmobiliaria.Service.InmuebleService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class InmuebleImplService implements InmuebleService{
    

    @Autowired
    private InmuebleRepository inmuebleRepository;
    private InmuebleConversion inmuebleConversion;

    @Override
    @Transactional
    public InmuebleDTO save(InmuebleDTO inmuebleDTO ) {
        Inmueble inmueble = inmuebleConversion.convertirDTOAInmueble(inmuebleDTO);
        inmuebleRepository.save(inmueble);
        return inmuebleConversion.convertirClienteADto(inmueble);
    }

    public InmuebleDTO update(Long id, InmuebleDTO inmuebleDTO){
        Optional<Inmueble> inmuebleCurrentOptional = inmuebleRepository.findById(id);
        if(inmuebleCurrentOptional.isPresent()){
            Inmueble inmuebleCurrent =  inmuebleConversion.convertirDTOAInmueble(inmuebleDTO);
            inmuebleCurrent.setId(id);
            inmuebleCurrent.setNumeroReferencia(inmuebleDTO.getNumeroReferencia());
            inmuebleCurrent.setNombrePropietario(inmuebleDTO.getNombrePropietario());
            inmuebleCurrent.setTelefonoPropietario(inmuebleDTO.getTelefonoPropietario());
            inmuebleCurrent.setSuperficie(inmuebleDTO.getSuperficie());
            inmuebleCurrent.setTipoInmueble(inmuebleDTO.getTipoInmueble());
            inmuebleCurrent.setTamanoParcela(inmuebleDTO.getTamanoParcela());
            inmuebleCurrent.setUrbanizacion(inmuebleDTO.getUrbanizacion());
            inmuebleCurrent.setOficina(inmuebleDTO.getOficina());
            inmuebleCurrent.setZona(inmuebleDTO.getZona());
    


            inmuebleRepository.save(inmuebleCurrent);
            
            return inmuebleConversion.convertirClienteADto(inmuebleCurrent);
        }
        return null;
    }

    @Override
    public void deleteById(Long id){
        inmuebleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InmuebleDTO> findAll(){
        List<Inmueble> inmuebles = (List<Inmueble>) inmuebleRepository.findAll();
        return inmuebles.stream()
                    .map(inmueblesitos -> inmuebleConversion.convertirClienteADto(inmueblesitos ))
                    .toList();
        }
}
