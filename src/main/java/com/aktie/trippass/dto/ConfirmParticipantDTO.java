package com.aktie.trippass.dto;

import java.util.UUID;

public record ConfirmParticipantDTO(
        String name,
        String email,
        UUID tripId) {
}
