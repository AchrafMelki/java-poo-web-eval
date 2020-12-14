package com.java.eval.web.controller;
import com.java.eval.web.model.Album;
import com.java.eval.web.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @RequestMapping(value="",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Album CreateAlbum(@RequestBody Album album){
        AlbumController albumService;
        return albumRepository.save(album);
    }
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteAlbum (@PathVariable("id") Integer id) {
        albumRepository.deleteById(id);
    }
}
