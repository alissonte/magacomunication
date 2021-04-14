package br.com.magacomunication.controller;

import br.com.magacomunication.model.Communication;
import br.com.magacomunication.repository.CommunicationRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/communication")
@RequiredArgsConstructor
public class CommunicationController {
    private final CommunicationRepository communicationRepository;

    @ApiOperation(value = "Recupera todos os envio de comunicação")
    @GetMapping(value = "/", produces = "application/json")
    public List<Communication> getCommunications() {
        return communicationRepository.findAll();
    }
}
