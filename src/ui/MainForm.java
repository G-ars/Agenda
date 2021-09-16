package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;

    public MainForm(){

        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        //conceitos do Jframe

        //função para localizar o meio da tela onde nossa interface irá aparecer
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //define full screen
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        //função para parar o programa ao sair
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListenners();
    }

    private void setListenners(){
        buttonNewContact.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
