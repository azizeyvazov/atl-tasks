package com.classroom.spring_boot_task.mapper;

import com.classroom.spring_boot_task.dto.AuthorRequest;
import com.classroom.spring_boot_task.dto.AuthorResponse;
import com.classroom.spring_boot_task.entity.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-09T19:31:30+0400",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorResponse entityToDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.setName( author.getName() );
        authorResponse.setSurname( author.getSurname() );
        authorResponse.setCreatedAt( author.getCreatedAt() );
        authorResponse.setUpdatedAt( author.getUpdatedAt() );

        return authorResponse;
    }

    @Override
    public Author dtoToEntity(AuthorRequest authorRequest) {
        if ( authorRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( authorRequest.getName() );
        author.setSurname( authorRequest.getSurname() );

        return author;
    }

    @Override
    public void updateAuthor(AuthorRequest authorRequest, Author author) {
        if ( authorRequest == null ) {
            return;
        }

        author.setName( authorRequest.getName() );
        author.setSurname( authorRequest.getSurname() );
    }
}
