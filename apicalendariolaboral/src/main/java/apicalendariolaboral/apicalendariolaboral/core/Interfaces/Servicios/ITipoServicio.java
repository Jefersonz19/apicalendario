package apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios;

import java.util.List;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;

public interface ITipoServicio {

    public List<Tipo> listar();

    public Tipo obtener(Long id);

    public List<Tipo> buscar(String tipo);

}