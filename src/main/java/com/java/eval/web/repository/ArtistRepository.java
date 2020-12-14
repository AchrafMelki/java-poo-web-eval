package com.java.eval.web.repository;

import com.java.eval.web.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    List<Artist> findByNameContaining(@Param("Name")String Name);

}