package com.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class RocketConfig extends Configuration {
    @NotEmpty
    private String rocketName;

    @JsonProperty
    public String getRocketName() {
        return rocketName;
    }
}
