package br.com.magacomunication.controller;

import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.service.CommunicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Magalu Communication"})
@RestController
@RequestMapping(path = "/communication")
@RequiredArgsConstructor
public class CommunicationController {
    private final CommunicationService communicationService;

    @ApiOperation(value = "Recupera todos os agendamentos envios de comunicação")
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Page<CommunicationDTO>> getCommunications() {
        return ResponseEntity.ok().body(communicationService.findAllCommunication());
    }

    @ApiOperation(value = "Salva um agendamento envio de comunicação")
    @PostMapping
    public ResponseEntity<CommunicationDTO> createCommunication(final @Validated @RequestBody CommunicationDTO communicationDTO) {
        return ResponseEntity.ok().body(communicationService.saveNewScheduleCommunication(communicationDTO));
    }
}
