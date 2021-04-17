package com.example.droolsrule.data;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestRequest {

    @NotBlank(message = "name can not be empty")
    private String name;
}
