package xmltoJSONConverter;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class EntryForm {
	 
	 private static JButton selectButton = new JButton("Open");
     private static JFileChooser fileChooser = new JFileChooser();
     private static JTextField inputTF = new JTextField(20);
     
     private static JTextField outputTF = new JTextField(20);
     private static JFileChooser opfileChooser = new JFileChooser();
     private static JButton oSelButton = new JButton("Open");
     
     private static JButton convertXMlButton = new JButton("Convert XML to JSON");
	

	public static void createAndShowGUI() {

		JFrame jFrame = new JFrame("EntryForm");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = jFrame.getContentPane();
		contentPane.setPreferredSize(new Dimension(500,500));
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		//Create and add the components.
        JLabel inputLabel = new JLabel("Input File (XML): ");        
        JLabel outputLabel = new JLabel("Select Output Folder :");
        
        contentPane.add(inputLabel);
        contentPane.add(inputTF);        
        contentPane.add(selectButton);  
        
        contentPane.add(outputLabel);
        contentPane.add(outputTF);
        contentPane.add(oSelButton);
        
        contentPane.add(convertXMlButton);

        //Adjust constraints for the label so it's at (5,5).
        layout.putConstraint(SpringLayout.WEST, inputLabel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, inputLabel, 5, SpringLayout.NORTH, contentPane);

        //Adjust constraints for the text field so it's at
        //(<label's right edge> + 5, 5).
        layout.putConstraint(SpringLayout.WEST, inputTF, 5, SpringLayout.EAST, inputLabel);
        layout.putConstraint(SpringLayout.NORTH, inputTF, 5, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, selectButton, 5, SpringLayout.EAST, inputTF);
        layout.putConstraint(SpringLayout.NORTH, selectButton, 5, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, outputLabel, 5, SpringLayout.WEST, inputLabel);
        layout.putConstraint(SpringLayout.NORTH, outputLabel, 40, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, outputTF, 5, SpringLayout.EAST, outputLabel);
        layout.putConstraint(SpringLayout.NORTH, outputTF, 40, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, oSelButton, 5, SpringLayout.EAST, outputTF);
        layout.putConstraint(SpringLayout.NORTH, oSelButton, 40, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, convertXMlButton, 25, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, convertXMlButton, 80, SpringLayout.NORTH, contentPane);
		
        
        jFrame.pack();
		jFrame.setVisible(true);

	}
	
	public static void main(String[] args) {
		
		/* Enabling Multiple Selection */
        //fileChooser.setMultiSelectionEnabled(true);

        /* Setting Current Directory */
        fileChooser.setCurrentDirectory(new File("C:\\Documents and Settings"));

        /* Adding action listener to open file */
        selectButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent event) {
        		String command = event.getActionCommand();
        		if (command.equals("Open")) {
        			if (fileChooser.showOpenDialog(selectButton) == JFileChooser.APPROVE_OPTION) {
        				inputTF.setText(fileChooser.getSelectedFile().getAbsolutePath());
        			}
        		}
        	}
        });

        opfileChooser.setCurrentDirectory(new File("C:\\"));
        opfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        oSelButton.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent event) {
				String command = event.getActionCommand();
				if (command.equals("Open")) {
					if (opfileChooser.showOpenDialog(oSelButton) == JFileChooser.APPROVE_OPTION) {
						outputTF.setText(opfileChooser.getSelectedFile().getAbsolutePath().toString());
					}
				}				
			}
		});
        
        
        convertXMlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XMLtoJSON converter = new XMLtoJSON();
				converter.convertXMLtoJSON(inputTF.getText(), outputTF.getText());	
			}
		});
        
        
        /* Running the Application */
        new EntryForm();

		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
