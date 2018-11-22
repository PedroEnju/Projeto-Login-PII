package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoCliente;
import br.com.pedroenju.Model.ModelCliente;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewCadastroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerCliente implements ActionListener {

    private ViewCadastroCliente view;
    private DaoCliente dao;

    public ViewCadastroCliente getView() {
        return this.view;
    }

    public ControllerCliente() {
        Connection conn = Conexao.getInstance().getConn();
        ModelCliente model = new ModelCliente();

        this.view = new ViewCadastroCliente(this);
        this.dao = new DaoCliente(conn);
        this.view.setModel(model);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastrar.cliente":
                    this.cadastrarCliente();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastrarCliente() {
        ModelCliente mc = this.view.getModel();
        this.dao.setModel(mc);

        if (this.dao.verificaCliente()) {
            this.dao.salvar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma marca com esse nome");
        }
    }

}
