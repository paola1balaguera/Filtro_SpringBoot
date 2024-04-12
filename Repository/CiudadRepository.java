package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.Ciudad;


public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    
}