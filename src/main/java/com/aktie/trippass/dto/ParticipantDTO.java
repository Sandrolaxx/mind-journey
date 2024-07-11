package com.aktie.trippass.dto;

import java.util.UUID;

public record ParticipantDTO(
        UUID id,
        String name,
        String email,
        boolean confirmed) {
}
