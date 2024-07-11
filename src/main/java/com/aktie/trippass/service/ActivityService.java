package com.aktie.trippass.service;

import com.aktie.trippass.dto.ActivityDTO;
import com.aktie.trippass.entities.Activity;
import com.aktie.trippass.entities.Trip;
import com.aktie.trippass.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public ActivityDTO addActivity(ActivityDTO dto, Trip trip) {
        var entity = new Activity(dto, trip);

        repository.save(entity);

        return new ActivityDTO(entity.getId(), entity.getTitle(), entity.getDate(), trip.getId());
    }

    public List<ActivityDTO> listByTripId(UUID tripId) {
        return repository.findByTripId(tripId).stream()
                .map(item -> new ActivityDTO(item.getId(), item.getTitle(), item.getDate(), item.getTrip().getId()))
                .toList();
    }

}
