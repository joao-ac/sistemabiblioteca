package com.joaoac.sistemabiblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoac.sistemabiblioteca.model.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
    List<Livro> findByDisponivel(boolean disponivel);
    List<Livro> findByAutorContainingIgnoreCase(String autor);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
