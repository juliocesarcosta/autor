package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.AutorEntity;

import java.util.List;

public interface AutorService {
    List<AutorEntity> getAllAutores();
    AutorEntity getAutorById(Long id);
    AutorEntity createAutor(AutorEntity autor);
    AutorEntity updateAutor(Long id, AutorEntity autor);
    void deleteAutor(Long id);
}
