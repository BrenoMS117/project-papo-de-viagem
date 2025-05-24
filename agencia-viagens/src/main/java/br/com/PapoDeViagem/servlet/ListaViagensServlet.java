package br.com.PapoDeViagem.servlet;

import br.com.PapoDeViagem.dao.ViagemDao;
import br.com.PapoDeViagem.model.Viagem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/destino")
public class ListaViagensServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViagemDao dao = new ViagemDao();
        List<Viagem> viagens = dao.listarTodas();

        req.setAttribute("viagens", viagens);
        req.getRequestDispatcher("destino.jsp").forward(req, resp);
        req.getRequestDispatcher("viagens.html").forward(req, resp);
        req.getRequestDispatcher("conta.html").forward(req, resp);
    }
}
