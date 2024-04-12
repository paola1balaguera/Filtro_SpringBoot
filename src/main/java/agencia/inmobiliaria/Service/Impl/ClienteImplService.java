package agencia.inmobiliaria.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import agencia.inmobiliaria.Configurationn.ClienteConversion;
import agencia.inmobiliaria.Repository.ClienteRepository;
import agencia.inmobiliaria.Repository.Entities.Cliente;
import agencia.inmobiliaria.Repository.EntitiesDTO.ClienteDTO;
import agencia.inmobiliaria.Service.ClienteService;

public class ClienteImplService implements ClienteService{
    
    
    @Autowired
    private ClienteRepository clienteRepository;
    private ClienteConversion clienteConversion;

    @Override
    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO ) {
        Cliente cliente = clienteConversion.convertirDTOACliente(clienteDTO);
        clienteRepository.save(cliente);
        return clienteConversion.convertirClienteADto(cliente);
    }

    public ClienteDTO update(Long id, ClienteDTO clienteDTO){
        Optional<Cliente> clienteCurrentOptional = clienteRepository.findById(id);
        if(clienteCurrentOptional.isPresent()){
            Cliente clienteCurrent = clienteConversion.convertirDTOACliente(clienteDTO);
            clienteCurrent.setId(id);
            clienteCurrent.setNombre(clienteDTO.getNombre());
            clienteCurrent.setApellido(clienteDTO.getApellido());
            clienteCurrent.setCedula(clienteDTO.getCedula());
            clienteCurrent.setTelefono(clienteCurrent.getTelefono());
            clienteCurrent.setEmail(clienteDTO.getEmail());


            clienteRepository.save(clienteCurrent);
            
            return clienteConversion.convertirClienteADto(clienteCurrent);
        }
        return null;
    }

    @Override
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes.stream()
                    .map(sedesita -> clienteConversion.convertirClienteADto(sedesita))
                    .toList();
        }
 
}
