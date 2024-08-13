package cop2805;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeWork5 extends JFrame{
    public JTextField textField1;
    public JList list;
    public DefaultListModel<String> listModel;

    public HomeWork5(){
        super();
        init();
    }

    private void init(){
        int frameWidth = 500;
        int frameHeight = 300;
        int BtnWidth = 15;
        int BtnHeight = 30;

        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("HW5 Name List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates new J-objects
        JPanel panelTop = new JPanel();
        this.setLayout(new GridLayout(2,3));
        listModel = new DefaultListModel<>();
        JLabel label = new JLabel("Enter A Name");
        textField1 = new JTextField();
        list = new JList<String>(listModel);
        JScrollPane scrollPane = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

       // listModel.addElement("default"); debugging code
        JButton AddNameBtn = new JButton("Add Name");
        JButton RemoveNameBtn = new JButton("Remove Name");
        JButton ClearBtn = new JButton("Clear List");
        AddNameBtn.addActionListener(new MyActionListener(this));
        RemoveNameBtn.addActionListener(new MyActionListener(this));
        ClearBtn.addActionListener(new MyActionListener(this));

        // sets screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int)(screenSize.getWidth()/2)-(frameWidth/2),(int)(screenSize.getHeight()/2)-(frameHeight/2),frameWidth,frameHeight);

        // adds to the frame

        this.add(label);
        this.add(textField1);
        this.add(scrollPane);
        this.add(AddNameBtn);
        this.add(RemoveNameBtn);
        this.add(ClearBtn);
        this.setVisible(true);
    }

    private static void constructGUI() {
        HomeWork5 newWindow = new HomeWork5();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                constructGUI();
            }
        });
    }
}
class MyActionListener implements ActionListener{

    HomeWork5 HW5;

    public MyActionListener(HomeWork5 frame){
        HW5=frame;
    }
    @Override
    public void actionPerformed(ActionEvent eventData) {
        JButton source = (JButton) eventData.getSource();
        if(source.getText().equals("Add Name") && HW5.textField1.getText().length()>0){
            System.out.println("added "+ HW5.textField1.getText());
            HW5.listModel.addElement(HW5.textField1.getText());
            HW5.textField1.setText("");
        }else if(source.getText().equals("Remove Name")){
            int[] delete = HW5.list.getSelectedIndices();
            for (int i = delete.length - 1; i >= 0; i--) {
                System.out.println("removed " + (String) HW5.listModel.elementAt(delete[i]));
                HW5.listModel.removeElementAt(delete[i]);
            }
        }
        else if((source.getText().equals("Clear List")))
        {
            System.out.println("cleared list");
            HW5.listModel.clear();
        }
    }
}