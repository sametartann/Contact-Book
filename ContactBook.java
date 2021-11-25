import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactBook extends JFrame implements ActionListener {

    JLabel lblName = new JLabel("Name");
    JLabel lblPhone = new JLabel("Phone");
    JLabel lblMail = new JLabel("E-mail");

    JTextField txtName = new JTextField("");
    JTextField txtPhone = new JTextField("");
    JTextField txtMail = new JTextField("");

    JButton cancel = new JButton("Cancel");
    JButton submit = new JButton("Submit");

    JLabel lblHometown = new JLabel("Hometown");
    String[] cities = new String[]{"Texas","Delaware","California","Wisconsin", "Arizona"};
    JComboBox comboBoxHomeTown = new JComboBox(cities);

    JLabel lblJobs = new JLabel("Job");

    //String[] jobs = new String[]{"other", "education", "health", "community"};
    //JComboBox<String> cmbJob = new JComboBox<String>(jobs);
    JComboBox<String> cmbJob = new JComboBox<String>(new String[]{"other", "education", "health", "community"});

    JLabel lblJobPictures = new JLabel(new ImageIcon());

    JPanel gender = new JPanel(new FlowLayout());
    JRadioButton female = new JRadioButton("F");
    JRadioButton male = new JRadioButton("M");

    JPanel hobby = new JPanel(new FlowLayout());
    JCheckBox coding = new JCheckBox("Coding");
    JCheckBox music = new JCheckBox("Music");
    JCheckBox travel = new JCheckBox("Travel");


    public ContactBook(){
        super("CONTACTS");
        //setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        setLocation(700,100);

        setLayout(new GridLayout(8,2));
        add(lblName);
        add(txtName);
        add(lblPhone);
        add(txtPhone);
        add(lblMail);
        add(txtMail);

        add(lblHometown);
        add(comboBoxHomeTown);

        add(lblJobs);
        JPanel panelJob = new JPanel(new FlowLayout());
        panelJob.add(cmbJob);
        panelJob.add(lblJobPictures);
        add(panelJob);


        add(new JLabel("Gender"));

        gender.add(female);
        gender.add(male);
        add(gender);

        add(new JLabel("Hobbies"));

        hobby.add(coding);
        hobby.add(music);
        hobby.add(travel);
        add(hobby);

        add(cancel);
        add(submit);

        pack();
        //setSize(... , ...);

        ButtonGroup bg = new ButtonGroup();
        bg.add(female);     bg.add(male);
        // to select ONLY one of the buttons

        cmbJob.addActionListener(this);
        cancel.addActionListener(this);
        submit.addActionListener(this);

    }


    public static void main(String[] args) {
        new ContactBook().setVisible(true);
    }

    public void clearSelections(){
        // this function clears the information of the previous person

        txtName.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        comboBoxHomeTown.setSelectedIndex(0);
        cmbJob.setSelectedIndex(0);
        female.setSelected(true);
        coding.setSelected(false);
        music.setSelected(false);
        travel.setSelected(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cmbJob){
            if (cmbJob.getSelectedItem() == "other"){
                lblJobPictures.setIcon(new ImageIcon("C:\\Users\\MSI-NB\\Downloads\\other.jpg"));
                //to see the picture, other.jpg must be added given location
            }
            else if (cmbJob.getSelectedItem() == "education"){
                lblJobPictures.setIcon(new ImageIcon("C:\\Users\\MSI-NB\\Downloads\\education.jpg"));
                //to see the picture, education.jpg must be added given location
            }
            else if (cmbJob.getSelectedItem() == "health"){
                lblJobPictures.setIcon(new ImageIcon("C:\\Users\\MSI-NB\\Downloads\\health.jpg"));
                //to see the picture, health.jpg must be added given location
            }
            else if (cmbJob.getSelectedItem() == "community"){
                lblJobPictures.setIcon(new ImageIcon("C:\\Users\\MSI-NB\\Downloads\\community.jpg"));
                //to see the picture, community.jpg must be added given location
            }
        }
        else if (e.getSource() == cancel){  //cancel button is clicked
            setVisible(false);
            //close the window
        }


        else if (e.getSource() ==submit){   // submit button is clicked

            String person = txtName.getText() + "-"+ txtPhone.getText() + "-"+
                    txtMail. getText() + "-" + comboBoxHomeTown.getSelectedItem()+
                    "-" + cmbJob.getSelectedItem() + "-" +
                    ((female.isSelected())? "F":"M")+ "-";
            //person information

            if (coding.isSelected())
                person += "Coding,";
            if (music.isSelected())
                person += "Music,";
            if (travel.isSelected())
                person += "Travel";

            if (submit.getText().contains("Add")){
                dlm.addElement(person);
            }
            else{
                dlm.setElementAt(person,list.getSelectedIndex());
            }
        }
    }

    DefaultListModel dlm;
    JList list = new JList();

    public void copier(DefaultListModel dlm, JList list) {
        this.dlm = dlm;
        this.list = list;
    }
}
