package com.tema10.mvc.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarUpdateRequest {

    private Integer id;

    private String carModel;

    private String carColour;

    private int horsePower;
}
