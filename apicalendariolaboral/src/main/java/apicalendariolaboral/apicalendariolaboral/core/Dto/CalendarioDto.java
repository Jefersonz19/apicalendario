package apicalendariolaboral.apicalendariolaboral.core.Dto;

import java.util.Date;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;

public class CalendarioDto {
    private long id;
    private Date fecha;
    private Tipo tipo;
    private String descripcion;

    public CalendarioDto(Long id, Date fecha, Tipo tipo, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}