package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.AutorEntity;
import br.com.biblioteca.autor.repository.AutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
        AutorEntity autor = new AutorEntity();
        autor.setNomeAutor("João");
        autor.setSobrenomeAutor("costa");

        // Configurar o comportamento do repositório mockado
        when(autorRepository.save(any(AutorEntity.class))).thenReturn(autor);

        // Chamar o método a ser testado
        AutorEntity createdAutor = autorService.createAutor(autor);

        // Verificar o resultado
        assertEquals("João", createdAutor.getNomeAutor());
        assertEquals("costa", createdAutor.getSobrenomeAutor());

        // Verificar se o método save foi chamado com o objeto correto
        verify(autorRepository).save(autor);
    }
}