package br.com.magacomunication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("identifier")
    private String identifier;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @JsonProperty("dtSend")
    private ZonedDateTime dtSend;

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private String type;

    @JsonProperty("status")
    private StatusCommunicationEnum status;
}
