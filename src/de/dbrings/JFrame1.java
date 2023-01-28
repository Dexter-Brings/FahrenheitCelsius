package de.dbrings;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrame1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFahrenheit;
	private JTextField tfCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();
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
	public JFrame1() {
		setTitle("Umrechnung Fahrenheit in Celsius");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfFahrenheit = new JTextField();
		tfFahrenheit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					var fahrenheit = Double.parseDouble(tfFahrenheit.getText());
					var celsius = (fahrenheit - 32) * 5 / 9;
					DecimalFormat f = new DecimalFormat("#0.00");
					tfCelsius.setText(f.format(celsius));
					tfFahrenheit.requestFocus();
					tfFahrenheit.selectAll();
				}
			}
		});
		tfFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFahrenheit.setBounds(33, 40, 201, 40);
		contentPane.add(tfFahrenheit);
		tfFahrenheit.setColumns(10);
		
		tfCelsius = new JTextField();
		tfCelsius.setEditable(false);
		tfCelsius.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCelsius.setColumns(10);
		tfCelsius.setBounds(33, 123, 201, 40);
		contentPane.add(tfCelsius);
		
		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var fahrenheit = Double.parseDouble(tfFahrenheit.getText());
				var celsius = (fahrenheit - 32) * 5 / 9;
				DecimalFormat f = new DecimalFormat("#0.00");
				tfCelsius.setText(f.format(celsius));
				tfFahrenheit.requestFocus();
				tfFahrenheit.selectAll();
			}
		});
		btnUmrechnen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUmrechnen.setBounds(267, 40, 115, 40);
		contentPane.add(btnUmrechnen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnde.setBounds(267, 123, 115, 40);
		contentPane.add(btnEnde);
		
		JLabel lblFahrenheit = new JLabel("Grad Fahrenheit");
		lblFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFahrenheit.setBounds(33, 17, 98, 13);
		contentPane.add(lblFahrenheit);
		
		JLabel lblCelsius = new JLabel("Grad Celsius");
		lblCelsius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelsius.setBounds(33, 100, 98, 13);
		contentPane.add(lblCelsius);
	}
}
