package br.com.biblioteca.autor.service;

import br.com.biblioteca.autor.model.AutorEntity;
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
    public List<AutorEntity> getAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public AutorEntity getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }


    @Override
    public AutorEntity createAutor(AutorEntity autor) {
        return autorRepository.save(autor);
    }

    @Override
    public AutorEntity updateAutor(Long id, AutorEntity autor) {
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
