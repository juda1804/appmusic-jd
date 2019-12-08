package co.com.poli.trabajofinal.services;


import co.com.poli.trabajofinal.model.PlayList;

import java.util.Optional;

public interface IPlayListService {
    PlayList save( PlayList playList );
    Boolean update( PlayList playList );
    void delete( PlayList playList);
    Iterable<PlayList> findAll();
    Optional<PlayList> findByName(String n);
}
