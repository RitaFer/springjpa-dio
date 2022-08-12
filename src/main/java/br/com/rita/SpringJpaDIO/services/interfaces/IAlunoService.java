package br.com.rita.SpringJpaDIO.services.interfaces;

import br.com.rita.SpringJpaDIO.dtos.AlunoDtoRequest;
import br.com.rita.SpringJpaDIO.dtos.AlunoDtoUpdate;
import br.com.rita.SpringJpaDIO.models.Aluno;
import br.com.rita.SpringJpaDIO.models.AvaliacaoFisica;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAlunoService {

    /**
     * Salva aluno no banco de dados
     * @param alunoDtoRequest - Dto com as informações para salvar o aluno
     * @return - Aluno salvo
     */
    Aluno save(AlunoDtoRequest alunoDtoRequest);

    /**
     * Retorna todos os alunos salvos
     * @return - todos os alunos salvos
     */
    List<Aluno> findAll();

    /**
     * Retorna aluno pelo id
     * @param id - Id do aluno a ser encontrado
     * @return - Aluno com o id enviado no @param
     */
    Aluno findById(Long id);

    /**
     * Atualiza aluno pelo id
     * @param id - id do aluno a ser atualiazado
     * @param alunoDtoUpdate - Dto com os dados para atualizar
     * @return - aluno com dados atualizados
     */
    Aluno update(Long id, AlunoDtoUpdate alunoDtoUpdate);

    /**
     * Deleta aluno pelo id
     * @param id - id do aluno a ser deletado
     */
    void delete(Long id);

    /**
     * Retorna todas as avaliações físicas do aluno
     * @param id - id do aluno
     * @return - Retorna todas as avaliações físicas
     */
    List<AvaliacaoFisica> findAllAvaliacoesFisica(Long id);

}
