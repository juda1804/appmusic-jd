package co.com.poli.trabajofinal.dao;

import co.com.poli.trabajofinal.model.PlayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayListDao extends CrudRepository<PlayList,Long> {
    Optional<PlayList> findByNameEquals(String name);
}
