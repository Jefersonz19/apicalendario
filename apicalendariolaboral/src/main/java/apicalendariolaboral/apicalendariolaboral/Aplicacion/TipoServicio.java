package apicalendariolaboral.apicalendariolaboral.Aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Repositorios.ITipoRepositorio;
import apicalendariolaboral.apicalendariolaboral.core.Interfaces.Servicios.ITipoServicio;

@Service
public class TipoServicio implements ITipoServicio {

    private ITipoRepositorio repositorio;

    public TipoServicio(ITipoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Tipo> listar() {
        return repositorio.findAll();
    }


    @Override
    public Tipo obtener(Long id) {
        var tipo = repositorio.findById(id);
        return tipo.isEmpty() ? null : tipo.get();
    }

    @Override
    public List<Tipo> buscar(String Tipo) {

        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

}
