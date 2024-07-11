package com.aktie.trippass.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityDTO(
        UUID id,
        String title,
        LocalDateTime date,
        UUID tripId) {
}
