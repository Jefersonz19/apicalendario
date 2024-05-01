
package apicalendariolaboral.apicalendariolaboral.Aplicacion;


import java.util.List;
import java.util.ArrayList;


import org.springframework.stereotype.Service;

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
    private ICalendarioRepositorio repositorio;
    private ITipoServicio servicio;

    public CalendarioServicio(CalendarioCliente calendarioCliente, ICalendarioRepositorio repositorio, ITipoServicio servicio) {
        this.calendarioCliente = calendarioCliente;
        this.repositorio = repositorio;
        this.servicio = servicio;
    }

    @Override
    public List<Calendario> listar() {
        return repositorio.findAll();
    }

    @Override
    public List<Calendario> listarPorYear(int year) {
        List<Calendario> calendarios = repositorio.findAll();
        List<Calendario> calendariosPorYear = new ArrayList<>();

        for (Calendario calendario : calendarios) {
            if (calendario.getYear() == year) {
                calendariosPorYear.add(calendario);
            }
        }

        return calendariosPorYear;
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
    public boolean eliminarYear(int year) {
        try {
            repositorio.deleteAll();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<CalendarioDto> obtenerFestivos(int year) {
        List<CalendarioDto> festivosDto = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            CalendarioDto festivosyear = calendarioCliente.obtener(year);
            if (festivosDto != null) {
                festivosDto.add(festivosyear);
            }
        }
        return festivosDto;
    }
/* 
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

    @Override
    public List<FestivoDto> obtenerDiaFestivos(int year) {
        return calendarioCliente.obtenerFestivo(year);
    }

    @Override
    public boolean generar(int year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generar'");
    }


    @Override
    public Calendario generar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generar'");
    }

    @Override
    public void generarCalendario(int year) {
        throw new UnsupportedOperationException("Unimplemented method 'generar'");
    }

}