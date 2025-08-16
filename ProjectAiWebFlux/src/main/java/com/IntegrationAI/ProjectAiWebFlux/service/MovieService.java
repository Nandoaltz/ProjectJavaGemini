package com.IntegrationAI.ProjectAiWebFlux.service;

import com.IntegrationAI.ProjectAiWebFlux.model.MovieModel;
import com.IntegrationAI.ProjectAiWebFlux.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieModel save(MovieModel movie){
        return movieRepository.save(movie);
    }

    public List<MovieModel> listAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<MovieModel> listById(Long id){
        return movieRepository.findById(id);
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public Optional<MovieModel> updateMovie(Long id, MovieModel movie) {
        return movieRepository
                .findById(id)
                .map(movieExists -> {
            movie.setId(id);
            movie.setDataDeCadastro(Instant.now());
            return movieRepository.save(movie);
        });
    }
}
