package com.jorgefernandez.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {

    private Long id;
    private String name;
    private String lastName;
    private String documentationId;
    //TODO this could be an enum
    private String documentationType;
    private String country;

}
