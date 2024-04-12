package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.Zona;

public interface ZonaRepository  extends JpaRepository<Zona, Long> {
    
}
