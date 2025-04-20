package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.Usuario;
import br.com.PapoDeViagem.model.Viagem;


import java.sql.*;

public class UsuarioDao {

    public void criarUsuario(Usuario usuario){
        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, DATA_NASCIMENTO, CPF, ADM) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getData_nascimento());
            preparedStatement.setString(5, usuario.getCpf());
            preparedStatement.setBoolean(6, usuario.getAdm());
            preparedStatement.execute();

            System.out.println("Usuario Criado com Sucesso!");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println(e);

        }
    }

    public boolean login(Usuario usuario) {

        String SQL = "SELECT * FROM USUARIO WHERE EMAIL = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Usuario Criado com Sucesso!");

            while (resultSet.next()){
                String senha = resultSet.getString("senha");

                if(senha.equals(usuario.getSenha())){
                    return true;
                }
            }

            connection.close();

            return true;

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
            return false;
        }


    }

}


