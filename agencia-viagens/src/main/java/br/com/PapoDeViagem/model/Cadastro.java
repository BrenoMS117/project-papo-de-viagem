package br.com.PapoDeViagem.model;

public class Cadastro {
    private String nome;
    private String email;
    private String senha;
    private String data_nascimento;
    private String cpf;
    private boolean adm;

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public String getData_nascimento(){
        return data_nascimento;
    }

    public String getCpf(){
        return cpf;
    }

    public boolean getAdm() { return adm; }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setData_nascimento(String data_nascimento){
        this.data_nascimento = data_nascimento;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setAdm(boolean adm) { this.adm = adm; }

}
