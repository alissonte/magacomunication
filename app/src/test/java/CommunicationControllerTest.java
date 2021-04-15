import br.com.magacomunication.controller.CommunicationController;
import br.com.magacomunication.model.CommunicationDTO;
import br.com.magacomunication.model.StatusCommunicationEnum;
import br.com.magacomunication.model.TypeCommunicationEnum;
import br.com.magacomunication.service.CommunicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class CommunicationControllerTest {

    private MockMvc mvc;

    @Mock
    private CommunicationService communicationService;

    @InjectMocks
    private CommunicationController communicationController;

    @Autowired
    private JacksonTester<CommunicationDTO> jsonCommunicationDTO;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(communicationController)
                .build();
    }

    @Disabled
    @Test
    public void canCreateACommunication() throws Exception {
        final CommunicationDTO communicationDTO = CommunicationDTO.builder()
            .dtSend(ZonedDateTime.parse("2021-04-14T21:04:44.527Z"))
            .identifier("alisson")
            .message("Teste mensagem controller")
            .status(StatusCommunicationEnum.PENDING)
            .type(TypeCommunicationEnum.EMAIL)
            .build();

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/communication").contentType(MediaType.APPLICATION_JSON).content(
                        jsonCommunicationDTO.write(communicationDTO).getJson()
                )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

}
