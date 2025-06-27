package org.example.emailverifier.brokers;

import java.io.Serial;
import java.io.Serializable;

public class MqDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String to;
    private final String secretCode;

    public String getTo() {
        return to;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public MqDto(String to, String secretCode) {
        this.to = to;
        this.secretCode = secretCode;
    }
}
