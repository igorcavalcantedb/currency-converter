package com.eurosys.converter.repository.util;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class AwesomeApi {
    private Map<String, AwesomeApiBody> properties;

    @JsonAnySetter
    public void add(String key, AwesomeApiBody value) {
        properties = new HashMap<>();
        properties.put(key, value);
    }
    public Map<String, AwesomeApiBody> getProperties() {
        return properties;
    }

}


