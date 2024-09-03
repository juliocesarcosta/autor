package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.Autor;
import br.com.biblioteca.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }


    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(Long id, Autor autor) {
        if (autorRepository.existsById(id)) {
            autor.setIdAutor(id);
            return autorRepository.save(autor);
        }
        return null;
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
