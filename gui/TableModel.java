package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Sale;

public class LineTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Sale> data;
	private static final String[] NAMES = {"Name", "Quantity"};
	
	public LineTableModel() {
		data = new ArrayList<>();
	}
	
	public void setData(List<Sale> sale) {
		this.data = lines;
		super.fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int col) {
		return NAMES[col];
	}
	
	@Override
	public int getRowCount() { 
		return data.size();
	}
 	
	@Override
	public int getColumnCount() {
		return NAMES.length;
	}
	
	public String getValueAt(int row, int col) {
		Line currLine = data.get(row);
		switch(col) {
			case 0: return currLine.getName();
			case 1: return "" + currLine.getQuantity();
			default: return "FOO-BAR";
		}
	}

	public Line getLine(int row) {
		return data.get(row);
	}
}
