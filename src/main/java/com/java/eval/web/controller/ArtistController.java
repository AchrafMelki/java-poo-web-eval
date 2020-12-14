package com.java.eval.web.controller;
import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping(value = "/artist")
    public class ArtistController {

        @Autowired
        private ArtistRepository artistRepository;

        @RequestMapping(
                value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE,
                method = RequestMethod.GET
        )
        public Optional<Artist> findById(@PathVariable(value = "Artistid") Integer Artistid){
                return artistRepository.findById(Artistid);
        }
        @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = "name")
        public List<Artist> findByName(@RequestParam("Name") String Name){
            return artistRepository.findByNameContaining(Name);
        }
        @RequestMapping(value="",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        public Page<Artist> listArtist(@RequestParam(defaultValue = "0", value = "page") Integer page ,
                                    @RequestParam(defaultValue = "20", value="size")Integer size,
                                    @RequestParam(defaultValue = "Name", value = "sortProperty") String sProp,
                                    @RequestParam(defaultValue = "ASC", value = "sortDirection") String sDir)
        {
            Pageable pageable = PageRequest.of(page,size, Sort.Direction.fromString(sDir), sProp);
            return artistRepository.findAll(pageable);
        }
        @RequestMapping(value="",
                method = RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces =MediaType.APPLICATION_JSON_VALUE)
        public Artist addArtist(
                @RequestBody Artist artist){
            if(artistRepository.findByNameContaining(artist.getName())!=null){
                throw new DuplicateRequestException("L'artiste existe déjà");
            }
            else {
                return artistRepository.save(artist);
            }
        }
        @RequestMapping(value="{id}",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces =MediaType.APPLICATION_JSON_VALUE)
        public Artist editArtist(@RequestBody Artist artist,@PathVariable Integer Artistid){
            return artistRepository.save(artist);
            }
        @RequestMapping(value = "/{id}",
                method = RequestMethod.DELETE)
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void supprArtist (@PathVariable("id") Integer id) {
            artistRepository.deleteById(id);
        }


    }
