<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.PapoDeViagem.model.Viagem" %>

<%
    List<Viagem> viagens = (List<Viagem>) request.getAttribute("viagens");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TerraVista</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="Styles/styledestino.css">
    <link rel="stylesheet" href="Styles/header-footer.css">
</head>
<body>
<div class="header">
    <header class="top-header">
        <div class="logo" onclick="window.location.href='/';">
            <img src="img/mountain black 1.png" alt="TerraVista Logo">TerraVista
        </div>
        <div class="auth-buttons">
            <button class="registro" onclick="window.location.href='registro.html';">Registrar</button>
            <button class="login" onclick="window.location.href='login.jsp';">Login</button>
        </div>
    </header>
    <section class="banner">
        <h2>Busque a nova viagem</h2>
        <h1>CONHECENDO NOVOS HORIZONTES</h1>
    </section>
    <div class="container-pesquisa">
        <section class="pesquisa">
            <input type="text" placeholder="Nome (A -> Z)">
            <input type="search" placeholder="Tipo de viagem">
            <input type="text" placeholder="Data disponível">
        </section>
    </div>
</div>
<section class="destinos">
    <h3>Conhecer Novos Destinos</h3>
    <div class="grid">
        <% for (Viagem viagem : viagens) { %>
            <div class="card">
                <img src="img/<%= viagem.getImagem() %>" alt="">
                <div class="info">
                    <h4><%= viagem.getNome() %></h4>
                    <p><%= viagem.getDescricao() %></p>
                    <div class="price-reserve">
                        <span>R$ <%= String.format("%.2f", viagem.getPreco()) %></span>
                        <a href="compra.jsp?id=<%= viagem.getId() %>">
                            <button class="btn">Reservar</button>
                        </a>
                    </div>
                </div>
            </div>
        <% } %>
    </div>
</section>

<footer class="footer">
    <div class="footer-elementos">
        <div class="footer-esquerda">
            <div class="logo">
                <img src="img/Mountain.png" alt="TerraVista Logo">TerraVista
            </div>
            <p>A PAZ QUE SÓ A VIAGEM TRAZ</p>
            <div class="social-icons">
                <img src="img/Instagram.png" alt="Instagram">
                <img src="img/WhatsApp.png" alt="WhatsApp">
                <img src="img/LinkedIn.png" alt="LinkedIn">
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
            <img src="img/imageCadastro-sem fundo (1) 1.png" alt="Imagem Viajante">
        </div>
    </div>
    <p class="copyright">&copy; COPYRIGHT TERRAVISTA 2025</p>
</footer>
</body>
</html>
