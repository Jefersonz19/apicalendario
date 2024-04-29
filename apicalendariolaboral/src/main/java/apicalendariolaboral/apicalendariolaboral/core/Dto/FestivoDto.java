package apicalendariolaboral.apicalendariolaboral.core.Dto;

import java.util.Date;

public class FestivoDto {
    private Date Fecha;
    private String Nombre;

    public FestivoDto(Date fecha, String nombre) {
        Fecha = fecha;
        Nombre = nombre;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}