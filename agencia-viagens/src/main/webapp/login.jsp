<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - TerraVista</title>
    <link rel="stylesheet" href="Styles/style-login.css">
    <link rel="stylesheet" href="Styles/header-footer.css">
</head>
<body>
    <header class="top-header">
        <div class="logo" onclick="window.location.href='/';">
        <img src="/img/mountain black 1.png" alt="TerraVista Logo">TerraVista
        </div>
    </header>


    <main class="main-elementos">
        <section class="formulario">
            <h1>BEM VINDO DE VOLTA!!</h1>
            <h2>VAMOS PARA MAIS UMA AVENTURA?</h2>
            <form class="login-form" action="/login" method="post">
                <input type="text" class="email" placeholder="Email ou nome de usuário" name="email" id="email" required>
                <input type="password" class="senha" placeholder="Senha" name="senha" id="senha" required>
                <% String erro = (String) request.getAttribute("erroLogin"); %>
                <% if (erro != null) { %>
                    <div style="color: red; font-weight: bold;">
                        <%= erro %>
                    </div>
                <% } %>
                <button type="submit" class="logar">Partiu? Novas aventuras</button>
                <p class="text-menor">Caso não possua uma conta cadastre-se</p>
                <button type="button" class="registrar" onclick="window.location.href='registro.html';">Registrar</button>
            </form>
        </section>

        <section class="image-section">
            <img src="img/imageCadastro 1.png" alt="Viagem" class="image">
        </section>
    </main>
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