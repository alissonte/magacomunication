package br.com.magacomunication.controller;

import br.com.magacomunication.model.Communication;
import br.com.magacomunication.repository.CommunicationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Magalu Communication"})
@RestController
@RequestMapping(path = "/communication")
@RequiredArgsConstructor
public class CommunicationController {
    private final CommunicationRepository communicationRepository;

    @ApiOperation(value = "Recupera todos os envios de comunicação")
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Page<Communication>> getCommunications() {
        return ResponseEntity.ok().body(communicationRepository.findAll(Pageable.unpaged()));
    }
}
