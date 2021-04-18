package br.com.magacomunication.service;

import br.com.magacomunication.common.CommunicationParamsException;
import br.com.magacomunication.model.Communication;
import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.model.CommunicationMapper;
import br.com.magacomunication.model.StatusCommunicationEnum;
import br.com.magacomunication.repository.CommunicationRepository;
import br.com.magacomunication.repository.TypeCommunicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasLength;

@Service
@AllArgsConstructor
@Slf4j
public class CommunicationService {
    private final CommunicationRepository communicationRepository;
    private final TypeCommunicationRepository typeCommunicationRepository;
    private final CommunicationMapper communicationMapper;

    /**
     *
     * @return
     */
    public List<CommunicationDTO> findAllCommunication() {
        List<Communication> communications = communicationRepository.findAll();
        return communicationMapper.map(communications);
    }

    /**
     *
     * @param communicationDTO
     * @return
     */
    public CommunicationDTO saveScheduleCommunication(final CommunicationDTO communicationDTO) {
        if(!(hasLength(communicationDTO.getMessage()) && hasLength(communicationDTO.getIdentifier()) && communicationDTO.getDtSend() != null)){
            throw new CommunicationParamsException("Parâmetros inválidos");
        }

        Communication communication = buildCommunication(communicationDTO);

        return communicationMapper.map(communicationRepository.save(communication));
    }

    /**
     *
     * @param id
     * @return
     */
    public CommunicationDTO findCommunicationById(final Integer id) {
        Communication communication = getCommunicationById(id);
        return communicationMapper.map(communication);
    }

    /**
     *
     * @param name
     * @return
     */
    public List<CommunicationDTO> findCommunicationByRecipient(final String name) {
        List<Communication> communications = communicationRepository.findAllByIdentifier(name);
        return communicationMapper.map(communications);
    }

    /**
     *
     * @param id
     * @return
     */
    public CommunicationDTO cancelCommunication(final Integer id) {
        Communication communication = getCommunicationById(id);
        communication.setStatus(StatusCommunicationEnum.CANCELLED);
        return communicationMapper.map(communicationRepository.save(communication));
    }

    /**
     *
     * @param id
     */
    public void deleteCommunication(Integer id) {
        getCommunicationById(id);
        communicationRepository.deleteById(id);
    }

    /**
     *
     * @param id
     * @param communicationDTO
     * @return
     */
    public CommunicationDTO updateCommunication(final Integer id, final CommunicationDTO communicationDTO) {
        if(!communicationRepository.existsCommunicationById(id)) {
            throw new EntityNotFoundException("Communication not found");
        }

        Communication communication = buildCommunication(communicationDTO);
        communication.setId(id);

        return communicationMapper.map(communicationRepository.save(communication));
    }

    private Communication getCommunicationById(Integer id) {
        Communication communication = communicationRepository.findById(id).orElse(null);
        if (isNull(communication)) {
            throw new EntityNotFoundException("Communication not found");
        }
        return communication;
    }

    private Communication buildCommunication(CommunicationDTO communicationDTO) {
        return Communication.builder()
                .identifier(communicationDTO.getIdentifier())
                .dtSend(LocalDateTime.now())
                .message(communicationDTO.getMessage())
                .type(communicationDTO.getType())
                .status(communicationDTO.getStatus())
                .build();
    }
}