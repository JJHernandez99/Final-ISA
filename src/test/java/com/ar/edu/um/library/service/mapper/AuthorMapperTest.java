package com.ar.edu.um.library.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ar.edu.um.library.domain.Author;
import com.ar.edu.um.library.service.dto.AuthorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @BeforeEach
    public void setUp() {
        authorMapper = new AuthorMapperImpl();
    }

    @Test
    public void testNullAuthorToEntity() {
        Author author = authorMapper.toEntity((AuthorDTO) null);

        assertNull(author);
    }

    @Test
    public void testAuthorToEntity() {
        AuthorDTO dto = new AuthorDTO(null, "test author");

        Author author = authorMapper.toEntity(dto);

        assertNotNull(author);
        assertEquals("test author", author.getFirstName());
    }

    @Test
    public void testPartialUpdate() {
        Author author = new Author();
        AuthorDTO dto = new AuthorDTO(null, "updated name");
        authorMapper.partialUpdate(author, dto);

        assertEquals(author.getFirstName(), "updated name");
    }
}
