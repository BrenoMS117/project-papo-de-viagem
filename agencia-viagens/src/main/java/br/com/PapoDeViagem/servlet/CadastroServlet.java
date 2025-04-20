package br.com.PapoDeViagem.servlet;

import br.com.PapoDeViagem.dao.UsuarioDao;
import br.com.PapoDeViagem.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String data_nascimento = request.getParameter("data_nascimento");
        String cpf = request.getParameter("cpf");
        boolean adm = Boolean.parseBoolean(request.getParameter("adm"));

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setData_nascimento(data_nascimento);
        usuario.setCpf(cpf);
        usuario.setAdm(adm);

        UsuarioDao dao = new UsuarioDao();
        dao.criarUsuario(usuario);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}