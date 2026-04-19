/*
5c. Develop a Swing program in Java to add the countries USA, India, Vietnam,
Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a
JList and display the capital of the countries on console whenever the countries are selected on the list.
*/
package oneA;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class JListCapitalExample extends JFrame {

    private JList<String> countryList;
    private Map<String, String> capitals;

    public JListCapitalExample() {

        capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : capitals.keySet()) {
            listModel.addElement(country);
        }

        countryList = new JList<>(listModel);

        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    List<String> selected = countryList.getSelectedValuesList();
                    for (String c : selected) {
                        System.out.println("Capital of " + c + " is: " + capitals.get(c));
                    }
                }
            }
        });

        add(new JScrollPane(countryList));

        setTitle("JList Capital Example");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JListCapitalExample();
    }
}