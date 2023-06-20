package com.java668.gateway.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRespDTO {

    private Long id;
    private String name;

}