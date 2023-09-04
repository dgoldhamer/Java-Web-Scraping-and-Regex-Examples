package pp04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UserGUI extends JPanel {
	
	
	  private JButton scrapeButton;
	  private JButton closeButton;
	  static JTextArea txtresults;
	  private JLabel lblresults;
	  private JScrollPane jp;
	  // add more UI components as needed
	  private Scraper scraper;
	  
	
	
	  private String url;
	  
	  public UserGUI() {
		 
		  // uses the url provided in the document


	    initGUI();
	    doTheLayout();

	    scrapeButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            try {
					scrape();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            }
	    });
	    
	    closeButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            close();
	            }
	    });
	    
	   
	  } // end of constructor

	  
	  // Creates and initialize the GUI objects
	  private void initGUI(){
		  
		  scrapeButton = new JButton("Scrape NFL Page");
		  closeButton = new JButton("Close");
		  lblresults = new JLabel("Output");
		  
		  txtresults = new JTextArea(20, 80);
		  txtresults.setText("");

		  txtresults.setWrapStyleWord(true);
		  txtresults.setLineWrap(false);
		  txtresults.setEditable(false);
		  txtresults.setVisible(true);
		  
		  jp = new JScrollPane(txtresults);
		  jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		  
	  
	  }// end of creating objects method

	
	  // Layouts the UI components as shown in the project document
	  private void doTheLayout(){

		  JPanel top = new JPanel();
		  top.add(scrapeButton);
		  JPanel center = new JPanel();
		  //center.add(txtresults);
		  center.add(jp);
		  JPanel bottom = new JPanel();
		  bottom.add(closeButton);
		  
		  setLayout ( new BorderLayout());
		  add(top, "North");
		  top.setPreferredSize(new Dimension(100,40));
		  add(center, "Center");
		  center.setPreferredSize(new Dimension(90,70));
		  add(bottom, "South");
		  bottom.setPreferredSize(new Dimension(100,40));
		  
	  }// end of Layout method

	 
	// Uses the Scraper object reference to return and display the data as shown in the project document 
	 void scrape() throws FileNotFoundException{
		 Scraper.parseData();
	       
	  }// end of scrape action event method
	  
	 
	  void close(){
	      System.exit(0);
	  }// end of close action event method
	  
	  


	public static void main(String[] args) {
	   JFrame f = new JFrame("NFL Stats");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();
        contentPane.add( new UserGUI());
        f.pack();
        f.setSize(1000, 500);
        f.setVisible(true);
	}// end of main method

}// end of class