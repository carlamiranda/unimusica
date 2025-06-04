package br.unifor.unimusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.unimusica.model.Musica;
import br.unifor.unimusica.repository.MusicaRepository;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository repository;

    @PostMapping
    public ResponseEntity<Musica> cadastrarMusica(@RequestBody Musica musica) {
        if (musica.getNome() == null || musica.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Musica salva = repository.save(musica);
        return ResponseEntity.status(201).body(salva);
    }

    @GetMapping
    public List<Musica> listarMusicas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarMusica(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizarMusica(@PathVariable String id, @RequestBody Musica nova) {
        return repository.findById(id).map(m -> {
            m.setNome(nova.getNome());
            m.setArtista(nova.getArtista());
            m.setAnoLancamento(nova.getAnoLancamento());
            m.setDuracao(nova.getDuracao());
            return ResponseEntity.ok(repository.save(m));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
