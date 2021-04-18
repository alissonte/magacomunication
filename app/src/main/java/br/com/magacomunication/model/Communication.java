package br.com.magacomunication.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "communication")
public class Communication implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "dt_send", nullable = false)
    private LocalDateTime dtSend;

    @Column(name = "message", nullable = false, length = 1000)
    private String message;

    @Column(name = "type")
    @Convert(converter = TypeCommunicationConverter.class)
    private TypeCommunicationEnum type;

    @Column(name = "status")
    @Convert(converter = StatusCommunicationConverter.class)
    private StatusCommunicationEnum status;
}
