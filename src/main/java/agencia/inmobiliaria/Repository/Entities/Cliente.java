package agencia.inmobiliaria.Repository.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres" , nullable = false)
    private String nombres;

    @Column(name = "apellidos" , nullable = false)
    private String apellidos;

    @Column(name = "cedula" , nullable = false)
    private Long cedula;

    @Column(name = "email" , nullable = false)
    private String email;
}
