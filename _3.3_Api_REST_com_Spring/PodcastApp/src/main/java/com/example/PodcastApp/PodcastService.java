package com.example.PodcastApp;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PodcastService {
    /**
     * Método para simular busca por um podcast pelo ID.
     */
    public Podcast findPodcastById(Integer id) {
        Podcast podcast = new Podcast();
        podcast.setId(id);
        podcast.setName("Meu podcast");
        podcast.setUrl("http://www.meupodcast.com.br");
        podcast.setSecretToken("super-secret-token-123");
        return podcast;
    }
    /**
     * Método para simular a criação de um novo podcast.
     */
    public Podcast createPodcast(PodcastCreationDto newPodcastDto) {
        Podcast podcast = new Podcast();
        // Vamos fingir que estamos salvando o podcast ao atribuir um id aleatório a ele
        podcast.setId(new Random().nextInt(0, 1000));
        podcast.setName(newPodcastDto.name());
        podcast.setUrl(newPodcastDto.url());
        podcast.setSecretToken("super-secret-token-123");
        return podcast;
    }
}
