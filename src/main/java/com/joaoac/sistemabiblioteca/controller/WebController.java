package com.joaoac.sistemabiblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoac.sistemabiblioteca.repository.EmprestimoRepositorio;
import com.joaoac.sistemabiblioteca.repository.UsuarioRepositorio;
import com.joaoac.sistemabiblioteca.service.LivroServico;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private LivroServico livroServico;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EmprestimoRepositorio emprestimoRepositorio;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("livros", livroServico.obterTodosLivros());
        model.addAttribute("usuarios", usuarioRepositorio.findAll());
        model.addAttribute("emprestimos", emprestimoRepositorio.findAll());
        return "home";
    }
}
