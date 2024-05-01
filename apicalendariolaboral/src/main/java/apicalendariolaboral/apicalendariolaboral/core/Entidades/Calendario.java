package apicalendariolaboral.apicalendariolaboral.core.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "calendario")
public class Calendario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_calendario")
    @GenericGenerator(name = "secuencia_calendario", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo Tipo;

    @Column(name = "descripcion")
    private String descripcion;

    public Calendario() {
    }

    /*
    public Calendario(long id, Date fecha, Tipo tipo, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    } */

    public Calendario(Date fecha, Tipo tipo, String descripcion) {
        this.fecha = fecha;
        Tipo = tipo;
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
        return Tipo;
    }


    public void setTipo(Tipo tipo) {
        Tipo = tipo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @SuppressWarnings("deprecation")
    public int getYear() {
        return fecha.getYear() + 1900;
    }

}

