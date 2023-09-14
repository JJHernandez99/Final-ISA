package com.ar.edu.um.library.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ar.edu.um.library.domain.Book;
import com.ar.edu.um.library.service.dto.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookMapperTest {

    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        bookMapper = new BookMapperImpl();
    }

    @Test
    public void testDtoToEntityMapping() {
        // Crear un objeto BookDTO de prueba
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setIsbn("1234567890");
        bookDTO.setName("Sample Book");
        bookDTO.setPublishYear("2023");
        bookDTO.setCopies(5);

        // Realizar el mapeo de BookDTO a Book
        Book book = bookMapper.toEntity(bookDTO);

        // Verificar que el mapeo se ha realizado correctamente
        assertEquals(book.getId(), bookDTO.getId());
        assertEquals(book.getIsbn(), bookDTO.getIsbn());
        assertEquals(book.getName(), bookDTO.getName());
        assertEquals(book.getPublishYear(), bookDTO.getPublishYear());
        assertEquals(book.getCopies(), bookDTO.getCopies());
    }

    @Test
    public void testEntityToDtoMapping() {
        // Crear un objeto Book de prueba
        Book book = new Book();
        book.setId(2L);
        book.setIsbn("9876543210");
        book.setName("Another Book");
        book.setPublishYear("2022");
        book.setCopies(3);

        // Realizar el mapeo de Book a BookDTO
        BookDTO bookDTO = bookMapper.toDto(book);

        // Verificar que el mapeo se ha realizado correctamente
        assertEquals(bookDTO.getId(), book.getId());
        assertEquals(bookDTO.getIsbn(), book.getIsbn());
        assertEquals(bookDTO.getName(), book.getName());
        assertEquals(bookDTO.getPublishYear(), book.getPublishYear());
        assertEquals(bookDTO.getCopies(), book.getCopies());
    }

    @Test
    public void testNullDtoToEntityMapping() {
        // Intentar mapear un objeto BookDTO nulo
        BookDTO bookDTO = null;
        Book book = bookMapper.toEntity(bookDTO);

        // Verificar que el resultado sea nulo
        assertNull(book);
    }
}
