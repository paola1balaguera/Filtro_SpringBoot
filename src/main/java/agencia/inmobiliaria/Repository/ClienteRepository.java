package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
