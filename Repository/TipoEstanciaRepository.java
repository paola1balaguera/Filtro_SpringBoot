package agencia.inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agencia.inmobiliaria.Repository.Entities.TipoEstancia;

public interface TipoEstanciaRepository extends JpaRepository<TipoEstancia, Long> {
    
}
