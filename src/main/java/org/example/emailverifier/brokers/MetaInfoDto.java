package org.example.emailverifier.brokers;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class MetaInfoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String projectName;
    private String senderUsername;
    private String to;
    private String secretCode;

}

