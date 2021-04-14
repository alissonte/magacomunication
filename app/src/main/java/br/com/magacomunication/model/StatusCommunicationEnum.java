package br.com.magacomunication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusCommunicationEnum {
    PENDING(100),
    SENT(200),
    CANCELLED(300);

    private final Integer status;

    public static StatusCommunicationEnum valueOf(Integer status) {
        return status == null ? null : Arrays.stream(StatusCommunicationEnum.values())
                .filter(v -> v.status.equals(status))
                .findFirst()
                .orElse(null);
    }

}
