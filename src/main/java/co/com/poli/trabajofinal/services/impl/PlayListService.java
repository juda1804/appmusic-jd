package co.com.poli.trabajofinal.services.impl;

import co.com.poli.trabajofinal.dao.IPlayListDao;
import co.com.poli.trabajofinal.model.PlayList;
import co.com.poli.trabajofinal.services.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListService implements IPlayListService {

    @Autowired
    private IPlayListDao playListDao;

    @Override
    public PlayList save(PlayList playList) {
        playListDao.save(playList);
        return playList;
    }

    @Override
    public Boolean update(PlayList playList) {
        Optional<PlayList> playListOpt = playListDao.findByName(playList.getName());
        return playListOpt.map(playL -> {
           playListDao.updatePlaylist(
                   playL.getId(),
                   playList.getDescription()
           );
           return true;
        }).orElse(false);
    }

    @Override
    public void delete(PlayList playList) {
        playListDao.delete(playList);
    }

    @Override
    public Iterable<PlayList> findAll() {
        return playListDao.findAll();
    }

    @Override
    public Optional<PlayList> findByName(String n) {
        Optional<PlayList> playListOpt = playListDao.findByName(n);
        return playListOpt;
    }


}
