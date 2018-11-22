package br.com.pedroenju.Controller;

import br.com.pedroenju.View.ViewCadastroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerCadastroUsuario implements ActionListener {

    private ViewCadastroUsuario view;

    public ControllerCadastroUsuario() {
        this.view = new ViewCadastroUsuario();
        this.view.addAL(this);
        this.view.setVisible(true);

    }

    public ViewCadastroUsuario getView() {
        return this.view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cadastrar.usuario":
                this.cadastrar();
                break;
            case "":
                break;
            default:
                System.out.println("Não ocorreu nada!!!");
                break;
        }
    }

    private void cadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
