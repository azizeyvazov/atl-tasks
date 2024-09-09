package com.classroom.spring_boot_task.mapper;

import com.classroom.spring_boot_task.dto.BookRequest;
import com.classroom.spring_boot_task.dto.BookResponse;
import com.classroom.spring_boot_task.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    BookResponse entityToDto(Book book);

    @Mapping(source = "authorId", target = "author.id")
    Book dtoToEntity(BookRequest bookRequest);
}
