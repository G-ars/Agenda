package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";


    public MainForm(){

        setContentPane(rootPanel);
        setSize(450, 400);
        setVisible(true);

        //conceitos do Jframe

        //função para localizar o meio da tela onde nossa interface irá aparecer
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //define full screen
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        //função para parar o programa ao sair
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContactBusiness = new ContactBusiness();

        setListenners();
        loadContacts();
    }

        private void loadContacts(){
           List<ContactEntity> contactlist = mContactBusiness.getList();
           
           String[] columnNames = {"Nome", "Telefones"};
            DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

            for(ContactEntity i: contactlist){
                Object[] o = new Object[2];

                o[0] = i.getName();
                o[1] = i.getPhone();

                model.addRow(o);

            }
            tableContacts.clearSelection();
            tableContacts.setModel(model);

            labelContactCount.setText(mContactBusiness.getContactCountDescription());
        }


    private void setListenners(){
        buttonNewContact.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){

                    if(tableContacts.getSelectedRow() != -1){
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }

                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mContactBusiness.delete(mName, mPhone);
                    loadContacts();
                    mName = "";
                    mPhone = "";
                } catch (Exception excp){
                    JOptionPane.showMessageDialog( new JFrame(), excp.getMessage());
                }
            }
        });
    }


}
