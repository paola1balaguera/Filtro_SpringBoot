package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.Oficina;

public interface OficinaRepository  extends JpaRepository<Oficina, Long> {
    
}