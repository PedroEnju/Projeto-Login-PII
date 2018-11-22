package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewLogin extends JFrame {

    private ModelLogin model;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private ActionListener al;

    public ViewLogin(ActionListener al) throws HeadlessException {
        super("Tela de Login");
        this.al = al;
        showTela();
        config();
    }

    public ModelLogin getModel() {
        this.model.setLogin(this.txtLogin.getText());
        this.model.setSenha(String.valueOf(this.txtSenha.getPassword()));
        return this.model;
    }

    public void setModel(ModelLogin model) {
        this.model = model;
    }

    private void showTela() {
        this.setLayout(new BorderLayout());

        JPanel pNorth = new JPanel(new FlowLayout());
        JPanel pCenter = new JPanel(new GridBagLayout());
        JPanel pSouth = new JPanel();

        JLabel lbTitle = new JLabel("Login");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);

        pNorth.setBackground(Color.getHSBColor(50, 50, 256));
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        this.txtLogin = new JTextField();
        this.txtSenha = new JPasswordField();
        this.btnEntrar = new JButton("Entrar");

        Dimension dField = new Dimension(200, 30);

        this.txtLogin.setPreferredSize(dField);
        this.txtSenha.setPreferredSize(dField);

        pNorth.add(lbTitle);

        GridBagConstraints p1 = new GridBagConstraints();
        GridBagConstraints p2 = new GridBagConstraints();
        GridBagConstraints p3 = new GridBagConstraints();
        GridBagConstraints p4 = new GridBagConstraints();

        p1.gridx = 0;
        p1.gridy = 0;
        p2.gridx = 0;
        p2.gridy = 1;
        p2.fill = GridBagConstraints.HORIZONTAL;
        p3.gridx = 0;
        p3.gridy = 2;
        p4.gridx = 0;
        p4.gridy = 3;
        p4.fill = GridBagConstraints.HORIZONTAL;

        pCenter.add(new JLabel("Login"), p1);
        pCenter.add(this.txtLogin, p2);
        pCenter.add(new JLabel("Senha"), p3);
        pCenter.add(this.txtSenha, p4);

        pSouth.add(this.btnEntrar);

        comandosBtn();
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void comandosBtn() {
        this.btnEntrar.addActionListener(this.al);

        this.btnEntrar.setActionCommand("login.entrar");
    }
}
