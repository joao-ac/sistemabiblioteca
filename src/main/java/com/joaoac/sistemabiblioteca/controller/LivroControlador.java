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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livros", description = "API para gerenciamento de livros")
public class LivroControlador {

    @Autowired
    private LivroServico livroServico;

    @Operation(summary = "Listar todos os livros", description = "Retorna uma lista com todos os livros cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de livros encontrada com sucesso")
    @GetMapping
    public List<LivroDTO> listarTodosLivros() {
        return livroServico.obterTodosLivros();
    }

    @Operation(summary = "Obter livro por ID", description = "Retorna um livro específico com base no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Livro encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> obterLivroPorId(
            @Parameter(description = "ID do livro", required = true) @PathVariable Long id) {
        return livroServico.obterLivroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Adicionar novo livro", description = "Adiciona um novo livro ao sistema")
    @ApiResponse(responseCode = "200", description = "Livro adicionado com sucesso")
    @PostMapping
    public LivroDTO adicionarLivro(
            @Parameter(description = "Dados do livro a ser adicionado", required = true) 
            @RequestBody LivroDTO livroDTO) {
        return livroServico.adicionarLivro(livroDTO);
    }

    @Operation(summary = "Buscar livros", description = "Busca livros com base em um termo de pesquisa")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @GetMapping("/buscar")
    public List<LivroDTO> buscarLivros(
            @Parameter(description = "Termo de busca", required = true) 
            @RequestParam String query) {
        return livroServico.buscarLivros(query);
    }

}
