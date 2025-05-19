package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.Login;
import br.com.PapoDeViagem.model.Usuario;

import java.sql.*;

public class UsuarioDao {

    public void criarUsuario(Usuario usuario){

        String SQLCriar = "CREATE TABLE IF NOT EXISTS USUARIO ( ID INT AUTO_INCREMENT PRIMARY KEY, NOME VARCHAR(100), EMAIL VARCHAR(100), SENHA VARCHAR(100), DATA_NASCIMENTO VARCHAR(10), CPF VARCHAR(110), ADM BOOLEAN)";

        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, DATA_NASCIMENTO, CPF, ADM) VALUES (?, ?, ?, ?, ?, ?)";

        String BuscarAdm = "SELECT * FROM USUARIO WHERE EMAIL = 'adm@gmail.com'";

        String adm = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, DATA_NASCIMENTO, CPF, ADM) VALUES ('ADM', 'adm@gmail.com', 'admin', '06/11/2004', '12345678910', TRUE)";

        ViagemDao viagemDao = new ViagemDao();
        viagemDao.criarTabelaViagem();
        SuasViagensDao svDao = new SuasViagensDao();
        svDao.criarTabelaSuasViagens();

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");
            connection.prepareStatement(SQLCriar).execute();

            PreparedStatement checkAdm = connection.prepareStatement(BuscarAdm);
            ResultSet result = checkAdm.executeQuery();
            if (!result.next()) {
                connection.prepareStatement(adm).execute();
            }

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

    public boolean login(Login login) {

        String SQL = "SELECT * FROM USUARIO WHERE EMAIL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, login.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String senha = resultSet.getString("senha");


                if (senha.equals(login.getSenha())) {
                    System.out.println("Login bem-sucedido");
                    connection.close();
                    return true;
                }
            }
            connection.close();
            return false;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

}


