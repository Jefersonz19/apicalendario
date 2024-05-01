package apicalendariolaboral.apicalendariolaboral.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ITipoServicio;

@RestController
@RequestMapping("/api/tipo")
public class TipoControlador {
    private ITipoServicio servicio;

    public TipoControlador(ITipoServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tipo> listarTipos() {
        return servicio.listar();
    }
      
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tipo obtener(@PathVariable long id) {
        return servicio.obtener(id);
    } 
}