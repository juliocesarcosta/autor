package br.com.biblioteca.autor.controller;


import br.com.biblioteca.autor.model.Livro;
import br.com.biblioteca.autor.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.getAllLivro();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        Livro livro = livroService.getLivroById(id);
        return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro createdLivro = livroService.createLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro updatedLivro = livroService.updateLivro(id, livro);
        return updatedLivro != null ? ResponseEntity.ok(updatedLivro) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }
}
