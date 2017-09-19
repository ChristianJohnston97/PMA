package main;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.StringUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Image;

import testing.Driver;
import main.Medication;
import java.awt.Color;


public class InputMyMedication extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JLabel lblStrengthMg;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblBarCode;
	private JLabel lblTabletsPer;
	private JButton btnAddMedication;
	 
	private Driver driver;
	private JButton button_1;
	private DisplayMedication displayMeds;

	
	public InputMyMedication(DisplayMedication displayMyMeds,Driver theDriver)
	{
		this();
		driver = theDriver;
		displayMeds = displayMyMeds;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputMyMedication frame = new InputMyMedication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
		
	public InputMyMedication() {
	
		
		try{
			driver = new Driver();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Input new medication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 53, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 91, 192, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddNewMedication = new JLabel("Add new medication");
		lblAddNewMedication.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblAddNewMedication.setBounds(17, 0, 200, 50);
		contentPane.add(lblAddNewMedication);
		
		JLabel lblNewLabel = new JLabel("Pharmaceutical company");
		lblNewLabel.setBounds(41, 41, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblMedication = new JLabel("Medication");
		lblMedication.setBounds(41, 79, 200, 50);
		contentPane.add(lblMedication);
		
		button = new JButton("Back to main page");
		button.setBackground(Color.red);
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame.main(null);
			}
		});
		button.setBounds(284, 243, 162, 29);
		contentPane.add(button);
		
		lblStrengthMg = new JLabel("Strength (mg)");
		lblStrengthMg.setBounds(41, 118, 200, 50);
		contentPane.add(lblStrengthMg);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 131, 192, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(218, 167, 192, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(218, 201, 192, 30);
		contentPane.add(textField_4);
		
		lblBarCode = new JLabel("Bar code Number ");
		lblBarCode.setBounds(41, 152, 200, 50);
		contentPane.add(lblBarCode);
		
		lblTabletsPer = new JLabel("No. of Tablets per Packet");
		lblTabletsPer.setBounds(41, 187, 200, 50);
		contentPane.add(lblTabletsPer);
		
		btnAddMedication = new JButton("Add Medication!");
		btnAddMedication.setBackground(Color.green);
		btnAddMedication.setOpaque(true);
		btnAddMedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boolean saveMed = false;
			if(!stringNotEmpty(textField.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please enter correct pharmaceutical company!");
				textField.setText("");
				saveMed = true;
			}
			if(!stringNotEmpty(textField_1.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please enter correct medication!");
				textField_1.setText("");
				saveMed = true;

			}
			if(!MyDoubleVerifier(textField_2))
			{
				JOptionPane.showMessageDialog(null, "Please enter correct strength!");
				textField_2.setText("");
				saveMed = true;

			}
			if(!MyBigDecmialVerifier(textField_3))
			{
				JOptionPane.showMessageDialog(null, "Please enter correct bar code!");
				textField_3.setText("");
				saveMed = true;

			}
			if(!MyNumericVerifier(textField_4))
			{
				JOptionPane.showMessageDialog(null, "Please enter correct number of tablets in packet!");
				textField_4.setText("");
				saveMed = true;

			}
			if(!saveMed)
			{
				saveMedication();
			}
			
			}
		});
		btnAddMedication.setBounds(17, 243, 162, 29);
		contentPane.add(btnAddMedication);
		
		button_1 = new JButton("Display Medication");
		button_1.setBackground(Color.green);
		button_1.setOpaque(true);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayMedication display = new DisplayMedication();
				display.setVisible(true);
			}
		});
		button_1.setBounds(218, 8, 192, 40);
		contentPane.add(button_1);
		Image img = new ImageIcon(this.getClass().getResource("/help-icon.png")).getImage();
	}
	
	
	protected void saveMedication() {
		
		
		//verifying data entry fields
		String string1 = textField.getText();
		String string2 = textField_1.getText();		
		String string3 = textField_2.getText();
		String string4 = textField_3.getText();
		String string5 = textField_4.getText();
		
		
		double double1 =  Double.parseDouble(string3);
		BigDecimal bD1 = new BigDecimal(string4);
		int int2 = Integer.parseInt(string5);
		
		


		Medication tempMedication = new Medication(string1,
				string2, double1, bD1, int2);
		try {
			// save to the database
			driver.addNewMedication(tempMedication);

			dispose();
			Result result = new Result();
			result.setVisible(true);
			
			// show success message
			JOptionPane.showMessageDialog(displayMeds,
					"Medication added succesfully.",
					"Medication Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			exc.printStackTrace();
 			JOptionPane.showMessageDialog(
					displayMeds,
					"Error saving medication: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

	    public boolean MyNumericVerifier(JComponent input) {
	       String text = ((JTextField) input).getText();
	       try {
	          Integer.parseInt(text);
	       } catch (NumberFormatException e) {
	          return false;
	       }

	       return true;
	    }
	
	

	    public boolean MyDoubleVerifier(JComponent input) {
	       String text = ((JTextField) input).getText();
	       try {
	    	   Double.parseDouble(text);
	       } catch (NumberFormatException e) {
	          return false;
	       }

	       return true;
	    }
	
	

	    public boolean MyBigDecmialVerifier(JComponent input) {
	       String text = ((JTextField) input).getText();
	       try {
	    	   BigDecimal bd = new BigDecimal(text);
	       } catch (NumberFormatException e) {
	          return false;
	       }
	       
	       if(text.length() != 13)
	       {
	    	   return false;
	       }
	       return true;
	    }
	
	public boolean stringNotEmpty(String string)
	{
		if(StringUtils.isNullOrEmpty(string))
		{
			System.out.println("Please enter a valid Pharmaceutical company");
			return false;
		}		
		return true;
	}

}
