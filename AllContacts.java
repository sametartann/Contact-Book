import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AllContacts extends JFrame implements MouseListener {

    JButton btnAdd = new JButton("Add");
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");

    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);

    JScrollPane scrPane = new JScrollPane(list);


    public AllContacts(){   //constructor
        super();
        setTitle("All My Contacts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(215,100);

        setLayout(new BorderLayout());
        add(scrPane, BorderLayout.CENTER);

        JPanel pnl = new JPanel(new GridLayout(1,3));
        pnl.add(btnAdd);    pnl.add(btnDelete);     pnl.add(btnEdit);
        //buttons are gathered in a panel

        add(pnl, BorderLayout.SOUTH);

        dlm.addElement("Jhon-573133-jhon@gmail.com-California-education-M-Music,Travel");
        dlm.addElement("David-213413-david@gmail.com-Delaware-health-M-Coding,Music,Travel");
        dlm.addElement("Drew-553151-drew@gmail.com-Texas-community-F-Coding,Travel");


        btnAdd.addMouseListener(this);
        btnDelete.addMouseListener(this);
        btnEdit.addMouseListener(this);
        //to listen mouse clicks

    }

    public static void main(String[] args) {
        new AllContacts().setVisible(true);
    }

    ContactBook contactBook = new ContactBook();

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == btnDelete){    //delete button is clicked
            if (list.getSelectedIndex() != -1)
                dlm.removeElementAt(list.getSelectedIndex());
        }

        else if (e.getSource() == btnAdd){  //add button is clicked
            contactBook.setVisible(true);
            contactBook.clearSelections();
            contactBook.submit.setText("Add New Contact");

            contactBook.copier(dlm, list);
        }

        else if (e.getSource() == btnEdit){ //edit button is clicked
            if (list.getSelectedIndex() == -1) return;

            contactBook.setVisible(true);
            contactBook.clearSelections();
            contactBook.submit.setText("Update Contact");
            contactBook.copier(dlm, list);

            String[] info = list.getSelectedValue().toString().split("-");
            contactBook.txtName.setText(info[0]);
            contactBook.txtPhone.setText(info[1]);
            contactBook.txtMail.setText(info[2]);
            contactBook.comboBoxHomeTown.setSelectedItem(info[3]);
            contactBook.cmbJob.setSelectedItem(info[4]);
            if (info[5].equals("F"))
                contactBook.female.setSelected(true);
            else
                contactBook.male.setSelected(true);

            String[] hobbies = info[6].split(",");

            for (int i = 0; i < hobbies.length; i++) {
                if (hobbies[i].equals("Coding"))
                    contactBook.coding.setSelected(true);

                else if (hobbies[i].equals("Music"))
                    contactBook.music.setSelected(true);

                else if (hobbies[i].equals("Travel"))
                    contactBook.travel.setSelected(true);

            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
