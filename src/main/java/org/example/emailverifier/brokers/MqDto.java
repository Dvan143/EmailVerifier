package org.example.emailverifier.brokers;

public class MqDto {
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
