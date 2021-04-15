package br.com.magacomunication.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommunicationMapper {

    CommunicationMapper MAPPER = Mappers.getMapper(CommunicationMapper.class);

    @Mapping(target = "type", source = "source.type.name")
    CommunicationDTO map(Communication source);

    default Page<CommunicationDTO> map(Page<Communication> page) {
        return page.map(this::map);
    }
}
