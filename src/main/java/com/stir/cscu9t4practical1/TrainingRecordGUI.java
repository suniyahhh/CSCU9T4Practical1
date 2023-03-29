// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    //new textfields
    private JTextField rep = new JTextField(2);
    private JTextField rec = new JTextField(2);
    private JTextField ter = new JTextField(10);
    private JTextField tem = new JTextField(10);
    private JTextField loc = new JTextField(10);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km or m for sprint):");
    private JButton addR = new JButton("Add Entry");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All");
    private JButton remove = new JButton("Remove");
    
    //new labels:
    private JLabel labrep = new JLabel(" Repitions (sprint ONLY):");
    private JLabel labrec = new JLabel(" Recovery (sprint ONLY):");
    private JLabel labter = new JLabel(" Terrain (cycle ONLY):");
    private JLabel labtem = new JLabel(" Tempo (cycle ONLY):");
    private JLabel labloc = new JLabel(" Location (swim ONLY):");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(9, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        // adding new text fields
        add(labrep);
        add(rep);
        rep.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(labter);
        add(ter);
        ter.setEditable(true);
        add(labtem);
        add(tem);
        tem.setEditable(true);
        add(labloc);
        add(loc);
        loc.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        remove.addActionListener(this);
        add(remove);
        findAllByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(900, 300);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
        	if (!rep.getText().isEmpty() && !rec.getText().isEmpty()) {message = addEntry("Sprint");}
        	else if (!ter.getText().isEmpty() && !tem.getText().isEmpty()) {message = addEntry("Cycle");}
        	else if (!loc.getText().isEmpty()) {message = addEntry("Swim");}
        	else {message = "Invalid entry. Recheck details.";}
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
        	message = lookupAll();
        }
        if (event.getSource()== remove) {
        	message = removeRec();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed


    
    
    //add sprint
    public String addEntry(String what) {
    	String message;
        try {
        	message = "" + what+ " Record added\n";
            System.out.println("Adding "+what+" entry to the records");
        	String n = name.getText();
        	if (n.isEmpty()) { //If name is blank, method is terminated 
        		message = "No name entered.";
        		System.out.println("Entry failed. No name entered.");
        		return message;};
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            int r=0,re=0;
            if(!rep.getText().isBlank()) { r = Integer.parseInt(rep.getText());}
            if(!rec.getText().isBlank()) { re = Integer.parseInt(rec.getText());}
            String terr="",temp="",l="";
            if (!ter.getText().isBlank()) {terr = ter.getText();}
            if (!tem.getText().isBlank()) {temp = tem.getText();}
            if (!loc.getText().isBlank()) {l = loc.getText();}
            // check for duplicate record
            if (myAthletes.checkDuplicate(n,d,m,y)) {
            	message = "Duplicate record found. Entry failed.";
            	System.out.println("Could not add " +what+ " record. Duplicate found.");
            	return message;};
            Entry e;
            if (!rep.getText().isEmpty()) { e = new SprintEntry(n, d, m, y, h, mm, s, km, r, re);}
            else if (!ter.getText().isEmpty()) { e = new CycleEntry(n, d, m, y, h, mm, s, km, terr, temp);}
        	else if (!loc.getText().isEmpty()) { e = new SwimEntry(n, d, m, y, h, mm, s, km, l);}
        	else {e = new Entry(n, d, m, y, h, mm, s, km);};
            myAthletes.addEntry(e);
        }
        catch (NumberFormatException numE){ //handle exception
        	message = "Invalid date format added. Only intergers accepted.";
        	System.out.println("Adding entry FAILED: " + numE);
        }
        
        return message;
    }
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    public String lookupAll() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAll(d, m, y);
        return message;
    }
    
    public String removeRec() {
    	String n = name.getText();
    	int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
    	String message = myAthletes.removeRec(n,d,m,y);
    	return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        rep.setText("");
        rec.setText("");
        ter.setText("");
        tem.setText("");
        loc.setText("");
    }// blankDisplay
    
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    
    

} // TrainingRecordGUI

