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

import Controllers.EmployeController;

public class employe extends JPanel {
	
	private JTextField idEmploye;
	private JTextField nom;
	private JTextField prenom;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public employe() {
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
		
		JLabel Titre1 = new JLabel("EMPLOYE");
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
		  rowHeader.add ("idEmploye");  
		  rowHeader.add ("nom");
		  rowHeader.add ("prenom");
		  
		  

//		  DefaultTableModel model = new DefaultTableModel(rowHeader,0); 
		  model = new DefaultTableModel(rowHeader,0);
		  table.setModel(model); 
		  model.addRow(rowHeader); 
		  
	  EmployeController c = new EmployeController();
	  ResultSet res = null;
		  try {
			  res = c.seeEmploye();
			  
		  } catch (SQLException e1) {
			  // TODO Auto-generated catch block
			  e1.printStackTrace();
		  }
	   	   
	   	   Vector<String> rowData;      
	   	   if (res != null) {
	   		try {
				while (res.next()){  
					rowData = new Vector<String>() ;  
			        rowData.add (res.getString("idEmploye"));   
				    rowData.add (res.getString("nom")); 
				    rowData.add (res.getString("prenom")); 
				   
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
		        	  
		        	idEmploye.setText(model.getValueAt(i, 0).toString());
					nom.setText(model.getValueAt(i, 1).toString());
					prenom.setText(model.getValueAt(i, 2).toString());
					
					
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
		
		idEmploye = new JTextField();
		idEmploye.setBounds(216, 286, 167, 37);
		idEmploye.setColumns(10);
		add(idEmploye);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(216, 357, 167, 37);
		add(nom);
		
		JButton ADD = new JButton("Ajouter");
		ADD.setForeground(Color.WHITE);
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				

				if(nom.getText().equals("") || prenom.getText().equals("")) {

					int aff;
					JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs","Avertissement", aff=0);
					
					}
				else{
				try {
					
					c.insertEmploye(nom.getText(),prenom.getText());
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//faire des controllers pour le else if
				
				int aff;
				JOptionPane.showMessageDialog(null, "Donnees inserees, vous avez ajoute un employe","note", aff=0);
				
				Object[] a = {idEmploye.getText(),nom.getText(),prenom.getText()};
				
				model.addRow(a);
				
				idEmploye.setText("");
				nom.setText("");
				prenom.setText("");
				
				
			}
				removeAll();
				add(new employe());
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
				
			
				
			
				
				int id = Integer.parseInt(idEmploye.getText());
		
				if(nom.getText().equals("") || prenom.getText().equals("")  ) {
					
					int aff;
					JOptionPane.showMessageDialog(null, "veuillez renseigner tout les champs","Avertissement", aff=0);
					
				}else{
					
						try {
							c.updateEmploye(id,nom.getText(),prenom.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						int aff;
						JOptionPane.showMessageDialog(null, "Donnees mises a jour","note", aff=0);
						
						model.setValueAt(nom.getText(), i, 1);
						model.setValueAt(prenom.getText(), i, 2);
						
					
				}
				
				removeAll();
				add(new employe());
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
					int id = Integer.parseInt(idEmploye.getText());
					try {
						c.deleteEmploye(id);
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
				idEmploye.setText("");
				nom.setText("");
				prenom.setText("");
				
			
			}
		});
		CLEAN.setFont(new Font("Dialog", Font.BOLD, 16));
		CLEAN.setBorderPainted(false);
		CLEAN.setBackground(new Color(120, 152, 234));
		CLEAN.setBounds(246, 710, 112, 37);
		add(CLEAN);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(216, 421, 167, 37);
		add(prenom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255, 90));
		panel_1.setBounds(48, 421, 150, 37);
		add(panel_1);
		
		JLabel lblidEmploye_1 = new JLabel("Prenom");
		lblidEmploye_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblidEmploye_1.setForeground(new Color(50, 73, 79));
		lblidEmploye_1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_1.add(lblidEmploye_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255, 90));
		panel_1_1.setBounds(48, 357, 150, 37);
		add(panel_1_1);
		
		JLabel lblidEmploye_1_1 = new JLabel("Nom");
		lblidEmploye_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblidEmploye_1_1.setForeground(new Color(50, 73, 79));
		lblidEmploye_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_1_1.add(lblidEmploye_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255, 90));
		panel_1_1_1.setBounds(48, 286, 150, 37);
		add(panel_1_1_1);
		
		JLabel lblidEmploye_1_1_1 = new JLabel("id_Employe");
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
