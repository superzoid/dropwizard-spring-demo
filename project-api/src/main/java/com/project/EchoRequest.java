package com.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

@EqualsAndHashCode
public class EchoRequest {
    @NotEmpty
    private final String request;

    @JsonCreator
    public EchoRequest(@JsonProperty("request") String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
}
