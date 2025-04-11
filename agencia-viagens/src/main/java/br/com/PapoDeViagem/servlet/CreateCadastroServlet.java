package br.com.PapoDeViagem.servlet;

import br.com.PapoDeViagem.dao.Viagemdao;
import br.com.PapoDeViagem.model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro")
public class CreateCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setEmail(email);
        cadastro.setSenha(senha);

        Viagemdao dao = new Viagemdao();
        dao.criarUsuario(cadastro);

        request.getRequestDispatcher("index.html").forward(request, response);


    }
}