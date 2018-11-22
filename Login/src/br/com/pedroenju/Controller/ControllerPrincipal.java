package br.com.pedroenju.Controller;

import br.com.pedroenju.View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerPrincipal implements ActionListener {

    private ViewPrincipal view;

    public ControllerPrincipal(String nomeUsuario) {
        this.view = new ViewPrincipal(this, nomeUsuario);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastro.usuario":
                    this.cadastroUsuario();
                    break;
                case "cadastro.automovel":
                    this.cadastroAutomovel();
                    break;
                case "cadastro.locacao":
                    this.cadastroLocacao();
                    break;
                case "cadastro.cliente":
                    this.cadastroCliente();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastroUsuario() {
        ControllerCadastroUsuario ccu = new ControllerCadastroUsuario();
        this.view.setFrame(ccu.getView());
    }

    private void cadastroAutomovel() {
        ControllerAutomovel ca = new ControllerAutomovel(this.view.getDesktopPane());
        this.view.setFrame(ca.getView());
    }

    private void cadastroLocacao() {
        ControllerLocacao cl = new ControllerLocacao();
        this.view.setFrame(cl.getView());
    }

    private void cadastroCliente() {
        ControllerCliente cc = new ControllerCliente();
        this.view.setFrame(cc.getView());
    }
}
