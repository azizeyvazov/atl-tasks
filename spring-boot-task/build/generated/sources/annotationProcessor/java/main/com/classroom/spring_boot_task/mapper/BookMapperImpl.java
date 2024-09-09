package com.classroom.spring_boot_task.mapper;

import com.classroom.spring_boot_task.dto.BookRequest;
import com.classroom.spring_boot_task.dto.BookResponse;
import com.classroom.spring_boot_task.entity.Author;
import com.classroom.spring_boot_task.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-09T20:24:02+0400",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponse entityToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setAuthorId( bookAuthorId( book ) );
        bookResponse.setName( book.getName() );
        bookResponse.setCount( book.getCount() );
        bookResponse.setCreatedAt( book.getCreatedAt() );
        bookResponse.setUpdatedAt( book.getUpdatedAt() );

        return bookResponse;
    }

    @Override
    public Book dtoToEntity(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookRequestToAuthor( bookRequest ) );
        book.setName( bookRequest.getName() );
        book.setCount( bookRequest.getCount() );

        return book;
    }

    private Long bookAuthorId(Book book) {
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getId();
    }

    protected Author bookRequestToAuthor(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( bookRequest.getAuthorId() );

        return author;
    }
}
