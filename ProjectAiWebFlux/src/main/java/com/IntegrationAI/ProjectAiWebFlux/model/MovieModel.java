package com.IntegrationAI.ProjectAiWebFlux.model;

import com.IntegrationAI.ProjectAiWebFlux.model.enums.MovieType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "movie_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;

    @CreationTimestamp
    private Instant dataDeCadastro;

    private MovieType movieType;
}
