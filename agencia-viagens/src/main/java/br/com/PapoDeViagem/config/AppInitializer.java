package br.com.PapoDeViagem.config;

import br.com.PapoDeViagem.dao.SuasViagensDao;
import br.com.PapoDeViagem.dao.UsuarioDao;
import br.com.PapoDeViagem.dao.ViagemDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Criando tabelas...");

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.criarTabelaUsuario();
        ViagemDao viagemDao = new ViagemDao();
        viagemDao.criarTabelaViagem();
        SuasViagensDao svDao = new SuasViagensDao();
        svDao.criarTabelaSuasViagens();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("encerrando");
    }
}
