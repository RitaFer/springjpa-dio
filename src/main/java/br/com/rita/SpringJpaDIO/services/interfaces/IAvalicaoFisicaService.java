package br.com.rita.SpringJpaDIO.services.interfaces;

import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoRequest;
import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoUpdate;
import br.com.rita.SpringJpaDIO.models.AvaliacaoFisica;

import java.util.List;

public interface IAvalicaoFisicaService {

    /**
     * Salva avaliação física no banco de dados
     * @param avaliacaoFisicaDtoRequest - Dto com as informações para salvar a avaliação física
     * @return - avaliação física salva
     */
    AvaliacaoFisica save(AvaliacaoFisicaDtoRequest avaliacaoFisicaDtoRequest);

    /**
     * Retorna todos as avaliações físicas salvas
     * @return - todas as avaliações físicas salvas
     */
    List<AvaliacaoFisica> findAll();

    /**
     * Retorna avaliação física pelo id
     * @param id - Id da avaliação física a ser encontrada
     * @return - avaliação física com dados atualizados
     */
    AvaliacaoFisica findById(Long id);

    /**
     * Atualiza avaliação física pelo id
     * @param avaliacaoFisicaDtoUpdate - Dto com os dados para atualizar
     * @param id - Id da avaliação física a ser atualiazada
     * @return - avaliação física com dados atualizados
     */
    AvaliacaoFisica update(Long id, AvaliacaoFisicaDtoUpdate avaliacaoFisicaDtoUpdate);

    /**
     * Deleta avaliação física pelo id
     * @param id - Id da avaliação física a ser encontrada a ser deletada
     */
    void delete(Long id);
}
