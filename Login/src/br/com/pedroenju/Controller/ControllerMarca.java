package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoMarca;
import br.com.pedroenju.Model.ModelMarca;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewMarca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerMarca implements ActionListener {

    private ViewMarca view;
    private DaoMarca dao;

    public ViewMarca getView() {
        return this.view;
    }

    public ControllerMarca() {
        Connection conn = Conexao.getInstance().getConn();
        ModelMarca model = new ModelMarca();

        this.view = new ViewMarca(this);
        this.dao = new DaoMarca(conn);
        this.view.setModel(model);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastrar.marca":
                    this.cadastrarMarca();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastrarMarca() {
        ModelMarca mm = this.view.getModel();
        this.dao.setModel(mm);

        if (this.dao.verificaMarca()) {
            this.dao.cadastrar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma marca com esse nome");
        }
    }

}
