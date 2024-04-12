package agencia.inmobiliaria.Service;

import java.util.List;

import agencia.inmobiliaria.Repository.EntitiesDTO.ClienteDTO;

public interface ClienteService {

    
    public ClienteDTO save(ClienteDTO clienteDTO);

    public ClienteDTO update(Long id, ClienteDTO clienteDTO );

    void deleteById(Long id);

    List<ClienteDTO> findAll();
}
