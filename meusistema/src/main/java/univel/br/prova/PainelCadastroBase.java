package univel.br.prova;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PainelCadastroBase extends JPanel {
		
		protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alteraçao";
		private JMenuBar menuBar;
		private JMenu mnArquivo;
		protected JMenuItem mntmImprimir;
		protected JMenuItem mntmExportarPdf;
		protected JLabel lblQuantidade;
		private JScrollPane scrollPane;
		protected JTable table;
		protected JLabel labelAlerta;
		protected JTextField txfNome;
		protected JTextField txfId;
		protected JTextField txfQualidade;
		protected JTextField txfQuantidate;
		protected JButton btnNovo;
		protected JButton btnSalvar;
		protected JButton btnExcluir;
		protected JButton btnAtualizar;
		
		public PainelCadastroBase() {
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			
			menuBar = new JMenuBar();
			//setJMenuBar(menuBar);
			
			mnArquivo = new JMenu("Arquivo");
			menuBar.add(mnArquivo);
			
			mntmImprimir = new JMenuItem("Imprimir");
			mnArquivo.add(mntmImprimir);
			
			mntmExportarPdf = new JMenuItem("Exportar PDF");
			mnArquivo.add(mntmExportarPdf);
			//contentPane = new JPanel();
			this.setBorder(new EmptyBorder(5, 5, 5, 5));
			//setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 0};
			gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
			gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(gbl_contentPane);
			
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			this.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblId = new JLabel("Id");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 0;
			gbc_lblId.gridy = 0;
			panel.add(lblId, gbc_lblId);
			
			txfId = new JTextField();
			GridBagConstraints gbc_txfId = new GridBagConstraints();
			gbc_txfId.anchor = GridBagConstraints.WEST;
			gbc_txfId.insets = new Insets(0, 0, 5, 5);
			gbc_txfId.gridx = 1;
			gbc_txfId.gridy = 0;
			panel.add(txfId, gbc_txfId);
			txfId.setColumns(5);
			
			labelAlerta = new JLabel(CARREGADO_PARA_ALTERACAO);
			labelAlerta.setForeground(Color.RED);
			GridBagConstraints gbc_labelAlerta = new GridBagConstraints();
			gbc_labelAlerta.anchor = GridBagConstraints.WEST;
			gbc_labelAlerta.insets = new Insets(0, 0, 5, 0);
			gbc_labelAlerta.gridx = 2;
			gbc_labelAlerta.gridy = 0;
			panel.add(labelAlerta, gbc_labelAlerta);
			
			JLabel lblNome = new JLabel("Nome");
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 1;
			panel.add(lblNome, gbc_lblNome);
			
			txfNome = new JTextField();
			GridBagConstraints gbc_txfNome = new GridBagConstraints();
			gbc_txfNome.gridwidth = 2;
			gbc_txfNome.insets = new Insets(0, 0, 5, 0);
			gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_txfNome.gridx = 1;
			gbc_txfNome.gridy = 1;
			panel.add(txfNome, gbc_txfNome);
			txfNome.setColumns(10);
			
			JLabel lblQualidade = new JLabel("Qualidade");
			GridBagConstraints gbc_lblQualidade = new GridBagConstraints();
			gbc_lblQualidade.insets = new Insets(0, 0, 5, 5);
			gbc_lblQualidade.gridx = 0;
			gbc_lblQualidade.gridy = 2;
			panel.add(lblQualidade, gbc_lblQualidade);
			
			txfQualidade = new JTextField();
			GridBagConstraints gbc_txfQualidade = new GridBagConstraints();
			gbc_txfQualidade.insets = new Insets(0, 0, 5, 0);
			gbc_txfQualidade.gridwidth = 2;
			gbc_txfQualidade.anchor = GridBagConstraints.WEST;
			gbc_txfQualidade.gridx = 1;
			gbc_txfQualidade.gridy = 2;
			panel.add(txfQualidade, gbc_txfQualidade);
			txfQualidade.setColumns(15);
			
			lblQuantidade = new JLabel("Quantidade");
			GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
			gbc_lblQuantidade.insets = new Insets(0, 0, 0, 5);
			gbc_lblQuantidade.gridx = 0;
			gbc_lblQuantidade.gridy = 3;
			panel.add(lblQuantidade, gbc_lblQuantidade);
			
			txfQuantidate = new JTextField();
			GridBagConstraints gbc_txfQuantidate = new GridBagConstraints();
			gbc_txfQuantidate.anchor = GridBagConstraints.WEST;
			gbc_txfQuantidate.gridwidth = 2;
			gbc_txfQuantidate.insets = new Insets(0, 0, 0, 5);
			gbc_txfQuantidate.gridx = 1;
			gbc_txfQuantidate.gridy = 3;
			panel.add(txfQuantidate, gbc_txfQuantidate);
			txfQuantidate.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			this.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			btnNovo = new JButton("Novo");
			GridBagConstraints gbc_btnNovo = new GridBagConstraints();
			gbc_btnNovo.anchor = GridBagConstraints.EAST;
			gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
			gbc_btnNovo.gridx = 0;
			gbc_btnNovo.gridy = 0;
			panel_1.add(btnNovo, gbc_btnNovo);
			
			btnSalvar = new JButton("Salvar");
			GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
			gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
			gbc_btnSalvar.gridx = 1;
			gbc_btnSalvar.gridy = 0;
			panel_1.add(btnSalvar, gbc_btnSalvar);
			
			btnExcluir = new JButton("Excluir");
			GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
			gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
			gbc_btnExcluir.gridx = 2;
			gbc_btnExcluir.gridy = 0;
			panel_1.add(btnExcluir, gbc_btnExcluir);
			
			btnAtualizar = new JButton("Atualizar");
			GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
			gbc_btnAtualizar.gridx = 3;
			gbc_btnAtualizar.gridy = 0;
			panel_1.add(btnAtualizar, gbc_btnAtualizar);
			
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 2;
			this.add(scrollPane, gbc_scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);

	}

}
