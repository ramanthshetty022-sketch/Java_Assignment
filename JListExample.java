/*
5a. Develop a Swing program in Java to add the countries USA, India, Vietnam,
Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a
JList and display them on console whenever the countries are selected on the list.
*/
package oneA;

import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

public class JListExample extends JFrame {

    private JList<String> countryList;

    public JListExample() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        countryList = new JList<>(listModel);

        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    List<String> selected = countryList.getSelectedValuesList();
                    System.out.println(selected);
                }
            }
        });

        add(new JScrollPane(countryList));

        setTitle("JList Example");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JListExample();
    }
}