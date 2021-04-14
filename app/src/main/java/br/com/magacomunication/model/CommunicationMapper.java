package br.com.magacomunication.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommunicationMapper {

    @Mapping(target = "type", source = "source.type.name")
    @Mapping(target = "dtSend", source = "dtSend", dateFormat="dd-MM-yyyy HH:mm:ss")
    CommunicationDTO map(Communication source);

    default Page<CommunicationDTO> map(Page<Communication> page) {
        return page.map(this::map);
    }
}
