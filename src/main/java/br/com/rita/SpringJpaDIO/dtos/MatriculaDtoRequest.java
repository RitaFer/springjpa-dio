package br.com.rita.SpringJpaDIO.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class MatriculaDtoRequest {

    @NotNull
    @Positive
    private Long alunoId;
}
