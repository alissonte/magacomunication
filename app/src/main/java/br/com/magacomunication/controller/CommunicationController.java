package br.com.magacomunication.controller;

import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.service.CommunicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Magalu Communication"})
@RestController
@RequestMapping(path = "/communication")
@RequiredArgsConstructor
public class CommunicationController {
    private final CommunicationService communicationService;

    @ApiOperation(value = "Consulta os envios",
            notes = "Este método consulta todos os agendamentos de envio de comunicação")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CommunicationDTO>> getCommunications() {
        return ResponseEntity.ok().body(communicationService.findAllCommunication());
    }

    @ApiOperation(value="Consulta Agendamento por ID", notes = "Consulta um envio de agendamento comunicação por id")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CommunicationDTO> getCommunicationById(final @PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(communicationService.findCommunicationById(id));
    }

    @ApiOperation(value = "Consulta por destinatário", notes = "Consulta os agendamentos de comunicação por destinatário")
    @GetMapping(value = "/recipient/{name}", produces = "application/json")
    public ResponseEntity<List<CommunicationDTO>> getCommunicationByReceiver(final @PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(communicationService.findCommunicationByRecipient(name));
    }

    @ApiOperation(value="Salva agendamento", notes = "Salva um agendamento envio de comunicação")
    @PostMapping
    public ResponseEntity<CommunicationDTO> createCommunication(final @Validated @RequestBody CommunicationDTO communicationDTO) {
        return ResponseEntity.ok().body(communicationService.saveScheduleCommunication(communicationDTO));
    }

    @ApiOperation(value="Cancela Agendamento", notes = "Cancela um agendamento envio de comunicação pelo id. Ao executar o agendamento ficará com o status 'Cancelled'")
    @PatchMapping(value = "/cancel/{id}")
    public ResponseEntity<CommunicationDTO> cancelCommunication(final @PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(communicationService.cancelCommunication(id));
    }

    @ApiOperation(value="Atualiza Agendamento", notes = "Atualiza um agendamento envio de comunicação pelo id.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CommunicationDTO> updateCommunication(final @PathVariable(value = "id") Integer id, final @Validated @RequestBody CommunicationDTO communicationDTO) {
        return ResponseEntity.ok().body(communicationService.updateCommunication(id, communicationDTO));
    }

    @ApiOperation(value="Deleta Agendamento", notes = "Deleta um agendamento envio de comunicação pelo id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCommunication(final @PathVariable(value = "id") Integer id) {
        communicationService.deleteCommunication(id);
        return ResponseEntity.noContent().build();
    }
}
