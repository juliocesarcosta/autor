package br.com.biblioteca.autor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "autor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private Long idAutor;
    @Column(name = "nome_autor", nullable = false)
    private String nomeAutor;
    @Column(name = "sobrenome_autor", nullable = false)
    private String sobrenomeAutor;

}
