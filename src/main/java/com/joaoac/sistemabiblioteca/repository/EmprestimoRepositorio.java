package com.joaoac.sistemabiblioteca.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoac.sistemabiblioteca.model.Emprestimo;
import com.joaoac.sistemabiblioteca.model.Usuario;

@Repository
public interface EmprestimoRepositorio extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByUsuario(Usuario usuario);
    List<Emprestimo> findByDataDevolvidoIsNull();
    List<Emprestimo> findByUsuarioAndDataDevolvidoIsNull(Usuario usuario);
}
