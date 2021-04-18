package br.com.magacomunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class DateTimeConfiguration {

    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();
//
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(ZonedDateTime.class, new StdScalarSerializer<ZonedDateTime>(ZonedDateTime.class) {
//
//            @Override
//            public void serialize(ZonedDateTime localDate, JsonGenerator jsonGenerator,
//                                  SerializerProvider serializerProvider) throws IOException {
//
//                jsonGenerator.writeString(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//            }
//        });


        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;

    }

}
