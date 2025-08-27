package com.joaoac.sistemabiblioteca.service.strategy;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class EstrategiaEmprestimoPadrao implements EstrategiaEmprestimo {

    @Override
    public LocalDate calcularDataDevolucao(LocalDate dataEmprestimo) {
        return dataEmprestimo.plusDays(14);
    }

    @Override
    public int getDiasEmprestimoMax() {
        return 14;
    }

    @Override
    public int getMaximoEmprestimosSimultaneos() {
        return 3;
    }
    
}
