package br.com.magacomunication.service;

import br.com.magacomunication.common.CommunicationParamsException;
import br.com.magacomunication.model.Communication;
import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.model.CommunicationMapper;
import br.com.magacomunication.model.StatusCommunicationEnum;
import br.com.magacomunication.repository.CommunicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommunicationServiceTest {

    @InjectMocks
    private CommunicationService communicationService;

    @Mock
    private CommunicationRepository communicationRepository;

    @Mock
    private CommunicationMapper communicationMapper;

    @Test
    public void givenValidParameters_WhenProcess_saveCommunicationWithoutErrors() {
        //Given
        final CommunicationDTO communicationDTO = CommunicationDTO.builder()
                .dtSend(LocalDateTime.now())
                .identifier("alissonte@gmail.com")
                .message("Fake message")
                .status(StatusCommunicationEnum.PENDING).build();

        final CommunicationDTO newCommunication = CommunicationDTO.builder()
                .id(5)
                .dtSend(LocalDateTime.now())
                .identifier("alissonte@gmail.com")
                .message("Fake message")
                .status(StatusCommunicationEnum.PENDING).build();

        when(communicationMapper.map(communicationRepository.save(any(Communication.class)))).thenReturn(newCommunication);

        //When
        CommunicationDTO result = communicationService.saveScheduleCommunication(communicationDTO);

        //Then
        verify(communicationRepository, times(1)).save(any(Communication.class));
        assertEquals(result.getId(), newCommunication.getId());
        assertEquals(result.getIdentifier(), newCommunication.getIdentifier());
        assertEquals(result.getMessage(), newCommunication.getMessage());
        assertEquals(result.getStatus(), newCommunication.getStatus());
    }

    @Test
    public void givenInvalidParameters_WhenProcess_thenThrowsException() {
        //Given
        final CommunicationDTO communicationDTO = CommunicationDTO.builder()
                .identifier("alissonte@gmail.com")
                .message("Fake message")
                .status(StatusCommunicationEnum.PENDING).build();

        //When
        Exception exception = assertThrows(CommunicationParamsException.class, () -> communicationService.saveScheduleCommunication(communicationDTO));

        //Then
        assertEquals("Parâmetros inválidos", exception.getMessage());
    }

    @Test
    public void givenCallAllResult_WhenProcess_returnAllCommunications() {
        //Given
        final List<Communication> communications = getCommunications();
        final List<CommunicationDTO> communicationDTOS = getCommunicationsDTOs(communications);

        when(communicationRepository.findAll()).thenReturn(communications);
        when(communicationMapper.map(communications)).thenReturn(communicationDTOS);

        //When
        final List<CommunicationDTO> result = communicationService.findAllCommunication();

        //Then
        assertEquals(result.size(), communications.size());
    }

    @Test
    public void givenCommunicationIdValid_WhenProcess_theReturnCommunicationValid() {
        //Given
        final Integer id = 1;
        final Communication communication = getCommunication(1, "A", "Message A");
        final CommunicationDTO communicationDTO = getCommunicationDTO(1, "A", "Message A");
        when(communicationRepository.findById(id)).thenReturn(Optional.ofNullable(communication));
        when(communicationMapper.map(communication)).thenReturn(communicationDTO);

        //When
        CommunicationDTO result = communicationService.findCommunicationById(id);

        //Then
        assertEquals(result.getId(), communicationDTO.getId());
    }

    @Test
    public void givenCommunicationWithIdInvalid_WhenProcess_throwsException() {
        //Given
        final Integer id = 1;

        //When
        Exception exception = assertThrows(EntityNotFoundException.class, () -> communicationService.findCommunicationById(id));

        //Then
        assertEquals(exception.getMessage(), "Communication not found");
    }

    @Test
    public void givenParamCancelAndId_WhenProcess_thenCancelCommunication() {
        //Given
        final Integer id = 1;

        final Communication communication = getCommunication(1, "A", "Message A");
        final CommunicationDTO communicationDTO = getCommunicationDTO(1, "A", "Message A");
        communicationDTO.setStatus(StatusCommunicationEnum.CANCELLED);

        when(communicationRepository.findById(id)).thenReturn(Optional.ofNullable(communication));
        when(communicationMapper.map(communicationRepository.save(communication))).thenReturn(communicationDTO);

        //When
        CommunicationDTO result = communicationService.cancelCommunication(id);

        //Then
        assertEquals(result.getStatus(), communicationDTO.getStatus());
    }

    private List<CommunicationDTO> getCommunicationsDTOs(List<Communication> communications) {
        final CommunicationDTO c1 = getCommunicationDTO(1, "A", "Message A");
        final CommunicationDTO c2 = getCommunicationDTO(2, "B", "Message B");
        final CommunicationDTO c3 = getCommunicationDTO(3, "C", "Message C");
        return Arrays.asList(c1, c2, c3);
    }

    private List<Communication> getCommunications() {
        final Communication c1 = getCommunication(1, "A","Message A" );
        final Communication c2 = getCommunication(2, "B", "Message B");
        final Communication c3 = getCommunication(3, "C", "Message C");
        return Arrays.asList(c1, c2, c3);
    }

    private Communication getCommunication(final Integer id, final String recipient, final String message) {
        return Communication.builder().id(id).dtSend(LocalDateTime.now()).identifier(recipient).message(message).build();
    }

    private CommunicationDTO getCommunicationDTO(final Integer id, final String recipient, final String message) {
        return CommunicationDTO.builder().id(id).dtSend(LocalDateTime.now()).identifier(recipient).message(message).build();
    }
}