package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.Autor;
import br.com.biblioteca.autor.repository.AutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class AutorServiceImplTest {

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorServiceImpl autorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAutor() {
        // Criar um autor para o teste
        Autor autor = new Autor();
        autor.setNomeAutor("João");
        autor.setSobrenomeAutor("costa");

        // Configurar o comportamento do repositório mockado
        when(autorRepository.save(any(Autor.class))).thenReturn(autor);

        // Chamar o método a ser testado
        Autor createdAutor = autorService.createAutor(autor);

        // Verificar o resultado
        assertEquals("João", createdAutor.getNomeAutor());
        assertEquals("costa", createdAutor.getSobrenomeAutor());
    }
}