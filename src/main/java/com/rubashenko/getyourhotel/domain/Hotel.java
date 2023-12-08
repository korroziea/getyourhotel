package com.rubashenko.getyourhotel.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Hotel {
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
    private Boolean hasWifi;
    @NotEmpty(message = "Conditioner cannot be empty")
    private Boolean hasConditioner;
}
