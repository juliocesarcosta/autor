package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> getAllAutores();
    Autor getAutorById(Long id);
    Autor createAutor(Autor autor);
    Autor updateAutor(Long id, Autor autor);
    void deleteAutor(Long id);
}
