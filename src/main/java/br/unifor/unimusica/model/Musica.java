package br.unifor.unimusica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musicas")
public class Musica {

    @Id
    private String id; 
    private String nome;
    private String artista;
    private int anoLancamento;
    private int duracao;

    public Musica() {}

    public Musica(String nome, String artista, int anoLancamento, int duracao) {
        this.nome = nome;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }
}
