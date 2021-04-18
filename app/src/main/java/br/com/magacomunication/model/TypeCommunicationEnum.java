package br.com.magacomunication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TypeCommunicationEnum {
    EMAIL(1, "Email"),
    SMS(2, "Sms"),
    PUSH(3, "Push"),
    WHATSAPP(4,"WhatsApp");

    private final Integer code;
    private final String description;

    public static TypeCommunicationEnum valueOf(Integer code) {
        return code == null ? null : Arrays.stream(TypeCommunicationEnum.values())
                .filter(v -> v.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
