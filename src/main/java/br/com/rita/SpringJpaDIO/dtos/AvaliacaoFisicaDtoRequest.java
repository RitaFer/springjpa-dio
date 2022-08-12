package br.com.rita.SpringJpaDIO.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AvaliacaoFisicaDtoRequest {

    @NotNull
    @Positive
    private Long alunoId;
    @NotNull
    @Positive
    private Double peso;
    @NotNull
    @Positive
    private Double altura;
}
