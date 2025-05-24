package br.com.PapoDeViagem.servlet;

import br.com.PapoDeViagem.dao.UsuarioDao;
import br.com.PapoDeViagem.model.Login;
import br.com.PapoDeViagem.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Login login = new Login(email, senha);
        boolean valido = new UsuarioDao().login(login);


        if (valido) {
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", email); // ou um objeto Usuario, se preferir
            resp.sendRedirect("/"); // ou a página principal após login
        } else {
            req.setAttribute("erroLogin", "Usuário ou senha incorretos!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
