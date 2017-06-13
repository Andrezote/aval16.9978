package univel.br.prova;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel{
	
	private List<Produto> lista;
	
	
	public ProdutoModel(List<Produto> list) {
		this.lista = list;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "NOME";
		case 2:
			return "QUALIDADE";
		case 3:
			return "QUANTIDADE";
		}
		return super.getColumnName(column);
	}
	@Override
	public Object getValueAt(int row, int column) {
		Produto p = lista.get(row);
		switch (column) {
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		case 2:
			return p.getQualidade();
		case 3:
			return p.getQuantidade();
		}
		
		return new Exception("Coluna nao declarada");
	}

	public Produto getContato(int idx) {
		return lista.get(idx);
	}

	public void remover(Produto contatoSelecionado) {
		this.lista.remove(contatoSelecionado);
		this.fireTableDataChanged();
	}

	public void adicionar(Produto c) {
		this.lista.add(c);
		this.fireTableDataChanged();
	}

}
