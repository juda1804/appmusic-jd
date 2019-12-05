package co.com.poli.trabajofinal.controller;

import co.com.poli.trabajofinal.model.PlayList;
import co.com.poli.trabajofinal.services.impl.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @PostMapping("/playlist")
    public void save(@RequestBody PlayList playList) {
        playListService.save(playList);
    }

    @GetMapping("/playlist")
    public List<PlayList> getAll() {
        List<PlayList> playLists = new ArrayList<>();
        playListService.findAll().forEach(playLists::add);
        return playLists;
    }
}
