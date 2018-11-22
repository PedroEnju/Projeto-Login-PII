package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoAutomovel;
import br.com.pedroenju.Dao.DaoModelo;
import br.com.pedroenju.Model.ModelAutomovel;
import br.com.pedroenju.Model.ModelModelo;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewCadastroAutomovel;
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
public class ControllerAutomovel implements ActionListener {

    private ViewCadastroAutomovel view;
    private DaoAutomovel dao;
    private JDesktopPane desk;

    public ViewCadastroAutomovel getView() {
        return this.view;
    }

    public ControllerAutomovel(JDesktopPane desk) {
        Connection conn = Conexao.getInstance().getConn();
        ModelAutomovel model = new ModelAutomovel();
        DaoModelo dm = new DaoModelo(conn);

        this.desk = desk;

        this.view = new ViewCadastroAutomovel(this);
        this.dao = new DaoAutomovel(conn);
        this.setModelo(dm);
        this.view.setModel(model);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastrar.automovel":
                    this.cadastrarAutomovel();
                    break;
                case "cadastro.modelo":
                    this.cadastroModelo();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastrarAutomovel() {
        ModelAutomovel mm = this.view.getModel();
        this.dao.setModel(mm);

        this.dao.salvar();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        this.view.dispose();

    }

    private void cadastroModelo() {
        ControllerModelo cm = new ControllerModelo(this.desk);
        this.desk.add(cm.getView());
    }

    private void setModelo(DaoModelo dm) {
        ArrayList<ModelModelo> item = dm.getAll();
        ArrayList<String> lista = new ArrayList<>();
        ModelModelo mm;
        int i;
        for (i = 0; i < item.size(); i++) {
            mm = item.get(i);
            lista.add(mm.getNome_modelo());
        }
        this.view.setModelo(lista);
    }

}
