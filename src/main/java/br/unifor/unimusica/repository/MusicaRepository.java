package br.unifor.unimusica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unifor.unimusica.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
}
