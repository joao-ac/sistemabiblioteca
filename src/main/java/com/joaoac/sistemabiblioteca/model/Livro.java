package com.joaoac.sistemabiblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, unique = true)
    private String isbn;

    private boolean disponivel = true;

    // Builder Pattern
    public static class Builder {
        private String titulo;
        private String autor;
        private String isbn;
        private boolean disponivel = true;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder disponivel(boolean disponivel) {
            this.disponivel = disponivel;
            return this;
        }

        public Livro build() {
            Livro livro = new Livro();
            livro.titulo = this.titulo;
            livro.autor = this.autor;
            livro.isbn = this.isbn;
            livro.disponivel = this.disponivel;
            return livro;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
    
    // Construtores, getters e setters
    public Livro() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
