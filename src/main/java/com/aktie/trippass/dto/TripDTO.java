package com.aktie.trippass.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TripDTO(
        String destination,
        LocalDateTime startAt,
        LocalDateTime endAt,
        List<String> guestsEmails,
        String ownerEmail,
        String ownerName) {
}
