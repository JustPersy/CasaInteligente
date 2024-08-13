package org.example.Presentacion;

import org.example.Logica.Casita;

import javax.swing.*;
import java.awt.event.*;

public class Home extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JList listilla;

    public Home() {
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        Casita cas = new Casita();
        cas.llenarLista(listilla);
        listilla.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        int indiceSeleccionado = listilla.getSelectedIndex();

        if (indiceSeleccionado != -1) {
            String textoSeleccionado = (String) listilla.getSelectedValue();
            Casita cas = new Casita();
            cas.cambiarEstado(textoSeleccionado);
            cas.llenarLista(listilla);
        } else {
            System.out.println("No se ha seleccionado el elemento");
        }


    }

    private void onCancel() {
        dispose();
    }
}
