package edu.javeriana.ingenieria.social.actividadxvinculacion.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ActividadXVinculacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String actividad;
    private Integer vinculacion;
    private String comentario;
    private Double nota;
}
