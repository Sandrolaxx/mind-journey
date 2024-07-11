package com.aktie.trippass.dto;

import java.util.UUID;

public record LinkDTO(
        UUID id,
        String title,
        String url,
        UUID tripId) {
}
