package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controllers.CommandeController;

public class commande extends JPanel {
	private JTextField idCommande;
	private JTextField quantite;
	private JTextField montantTotal;
	private JTextField idEmploye;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public commande() {

	


		/**
		 * Create the panel.
		 */
	
			setBounds(0, 0, 1920, 1080);
			setLayout(null);
			
			JButton btnRetour = new JButton("RETOUR");
			btnRetour.setForeground(Color.DARK_GRAY);
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeAll();
					add(new accueil());
					updateUI();
					
				}
			});
			btnRetour.setFont(new Font("Dialog", Font.BOLD, 23));
			btnRetour.setBorderPainted(false);
			btnRetour.setBackground(new Color(190, 220, 250));
			btnRetour.setBounds(48, 48, 167, 58);
			add(btnRetour);
			
			JPanel panelTitre = new JPanel();
			panelTitre.setLayout(null);
			panelTitre.setBackground(new Color(255, 255, 255, 90));
			panelTitre.setBounds(48, 48, 1421, 217);
			add(panelTitre);
			
			JLabel Titre1 = new JLabel("COMMANDES");
			Titre1.setHorizontalAlignment(SwingConstants.CENTER);
			Titre1.setForeground(new Color(50,73,79));
			Titre1.setFont(new Font("Dialog", Font.BOLD, 90));
			Titre1.setBounds(317, 10, 786, 106);
			panelTitre.add(Titre1);
			
			JPanel Table = new JPanel();
			Table.setLayout(null);
			Table.setBackground(new Color(255, 255, 255, 90));
			Table.setBounds(415, 275, 1054, 522);
			add(Table);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 1034, 502);
			Table.add(scrollPane);
			
			table = new JTable();
			
			Vector<String> rowHeader = new Vector<String> ();      
			  rowHeader.add ("idCommande");  
			  rowHeader.add ("quantite");
			  rowHeader.add ("montantTotal");
			  rowHeader.add ("idEmploye");
			  

