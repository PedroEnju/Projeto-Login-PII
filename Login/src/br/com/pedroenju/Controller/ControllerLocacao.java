package br.com.pedroenju.Controller;

import br.com.pedroenju.Dao.DaoAutomovel;
import br.com.pedroenju.Dao.DaoCliente;
import br.com.pedroenju.Dao.DaoLocacao;
import br.com.pedroenju.Dao.DaoModelo;
import br.com.pedroenju.Model.ModelAutomovel;
import br.com.pedroenju.Model.ModelCliente;
import br.com.pedroenju.Model.ModelLocacao;
import br.com.pedroenju.Services.Conexao;
import br.com.pedroenju.View.ViewLocacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Smith Enju
 */
public class ControllerLocacao implements ActionListener {

    private ViewLocacao view;
    private DaoLocacao dao;

    public ViewLocacao getView() {
        return this.view;
    }

    public ControllerLocacao() {
        Connection conn = Conexao.getInstance().getConn();
        ModelLocacao model = new ModelLocacao();
        DaoAutomovel da = new DaoAutomovel(conn);
        DaoCliente dc = new DaoCliente(conn);

        this.view = new ViewLocacao(this);
        this.dao = new DaoLocacao(conn);
        this.setCliente(dc);
        this.setAutomovel(da);
        this.view.setModel(model);
        this.automovelSelected();
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view != null) {
            switch (e.getActionCommand()) {
                case "cadastrar.locacao":
                    this.cadastrarLocacao();
                    break;
                case "cbAutomovel.change":
                    this.automovelSelected();
                    break;
                default:
                    System.out.println("Não ocorreu nada!!!");
                    break;
            }
        }
    }

    private void cadastrarLocacao() {
        ModelLocacao ml = this.view.getModel();
        this.dao.setModel(ml);
        this.dao.salvar();
        JOptionPane.showMessageDialog(null, "Veículo locado com sucesso");
        this.view.dispose();
    }

    private void setAutomovel(DaoAutomovel da) {
        ArrayList<ModelAutomovel> item = da.getAll();
        ArrayList<String> lista = new ArrayList<>();
        ModelAutomovel mm;
        int i;
        for (i = 0; i < item.size(); i++) {
            mm = item.get(i);
            lista.add(mm.getModelo());
        }
        this.view.setAutomovel(lista);
    }

    private void setCliente(DaoCliente dc) {
        ArrayList<ModelCliente> item = dc.getAll();
        ArrayList<String> lista = new ArrayList<>();
        ModelCliente mc;
        int i;
        for (i = 0; i < item.size(); i++) {
            mc = item.get(i);
            lista.add(mc.getNome_cliente());
        }
        this.view.setCliente(lista);
    }

    private void automovelSelected() {
        int days = 7;
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, days);

        DaoAutomovel da = new DaoAutomovel(Conexao.getInstance().getConn());
        DaoModelo dm = new DaoModelo(Conexao.getInstance().getConn());
        ModelAutomovel ma = da.getByID(dm.getID(this.view.getAutomovel()));
        ModelLocacao ml = new ModelLocacao();
        
        ml.setHora_fim(new SimpleDateFormat("dd/MM/yyyy 23:59").format(cal.getTime()));
        ml.setKm_inicio(ma.getKm_atual());
        ml.setKm_fim(ma.getKm_atual());
        ml.setKm_rodado(ml.getKm_fim() - ml.getKm_inicio());
        ml.setTempo_hora((days - 1) * 24);
        ml.setValor_hora(ma.getValor_locacao_hora());
        ml.setValor_km(ma.getValor_locacao_km());
        ml.setValor_total(ml.getValor_hora() * ml.getTempo_hora());
        
        this.view.setModel(ml);
    }
}
