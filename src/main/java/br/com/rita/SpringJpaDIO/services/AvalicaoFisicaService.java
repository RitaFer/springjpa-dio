package br.com.rita.SpringJpaDIO.services;

import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoRequest;
import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoUpdate;
import br.com.rita.SpringJpaDIO.models.Aluno;
import br.com.rita.SpringJpaDIO.models.AvaliacaoFisica;
import br.com.rita.SpringJpaDIO.repositories.AvaliacaoFisicaRepository;
import br.com.rita.SpringJpaDIO.services.exceptions.DataBaseException;
import br.com.rita.SpringJpaDIO.services.exceptions.ResourceNotFoundException;
import br.com.rita.SpringJpaDIO.services.interfaces.IAvalicaoFisicaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvalicaoFisicaService implements IAvalicaoFisicaService {

    private final AlunoService alunoService;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public AvalicaoFisicaService(AlunoService alunoService, AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.alunoService = alunoService;
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    @Override
    public AvaliacaoFisica save(AvaliacaoFisicaDtoRequest avaliacaoFisicaDtoRequest) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno byId = alunoService.findById(avaliacaoFisicaDtoRequest.getAlunoId());
        avaliacaoFisica.setAluno(byId);
        avaliacaoFisica.setAltura(avaliacaoFisicaDtoRequest.getAltura());
        avaliacaoFisica.setPeso(avaliacaoFisicaDtoRequest.getPeso());
        avaliacaoFisicaRepository.save(avaliacaoFisica);
        return avaliacaoFisica;
    }

    @Override
    public List<AvaliacaoFisica> findAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica findById(Long id) {
        return avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaDtoUpdate avaliacaoFisicaDtoUpdate) {
        AvaliacaoFisica avaliacao = findById(id);
        avaliacao.setPeso(avaliacaoFisicaDtoUpdate.getPeso());
        avaliacao.setAltura(avaliacaoFisicaDtoUpdate.getAltura());
        avaliacaoFisicaRepository.save(avaliacao);
        return avaliacao;
    }

    @Override
    public void delete(Long id) {
        try{
            avaliacaoFisicaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
