package com.IntegrationAI.ProjectAiWebFlux.controller;


import com.IntegrationAI.ProjectAiWebFlux.model.MovieModel;
import com.IntegrationAI.ProjectAiWebFlux.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody MovieModel model){
        movieService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário adicionado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> listAllMovies(){
        return ResponseEntity.ok(movieService.listAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieModel>> findMovie(@PathVariable Long id){
        return ResponseEntity.ok(movieService.listById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Livro deletado com sucesso!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody MovieModel movie){
        return movieService.updateMovie(id,movie)
                .map(MovieIsPresent ->
                    ResponseEntity.ok(String.format("Movie %s atualizo", movie
                            .getNome())))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Filme não atualizado"));
    }
}
