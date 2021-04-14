package br.com.magacomunication.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

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

    @Column(name = "identifier", nullable = true)
    private String identifier;

    @Column(name = "dt_send", nullable = false)
    private ZonedDateTime dtSend;

    @Column(name = "message", nullable = false, length = 1000)
    private String message;

    @ManyToOne(targetEntity = TypeCommunication.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "type", nullable = false, updatable = false, insertable = false)
    private TypeCommunication type;

    //@Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Convert(converter = StatusCommunicationConverter.class)
    private StatusCommunicationEnum status;
}
