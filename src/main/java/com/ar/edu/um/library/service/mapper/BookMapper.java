package com.ar.edu.um.library.service.mapper;

import com.ar.edu.um.library.domain.Author;
import com.ar.edu.um.library.domain.Book;
import com.ar.edu.um.library.domain.Publisher;
import com.ar.edu.um.library.service.dto.AuthorDTO;
import com.ar.edu.um.library.service.dto.BookDTO;
import com.ar.edu.um.library.service.dto.PublisherDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Book} and its DTO {@link BookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDTO, Book> {
    @Mapping(target = "publisher", source = "publisher", qualifiedByName = "publisherName")
    @Mapping(target = "authors", source = "authors", qualifiedByName = "authorFirstNameSet")
    BookDTO toDto(Book s);

    @Mapping(target = "removeAuthor", ignore = true)
    Book toEntity(BookDTO bookDTO);

    @Named("publisherName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    PublisherDTO toDtoPublisherName(Publisher publisher);

    @Named("authorFirstName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    AuthorDTO toDtoAuthorFirstName(Author author);

    @Named("authorFirstNameSet")
    default Set<AuthorDTO> toDtoAuthorFirstNameSet(Set<Author> author) {
        return author.stream().map(this::toDtoAuthorFirstName).collect(Collectors.toSet());
    }
}
