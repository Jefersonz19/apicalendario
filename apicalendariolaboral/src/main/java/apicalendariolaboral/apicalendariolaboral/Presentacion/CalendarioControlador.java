package apicalendariolaboral.apicalendariolaboral.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ICalendarioServicio;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {
    private ICalendarioServicio servicio;

    public CalendarioControlador(ICalendarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/generar/{year}", method = RequestMethod.GET)
    public boolean generar(@PathVariable int year) {
        return servicio.generar(year);
    }

    @RequestMapping(value = "/listar/{year}", method = RequestMethod.GET)
    public List<FestivoDto> buscar(@PathVariable int year) {
        var festivos = servicio.obtenerFestivos(year);
        return festivos;
    }
    
    @RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
    public Calendario obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Calendario crear(@RequestBody Calendario calendario) {
        return servicio.agregar(calendario);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
}
