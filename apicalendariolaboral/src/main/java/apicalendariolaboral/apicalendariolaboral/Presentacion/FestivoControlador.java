package apicalendariolaboral.apicalendariolaboral.Presentacion;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;

import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ICalendarioServicio;


@RestController
@RequestMapping("/festivos")
public class FestivoControlador {
    private ICalendarioServicio servicio;

    public FestivoControlador(ICalendarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/obtener/{year}", method=RequestMethod.GET)
    public List<FestivoDto> requestMethodName(@PathVariable int year) {
        return servicio.listarFestivos(year);
    }
    

}