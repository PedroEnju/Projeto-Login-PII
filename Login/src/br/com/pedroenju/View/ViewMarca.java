package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelMarca;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewMarca extends JInternalFrame {

    private ActionListener al;
    private ModelMarca model;
    private JTextField txtNome_Marca;
    private JCheckBox cbStatus;
    private JButton btnCadastrar;

    public ViewMarca(ActionListener al) throws HeadlessException {
        super("Cadastro de Marca");
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

        this.txtNome_Marca = new JTextField();
        this.txtNome_Marca.setPreferredSize(dText);
        this.cbStatus = new JCheckBox();
        this.cbStatus.setSelected(true);

        this.btnCadastrar = new JButton("Cadastrar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Cadastro de Marca");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.BLUE);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel("Nome da Marca"));
        pCenter.add(this.txtNome_Marca);
        pCenter.add(new JLabel("Status"));
        pCenter.add(this.cbStatus);

        pSouth.add(this.btnCadastrar);
        comandosBtn();
    }

    public void setModel(ModelMarca model) {
        this.model = model;
    }

    public ModelMarca getModel() {
        this.model.setNome_marca(this.txtNome_Marca.getText());
        String status = "A";
        if (!cbStatus.isSelected()) {
            status = "I";
        }
        this.model.setStatus(status);
        return this.model;
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
        this.setLayer(3);
    }

    private void comandosBtn() {
        this.btnCadastrar.addActionListener(this.al);

        this.btnCadastrar.setActionCommand("cadastrar.marca");
    }

}
