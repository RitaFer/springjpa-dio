package br.com.rita.SpringJpaDIO.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AlunoDtoRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Size(min = 3)
    private String bairro;
    @NotNull
    @Past
    private LocalDate dataNascimento;

}
