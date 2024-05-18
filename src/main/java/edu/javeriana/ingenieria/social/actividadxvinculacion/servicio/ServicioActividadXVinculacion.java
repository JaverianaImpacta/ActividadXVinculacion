package edu.javeriana.ingenieria.social.actividadxvinculacion.servicio;

import edu.javeriana.ingenieria.social.actividadxvinculacion.dominio.ActividadXVinculacion;
import edu.javeriana.ingenieria.social.actividadxvinculacion.repositorio.RepositorioActividadXVinculacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ServicioActividadXVinculacion {
    @Autowired
    private RepositorioActividadXVinculacion repositorio;

    public List<ActividadXVinculacion> obtenerActividadesXVinculaciones(){
        return repositorio.findAll();
    }

    public List<ActividadXVinculacion> obtenerActividadesXVinculacion(Integer vinculacion){
        return repositorio.findAllByVinculacion(vinculacion);
    }

    public List<ActividadXVinculacion> obtenerVinculacionesXActividad(String actividad){
        return repositorio.findAllByActividad(actividad);
    }

    public ActividadXVinculacion crearActividadXVinculacion(ActividadXVinculacion actividad){
        return repositorio.save(actividad);
    }

    public ActividadXVinculacion actualizarActividadXVinculacion(Integer id, ActividadXVinculacion actividad){
        if(repositorio.findById(id).orElse(null) == null){
            return null;
        }
        actividad.setId(id);
        return repositorio.save(actividad);
    }

    public ActividadXVinculacion borrarActividadXVinculacion(Integer id) {
        ActividadXVinculacion aux = repositorio.findById(id).orElse(null);
        if(aux != null){
            repositorio.delete(aux);
            return aux;
        }
        return null;
    }

    public boolean ActividadXVinculacionExiste(ActividadXVinculacion actividad) {
        List<ActividadXVinculacion> lista = repositorio.findAllByActividad(actividad.getActividad());
        for (ActividadXVinculacion vinculacion : lista) {
            if (Objects.equals(vinculacion.getVinculacion(), actividad.getVinculacion())) {
                return true;
            }
        }
        return false;
    }

    public boolean ActividadXVinculacionExiste(Integer id) {
        return repositorio.existsById(id);
    }
}
