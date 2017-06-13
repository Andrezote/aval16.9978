package univel.br.prova;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class PainelWrapper extends JPanel {

	private JButton btnXis;
	private JLabel lblTitulo;

	/**
	 * Create the panel.
	 */
	public PainelWrapper() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setForeground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitulo = new JLabel("New label");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblTitulo, gbc_lblNewLabel);
		
		btnXis = new JButton("Xis");
		GridBagConstraints gbc_btnXis = new GridBagConstraints();
		gbc_btnXis.anchor = GridBagConstraints.EAST;
		gbc_btnXis.gridx = 1;
		gbc_btnXis.gridy = 0;
		panel.add(btnXis, gbc_btnXis);

	}
	
	public void setConteudo(JPanel painel){
		add(painel,BorderLayout.CENTER);
	}
	
	public void setAcaoFechar(ActionListener action){
		btnXis.addActionListener(action);
	}
	
	public void setTitulo(String titulo){
		lblTitulo.setText(titulo);
	}

}
