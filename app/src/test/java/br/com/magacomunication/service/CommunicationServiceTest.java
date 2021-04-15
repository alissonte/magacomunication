package br.com.magacomunication.service;


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

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
                .dtSend(ZonedDateTime.now())
                .identifier("alissonte@gmail.com")
                .message("Fake message")
                .status(StatusCommunicationEnum.PENDING).build();

        final CommunicationDTO newCommunication = CommunicationDTO.builder()
                .id(5)
                .dtSend(ZonedDateTime.now())
                .identifier("alissonte@gmail.com")
                .message("Fake message")
                .status(StatusCommunicationEnum.PENDING).build();

        when(communicationMapper.map(communicationRepository.save(any(Communication.class)))).thenReturn(newCommunication);

        //When
        CommunicationDTO result = communicationService.saveNewScheduleCommunication(communicationDTO);

        //Then
        verify(communicationRepository, times(1)).save(any(Communication.class));
        assertEquals(result.getId(), newCommunication.getId());
        assertEquals(result.getIdentifier(), newCommunication.getIdentifier());
        assertEquals(result.getMessage(), newCommunication.getMessage());
        assertEquals(result.getStatus(), newCommunication.getStatus());
    }
}