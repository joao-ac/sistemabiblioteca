package com.joaoac.sistemabiblioteca.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joaoac.sistemabiblioteca.model.Livro;
import com.joaoac.sistemabiblioteca.model.Usuario;
import com.joaoac.sistemabiblioteca.repository.LivroRepositorio;
import com.joaoac.sistemabiblioteca.repository.UsuarioRepositorio;

@Configuration
public class DadosIniciais {

    @Bean
    CommandLineRunner initDatabase(LivroRepositorio livroRepositorio, UsuarioRepositorio usuarioRepositorio) {
        return args -> {
            // Adicionando alguns livros de exemplo
            Livro livro1 = Livro.builder()
                    .titulo("Dom Quixote")
                    .autor("Miguel de Cervantes")
                    .isbn("9788573264425")
                    .disponivel(true)
                    .build();
            
            Livro livro2 = Livro.builder()
                    .titulo("1984")
                    .autor("George Orwell")
                    .isbn("9788535914849")
                    .disponivel(true)
                    .build();

            livroRepositorio.save(livro1);
            livroRepositorio.save(livro2);

            // Adicionando alguns usuários de exemplo
            Usuario usuario1 = new Usuario();
            usuario1.setNome("João Silva");
            usuario1.setEmail("joaosilva@email.com.br");
            usuario1.setTipoUsuario(Usuario.TipoUsuario.PADRAO);

            Usuario usuario2 = new Usuario();
            usuario2.setNome("Maria Santos");
            usuario2.setEmail("mariasantos@email.com.br");
            usuario2.setTipoUsuario(Usuario.TipoUsuario.PREMIUM);

            usuarioRepositorio.save(usuario1);
            usuarioRepositorio.save(usuario2);
        };
    }
}
