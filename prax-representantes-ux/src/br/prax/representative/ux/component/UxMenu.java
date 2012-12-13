package br.prax.representative.ux.component;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import swing2swt.layout.BorderLayout;

public class UxMenu extends Composite {

	private CTabFolder tabFolder;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param orientation
	 * @see BorderLayout.WEST (so on and so forth)
	 */
	public UxMenu(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setLayoutData(BorderLayout.CENTER);
		tabFolder.setBorderVisible(false);
		tabFolder.setSimple(false);
		tabFolder.setUnselectedCloseVisible(false);
	}
	
	public void addItem(final UxMenuItem item) {
		CTabItem ti = new CTabItem(tabFolder, SWT.NONE);
		ti.setText(item.text);
		ti.setImage(item.itemImage);
		
		if (item.controlBuilder != null) {
			Control c = item.controlBuilder.build(tabFolder);
			ti.setControl(c);
		}
		
		//TODO: not working
		ti.addListener(SWT.MouseUp, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				if (item.action != null) {
					item.action.run();
				}
			}
		});
		
		tabFolder.layout();
	}

	@Override
	protected void checkSubclass() {
		// window builder stuff
		// Disable the check that prevents subclassing of SWT components
	}
}
