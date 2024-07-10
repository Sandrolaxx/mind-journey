package com.aktie.mind_journey.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CreateTripDTO(
        String destination,
        LocalDateTime startAt,
        LocalDateTime endAt,
        List<String> guestsEmails,
        String ownerEmail,
        String ownerName) {
}
