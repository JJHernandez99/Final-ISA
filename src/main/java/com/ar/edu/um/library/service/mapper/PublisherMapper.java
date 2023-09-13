package com.ar.edu.um.library.service.mapper;

import com.ar.edu.um.library.domain.Publisher;
import com.ar.edu.um.library.service.dto.PublisherDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Publisher} and its DTO {@link PublisherDTO}.
 */
@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherDTO, Publisher> {}
