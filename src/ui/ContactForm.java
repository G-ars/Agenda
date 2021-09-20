package ui;
import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textFone;
    private JButton buttonCancel;
    private JButton buttonSave;

    private ContactBusiness mContactBusiness;


    public ContactForm(){

        setContentPane(rootPanel);
        setSize(450, 400);
        setVisible(true);

        //função para localizar o meio da tela onde nossa interface irá aparecer
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        //função para parar o programa ao sair
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContactBusiness = new ContactBusiness();
        setListeners();

    }

        private void setListeners(){

            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{
                        String name = textName.getText();
                        String phone = textFone.getText();

                        mContactBusiness.save(name, phone);
                        new MainForm();
                        dispose();
                    } catch (Exception excp){
                        JOptionPane.showMessageDialog( new JFrame(), excp.getMessage());
                    }

                }
            });


            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ou seja mostra o main form e escode o contactform
                    new MainForm();
                    dispose();
                }
            });
        }

}
