package br.com.magacomunication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunicationDTO {

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Destinatário", required = true)
    @NotNull(message = "Destinatário não pode ser nulo")
    private String identifier;

    //@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @NotNull(message = "Data de envio não pode ser nulo")
    @JsonProperty("Data de envio")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dtSend;

    @JsonProperty(value = "Mensagem", required = true)
    @NotNull(message = "Mensagem não pode ser nulo")
    private String message;

    @JsonProperty("Tipo de Envio")
    @Builder.Default
    private TypeCommunicationEnum type = TypeCommunicationEnum.EMAIL;

    @JsonProperty("Status")
    @Builder.Default
    private StatusCommunicationEnum status = StatusCommunicationEnum.PENDING;
}
