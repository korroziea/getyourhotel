package com.rubashenko.getyourhotel.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Rating cannot be empty")
    private Double rating;
    @NotEmpty(message = "Country cannot be empty")
    private String country;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "Distance to the sea cannot be empty")
    private Double distanceToSea;
    @NotEmpty(message = "Wi-Fi cannot be empty")
    private Boolean wifi;
    @NotEmpty(message = "Conditioner cannot be empty")
    private Boolean conditioner;
}