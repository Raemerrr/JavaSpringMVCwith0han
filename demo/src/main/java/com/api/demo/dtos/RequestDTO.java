package com.api.demo.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RequestDTO {
    private int page;
    private int perPage;
    private String cond;
}
