package com.eurosys.converter.repository.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Xpto {

        @JsonProperty("USDEUR")
        public Body body;

    @Override
    public String toString() {
        return "Xpto{" +
                "body=" + body +
                '}';
    }
}


