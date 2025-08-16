package com.IntegrationAI.ProjectAiWebFlux.repository;

import com.IntegrationAI.ProjectAiWebFlux.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
