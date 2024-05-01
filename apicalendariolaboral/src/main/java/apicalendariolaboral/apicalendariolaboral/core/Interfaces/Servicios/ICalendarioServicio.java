package apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios;

import java.util.List;

import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
//import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;
import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;

public interface ICalendarioServicio {

    public List<CalendarioDto> obtenerFestivos(int year); //* 

    public List<FestivoDto> obtenerDiaFestivos(int year); //* 

   // public List<CalendarioDto> listar2();

    public List<Calendario> listar();  //*

    public boolean generar(int year);

    public List<Calendario> listarPorYear(int year);  //*

    public Calendario agregar(Calendario calendario); //* 

    public boolean eliminar(Long id); //* 

    public boolean eliminarYear(int year); //* 

    public Calendario generar(Long id);

    public void generarCalendario(int year); //* */

    public List<FestivoDto> listarFestivos(int year);
    
}
