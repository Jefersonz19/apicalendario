// Elaborado por:  Jeferson Zapata


package apicalendariolaboral.apicalendariolaboral.Aplicacion;


import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.time.*;
import java.time.format.TextStyle;


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

    
    public CalendarioServicio() {

    }
    public CalendarioServicio(CalendarioCliente calendarioCliente) {
        this.calendarioCliente=calendarioCliente;

    }
    public CalendarioServicio(CalendarioCliente calendarioCliente, ICalendarioRepositorio repositorio, ITipoServicio servicio) {
        this.calendarioCliente = calendarioCliente;
        this.repositorio = repositorio;
        this.servicio = servicio;
    }

    @Override
    public List<FestivoDto> listarFestivos(int year){
        return calendarioCliente.listarFestivos(year);
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

        Year anio = Year.of(year); 
        List<FestivoDto> festivos = obtenerDiaFestivos(year);

        anio
                .atDay(1) 
                .datesUntil( 
                        anio
                                .plusYears(1) 
                                .atDay(1) 
                ) 
                .forEach((value) -> {
                    ZoneId defaultZoneId = ZoneId.systemDefault();
                    Date date = Date.from(value.atStartOfDay(defaultZoneId).toInstant());
                    repositorio.deleteByFecha(date);
                    String nombredia = getDia(value, Locale.getDefault());
                    boolean esFestivo = findFestivo(value, festivos);
                    boolean esFinDeSemana = esFinDeSemana(value);
                    Tipo tipo = esFestivo ? servicio.obtener(Long.valueOf(3))
                            : esFinDeSemana ? servicio.obtener(Long.valueOf(2))
                                    : servicio.obtener(Long.valueOf(1));
                    Calendario dia = new Calendario(date, tipo, nombredia);
                    agregar(dia);
                });
    }

    public static boolean esFinDeSemana(final LocalDate ld) {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    boolean findFestivo(LocalDate fecha, List<FestivoDto> listFestivo) {
        for (FestivoDto festivo : listFestivo) {
            Date date = convertToDateViaSqlDate(fecha);
            Date fechaFestivo = convertToDateViaSqlDate(
                    festivo.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1));
            if (date.equals(fechaFestivo)) {
                return true;
            }
        }
        return false;
    }

    public static String getDia(LocalDate date, Locale locale) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, locale);
    }

}