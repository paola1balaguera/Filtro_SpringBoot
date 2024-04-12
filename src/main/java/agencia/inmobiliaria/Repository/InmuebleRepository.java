package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.Inmueble;

public interface InmuebleRepository  extends JpaRepository<Inmueble, Long> {
    
}
