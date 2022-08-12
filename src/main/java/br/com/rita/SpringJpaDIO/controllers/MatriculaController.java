package br.com.rita.SpringJpaDIO.controllers;

import br.com.rita.SpringJpaDIO.dtos.MatriculaDtoRequest;
import br.com.rita.SpringJpaDIO.models.Matricula;
import br.com.rita.SpringJpaDIO.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> findAll(){
        List<Matricula> all = matriculaService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Long id){
        Matricula byId = matriculaService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<Matricula> save(@RequestBody @Valid MatriculaDtoRequest matriculaDtoRequest){
        Matricula save = matriculaService.save(matriculaDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matricula> delete(@PathVariable Long id){
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
