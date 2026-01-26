package com.apps.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "id",
        "name",
        "age",
        "email",
        "referenceNo",
        "address"
})
public class StudentDto {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private String referenceNo;

    private AddressDto address;
}
