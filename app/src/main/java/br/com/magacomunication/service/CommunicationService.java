package br.com.magacomunication.service;

import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.model.CommunicationMapper;
import br.com.magacomunication.repository.CommunicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CommunicationService {
    private final CommunicationRepository communicationRepository;
    private final CommunicationMapper communicationMapper;

    public Page<CommunicationDTO> findAllCommunication() {
        return communicationMapper.map(communicationRepository.findAll(Pageable.unpaged()));
        //return null;
    }

}
