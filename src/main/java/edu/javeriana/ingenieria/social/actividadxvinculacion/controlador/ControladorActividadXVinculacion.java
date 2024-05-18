package edu.javeriana.ingenieria.social.actividadxvinculacion.controlador;

import edu.javeriana.ingenieria.social.actividadxvinculacion.dominio.ActividadXVinculacion;
import edu.javeriana.ingenieria.social.actividadxvinculacion.servicio.ServicioActividadXVinculacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/actividadesXVinculaciones")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorActividadXVinculacion {
    @Autowired
    private ServicioActividadXVinculacion servicio;

    @GetMapping("listar")
    public List<ActividadXVinculacion> obtenerActividadesXVinculacion() {
        return servicio.obtenerActividadesXVinculaciones();
    }

    @GetMapping("obtenerXVinculacion")
    public ResponseEntity<List<ActividadXVinculacion>> obtenerActividadesXVinculacion(@RequestParam Integer vinculacion) {
        if(vinculacion==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ActividadXVinculacion> lista = servicio.obtenerActividadesXVinculacion(vinculacion);
        if(lista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("obtenerXActividad")
    public ResponseEntity<List<ActividadXVinculacion>> obtenerVinculacionesXActividad(@RequestParam String actividad) {
        if(actividad==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ActividadXVinculacion> lista = servicio.obtenerVinculacionesXActividad(actividad);
        if(lista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<ActividadXVinculacion> crearActividadXVinculacion(@RequestBody ActividadXVinculacion actividad) {
        if(actividad == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.ActividadXVinculacionExiste(actividad) || servicio.ActividadXVinculacionExiste(actividad.getId())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(servicio.crearActividadXVinculacion(actividad), HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<ActividadXVinculacion> actualizarActividadXVinculacion(@RequestParam Integer id ,@RequestBody ActividadXVinculacion actividad) {
        if(!Objects.equals(id, actividad.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(servicio.actualizarActividadXVinculacion(id, actividad)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actividad, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<HttpStatus> borrarActividadXVinculacion(@RequestParam Integer id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.borrarActividadXVinculacion(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
