package br.com.magacomunication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusCommunicationEnum {
    PENDING(100, "Pending"),
    SENT(200, "Sent"),
    CANCELLED(300,"Cancelled");

    private final Integer code;
    private final String status;

    public static StatusCommunicationEnum valueOf(Integer code) {
        return code == null ? null : Arrays.stream(StatusCommunicationEnum.values())
                .filter(v -> v.code.equals(code))
                .findFirst()
                .orElse(null);
    }

}
