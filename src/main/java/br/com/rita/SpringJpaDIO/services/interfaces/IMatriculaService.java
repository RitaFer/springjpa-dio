package br.com.rita.SpringJpaDIO.services.interfaces;

import br.com.rita.SpringJpaDIO.dtos.MatriculaDtoRequest;
import br.com.rita.SpringJpaDIO.models.Matricula;

import java.util.List;

public interface IMatriculaService {

    /**
     *Salva matricula no banco de dados
     * @param matriculaDtoRequest - Dto com as informações para salvar a matrícula
     * @return - matrícula salva
     */
    Matricula save(MatriculaDtoRequest matriculaDtoRequest);

    /**
     * Retorna todos as matrículas salvas
     *
     * @return - todas as matrículas salvas
     */
    List<Matricula> findAll();

    /**
     * Retorna matrícula pelo id
     * @param id - Id da matrícula a ser encontrada
     * @return - matrícula com dados atualizados
     */
    Matricula findById(Long id);

    /**
     * Deleta matrícula pelo id
     * @param id - id da matrícula a ser deletada
     */
    void delete(Long id);
}
