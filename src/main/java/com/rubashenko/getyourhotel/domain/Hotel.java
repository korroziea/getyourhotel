package com.rubashenko.getyourhotel.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Table(name = "hotels")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotNull(message = "Rating cannot be empty")
    private Double rating;
    @NotEmpty(message = "Country cannot be empty")
    private String country;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotNull(message = "Distance to the sea cannot be empty")
    private Double distanceToSea;
    @NotNull(message = "Wi-Fi cannot be empty")
    private Boolean wifi;
    @NotNull(message = "Conditioner cannot be empty")
    private Boolean conditioner;
}
