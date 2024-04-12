package agencia.inmobiliaria.Configurationn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import agencia.inmobiliaria.Repository.Entities.Cliente;
import agencia.inmobiliaria.Repository.EntitiesDTO.ClienteDTO;

public class ClienteConversion {
    
    @Autowired
    private ModelMapper dbm;

    public Cliente convertirDTOACliente(ClienteDTO clienteDTO){
        return dbm.map(clienteDTO,Cliente.class);
    }

    public ClienteDTO convertirClienteADto(Cliente cliente){
        ClienteDTO clienteDTO = dbm.map(cliente, ClienteDTO.class);

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(clienteDTO.getApellido());
        clienteDTO.setCedula(clienteDTO.getCedula());
        clienteDTO.setTelefono(clienteDTO.getTelefono());
        clienteDTO.setEmail(clienteDTO.getEmail());


        return clienteDTO;
    } 
        
}
