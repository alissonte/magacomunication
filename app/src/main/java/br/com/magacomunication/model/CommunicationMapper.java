package br.com.magacomunication.model;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommunicationMapper {

    CommunicationMapper MAPPER = Mappers.getMapper(CommunicationMapper.class);

    CommunicationDTO map(Communication source);

    default Page<CommunicationDTO> map(Page<Communication> page) {
        return page.map(this::map);
    }

    default List<CommunicationDTO> map(List<Communication> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
