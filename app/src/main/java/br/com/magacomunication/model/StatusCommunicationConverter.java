package br.com.magacomunication.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusCommunicationConverter implements AttributeConverter<StatusCommunicationEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(StatusCommunicationEnum attribute) {
        if(attribute == null) {
            return null;
        }
        return attribute.getStatus();
    }

    @Override
    public StatusCommunicationEnum convertToEntityAttribute(Integer status) {
        return StatusCommunicationEnum.valueOf(status);
    }
}
