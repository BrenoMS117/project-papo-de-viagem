<%@ page import="java.sql.*, java.util.*, br.com.PapoDeViagem.model.Viagem, br.com.PapoDeViagem.dao.ViagemDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ViagemDao dao = new ViagemDao();
    Viagem viagem = dao.buscarPorId(id);
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%= viagem.getNome() %> - TerraVista</title>
    <link rel="stylesheet" href="Styles/stylecompra.css" />
    <link rel="stylesheet" href="Styles/header-footer.css" />
</head>
<body>
<div class="header">
    <header class="top-header">
        <div class="logo">
            <img src="img/mountain black 1.png" alt="TerraVista Logo" />TerraVista
        </div>
        <nav>
            <a href="/destino">Destinos</a>
        </nav>
        <div class="auth-buttons">
            <button class="registro" onclick="window.location.href='registro.html';">Registrar</button>
            <button class="login" onclick="window.location.href='login.jsp';">Login</button>
        </div>
    </header>

    <section class="banner">
        <h1>
            Tenha A MELHOR VIAGEM DA SUA VIDA EM: <%= viagem.getNome() %>!!
        </h1>
    </section>
</div>

<section class="melhor-madrid">
    <div class="prop">
      <img src="img/<%= viagem.getImagem() %>" alt="">
        <h3>Conheça um pouco de <%= viagem.getNome() %></h3>
        <p>Planeje sua viagem agora mesmo!</p>
    </div>
</section>

<section class="pacotes-turisticos">
    <h3>Saiba mais sobre <%= viagem.getNome() %>:</h3>
    <br>

    <div class="pacotes">
        <div class="lista-pacotes">

            <p><%= viagem.getDescricao() %></p>
        </div>

        <div class="resumo-pacote">
            <div class="container-datas">
                <div class="datas">
                    <img src="img/Calendar.png" alt="" />
                </div>
                <div class="txt-data">
                    <strong>Data</strong>
                    <p><%= viagem.getData() %></p>
                </div>
            </div>

            <div class="total">
                <span>TOTAL:</span>
                <span id="total">R$<%= String.format("%.2f", viagem.getPreco() * 3) %></span>
            </div>
            <button class="btn" onclick="window.location.href='viagens.html';">Reservar</button>
        </div>

    </div>

</section>

<footer class="footer">
    <div class="footer-elementos">
        <div class="footer-esquerda">
            <div class="logo">
                <img src="img/Mountain.png" alt="TerraVista Logo" />TerraVista
            </div>
            <p>A PAZ QUE SÓ A VIAGEM TRAZ</p>
            <div class="social-icons">
                <img src="img/Instagram.png" alt="Instagram" />
                <img src="img/WhatsApp.png" alt="WhatsApp" />
                <img src="img/LinkedIn.png" alt="LinkedIn" />
            </div>
        </div>
        <div class="footer-meio">
            <ul>
                <li>BRASIL</li>
                <li>ESPANHA</li>
                <li>TURQUIA</li>
                <li>CANADÁ</li>
                <li>PERU</li>
                <li>INDONÉSIA</li>
            </ul>
        </div>
        <div class="footer-images">
            <img src="img/imageCadastro-sem fundo (1) 1.png" alt="Imagem Viajante" />
        </div>
    </div>
    <p class="copyright">&copy; COPYRIGHT TERRAVISTA 2025</p>
</footer>
</body>
</html>
