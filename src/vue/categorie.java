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

import Controllers.CategoriesController;

public class categorie extends JPanel {

	private JTextField idCategorie;
	private JTextField nom;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel
	 */
	public categorie() {
	

			
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
			
			JLabel Titre1 = new JLabel("CATEGORIES");
			Titre1.setForeground(new Color(50, 73, 79));
			Titre1.setHorizontalAlignment(SwingConstants.CENTER);
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
			  rowHeader.add ("idCategorie");  
			  rowHeader.add ("nom");  
			  

//			  DefaultTableModel model = new DefaultTableModel(rowHeader,0); 
			  model = new DefaultTableModel(rowHeader,0);
			  table.setModel(model); 
			  model.addRow(rowHeader); 
			  
		  CategoriesController c = new CategoriesController();
		  ResultSet res = null;
			  try {
				  res = c.seeCategory();
				  
			  } catch (SQLException e1) {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
			  }
		   	   
		   	   Vector<String> rowData;      
		   	   if (res != null) {
		   		try {
					while (res.next()){  
						rowData = new Vector<String>() ;  
				    rowData.add (res.getString("idCategorie"));  
					   
					    rowData.add (res.getString("nom"));   
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
			        	  
			        	idCategorie.setText(model.getValueAt(i, 0).toString());
						nom.setText(model.getValueAt(i, 1).toString());
						
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
			
			idCategorie = new JTextField();
			idCategorie.setBounds(216, 275, 167, 37);
			idCategorie.setColumns(10);
			add(idCategorie);
			
			nom = new JTextField();
			nom.setColumns(10);
			nom.setBounds(216, 336, 167, 37);
			add(nom);
			
			JButton ADD = new JButton("Ajouter");
			ADD.setForeground(Color.WHITE);
			ADD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					if(nom.getText().equals("")) {

						int aff;
						JOptionPane.showMessageDialog(null, "renseigner au moins le nom","Avertissement", aff=0);
						
						}
					else{
					try {
						
						c.insertCategory(nom.getText());
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//faire des controllers pour le else if
					
					int aff;
					JOptionPane.showMessageDialog(null, "Donnees inserees, vous avez cree un joueur","note", aff=0);
					
					Object[] a = {idCategorie.getText(),nom.getText()};
					
					model.addRow(a);
					
					idCategorie.setText("");
					nom.setText("");
					
				}
					removeAll();
					add(new categorie());
					updateUI();

					
				}});
			ADD.setFont(new Font("Dialog", Font.BOLD, 16));
			ADD.setBorderPainted(false);
			ADD.setBackground(new Color(120,152,234));
			ADD.setBounds(97, 638, 118, 37);
			add(ADD);
			
			JButton UPDATE = new JButton("Modifier");
			UPDATE.setForeground(Color.WHITE);
			UPDATE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					
				
					
					
					int id = Integer.parseInt(idCategorie.getText());
			
					if(nom.getText().equals("")) {
						
						int aff;
						JOptionPane.showMessageDialog(null, "renseigner au moins le nom","Avertissement", aff=0);
						
					}else{
						
							try {
								c.updateCategory(id,nom.getText());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							int aff;
							JOptionPane.showMessageDialog(null, "Donnees maj","note", aff=0);
							
							model.setValueAt(nom.getText(), i, 1);
							
						
					}
					
					removeAll();
					add(new categorie());
					updateUI();
					
				}
			});
			UPDATE.setFont(new Font("Dialog", Font.BOLD, 16));
			UPDATE.setBorderPainted(false);
			UPDATE.setBackground(new Color(120,152,234));
			UPDATE.setBounds(246, 638, 112, 37);
			add(UPDATE);
			
			JButton DELETE = new JButton("DELETE");
			DELETE.setForeground(Color.WHITE);
			DELETE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i>0) {
						int aff;
						int id = Integer.parseInt(idCategorie.getText());
						try {
							c.deleteCategory(id);
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
			DELETE.setBackground(new Color(120,152,234));
			DELETE.setBounds(97, 710, 118, 37);
			add(DELETE);
			
			JButton CLEAN = new JButton("CLEAR");
			CLEAN.setForeground(Color.WHITE);
			CLEAN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idCategorie.setText("");
					nom.setText("");
				
				}
			});
			CLEAN.setFont(new Font("Dialog", Font.BOLD, 16));
			CLEAN.setBorderPainted(false);
			CLEAN.setBackground(new Color(120,152,234));
			CLEAN.setBounds(246, 710, 112, 37);
			add(CLEAN);
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255, 90));
			panel.setBounds(58, 336, 134, 37);
			add(panel);
			
			
			
			JLabel Lnom = new JLabel("Nom");
			panel.add(Lnom);
			Lnom.setForeground(new Color(50, 73, 79));
			Lnom.setHorizontalAlignment(SwingConstants.CENTER);
			Lnom.setFont(new Font("Dialog", Font.BOLD, 20));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255, 90));
			panel_1.setBounds(58, 275, 134, 37);
			add(panel_1);
			
			JLabel Lnom_1 = new JLabel("id_Categorie");
			Lnom_1.setHorizontalAlignment(SwingConstants.CENTER);
			Lnom_1.setForeground(new Color(50, 73, 79));
			Lnom_1.setFont(new Font("Dialog", Font.BOLD, 20));
			panel_1.add(Lnom_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\test\\img\\background.jpg"));
			lblNewLabel.setBounds(0, 0, 1570, 840);
			add(lblNewLabel);
			
		
			
			
		

	}
}
