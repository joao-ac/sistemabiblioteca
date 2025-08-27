package com.joaoac.sistemabiblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoac.sistemabiblioteca.dto.LivroDTO;
import com.joaoac.sistemabiblioteca.model.Livro;
import com.joaoac.sistemabiblioteca.repository.LivroRepositorio;

@Service
public class LivroServico {

    @Autowired
    private LivroRepositorio livroRepositorio;

    public List<LivroDTO> obterTodosLivros() {
        return livroRepositorio.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<LivroDTO> obterLivroPorId(Long id) {
        return livroRepositorio.findById(id)
                .map(this::converterParaDTO);
    }

    public LivroDTO adicionarLivro(LivroDTO livroDTO) {
        Livro livro = Livro.builder()
                .titulo(livroDTO.getTitulo())
                .autor(livroDTO.getAutor())
                .isbn(livroDTO.getIsbn())
                .disponivel(true)
                .build();
        
        Livro livroSalvo = livroRepositorio.save(livro);
        return converterParaDTO(livroSalvo);
    }

    public List<LivroDTO> buscarLivros(String query) {
        List<Livro> livros = livroRepositorio.findByTituloContainingIgnoreCase(query);
        livros.addAll(livroRepositorio.findByAutorContainingIgnoreCase(query));
        return livros.stream()
                .distinct()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private LivroDTO converterParaDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setIsbn(livro.getIsbn());
        dto.setDisponivel(livro.isDisponivel());
        return dto;
    }
    
}
