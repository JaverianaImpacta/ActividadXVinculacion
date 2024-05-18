package edu.javeriana.ingenieria.social.actividadxvinculacion.repositorio;

import edu.javeriana.ingenieria.social.actividadxvinculacion.dominio.ActividadXVinculacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioActividadXVinculacion extends JpaRepository<ActividadXVinculacion, Integer> {
    List<ActividadXVinculacion> findAllByVinculacion(Integer vinculacion);

    List<ActividadXVinculacion> findAllByActividad(String actividad);
}
