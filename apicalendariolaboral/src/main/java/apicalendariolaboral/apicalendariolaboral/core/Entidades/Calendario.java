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
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo tipo;

    @Column(name = "descripcion")
    private String descripcion;

    private Date fecha;

    public Calendario() {
    }

    public Calendario(Long id, Tipo tipo, String descripcion, Date fecha) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    

}

