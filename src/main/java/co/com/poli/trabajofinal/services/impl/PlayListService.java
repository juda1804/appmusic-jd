package co.com.poli.trabajofinal.services.impl;

import co.com.poli.trabajofinal.dao.IPlayListDao;
import co.com.poli.trabajofinal.dao.ISongDao;
import co.com.poli.trabajofinal.model.PlayList;
import co.com.poli.trabajofinal.services.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayListService implements IPlayListService {

    @Autowired
    private IPlayListDao playListDao;

    @Autowired
    private ISongDao songDao;

    @Override
    public PlayList save(PlayList playList) {
        playListDao.save(playList);
        playList.getSongs().forEach( song -> songDao.save(song));
        return playList;
    }

    @Override
    public Iterable<PlayList> findAll() {
        return playListDao.findAll();
    }
}
