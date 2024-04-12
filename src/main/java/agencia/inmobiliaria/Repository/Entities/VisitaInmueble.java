package agencia.inmobiliaria.Repository.Entities;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitaInmueble")
public class VisitaInmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha" , nullable = false)
    private Date fecha;

    @Column(name = "hora" , nullable = false)
    private LocalTime hora;

    @Column(name = "realizada", nullable = false)
    private Boolean realizada;

    @Column(name = "comentario" , nullable = false)
    private String comentario;

    @ManyToOne
    private Oficina oficina;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Inmueble inmueble;
}
