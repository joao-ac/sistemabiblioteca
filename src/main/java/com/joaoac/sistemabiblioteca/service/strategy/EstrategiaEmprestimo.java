package com.joaoac.sistemabiblioteca.service.strategy;

import java.time.LocalDate;

public interface EstrategiaEmprestimo {
    LocalDate calcularDataDevolucao(LocalDate dataEmprestimo);
    int getDiasEmprestimoMax();
    int getMaximoEmprestimosSimultaneos();
}
