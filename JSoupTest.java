package Demo;
/**
 * @author Eddie
 * 09/11/2020
 * version 1.0
 */
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout. Group;

public class JSoupTest implements ActionListener { 
private static JLabel userLabel;
private static JTextField userText;
private static JButton button;
private static JPanel panel;
private static JLabel success ;
private static JPanel frame;
private static String urlinput, urltitle;
	 
public static void main(String [] args) {

// GUI settings
JFrame frame = new JFrame("URL search");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            
panel = new JPanel(); panel.setLayout(null);
userLabel = new JLabel("Enter URL");
panel.add(userLabel);
userLabel.setBounds(50, 50, 150, 25);
			      
userText = new JTextField(80);
panel.add(userText);               
userText.setBounds(130, 50, 150, 25);
			      
success = new JLabel("");
panel.add(success); success.setBounds(50, 200, 400, 25);
		 
button = new JButton("Submit");
button.addActionListener(new JSoupTest());
button.setBounds(50, 100, 130, 25); 
panel.add(button);

frame.add(panel);
frame.setSize(500,400);
frame.setVisible(true);
}
@Override //URL input 
public void actionPerformed(ActionEvent e)  {  
urlinput = userText.getText();

//Connect to JSoup library to parse URL
try {
Document doc = null;
doc = Jsoup.connect(urlinput).get();
urltitle = doc.title();
}
catch (IOException s) {
s.printStackTrace();
}		 
success.setText ("The URL title is " + urltitle);
// Printing to GUI 
}
}