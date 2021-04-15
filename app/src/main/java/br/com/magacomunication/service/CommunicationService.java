package br.com.magacomunication.service;

import br.com.magacomunication.model.Communication;
import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.model.CommunicationMapper;
import br.com.magacomunication.model.TypeCommunication;
import br.com.magacomunication.repository.CommunicationRepository;
import br.com.magacomunication.repository.TypeCommunicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

import static org.springframework.util.StringUtils.hasLength;

@Service
@AllArgsConstructor
@Slf4j
public class CommunicationService {
    private final CommunicationRepository communicationRepository;
    private final TypeCommunicationRepository typeCommunicationRepository;
    private final CommunicationMapper communicationMapper;

    public Page<CommunicationDTO> findAllCommunication() {
        return communicationMapper.map(communicationRepository.findAll(Pageable.unpaged()));
    }

    public CommunicationDTO saveNewScheduleCommunication(final CommunicationDTO communicationDTO) {
        final String type = communicationDTO.getType();
        final TypeCommunication tc = hasLength(type) ? typeCommunicationRepository.findByName(type).orElse(null) : null;

        Communication communication = Communication.builder()
                .identifier(communicationDTO.getIdentifier())
                .dtSend(ZonedDateTime.now())
                .message(communicationDTO.getMessage())
                .type(tc)
                .build();

        return communicationMapper.map(communicationRepository.save(communication));
    }
}