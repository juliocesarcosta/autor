package br.com.biblioteca.autor.controller;

import br.com.biblioteca.autor.model.AutorEntity;
import br.com.biblioteca.autor.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorEntity> getAllAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> getAutorById(@PathVariable Long id) {
        AutorEntity autor = autorService.getAutorById(id);
        return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AutorEntity> createAutor(@RequestBody AutorEntity autor) {
        AutorEntity createdAutor = autorService.createAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorEntity> updateAutor(@PathVariable Long id, @RequestBody AutorEntity autor) {
        AutorEntity updatedAutor = autorService.updateAutor(id, autor);
        return updatedAutor != null ? ResponseEntity.ok(updatedAutor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
