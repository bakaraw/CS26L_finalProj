package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

	public class Progressbar {
   
	public Progressbar() {JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(463, 316);
    frame.getContentPane().setLayout(null);

    
    JProgressBar progressBar = new JProgressBar(0, 100);
    progressBar.setBounds(73, 128, 300, 41);
    progressBar.setStringPainted(true);

 
    frame.getContentPane().add(progressBar);
    
    JLabel lblNewLabel = new JLabel("LOADING");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblNewLabel.setBounds(172, 64, 102, 35);
    frame.getContentPane().add(lblNewLabel);

    
    Timer timer = new Timer(10, new ActionListener() {
       int value = 0;

      
    public void actionPerformed(ActionEvent e) {
        value++;
        progressBar.setValue(value);

            if (value >= 100) {
                ((Timer) e.getSource()).stop();     
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {

                        new Dashboard2().setVisible(true);
                    }                
                });
                
                frame.dispose(); 
            }
        }
    });

    timer.start();
    frame.setVisible(true);
}
	
 
}
