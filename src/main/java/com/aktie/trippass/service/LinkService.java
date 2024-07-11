package com.aktie.trippass.service;

import com.aktie.trippass.dto.LinkDTO;
import com.aktie.trippass.entities.Link;
import com.aktie.trippass.entities.Trip;
import com.aktie.trippass.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public LinkDTO addLink(LinkDTO dto, Trip trip) {
        var entity = new Link(dto, trip);

        repository.save(entity);

        return new LinkDTO(entity.getId(), entity.getTitle(), entity.getUrl(), trip.getId());
    }

    public List<LinkDTO> listByTripId(UUID tripId) {
        return repository.findByTripId(tripId).stream()
                .map(item -> new LinkDTO(item.getId(), item.getTitle(), item.getUrl(), item.getTrip().getId()))
                .toList();
    }

}
