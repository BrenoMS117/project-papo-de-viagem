package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.SuasViagens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SuasViagensDao {

    public void criarTabelaSuasViagens() {

        String SQLCriar = "CREATE TABLE IF NOT EXISTS SUAS_VIAGENS (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "ID_USUARIO INT, " +
                "ID_VIAGEM INT, " +
                "DATA_COMPRA VARCHAR(10))";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            connection.prepareStatement(SQLCriar).execute();
            connection.close();
            System.out.println("Tabela SUAS_VIAGENS criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela SUAS_VIAGENS: " + e.getMessage());
        }
    }

    public void registrarCompra(SuasViagens sv) {

        String SQLInserir = "INSERT INTO SUAS_VIAGENS (ID_USUARIO, ID_VIAGEM, DATA_COMPRA) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement ps = connection.prepareStatement(SQLInserir);
            ps.setInt(1, sv.getIdUsuario());
            ps.setInt(2, sv.getIdViagem());
            ps.setString(3, sv.getDataCompra());

            ps.execute();
            System.out.println("Compra registrada com sucesso!");

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao registrar compra: " + e.getMessage());
        }
    }
}
