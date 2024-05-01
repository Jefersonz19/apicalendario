package apicalendariolaboral.apicalendariolaboral.core.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FestivoDto {
    @JsonProperty("Nombre")
    private String nombre;

    @JsonProperty("Fecha")
    private Date fecha;


    public FestivoDto(String nombre, Date fecha ) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}