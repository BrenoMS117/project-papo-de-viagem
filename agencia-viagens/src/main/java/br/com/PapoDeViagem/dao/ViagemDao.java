package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.Viagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ViagemDao {

    public void criarTabelaViagem() {
        String SQLCriar = "CREATE TABLE IF NOT EXISTS VIAGEM (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NOME VARCHAR(100), " +
                "DATA VARCHAR(10), " +
                "PRECO DOUBLE, " +
                "DESCRICAO VARCHAR(255))";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            connection.prepareStatement(SQLCriar).execute();
            System.out.println("Tabela VIAGEM criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela VIAGEM: " + e.getMessage());
        }
    }

    public void inserirViagem(Viagem viagem) {
        String SQLInserir = "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLInserir);
            preparedStatement.setString(1, viagem.getNome());
            preparedStatement.setString(2, viagem.getData());
            preparedStatement.setDouble(3, viagem.getPreco());
            preparedStatement.setString(4, viagem.getDescricao());

            preparedStatement.execute();
            System.out.println("Viagem inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir viagem: " + e.getMessage());
        }
    }
}