package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.Viagem;
import br.com.PapoDeViagem.model.Cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Viagemdao {

    public void criarViagem(Viagem Viagem) {

    }

    public void criarUsuario(Cadastro cadastro){
        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, DATA_NASCIMENTO, CPF, ADM) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cadastro.getNome());
            preparedStatement.setString(2, cadastro.getEmail());
            preparedStatement.setString(3, cadastro.getSenha());
            preparedStatement.setString(4, cadastro.getData_nascimento());
            preparedStatement.setString(5, cadastro.getCpf());
            preparedStatement.setBoolean(6, cadastro.getAdm());
            preparedStatement.execute();

            System.out.println("Usuario Criado com Sucesso!");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println(e);

        }
    }

}
