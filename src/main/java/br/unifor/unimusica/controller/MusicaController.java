package br.unifor.unimusica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private List<Musica> musicas = new ArrayList<>();
    private AtomicInteger contadorMusicas = new AtomicInteger(0);

    @PostMapping
    public ResponseEntity<Musica> cadastrarMusica(@RequestBody Musica musica) {
        if (musica.getNome() == null || musica.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        musica.setId(contadorMusicas.incrementAndGet());
        musicas.add(musica);
        return ResponseEntity.status(HttpStatus.CREATED).body(musica);
    }

    @GetMapping
    public List<Musica> listarMusicas() {
        return musicas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarMusica(@PathVariable int id) {
        Optional<Musica> musica = musicas.stream()
                .filter(m -> m.getId() == id)
                .findFirst();

        if (musica.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(musica.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizarMusica(@PathVariable int id, @RequestBody Musica musicaAtualizada) {
        Optional<Musica> musicaOpt = musicas.stream()
                .filter(m -> m.getId() == id)
                .findFirst();

        if (musicaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Musica musica = musicaOpt.get();
        musica.setNome(musicaAtualizada.getNome());
        musica.setArtista(musicaAtualizada.getArtista());
        musica.setAnoLancamento(musicaAtualizada.getAnoLancamento());
        musica.setDuracao(musicaAtualizada.getDuracao());

        return ResponseEntity.ok(musica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable int id) {
        boolean removido = musicas.removeIf(m -> m.getId() == id);
        if (!removido) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
