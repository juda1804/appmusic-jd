package co.com.poli.trabajofinal.controller;

import co.com.poli.trabajofinal.controller.exceptions.ResourceConflict;
import co.com.poli.trabajofinal.controller.exceptions.ResourceNotFoundException;
import co.com.poli.trabajofinal.model.PlayList;
import co.com.poli.trabajofinal.services.impl.PlayListService;
import co.com.poli.trabajofinal.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @PostMapping("/lists")
    @ResponseStatus( HttpStatus.ACCEPTED )
    public ResponseHttp save(@RequestBody PlayList playList) {
        playListService.save(playList);
        ResponseHttp responseHttp = new ResponseHttp();
        responseHttp.setMessageBody(playList);
        return responseHttp;
    }

    @GetMapping("/lists")
    public ResponseHttp getAll() {
        List<PlayList> playLists = new ArrayList<>();
        Iterable<PlayList> playListsIterable = playListService.findAll();
        playListsIterable.forEach(playLists::add);

        if (playLists.isEmpty()) throw new ResourceNotFoundException("there're not elements in playlist.");


        ResponseHttp responseHttp = new ResponseHttp();
        responseHttp.setMessageBody(playLists);

        return responseHttp;
    }

    @GetMapping("/lists/{listName}")
    public ResponseHttp getOne(@RequestParam String listName) {
        Optional<PlayList> playListOpt = playListService.findByName(listName);

        if (! playListOpt.isPresent()) throw new ResourceNotFoundException(listName);

        ResponseHttp responseHttp = new ResponseHttp();
        responseHttp.setMessageBody(playListOpt.get());

        return responseHttp;
    }


    @RequestMapping(
            name ="/lists/{listName}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayList(@RequestBody PlayList playList){
        Optional<PlayList> playListOpt = playListService.findByName(playList.getName());
        if (!playListOpt.isPresent()) throw new ResourceNotFoundException(playList.getName());
        playListOpt.map(
                pl -> {
                    if (!pl.getName().equals(playList.getName())) throw new ResourceConflict();
                    return playListService.update(playList);
                }
        );
    }

    @DeleteMapping("/lists/{listName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayList(@RequestParam String listName){
        Optional<PlayList> playListOpt = playListService.findByName(listName);
        if (!playListOpt.isPresent()) throw new ResourceNotFoundException(listName);

        playListService.delete(playListOpt.get());
    }


}
