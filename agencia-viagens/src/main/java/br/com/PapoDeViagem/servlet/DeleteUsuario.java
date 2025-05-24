package br.com.PapoDeViagem.servlet;

import br.com.PapoDeViagem.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deletar-conta")
public class DeleteUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioLogado") != null) {
            String email = (String) session.getAttribute("usuarioLogado");

            UsuarioDao dao = new UsuarioDao();
            dao.deletarPorEmail(email);

            session.invalidate(); // encerra a sessão
        }

        resp.sendRedirect("login.jsp"); // volta para o login
    }
}
