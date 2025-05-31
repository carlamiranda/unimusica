package br.unifor.unimusica.model;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private int anoLancamento;
    private String duracao;

    public Musica (int id, String nome, String artista, int anoLancamento, String duracao){
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getArtista(){
        return artista;
    }

    public void setArtista(String artista){
        this.artista = artista;
    }

    public int getAnoLancamento(){
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento){
        this.anoLancamento = anoLancamento;
    }

    public String getDuracao(){
        return duracao;
    }

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }
}