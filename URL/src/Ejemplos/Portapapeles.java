package Ejemplos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Portapapeles extends JFrame {

	private JPanel contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portapapeles frame = new Portapapeles();
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
	public Portapapeles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {
			
			@Override
			public void flavorsChanged(FlavorEvent e) {
			
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				String result;
				try {
					result = (String) clipboard.getData(DataFlavor.stringFlavor);
					String menu=hilo.menu(result,"sitemap");
					label.setText(menu);
				} catch (UnsupportedFlavorException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		label = new JLabel("");
		label.setBounds(121, 72, 182, 29);
		contentPane.add(label);
		
	}
}
