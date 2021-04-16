package br.com.magacomunication.common;

import lombok.Getter;

@Getter
public class CommunicationParamsException extends RuntimeException {

    public CommunicationParamsException(final String message) {
        super(message);
    }

}
