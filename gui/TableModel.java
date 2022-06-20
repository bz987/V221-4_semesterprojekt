package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Line;
import model.Product;
import model.Sale;

public class TableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Line> data;
	private static final String[] NAMES = {"Produkt navn", "Mængde", "Pris"};
	
	public TableModel() {
		data = new ArrayList<>();
	}
	
	public void setData(List<Line> products) {
		this.data = products;
		super.fireTableDataChanged();
	}
	public void addData(Line product) {
		this.data.add(product);
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
			case 0: return currLine.getProductName();
			case 1: return "" + currLine.getQuantity();
			case 2: return "" + currLine.getPrice()*currLine.getQuantity();
			default: return "N/A";
		}
	}

	public Line getLine(int row) {
		return data.get(row);
	}
}
