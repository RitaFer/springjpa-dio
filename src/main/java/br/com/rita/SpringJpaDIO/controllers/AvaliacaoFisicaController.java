package br.com.rita.SpringJpaDIO.controllers;

import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoRequest;
import br.com.rita.SpringJpaDIO.dtos.AvaliacaoFisicaDtoUpdate;
import br.com.rita.SpringJpaDIO.models.AvaliacaoFisica;
import br.com.rita.SpringJpaDIO.services.AvalicaoFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvalicaoFisicaService avalicaoFisicaService;

    public AvaliacaoFisicaController(AvalicaoFisicaService avalicaoFisicaService) {
        this.avalicaoFisicaService = avalicaoFisicaService;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> findAll(){
        List<AvaliacaoFisica> all = avalicaoFisicaService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> findById(@PathVariable Long id){
        AvaliacaoFisica byId = avalicaoFisicaService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> save(@RequestBody @Valid AvaliacaoFisicaDtoRequest avaliacaoFisicaDtoRequest){
        AvaliacaoFisica save = avalicaoFisicaService.save(avaliacaoFisicaDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id
            , @RequestBody @Valid AvaliacaoFisicaDtoUpdate avaliacaoFisicaDtoUpdate){
        AvaliacaoFisica update = avalicaoFisicaService.update(id, avaliacaoFisicaDtoUpdate);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> delete(@PathVariable Long id){
        avalicaoFisicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
