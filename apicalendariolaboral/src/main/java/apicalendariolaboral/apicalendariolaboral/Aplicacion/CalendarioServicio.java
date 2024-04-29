/* 
package apicalendariolaboral.apicalendariolaboral.Aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ITipoServicio;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Repositorios.ICalendarioRepositorio;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ICalendarioServicio;

@Service
public class CalendarioServicio implements ICalendarioServicio {
    //private ICalendarioServicio repositorio;

    private CalendarioCliente calendarioCliente;
    private ICalendarioServicio repositorio;


   /*  public CalendarioServicio(ICalendarioServicio repositorio) {
        this.repositorio = repositorio;
    } 
    public CalendarioServicio(CalendarioCliente calendarioCliente, ICalendarioServicio repositorio) {
        this.calendarioCliente = calendarioCliente;
        this.repositorio = repositorio;
    }

    @Override
    public List<Calendario> listar2() {
        return repositorio.findAll();
    }

    @Override
    public List<Calendario> listaryear(int año) {
        List<Calendario> calendarios = repositorio.findAll();
        List<Calendario> calendariosPorAño = new ArrayList<>();

        for (Calendario calendario : calendarios) {
            if (calendario.getYear() == año) {
                calendariosPorAño.add(calendario);
            }
        }

        return calendariosPorAño;
    }

    @Override
    public Calendario agregar(Calendario calendario) {
        calendario.setId(0);
        return repositorio.save(calendario);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<CalendarioDto> obtenerFestivos(int year) {
        List<CalendarioDto> festivosDto = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            CalendarioDto festivosyear = calendarioCliente.obtenerFestivosold(year);
            if (festivosDto != null) {
                festivosDto.add(festivosyear);
            }
        }
        return festivosDto;
    }

    @Override
    public Calendario obtener(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    } 

    @Override
    public List<FestivoDto> obtenerFestivos(int year) {

        return calendarioCliente.obtenerFestivo(year);
    }

    // List<FestivosDto> festivosDto = new ArrayList<>();
    // for (int month = 1; month <= 12; month++) {
    // FestivosDto festivosyear = calendarioCliente.obtenerFestivos(año);
    // if (festivosDto != null) {
    // festivosDto.add(festivosyear);
    // }
    // }
    // return festivosDto;
}

*/