package com.apps.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "city",
        "country",
        "postalCode"
})
public record AddressDto(
        String country,
        String city,
        String postalCode
) {
}
