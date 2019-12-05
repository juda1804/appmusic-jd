package co.com.poli.trabajofinal.dao;

import co.com.poli.trabajofinal.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongDao extends CrudRepository<Song,Long> {
}
