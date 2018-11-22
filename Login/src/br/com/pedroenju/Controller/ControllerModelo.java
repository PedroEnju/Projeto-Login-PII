package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoMarca;
import br.com.pedroenju.Dao.DaoModelo;
import br.com.pedroenju.Model.ModelMarca;
import br.com.pedroenju.Model.ModelModelo;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewModelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerModelo implements ActionListener {

    private ViewModelo view;
    private DaoModelo dao;
    private JDesktopPane desk;

    public ViewModelo getView() {
        return this.view;
    }

    public ControllerModelo(JDesktopPane desk) {
        Connection conn = Conexao.getInstance().getConn();
        ModelModelo model = new ModelModelo();
        DaoMarca dm = new DaoMarca(conn);

        this.desk = desk;

        this.view = new ViewModelo(this);
        this.dao = new DaoModelo(conn);
        this.setMarca(dm);
        this.view.setModel(model);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastrar.modelo":
                    this.cadastrarModelo();
                    break;
                case "cadastro.marca":
                    this.cadastroMarca();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastrarModelo() {
        ModelModelo mm = this.view.getModel();
        this.dao.setModel(mm);

        if (this.dao.verificaMarca()) {
            this.dao.salvar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma marca com esse nome");
        }
    }

    private void cadastroMarca() {
        ControllerMarca cm = new ControllerMarca();
        this.desk.add(cm.getView());
    }

    private void setMarca(DaoMarca dm) {
        ArrayList<ModelMarca> item = dm.getAll();
        ArrayList<String> lista = new ArrayList<>();
        ModelMarca mm;
        int i;
        for (i = 0; i < item.size(); i++) {
            mm = item.get(i);
            lista.add(mm.getNome_marca());
        }
        this.view.setMarca(lista);
    }

}
