package com.classroom.spring_boot_task.mapper;

import com.classroom.spring_boot_task.dto.AuthorRequest;
import com.classroom.spring_boot_task.dto.AuthorResponse;
import com.classroom.spring_boot_task.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {

    AuthorResponse entityToDto(Author author);

    Author dtoToEntity(AuthorRequest authorRequest);

    void updateAuthor(AuthorRequest authorRequest, @MappingTarget Author author);
}
