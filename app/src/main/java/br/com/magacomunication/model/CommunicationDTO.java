package br.com.magacomunication.model;

import br.com.magacomunication.common.CustomLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunicationDTO {

    @JsonIgnore
    private Integer id;

    @JsonProperty(value = "Destinatário", required = true)
    @NotNull
    private String identifier;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @NotNull
    @JsonProperty(value = "Data/Hora", required = true)
    private ZonedDateTime dtSend;

    @JsonProperty(value = "Mensagem", required = true)
    @NotNull
    private String message;

    @JsonProperty("Tipo de Envio")
    private String type;

    @JsonProperty("Status")
    @Builder.Default
    private StatusCommunicationEnum status = StatusCommunicationEnum.PENDING;
}
