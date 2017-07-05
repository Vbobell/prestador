package com.lucas.senac.topicosavancados.bean;

public class PrestadorServico {

    private int imagem;
    private String nome;
    private String profissao;
    private String cidade;
    private String endereco;

    public PrestadorServico(String nome, String profissao, String cidade, String endereco, int imagem) {
        this.imagem = imagem;
        this.nome = nome;
        this.profissao = profissao;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public PrestadorServico() {

    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PrestadorServico{" +
                "imagem=" + imagem +
                ", nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}

