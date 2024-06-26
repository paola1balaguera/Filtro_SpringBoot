package agencia.inmobiliaria.Repository.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroReferencia" , nullable = false)
    private Long numeroReferencia;

    @Column(name = "nombrePropietario" , nullable = false)
    private String nombrePropietario;

    @Column(name = "telefonoPropietario" , nullable = false)
    private String telefonoPropietario;

    @Column(name = "superficie" , nullable = false)
    private Integer superficie;

    public enum TipoInmueble{
        piso_nuevo,
        pisos_de_ocasion,
        villas,
        casas,
        locales
    }

    @Column(name = "tipoInmueble" , nullable = false)
    private TipoInmueble tipoInmueble;

    @Column(name = "tamanoParcela" , nullable = true)
    private Integer tamanoParcela;

    @Column(name = "urbanizacion" , nullable = true)
    private String urbanizacion;

    @Column(name = "venta" , nullable = false)
    private Boolean venta;

    @Column(name = "alquiler" , nullable = false)
    private Boolean alquiler;

    @Column(name = "valorVenta" , nullable = false)
    private Long valorVenta;

    @Column(name = "valorAlquiler" , nullable = false)
    private Long valorAlquiler;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Oficina oficina;

    @ManyToOne
    private Zona zona;
}
