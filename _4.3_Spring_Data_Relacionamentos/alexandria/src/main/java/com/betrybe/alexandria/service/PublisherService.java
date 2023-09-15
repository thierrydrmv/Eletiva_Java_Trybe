package com.betrybe.alexandria.service;

import com.betrybe.alexandria.models.entities.Publisher;
import com.betrybe.alexandria.models.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher insertPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Optional<Publisher> updatePublisher(Long id, Publisher publisher) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);

        if(optionalPublisher.isPresent()) {
            Publisher publishFromDB = optionalPublisher.get();
            publishFromDB.setAddress(publisher.getAddress());
            publishFromDB.setName(publisher.getName());

            Publisher updatedPublisher = publisherRepository.save(publishFromDB);
            return Optional.of(updatedPublisher);
        }

        return optionalPublisher;
    }

    public Optional<Publisher> removePublisherById(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);

        if(publisherOptional.isPresent()) {
            publisherRepository.deleteById(id);
        }

        return publisherOptional;
    }

    public Optional<Publisher> getPublishersById(Long id) {
        return publisherRepository.findById(id);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
