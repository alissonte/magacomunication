package br.com.magacomunication.common;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static java.util.Objects.isNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String timestamp;
    private String message;
    private int status;
    private Long errorCode;

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    protected static String getMessage(Exception ex) {
        if (isNull(ex.getMessage())) {
            return ex.toString();
        }
        return ex.getMessage();
    }

    protected static Optional<Long> getErrorCode(Exception ex) {
        if (ex instanceof CommunicationParamsException) {
            CommunicationParamsException communicatonEx = (CommunicationParamsException) ex;
            return Optional.of(500L);
        }
        return Optional.empty();
    }
}