package br.com.biblioteca.autor.service;



import br.com.biblioteca.autor.model.Livro;

import java.util.List;

public interface LivroService {
    List<Livro> getAllLivro();
    Livro getLivroById(Long id);
    Livro createLivro(Livro livro);
    Livro updateLivro(Long id, Livro livro);
    void deleteLivro(Long id);
}