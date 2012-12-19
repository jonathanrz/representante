package br.prax.representative.ux.fragments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ActionPaneFragment extends Composite {

	public ActionPaneFragment(Composite container) {
		super(container, SWT.NONE);
		configureLayout();
	}
	
	private void configureLayout() {
		setLayout(new RowLayout());
	}

	public void addAction(String text, Image icon, final Runnable action) {
		if (action == null) throw new RuntimeException("action shouldn't be null");
		
		Button bt = new Button(this, SWT.PUSH);
		bt.setText(text);
		bt.setImage(icon);
		bt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				action.run();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
			
		});
	}

}
