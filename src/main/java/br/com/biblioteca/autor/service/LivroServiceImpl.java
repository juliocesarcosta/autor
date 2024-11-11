package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.Livro;
import br.com.biblioteca.autor.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public List<Livro> getAllLivro() {
        return livroRepository.findAll();  // Corrigido para retornar todos os livros
    }

    @Override
    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    @Override
    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public Livro updateLivro(Long id, Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id);  // Adicionado para garantir que o ID é atualizado corretamente
            return livroRepository.save(livro);
        }
        return null;
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}