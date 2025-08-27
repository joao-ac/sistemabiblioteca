package com.joaoac.sistemabiblioteca.service.strategy;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class EstrategiaEmprestimoPremium implements EstrategiaEmprestimo {

    @Override
    public LocalDate calcularDataDevolucao(LocalDate dataEmprestimo) {
        return dataEmprestimo.plusDays(30);
    }

    @Override
    public int getDiasEmprestimoMax() {
        return 30;
    }

    @Override
    public int getMaximoEmprestimosSimultaneos() {
        return 10;
    }
    
}
