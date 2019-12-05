package co.com.poli.trabajofinal.services;


import co.com.poli.trabajofinal.model.PlayList;

public interface IPlayListService {
    PlayList save( PlayList playList );
    Iterable<PlayList> findAll();
}
