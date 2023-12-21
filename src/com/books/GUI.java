package com.books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements UI{
    JPanel homePane = new JPanel();
            JPanel viewPane = new JPanel(null);
    JPanel addBookPane = new JPanel(null);
    JPanel addReaderPane = new JPanel(null);
    private JPanel cardPanel;
    private CardLayout cardLayout;


    JButton addBookBtn, removeBookBtn, printAllBooksBtn, addReaderBtn, removeReaderBtn, printAllReadersBtn, ieskotiKnygosBtn;
    JButton homeBtn;
    JLabel viewLabel;
    Biblioteka mainLogic;

    Font contentFont = new Font("Calibri", Font.PLAIN, 20);
    Font titleFont = new Font("Calibri", Font.BOLD, 30);

    String[] userInput = new String[8];
    int nextLine = 0;

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setTitle("Library system 3000");
        setBackground(Color.pink);

    }


    @Override
    public void start(Biblioteka mainLogic) {
        this.mainLogic = mainLogic;
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);


//        homePane = new JPanel();
        homePane.setLayout(new BoxLayout(homePane, BoxLayout.PAGE_AXIS));
        homePane.setAlignmentX(Box.CENTER_ALIGNMENT);
        homePane.setBackground(Color.orange);


        homePane.add(  addBookBtn = new JButton("Prideti knyga")  );
        homePane.add(  removeBookBtn = new JButton("Pasalinti knyga")  );
        homePane.add(  printAllBooksBtn = new JButton("Rodyti knygu sarasa")  );

        homePane.add(  addReaderBtn = new JButton("Prideti skaitytoja")  );
        homePane.add(  removeReaderBtn = new JButton("Pasalinti skaitytoja")  );
        homePane.add(  printAllReadersBtn = new JButton("Rodyti skaitytoju sarasa")  );

        homePane.add(  ieskotiKnygosBtn = new JButton("Ieskoti knygos")  );



//        homePane.setVisible(true);
        //------------------
