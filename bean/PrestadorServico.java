package com.lucas.senac.topicosavancados.bean;

public class PrestadorServico {

    private int imagem;
    private String nome;
    private String profissao;
    private String cidade;
    private String bairro;
    private String endereco;
    private int dddT;
    private int telefone;
    private int dddW;
    private int whats;
    private String email;

    public PrestadorServico() {
    }

    public PrestadorServico(int imagem, String nome, String profissao, String cidade, String bairro, String endereco, int dddT, int telefone, int dddW, int whats, String email) {
        this.imagem = imagem;
        this.nome = nome;
        this.profissao = profissao;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.dddT = dddT;
        this.telefone = telefone;
        this.dddW = dddW;
        this.whats = whats;
        this.email = email;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDddT() {
        return dddT;
    }

    public void setDddT(int dddT) {
        this.dddT = dddT;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getDddW() {
        return dddW;
    }

    public void setDddW(int dddW) {
        this.dddW = dddW;
    }

    public int getWhats() {
        return whats;
    }

    public void setWhats(int whats) {
        this.whats = whats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PrestadorServico{" +
                "imagem=" + imagem +
                ", nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dddT=" + dddT +
                ", telefone=" + telefone +
                ", dddW=" + dddW +
                ", whats=" + whats +
                ", email='" + email + '\'' +
                '}';
    }
}

