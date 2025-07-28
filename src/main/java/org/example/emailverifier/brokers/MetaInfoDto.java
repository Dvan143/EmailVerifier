package org.example.emailverifier.brokers;

import java.io.Serial;
import java.io.Serializable;

public class MetaInfoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String projectName;
    private String senderUsername;
    private String to;
    private String senderIp;
    private String secretCode;

    public String getProjectName() {
        return projectName;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getTo() {
        return to;
    }

    public String getSenderIp() {
        return senderIp;
    }

    public String getSecretCode() {
        return secretCode;
    }
}

