package apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios;

import java.util.List;

import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;

public interface ICalendarioServicio {

    public List<FestivoDto> obtenerFestivos(int anio);

    public List<CalendarioDto> listar();

    public List<Calendario> listar2();

    public List<Calendario> listaryear(int year);

    public boolean generar(int anio);

    public Calendario agregar(Calendario calendario);

    public boolean eliminar(Long id);

    public Calendario obtener(Long id);

    public Calendario generar(Long id);
    
}
