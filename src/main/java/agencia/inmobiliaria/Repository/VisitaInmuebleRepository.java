package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.VisitaInmueble;

public interface VisitaInmuebleRepository extends JpaRepository<VisitaInmueble, Long> {
    
}
