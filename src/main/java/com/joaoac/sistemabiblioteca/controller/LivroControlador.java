package com.joaoac.sistemabiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaoac.sistemabiblioteca.dto.LivroDTO;
import com.joaoac.sistemabiblioteca.service.LivroServico;

@RestController
@RequestMapping("/api/livros")
public class LivroControlador {

    @Autowired
    private LivroServico livroServico;

    @GetMapping
    public List<LivroDTO> listarTodosLivros() {
        return livroServico.obterTodosLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> obterLivroPorId(@PathVariable Long id) {
        return livroServico.obterLivroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LivroDTO adicionarLivro(@RequestBody LivroDTO livroDTO) {
        return livroServico.adicionarLivro(livroDTO);
    }

    @GetMapping("/buscar")
    public List<LivroDTO> buscarLivros(@RequestParam String query) {
        return livroServico.buscarLivros(query);
    }

}
