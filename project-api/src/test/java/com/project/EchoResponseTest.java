package com.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONObjectAs;

public class EchoResponseTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final JSONObject expectedJson = new JSONObject(fixture("fixtures/response.json"));
        final JSONObject actualJson = new JSONObject(MAPPER.writeValueAsString(new EchoResponse("andy")));
        assertThat(expectedJson, is(sameJSONObjectAs(actualJson)));
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final JSONObject actualJson = new JSONObject(fixture("fixtures/response.json"));
        final JSONObject expectedJson = new JSONObject(MAPPER.writeValueAsString(new EchoResponse("andy")));
        assertThat(expectedJson, is(sameJSONObjectAs(actualJson)));
    }


}