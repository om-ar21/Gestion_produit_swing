package vue;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.SwingConstants;


public class accueil extends JPanel {
	private DefaultTableModel model;

	public accueil() {//pour de plus ample d�tails sur la construction de ce panel se referer a admin compagnon (m�me construction)
		//caract�ristiques du panel 
		
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JPanel panelTitre = new JPanel();
		panelTitre.setLayout(null);
		panelTitre.setBackground(new Color(255, 255, 255, 90));
		panelTitre.setBounds(49, 49, 1421, 217);
		add(panelTitre);
		
		JLabel Titre1 = new JLabel("BIENVENU");
		Titre1.setForeground(new Color(50, 73, 79));
		Titre1.setHorizontalAlignment(SwingConstants.CENTER);
		Titre1.setFont(new Font("Dialog", Font.BOLD, 90));
		Titre1.setBounds(318, 0, 786, 106);
		panelTitre.add(Titre1);
		
		JLabel lblNewLabel_1 = new JLabel("Veuillez Séléctionner la rubrique que vous souhaitez consulter");
		lblNewLabel_1.setForeground(new Color(50, 73, 79));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(335, 99, 751, 118);
		panelTitre.add(lblNewLabel_1);
		
		
		
		JButton categories = new JButton("CATEGORIES");
		categories.setForeground(Color.WHITE);
		categories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				removeAll();
				add(new categorie());
				updateUI();

				
			}});
		categories.setFont(new Font("Dialog", Font.BOLD, 16));
		categories.setBorderPainted(false);
		categories.setBackground(new Color(120, 152, 234));
		categories.setBounds(49, 441, 177, 57);
		add(categories);
		
		JButton clients = new JButton("CLIENTS");
		clients.setForeground(Color.WHITE);
		clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new client());
				updateUI();
				
			}
		});
		clients.setFont(new Font("Dialog", Font.BOLD, 16));
		clients.setBorderPainted(false);
		clients.setBackground(new Color(120, 152, 234));
		clients.setBounds(354, 441, 164, 57);
		add(clients);
		
		JButton produits = new JButton("PRODUITS");
		produits.setForeground(Color.WHITE);
		produits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new produit());
				updateUI();
				
	
			}
		});
		produits.setFont(new Font("ROBOTO", Font.BOLD, 16));
		produits.setBorderPainted(false);
		produits.setBackground(new Color(120, 152, 234));
		produits.setBounds(1306, 441, 164, 57);
		add(produits);
		
		JButton employes = new JButton("EMPLOYES");
		employes.setForeground(Color.WHITE);
		employes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new employe());
				updateUI();
				
			
			}
		});
		employes.setFont(new Font("Dialog", Font.BOLD, 16));
		employes.setBorderPainted(false);
		employes.setBackground(new Color(120, 152, 234));
		employes.setBounds(1015, 441, 164, 57);
		add(employes);
		
		JButton btnCommandes = new JButton("COMMANDES");
		btnCommandes.setForeground(Color.WHITE);
		btnCommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new commande());
				updateUI();
				
			
			}
		});
		btnCommandes.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCommandes.setBorderPainted(false);
		btnCommandes.setBackground(new Color(120, 152, 234));
		btnCommandes.setBounds(678, 441, 164, 57);
		add(btnCommandes);
		
//		JLabel fond = new JLabel("");
//		fond.setIcon(new ImageIcon("C:/Users/user/Desktop/me/src/background.jpg"));
//		fond.setBounds(0, 0, 1540, 840);
//		add(fond);
//		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\test\\img\\background.jpg"));
		lblNewLabel.setBounds(0, 0, 1570, 840);
		add(lblNewLabel);
	
	}
}