//			  DefaultTableModel model = new DefaultTableModel(rowHeader,0); 
			  model = new DefaultTableModel(rowHeader,0);
			  table.setModel(model); 
			  model.addRow(rowHeader); 
			  
		  CommandeController c = new CommandeController();
		  ResultSet res = null;
			  try {
				  res = c.seeCommande();
				  
			  } catch (SQLException e1) {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
			  }
		   	   
		   	   Vector<String> rowData;      
		   	   if (res != null) {
		   		try {
					while (res.next()){  
						rowData = new Vector<String>() ;  
				        rowData.add (res.getString("idCommande"));   
					    rowData.add (res.getString("quantite")); 
					    rowData.add (res.getString("montantTotal")); 
					    rowData.add (res.getString("idEmploye")); 
					    model.addRow(rowData); 
					    model.setColumnIdentifiers(rowData);//pour chopper la colonne
					   }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
		   	   }
		   	      table.setShowGrid(true);
		   	      table.setShowVerticalLines(true);
		   	      
		   	   table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent e) {
						int i = table.getSelectedRow();
			        	  
			        	idCommande.setText(model.getValueAt(i, 0).toString());
						quantite.setText(model.getValueAt(i, 1).toString());
						montantTotal.setText(model.getValueAt(i, 2).toString());
						idEmploye.setText(model.getValueAt(i, 3).toString());
						
					}
				});
		   	   
		   	      Table.add(scrollPane);
		   	  
		   	      try {
					res.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			idCommande = new JTextField();
			idCommande.setBounds(216, 286, 167, 37);
			idCommande.setColumns(10);
			add(idCommande);
			
			quantite = new JTextField();
			quantite.setColumns(10);
			quantite.setBounds(216, 370, 167, 37);
			add(quantite);
			
			JButton ADD = new JButton("Ajouter");
			ADD.setForeground(Color.WHITE);
			ADD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int total = Integer.parseInt(montantTotal.getText());
					int quantity = Integer.parseInt(quantite.getText());
					int idEmp = Integer.parseInt(idEmploye.getText());
					

					if(quantite.getText().equals("") || montantTotal.getText().equals("") || idEmploye.getText().equals("") ) {

						int aff;
						JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs","Avertissement", aff=0);
						
						}
					else{
					try {
						
						c.insertCommande(quantity,total,idEmp);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					int aff;
					JOptionPane.showMessageDialog(null, "Donnees inserees, vous avez ajoute une commande","note", aff=0);
					
					Object[] a = {idCommande.getText(),quantite.getText(),montantTotal.getText(),idEmploye.getText()};
					
					model.addRow(a);
					
					idCommande.setText("");
					quantite.setText("");
					montantTotal.setText("");
					idEmploye.setText("");
					
				}
					removeAll();
					add(new commande());
					updateUI();

					
				}});
			ADD.setFont(new Font("Dialog", Font.BOLD, 16));
			ADD.setBorderPainted(false);
			ADD.setBackground(new Color(120, 152, 234));
			ADD.setBounds(97, 638, 118, 37);
			add(ADD);
			
			JButton UPDATE = new JButton("Modifier");
			UPDATE.setForeground(Color.WHITE);
			UPDATE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					
				
					
					int total = Integer.parseInt(montantTotal.getText());
					int quantity = Integer.parseInt(quantite.getText());
					int idEmp = Integer.parseInt(idEmploye.getText());
					int id = Integer.parseInt(idCommande.getText());
			
					if(quantite.getText().equals("") || montantTotal.getText().equals("") || idEmploye.getText().equals("") ) {
						
						int aff;
						JOptionPane.showMessageDialog(null, "veuillez renseigner tout les champs","Avertissement", aff=0);
						
					}else{
						
							try {
								c.updateCommande(id,quantity,total,idEmp);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							int aff;
							JOptionPane.showMessageDialog(null, "Donnees mises a jour","note", aff=0);
							
							model.setValueAt(quantite.getText(), i, 1);
							
						
					}
					
					removeAll();
					add(new commande());
					updateUI();
					
				}
			});
			UPDATE.setFont(new Font("Dialog", Font.BOLD, 16));
			UPDATE.setBorderPainted(false);
			UPDATE.setBackground(new Color(120, 152, 234));
			UPDATE.setBounds(246, 638, 112, 37);
			add(UPDATE);
			
			JButton DELETE = new JButton("Supprimer");
			DELETE.setForeground(Color.WHITE);
			DELETE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i>0) {
						int aff;
						int id = Integer.parseInt(idCommande.getText());
						try {
							c.deleteCommande(id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Donnees supprimees","note", aff=0);
						model.removeRow(i);
					}else {
						int aff;
						JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne","note", aff=0);
					}
				}
			});
			DELETE.setFont(new Font("Dialog", Font.BOLD, 16));
			DELETE.setBorderPainted(false);
			DELETE.setBackground(new Color(120, 152, 234));
			DELETE.setBounds(97, 710, 118, 37);
			add(DELETE);
			
			JButton CLEAN = new JButton("CLEAR");
			CLEAN.setForeground(Color.WHITE);
			CLEAN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idCommande.setText("");
					quantite.setText("");
					montantTotal.setText("");
					idEmploye.setText("");
				
				}
			});
			CLEAN.setFont(new Font("Dialog", Font.BOLD, 16));
			CLEAN.setBorderPainted(false);
			CLEAN.setBackground(new Color(120, 152, 234));
			CLEAN.setBounds(246, 710, 112, 37);
			add(CLEAN);
			
			montantTotal = new JTextField();
			montantTotal.setColumns(10);
			montantTotal.setBounds(216, 444, 167, 37);
			add(montantTotal);
			
			idEmploye = new JTextField();
			idEmploye.setColumns(10);
			idEmploye.setBounds(216, 533, 167, 37);
			add(idEmploye);
			
			JPanel panel = new JPanel();
			panel.setBounds(48, 533, 150, 37);
			panel.setBackground(new Color(255,255,255,90));
			add(panel);
			
			JLabel lblidEmploye = new JLabel("Employe");
			lblidEmploye.setForeground(new Color(50,73,79));
			panel.add(lblidEmploye);
			lblidEmploye.setHorizontalAlignment(SwingConstants.CENTER);
			lblidEmploye.setFont(new Font("Dialog", Font.BOLD, 20));
			
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255, 90));
			panel_1.setBounds(48, 444, 150, 37);
			add(panel_1);
			
			JLabel lblidEmploye_1 = new JLabel("Total");
			lblidEmploye_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblidEmploye_1.setForeground(new Color(50, 73, 79));
			lblidEmploye_1.setFont(new Font("Dialog", Font.BOLD, 20));
			panel_1.add(lblidEmploye_1);
			

			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBackground(new Color(255, 255, 255, 90));
			panel_1_1.setBounds(48, 370, 150, 37);
			add(panel_1_1);
			
			JLabel lblidEmploye_1_1 = new JLabel("Quantité");
			lblidEmploye_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblidEmploye_1_1.setForeground(new Color(50, 73, 79));
			lblidEmploye_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
			panel_1_1.add(lblidEmploye_1_1);
			
			
			JPanel panel_1_1_1 = new JPanel();
			panel_1_1_1.setBackground(new Color(255, 255, 255, 90));
			panel_1_1_1.setBounds(48, 286, 150, 37);
			add(panel_1_1_1);
			
			JLabel lblidEmploye_1_1_1 = new JLabel("id_Commande");
			lblidEmploye_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblidEmploye_1_1_1.setForeground(new Color(50, 73, 79));
			lblidEmploye_1_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
			panel_1_1_1.add(lblidEmploye_1_1_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\test\\img\\background.jpg"));
			lblNewLabel.setBounds(0, 0, 1570, 840);
			add(lblNewLabel);
			

			
		
			
		
			
	}


	

}
