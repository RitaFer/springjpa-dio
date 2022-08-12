package br.com.rita.SpringJpaDIO.services;

import br.com.rita.SpringJpaDIO.dtos.AlunoDtoRequest;
import br.com.rita.SpringJpaDIO.dtos.AlunoDtoUpdate;
import br.com.rita.SpringJpaDIO.models.Aluno;
import br.com.rita.SpringJpaDIO.models.AvaliacaoFisica;
import br.com.rita.SpringJpaDIO.repositories.AlunoRepository;
import br.com.rita.SpringJpaDIO.services.exceptions.DataBaseException;
import br.com.rita.SpringJpaDIO.services.exceptions.DuplicatedDataException;
import br.com.rita.SpringJpaDIO.services.exceptions.ResourceNotFoundException;
import br.com.rita.SpringJpaDIO.services.interfaces.IAlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno save(AlunoDtoRequest alunoDtoRequest) {

        Optional<Aluno> byCpf = alunoRepository.findByCpf(alunoDtoRequest.getCpf());
        if(byCpf.isPresent()){
            throw new DuplicatedDataException("CPF already registered!");
        }

        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDtoRequest, aluno);
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Aluno update(Long id, AlunoDtoUpdate alunoDtoUpdate) {
        Aluno aluno = findById(id);
        BeanUtils.copyProperties(alunoDtoUpdate, aluno);
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public void delete(Long id) {
        try{
            alunoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    @Override
    public List<AvaliacaoFisica> findAllAvaliacoesFisica(Long id) {
        Aluno aluno = findById(id);
        return aluno.getAvaliacoesFisica();
    }

}
