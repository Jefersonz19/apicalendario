package apicalendariolaboral.apicalendariolaboral.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
//import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
//import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ICalendarioServicio;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {
    private ICalendarioServicio servicio;

    public CalendarioControlador(ICalendarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/generar/{year}", method = RequestMethod.POST) //*
    public List<Calendario> generar(@PathVariable int year) {
        servicio.generarCalendario(year);
        return servicio.listar();
    } 

    @RequestMapping(value = "/listar/", method = RequestMethod.GET)  //*
    public List<Calendario> listar() {
        return servicio.listar();
    }
    /* 
    @RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
    public Calendario obtener(@PathVariable long id) {
        return servicio.obtener(id);
    } */

    @GetMapping("/listar/{year}")  //*
    public List<Calendario> listar(@PathVariable("year") Integer year) {
        return servicio.listarPorYear(year);
        /* 
        if (year == null) {
        return servicio.listar2();
        } else {
            return servicio.listarPorYear(year);
        } */
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Calendario agregar(@RequestBody Calendario calendario) {
        return servicio.agregar(calendario);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)  //*
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @GetMapping("/festivos/{year}") //* 
    public List<FestivoDto> obtenerDiaFestivos(@PathVariable("year") Integer year) {

        return servicio.obtenerDiaFestivos(year);
    }
}
