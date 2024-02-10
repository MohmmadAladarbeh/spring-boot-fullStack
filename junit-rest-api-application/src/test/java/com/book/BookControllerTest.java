package com.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rest.app.Book;
import com.rest.app.controllers.BookController;
import com.rest.app.BookRepository;
import com.rest.app.BookServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {


    @Mock
    private BookRepository bookRepository;
    private BookServices underTest;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    BookRepository bookRepositoryUnderTest;

    @InjectMocks
    BookController bookControllerUnderTest;

    @BeforeEach
    void setUp() {
        underTest = new BookServices(bookRepository);
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(bookRepositoryUnderTest).build();

    }

    @Test
    public void addBook () {

        Book book = new Book(
                1L,
                23L,
                "mohammad",
                "Body"
        );

        underTest.addNewBook(book);

        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        verify(bookRepository).save(argumentCaptor.capture());

        Book capturedValue = argumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(book);
    }

}
