package com.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

@EqualsAndHashCode
public class EchoResponse {
    @NotEmpty
    private final String response;

    @JsonCreator
    public EchoResponse(@JsonProperty("response") String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
