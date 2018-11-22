package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelMarca;
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
public class ViewModelo extends JInternalFrame {

    private ActionListener al;
    private ModelModelo model;
    private JComboBox cbMarca;
    private JTextField txtNome_Modelo;
    private JButton btnCadastrar, btnMarca;
    private JCheckBox checkStatus;

    public ViewModelo(ActionListener al) throws HeadlessException {
        super("Cadastro de Modelo");
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

        this.cbMarca = new JComboBox<>();
        this.cbMarca.setPreferredSize(dText);
        this.txtNome_Modelo = new JTextField();
        this.txtNome_Modelo.setPreferredSize(dText);
        this.checkStatus = new JCheckBox();
        this.checkStatus.setSelected(true);

        this.btnMarca = new JButton("Marca");
        this.btnCadastrar = new JButton("Cadastrar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Cadastro de Modelo");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.BLUE);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel(""));
        pCenter.add(this.btnMarca);
        pCenter.add(new JLabel("Marca"));
        pCenter.add(this.cbMarca);
        pCenter.add(new JLabel("Nome do Modelo"));
        pCenter.add(this.txtNome_Modelo);
        pCenter.add(new JLabel("Status"));
        pCenter.add(this.checkStatus);

        pSouth.add(this.btnCadastrar);
        comandosBtn();
    }

    public void setModel(ModelModelo model) {
        this.model = model;
    }

    public ModelModelo getModel() {
        this.model.setMarca(String.valueOf(this.cbMarca.getSelectedItem()));
        this.model.setNome_modelo(this.txtNome_Modelo.getText());
        String status = "A";
        if (!checkStatus.isSelected()) {
            status = "I";
        }
        this.model.setStatus(status);
        return this.model;
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
        this.setLayer(2);
    }

    private void comandosBtn() {
        this.btnMarca.addActionListener(this.al);
        this.btnCadastrar.addActionListener(this.al);

        this.btnMarca.setActionCommand("cadastro.marca");
        this.btnCadastrar.setActionCommand("cadastrar.modelo");
    }

    public void setMarca(ArrayList<String> lista) {
        DefaultComboBoxModel<ModelMarca> cbModel = new DefaultComboBoxModel(lista.toArray());
        this.cbMarca.setModel(cbModel);
    }
}
