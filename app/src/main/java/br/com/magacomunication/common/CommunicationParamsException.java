package br.com.magacomunication.common;

import lombok.Getter;

@Getter
public class CommunicationParamsException extends RuntimeException{

    public CommunicationParamsException(String message) {
        super(message);
    }
}
