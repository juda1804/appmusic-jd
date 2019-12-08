package co.com.poli.trabajofinal.dao;

import co.com.poli.trabajofinal.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayListDao extends JpaRepository<PlayList,Long> {
    Optional<PlayList> findByName(String name);

    @Modifying
    @Query("UPDATE PlayList SET description = ?2 WHERE id = ?1")
    int updatePlaylist( Long id, String description);

}
