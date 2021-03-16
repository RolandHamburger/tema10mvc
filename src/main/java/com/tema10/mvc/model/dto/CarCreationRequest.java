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
public class CarCreationRequest {

    private Integer id;

    @NotNull
    private String carModel;

    @NotNull
    private String carColour;

    @NotNull
    private int horsePower;

}
