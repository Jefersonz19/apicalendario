package apicalendariolaboral.apicalendariolaboral.core.Interfaces.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Tipo;

@Repository
public interface ITipoRepositorio extends JpaRepository<Tipo, Long>{

    @Query("SELECT u FROM Tipo u  WHERE u.id = ?1")
    Tipo obtener(Long id);
    
}
