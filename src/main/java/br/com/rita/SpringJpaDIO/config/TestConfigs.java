package br.com.rita.SpringJpaDIO.config;

import br.com.rita.SpringJpaDIO.models.Aluno;
import br.com.rita.SpringJpaDIO.repositories.AlunoRepository;
import br.com.rita.SpringJpaDIO.repositories.AvaliacaoFisicaRepository;
import br.com.rita.SpringJpaDIO.repositories.MatriculaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfigs implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final MatriculaRepository matriculaRepository;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public TestConfigs(AlunoRepository alunoRepository, MatriculaRepository matriculaRepository, AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.alunoRepository = alunoRepository;
        this.matriculaRepository = matriculaRepository;
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Aluno aluno = new Aluno(null, "victor", "11353039676", "Sta maria", LocalDate.now(),null);
        alunoRepository.save(aluno);
    }
}
