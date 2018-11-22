package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelAutomovel;
import br.com.pedroenju.Model.ModelModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewCadastroAutomovel extends JInternalFrame {

    private ActionListener al;
    private ModelAutomovel model;
    private JComboBox cbModelo;
    private JTextField txtPlaca, txtCor, txtTipo_Combustivel, txtKM_Atual, txtRenavam, txtChassi, txtValor_Locacao_Hora, txtValor_Locacao_KM;
    private JCheckBox checkStatus;
    private JButton btnCadastrar, btnModelo;

    public ViewCadastroAutomovel(ActionListener al) throws HeadlessException {
        super("Cadastro de Automóvel");
        this.al = al;
        showTela();
        config();
    }

    private void showTela() {
        this.setLayout(new BorderLayout());

        JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pCenter = new JPanel(new GridLayout(0, 2));
        JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        Dimension dText = new Dimension(200, 30);

        this.cbModelo = new JComboBox<>();
        this.cbModelo.setPreferredSize(dText);
        this.txtPlaca = new JTextField();
        this.txtPlaca.setPreferredSize(dText);
        this.txtCor = new JTextField();
        this.txtCor.setPreferredSize(dText);
        this.txtTipo_Combustivel = new JTextField();
        this.txtTipo_Combustivel.setPreferredSize(dText);
        this.txtKM_Atual = new JTextField();
        this.txtKM_Atual.setPreferredSize(dText);
        this.txtRenavam = new JTextField();
        this.txtRenavam.setPreferredSize(dText);
        this.txtChassi = new JTextField();
        this.txtChassi.setPreferredSize(dText);
        this.txtValor_Locacao_Hora = new JTextField();
        this.txtValor_Locacao_Hora.setPreferredSize(dText);
        this.txtValor_Locacao_KM = new JTextField();
        this.txtValor_Locacao_KM.setPreferredSize(dText);
        this.checkStatus = new JCheckBox();
        this.checkStatus.setSelected(true);

        this.btnModelo = new JButton("Modelo");
        this.btnCadastrar = new JButton("Cadastrar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Cadastro de Automóvel");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.BLUE);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel(""));
        pCenter.add(this.btnModelo);
        pCenter.add(new JLabel("Modelo"));
        pCenter.add(this.cbModelo);
        pCenter.add(new JLabel("Placa"));
        pCenter.add(this.txtPlaca);
        pCenter.add(new JLabel("Cor"));
        pCenter.add(this.txtCor);
        pCenter.add(new JLabel("Combustível"));
        pCenter.add(this.txtTipo_Combustivel);
        pCenter.add(new JLabel("Kilometragem"));
        pCenter.add(this.txtKM_Atual);
        pCenter.add(new JLabel("Renavam"));
        pCenter.add(this.txtRenavam);
        pCenter.add(new JLabel("Chassi"));
        pCenter.add(this.txtChassi);
        pCenter.add(new JLabel("Valor p/ Hora"));
        pCenter.add(this.txtValor_Locacao_Hora);
        pCenter.add(new JLabel("Valor p/ KM"));
        pCenter.add(this.txtValor_Locacao_KM);
        pCenter.add(new JLabel("Status"));
        pCenter.add(this.checkStatus);

        pSouth.add(this.btnCadastrar);
        comandosBtn();
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
        this.setLayer(1);
    }

    public void setModel(ModelAutomovel model) {
        this.model = model;
    }

    public ModelAutomovel getModel() {
        this.model.setModelo(String.valueOf(this.cbModelo.getSelectedItem()));
        this.model.setPlaca(this.txtPlaca.getText());
        this.model.setCor(this.txtCor.getText());
        this.model.setTipo_combustivel(this.txtTipo_Combustivel.getText());
        this.model.setKm_atual(Double.parseDouble(this.txtKM_Atual.getText()));
        this.model.setRenavam(this.txtRenavam.getText());
        this.model.setChassi(this.txtChassi.getText());
        this.model.setValor_locacao_hora(Double.parseDouble(this.txtValor_Locacao_Hora.getText()));
        this.model.setValor_locacao_km(Double.parseDouble(this.txtValor_Locacao_KM.getText()));
        String status = "A";
        if (!checkStatus.isSelected()) {
            status = "I";
        }
        this.model.setStatus(status);
        return this.model;
    }

    private void comandosBtn() {
        this.btnModelo.addActionListener(this.al);
        this.btnCadastrar.addActionListener(this.al);

        this.btnModelo.setActionCommand("cadastro.modelo");
        this.btnCadastrar.setActionCommand("cadastrar.automovel");
    }

    public void setModelo(ArrayList<String> lista) {
        DefaultComboBoxModel<ModelModelo> cbModel = new DefaultComboBoxModel(lista.toArray());
        this.cbModelo.setModel(cbModel);
    }
}
