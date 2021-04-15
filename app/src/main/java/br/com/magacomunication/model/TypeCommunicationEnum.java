package br.com.magacomunication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TypeCommunicationEnum {

    EMAIL(1, "Email"),
    SMS(2, "Sms"),
    SENT(3, "Push"),
    CANCELLED(4,"Whatsapp");

    private final Integer code;
    private final String description;

    public static TypeCommunicationEnum valueOf(Integer code) {
        return code == null ? null : Arrays.stream(TypeCommunicationEnum.values())
                .filter(v -> v.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