//        viewPane = new JPanel(null);

        homeBtn = new JButton("Back Home");
        homeBtn.setBounds(550, 500, 100, 40);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(homeBtn);
        add(southPanel, BorderLayout.SOUTH);


        viewPane.setBackground(Color.PINK);

        viewLabel = new JLabel("<html>");
        viewLabel.setFont(contentFont);
        viewLabel.setForeground(Color.GRAY);

        viewLabel.setBounds(50, 50, 500, 400);
        viewPane.add(viewLabel);




        homeBtn.addActionListener(e -> {
            cardLayout.show(cardPanel, "home");
            nextLine =0;

        });

        printAllBooksBtn.addActionListener(e -> showInfoPane("3"));
        printAllReadersBtn.addActionListener(e -> showInfoPane("6"));
        addBookBtn.addActionListener(e -> cardLayout.show(cardPanel, "addBook"));
        removeBookBtn.addActionListener(e -> showInfoPane("2"));
        addReaderBtn.addActionListener(e -> cardLayout.show(cardPanel, "addReader"));
        removeReaderBtn.addActionListener(e ->         cardLayout.show(cardPanel, "removeReader"));
        ieskotiKnygosBtn.addActionListener(e -> showInfoPane("7"));




        cardPanel.add(homePane, "home");
        cardPanel.add(viewPane, "view");



        setUpAddReaderPane();
        setUpAddBookPane();

        setUpRemoveReaderPane();

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void setUpAddBookPane(){
        JLabel title = new JLabel("Add new book");
        title.setFont(titleFont);
        title.setBounds(250, 30, 200, 40);
        addBookPane.add(title);

        JLabel pavadinimasLbl = new JLabel("Pavadinimas");
        pavadinimasLbl.setFont(contentFont);
        pavadinimasLbl.setBounds(120, 120, 150, 40);
        JTextField pavadinimas = new JTextField(20);
        pavadinimas.setBounds(300, 120, 200, 40);
        addBookPane.add(pavadinimasLbl);
        addBookPane.add(pavadinimas);

        JLabel autoriusLbl = new JLabel("Autorius");
        autoriusLbl.setFont(contentFont);
        autoriusLbl.setBounds(120, 180, 150, 40);
        JTextField autorius = new JTextField(20);
        autorius.setBounds(300, 180, 200, 40);
        addBookPane.add(autoriusLbl);
        addBookPane.add(autorius);

        JLabel metaiLbl = new JLabel("Metai");
        metaiLbl.setFont(contentFont);
        metaiLbl.setBounds(120, 240, 150, 40);
        JTextField metai = new JTextField(20);
        metai.setBounds(300, 240, 200, 40);
        addBookPane.add(metaiLbl);
        addBookPane.add(metai);

        JButton submit = new JButton("Submit");
        submit.setFont(contentFont);
        submit.setBounds(300, 350, 100, 40);
        addBookPane.add(submit);



        submit.addActionListener(e -> {
            userInput[0] = pavadinimas.getText();
            userInput[1] = autorius.getText();
            userInput[2] = metai.getText();
            mainLogic.apdorokPasirinkima("1");

            showInfoPane("3");
            cleanInputFields(pavadinimas, autorius,metai);

        });


//        addBookPane.setVisible(false);
//        add(addBookPane);
        cardPanel.add(addBookPane, "addBook");

    }

    public void setUpAddReaderPane(){
        JLabel title = new JLabel("Add new Reader");
        title.setFont(titleFont);
        title.setBounds(250, 30, 200, 40);
        addReaderPane.add(title);

        JLabel pavadinimasLbl = new JLabel("Pilnas Vardas");
        pavadinimasLbl.setFont(contentFont);
        pavadinimasLbl.setBounds(120, 120, 150, 40);
        JTextField pavadinimas = new JTextField(20);
        pavadinimas.setBounds(300, 120, 200, 40);
        addReaderPane.add(pavadinimasLbl);
        addReaderPane.add(pavadinimas);

        JLabel telephoneLbl = new JLabel("Telefono no");
        telephoneLbl.setFont(contentFont);
        telephoneLbl.setBounds(120, 180, 150, 40);
        JTextField telephone = new JTextField(20);
        telephone.setBounds(300, 180, 200, 40);
        addReaderPane.add(telephoneLbl);
        addReaderPane.add(telephone);

        JButton submitx = new JButton("Submit");
        submitx.setFont(contentFont);
        submitx.setBounds(300, 350, 100, 40);
        addReaderPane.add(submitx);



        submitx.addActionListener(e -> {
            userInput[0] = pavadinimas.getText();
            userInput[1] = telephone.getText();
            mainLogic.apdorokPasirinkima("4");

            showInfoPane("6");
            cleanInputFields(pavadinimas, telephone);
        });

//        addReaderPane.setVisible(false);
//        add(addReaderPane);
        cardPanel.add(addReaderPane, "addReader");
    }

    public void setUpRemoveReaderPane(){
        JLabel title = new JLabel("Remove Reader");

        JPanel removeReaderPane = new JPanel(null);
        title.setFont(titleFont);
        title.setBounds(250, 30, 200, 40);
        removeReaderPane.add(title);



        JButton submitx = new JButton("Submit");
        submitx.setFont(contentFont);
        submitx.setBounds(300, 480, 100, 40);
        removeReaderPane.add(submitx);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Reader reader : mainLogic.readerArr) {
            listModel.addElement(reader.toFancyString());
        }


        JList<String> itemList = new JList<>(listModel);
        itemList.setCellRenderer(new CheckboxListCellRenderer());
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setBounds(100, 80, 500, 350);

        removeReaderPane.add(scrollPane);
        cardPanel.add(removeReaderPane, "removeReader");



        submitx.addActionListener(e -> {
            userInput[0] = "asd";

            for (Reader reader : mainLogic.readerArr) {
                if (reader.toFancyString().equals(itemList.getSelectedValue())){
                    userInput[0] = reader.getId()+"";
                    break;
                }
            }

            mainLogic.apdorokPasirinkima("5");

            showInfoPane("6");

        });

//        addReaderPane.setVisible(false);
//        add(addReaderPane);
    }


    private class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<String> {
        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setComponentOrientation(list.getComponentOrientation());
            setSelected(isSelected);
            setEnabled(list.isEnabled());
            setText(value);

            return this;
        }
    }


    public void cleanInputFields(JTextField... textFields){
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }



    public void showInfoPane(String swichID){
        cardLayout.show(cardPanel, "view");
        viewLabel.setText("<html>");
        mainLogic.apdorokPasirinkima(swichID);
    }

    @Override
    public void spausdinkMenu() {

    }

    @Override
    public String getVartotojoPasirinkimas() {
        return null;
    }

    @Override
    public String getUserInput(String msg) {
        return userInput[nextLine++];
    }

    @Override
    public void infoOut(String msg) {
        String oldText = viewLabel.getText();
        viewLabel.setText(oldText + msg + "<br>");
    }

    @Override
    public void goodbyeAction() {

    }
}
