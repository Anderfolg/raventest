package com.anderfolg.ravenTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "customers")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "Full name is mandatory")
    @Size(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @Column(name = "phone")
    @Size(min = 6, max = 14, message = "Phone must be between 6 and 14 characters")
    @Pattern(regexp = "\\+[0-9]+$", message = "Invalid phone number format (+XXXXXXXXXX))")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
