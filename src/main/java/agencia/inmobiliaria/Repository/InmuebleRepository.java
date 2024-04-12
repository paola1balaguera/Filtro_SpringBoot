package agencia.inmobiliaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import agencia.inmobiliaria.Repository.Entities.Inmueble;

public interface InmuebleRepository  extends JpaRepository<Inmueble, Long> {
    String GET_INMUEBLE_BY_ALQUIER_OR_VENTA = "SELECT i.* FROM inmueble i WHERE venta = true OR alquiler = true";

    @Query(value = GET_INMUEBLE_BY_ALQUIER_OR_VENTA, nativeQuery = true)
    List<Inmueble> getInmuebleByAlquilerOrVenta();


    Inmueble findInmuebleByNumeroReferencia(Long numeroReferencia);
}
