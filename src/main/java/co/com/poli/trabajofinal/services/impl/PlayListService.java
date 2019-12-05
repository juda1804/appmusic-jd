package co.com.poli.trabajofinal.services.impl;

import co.com.poli.trabajofinal.dao.IPlayListDao;
import co.com.poli.trabajofinal.model.PlayList;
import co.com.poli.trabajofinal.services.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayListService implements IPlayListService {

    @Autowired
    private IPlayListDao playListDao;

    @Override
    public PlayList save(PlayList playList) {
        return playListDao.save(playList);
    }

    @Override
    public Iterable<PlayList> findAll() {
        return playListDao.findAll();
    }
}
