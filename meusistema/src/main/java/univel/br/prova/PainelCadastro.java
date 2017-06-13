package univel.br.prova;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class PainelCadastro extends PainelCadastroBase{
	
	private Produto contatoSelecionado;
	
	private ProdutoModel modelo;
	
	public PainelCadastro() {
		super();
		limparCampos();
		configurarBotoes();
		configuraTabela();
		configuraMenus();
	}

	private void configuraMenus() {
		super.mntmImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//colocar duas barras sempre que copiar um path novo
				String file = "C:\\Users\\aftosetto\\JaspersoftWorkspace\\MyReports\\JasperDnv.jasper";
				
				JasperPrint jasperPrintPDF;
				try {
					Connection con = ConexaoDB.getInstance().getConnection();
					
					//preencher com jasperfillmanager
					jasperPrintPDF = JasperFillManager.fillReport(file, null, con);
					Locale locale = Locale.getDefault();
					//voce passa o relatorio preenchido, o false e pra nao fechar sua aplicaçao
					//locale ele pega a localizaçao da sua maquina e traduz pra portugues
					JasperViewer.viewReport(jasperPrintPDF, false, locale);
					//Desktop.getDesktop().open(new File("teste.pdf"));
				} catch (JRException e3) {
					e3.printStackTrace();
				}
				ProdutoDao dao = new ProdutoDao();
				List<Produto> lista = dao.getTodos();
				lista.forEach(System.out::println);
				
				System.out.println("teste");
			}
		});
		super.mntmExportarPdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//colocar duas barras sempre que copiar um path novo
				String file = "C:\\Users\\aftosetto\\JaspersoftWorkspace\\MyReports\\JasperDnv.jasper";
				
				JasperPrint jasperPrintPDF;
				try {
					Connection con = ConexaoDB.getInstance().getConnection();
					//preencher com jasperfillmanager
					jasperPrintPDF = JasperFillManager.fillReport(file, null, con);
					Locale locale = Locale.getDefault();
					//se for pra exportar arquivo chama esse o viewer e para abrir o jasperviewer chama o de cima
					JasperExportManager.exportReportToPdfFile(jasperPrintPDF, "teste.pdf");
					
					Desktop.getDesktop().open(new File("teste.pdf"));
				} catch (JRException e3) {
					e3.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}


	private void configuraTabela() {
		
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = dao.getTodos();
		
		this.modelo = new ProdutoModel(lista);
		// this.modelo = new ContatoModel();
		super.table.setModel(modelo);
		
		super.table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						System.out.println("NÃ£o hÃ¡ linha selecionada");
					} else {
						System.out.println("Linha " + idx);
						carregarLinha(idx);
					}
				}
			}
		});

			
		
	}


	protected void carregarLinha(int idx) {
		Produto c = this.modelo.getContato(idx);
		this.contatoSelecionado = c;
		this.labelAlerta.setText(CARREGADO_PARA_ALTERACAO);
		
		super.txfId.setText(String.valueOf(c.getId()));
		super.txfNome.setText(c.getNome());
		super.txfQualidade.setText(c.getQualidade());
		super.txfQuantidate.setText(String.valueOf(c.getQuantidade()));
		
		super.btnExcluir.setEnabled(true);
		
	}


	private void configurarBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Novo");
				novo();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Salvar");
				salvar();
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Excluir");
				excluir();
			}
		});
	}


	protected void excluir() {
		this.modelo.remover(this.contatoSelecionado);
		limparCampos();
	}


	protected void salvar() {
		if (contatoSelecionado == null) {
			Produto c = new Produto();
			
			String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strQualidade = txfQualidade.getText().trim();
			String Quantidade = txfQuantidate.getText().trim();
			
			Long LongId = Long.parseLong(strId);
			int intQtd = Integer.parseInt(Quantidade);
			
			c.setId(LongId);
			c.setNome(strNome);
			c.setQualidade(strQualidade);
			c.setQuantidade(intQtd);
			
			this.modelo.adicionar(c);
			
			limparCampos();
			
		} else {
			
			String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strQualidade = txfQualidade.getText().trim();
			String strQuantidade = txfQuantidate.getText().trim();
			
			Long intId = Long.parseLong(strId);
			int intQuantidade = Integer.parseInt(strQuantidade);	
			
			this.contatoSelecionado.setId(intId);
			this.contatoSelecionado.setNome(strNome);
			this.contatoSelecionado.setQualidade(strQualidade);
			this.contatoSelecionado.setQuantidade(intQuantidade);
			
			limparCampos();
			this.modelo.fireTableDataChanged();
		}
		
	}


	protected void novo() {
		this.contatoSelecionado = null;
		
		limparCampos();
	}


	private void limparCampos() {
		super.labelAlerta.setText("");
		super.txfId.setText("");
		super.txfNome.setText("");
		super.txfQualidade.setText("");
		super.txfQuantidate.setText("");
		
		super.btnExcluir.setEnabled(false);
	}


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		try {
////			UIManager.setLookAndFeel(
////			        UIManager.getSystemLookAndFeelClassName());
//			
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		        if ("Nimbus".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
//			
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e1) {
//			e1.printStackTrace();
//		}
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipal frame = new TelaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
