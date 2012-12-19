package br.prax.representative.ux.fragments;

import javax.print.attribute.standard.Severity;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import br.prax.representative.model.ValidationMessage;
import br.prax.representative.utils.IconUtils;

public class MessagesFragment extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MessagesFragment(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		TableViewer tableViewer = new TableViewer(this, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnSeverityImage = tableViewerColumn_1.getColumn();
		tblclmnSeverityImage.setAlignment(SWT.CENTER);
		tblclmnSeverityImage.setWidth(31);

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnDescrio = tableViewerColumn_2.getColumn();
		tblclmnDescrio.setWidth(100);
		tblclmnDescrio.setText("Descrićão");

	}

	public void addMessage(ValidationMessage message) {
		addMessage(message.getSeverity(), message.getMessage());
	}

	public void addMessage(Severity s, String message) {
		Image img = IconUtils.getSmallIcon(s.getName(), getDisplay()
				.getSystemImage(getSystemImageCode(s)));
		TableItem it = new TableItem(table, SWT.NONE);
		it.setImage(0, img);
		it.setText(1, message);

		for (TableColumn c : table.getColumns()) {
			c.pack();
		}
		getShell().layout(true, true);
	}

	private int getSystemImageCode(Severity s) {
		if (s == Severity.REPORT)
			return SWT.ICON_INFORMATION;
		if (s == Severity.WARNING)
			return SWT.ICON_WARNING;
		if (s == Severity.ERROR)
			return SWT.ICON_ERROR;
		return SWT.NONE;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
