package com.anderfolg.ravenTest.entities;

public record CustomerResponseDTO(
        Long id,
        String fullName,
        String email,
        String phone) {
}
