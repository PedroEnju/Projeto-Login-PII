package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoLogin;
import br.com.pedroenju.Model.ModelLogin;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerLogin implements ActionListener {

    private ViewLogin view;
    private DaoLogin dao;

    public ControllerLogin() {
        Connection conn = Conexao.getInstance().getConn();
        ModelLogin model = new ModelLogin();

        this.view = new ViewLogin(this);
        this.dao = new DaoLogin(conn);
        this.view.setModel(model);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "login.entrar":
                    this.logar();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void logar() {
        ModelLogin model = this.view.getModel();
        this.dao.setModel(model);

        if (this.dao.verificarLogin() != null) {
            ModelLogin ml = this.dao.verificarLogin();
            ControllerPrincipal cp = new ControllerPrincipal(ml.getNome());
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "LOGIN INCORRETO!!!");
        }
    }
}
