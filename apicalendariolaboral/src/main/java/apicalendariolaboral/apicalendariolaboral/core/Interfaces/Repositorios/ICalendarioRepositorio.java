package apicalendariolaboral.apicalendariolaboral.core.Interfaces.Repositorios;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apicalendariolaboral.apicalendariolaboral.core.Entidades.Calendario;
import jakarta.transaction.Transactional;

@Repository
public interface ICalendarioRepositorio extends JpaRepository<Calendario, Long> {
    @Transactional
    long deleteByFecha(Date fecha);
    //@Query("SELECT u FROM calendario u  WHERE u.id = ?1")
    //Calendario obtener(long id);

}
