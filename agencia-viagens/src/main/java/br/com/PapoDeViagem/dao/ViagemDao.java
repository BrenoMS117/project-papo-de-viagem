package br.com.PapoDeViagem.dao;

import br.com.PapoDeViagem.model.Viagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {

    public void criarTabelaViagem() {
        String SQLCriar = "CREATE TABLE IF NOT EXISTS VIAGEM (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NOME VARCHAR(100), " +
                "DATA VARCHAR(10), " +
                "PRECO DECIMAL(10,2), " +
                "DESCRICAO VARCHAR(255), " +
                "IMAGEM VARCHAR(255))";

        String verificar = "SELECT COUNT(*) FROM VIAGEM";

        String[] inserts = {
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Madrid, Espanha', '2025-06-01', 6800.00, 'Madrid é muito mais do que a capital da Espanha, é uma cidade que respira história e arte.', 'madrid.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Paris, França', '2025-06-10', 7900.00, 'Conhecida como a Cidade Luz, Paris é famosa por sua arquitetura icônica, e atmosfera romântica.', 'paris.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Cancun, México', '2025-07-05', 5400.00, 'Praias deslumbrantes, resorts all-inclusive e uma vida noturna animada.', 'cancun.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Bali, Indonésia', '2025-08-12', 8900.00, 'Praias paradisíacas, templos impressionantes e uma cultura rica e espiritual.', 'ball.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Nova York, EUA', '2025-09-20', 9200.00, 'Uma das cidades mais vibrantes do mundo, com atrações como Central Park, Broadway e a Estátua da Liberdade.', 'Nova York.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Cape Town, África do Sul', '2025-10-05', 7400.00, 'Beleza natural impressionante, com destaque para a Table Mountain e vinícolas renomadas.', 'cape_town.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Tóquio, Japão', '2025-11-01', 11000.00, 'Uma mistura única de tradição e modernidade, com templos antigos, tecnologia avançada e gastronomia incrível.', 'toquio.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Machu Pichu, Peru', '2025-12-10', 6500.00, 'Uma das maravilhas do mundo, com ruínas incas impressionantes e paisagens deslumbrantes.', 'machu_pichu.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Roma, Itália', '2026-01-15', 7800.00, 'História viva, com o Coliseu, o Vaticano e uma gastronomia inesquecível.', 'roma.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Amazonas, Brasil', '2026-02-20', 3800.00, 'Imagine adentrar a maior floresta tropical do planeta, onde a natureza reina soberana e cada passo revela uma nova surpresa.', 'amazonas.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Capadócia, Turquia', '2026-03-12', 8100.00, 'Imagine sobrevoar de balão vales repletos de formações rochosas esculpidas pelo tempo.', 'capadocia.png')",
            "INSERT INTO VIAGEM (NOME, DATA, PRECO, DESCRICAO, IMAGEM) VALUES ('Província Ontário, Canadá', '2026-04-18', 8700.00, 'Ontário é um destino que combina o charme das cidades vibrantes com a serenidade da natureza.', 'ontario.png')"
        };

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            connection.prepareStatement(SQLCriar).execute();
            System.out.println("Tabela Viagem criada com sucesso!");

            ResultSet rs = connection.prepareStatement(verificar).executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                for (String insert : inserts) {
                    connection.prepareStatement(insert).execute();
                }
                System.out.println("Viagens inseridas com sucesso.");
            } else {
                System.out.println("Viagens já existem no banco.");
            }

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

    public List<Viagem> listarTodas() {
        List<Viagem> lista = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            String sql = "SELECT * FROM VIAGEM";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Viagem viagem = new Viagem();
                viagem.setId(rs.getInt("ID"));
                viagem.setNome(rs.getString("NOME"));
                viagem.setData(rs.getString("DATA"));
                viagem.setPreco(rs.getDouble("PRECO"));
                viagem.setDescricao(rs.getString("DESCRICAO"));
                viagem.setImagem(rs.getString("IMAGEM")); // caminho da imagem
                lista.add(viagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Viagem buscarPorId(int id) {
        Viagem viagem = null;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM VIAGEM WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                viagem = new Viagem();
                viagem.setId(rs.getInt("ID"));
                viagem.setNome(rs.getString("NOME"));
                viagem.setData(rs.getDate("DATA").toString());
                viagem.setPreco(rs.getDouble("PRECO"));
                viagem.setDescricao(rs.getString("DESCRICAO"));
                viagem.setImagem(rs.getString("IMAGEM"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viagem;
    }
}