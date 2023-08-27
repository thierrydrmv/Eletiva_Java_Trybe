package com.example.PodcastApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Random;

@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
    private PodcastService service;
    @Autowired
    public PodcastRestController(PodcastService service) {
        this.service = service;
    }
    @GetMapping
    public String getRoot() {
        return "Yay Podscasts!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PodcastDto> getPodcast(@PathVariable Integer id) {
        if (id > 1000)
            return ResponseEntity.notFound().build();

        Podcast podcast = service.findPodcastById(id);

        PodcastDto podcastDto = new PodcastDto(
                podcast.getId(), podcast.getName(), podcast.getUrl()
        );

        return ResponseEntity.ok(podcastDto);
    }

    // ... restante da classe ...
    @GetMapping("/search")
    public String searchPodcast(@RequestParam String title) {
        return String.format("Você busacou por Podcasts com o título: %s", title);
    }

    @PostMapping
    public ResponseEntity<PodcastDto> newPodcast(@RequestBody PodcastCreationDto newPodcast) {
        Podcast podcast = service.createPodcast(newPodcast);

        PodcastDto podcastDto = new PodcastDto(
                podcast.getId(), podcast.getName(), podcast.getUrl()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(podcastDto);
    }

}