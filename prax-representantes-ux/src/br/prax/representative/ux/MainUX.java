package br.prax.representative.ux;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import swing2swt.layout.BorderLayout;
import br.prax.representative.utils.IconUtils;
import br.prax.representative.ux.component.IUxControlBuilder;
import br.prax.representative.ux.component.UxMenu;
import br.prax.representative.ux.component.UxMenuItem;
import br.prax.representative.ux.fragments.ArtifactForm;
import br.prax.representative.ux.fragments.CustomerForm;
import br.prax.representative.ux.fragments.InvoiceForm;
import br.prax.representative.ux.fragments.SettingsForm;

public class MainUX extends ApplicationWindow {

	/**
	 * Create the application window.
	 */
	public MainUX() {
		super(null);
		createActions();
		// addToolBar(SWT.FLAT | SWT.WRAP);
		// addMenuBar();
		// addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new BorderLayout(0, 0));

		final UxMenu pane = new UxMenu(container, SWT.NONE);
		pane.setLayoutData(BorderLayout.CENTER);

		UxMenuItem item = new UxMenuItem();
		item.text = "Configuraćões";
		item.itemImage = IconUtils.getMediumIcon("settings.png");
		item.controlBuilder = new IUxControlBuilder() {
			@Override
			public Control build(Composite parent) {
				return new SettingsForm(parent, SWT.NONE);
			}
		};
		pane.addItem(item);

		item.text = "Cadastro de clientes";
		item.itemImage = IconUtils.getMediumIcon("add-customer.png");
		item.controlBuilder = new IUxControlBuilder() {
			@Override
			public Control build(Composite parent) {
				return new CustomerForm(parent, SWT.NONE);
			}
		};
		pane.addItem(item);

		item.text = "Cadastro de produtos";
		item.itemImage = IconUtils.getMediumIcon("product.png");
		item.controlBuilder = new IUxControlBuilder() {
			@Override
			public Control build(Composite parent) {
				return new ArtifactForm(parent, SWT.NONE);
			}
		};
		pane.addItem(item);

		item.text = "Pedido";
		item.itemImage = IconUtils.getMediumIcon("cart.png");
		item.controlBuilder = new IUxControlBuilder() {
			@Override
			public Control build(Composite parent) {
				return new InvoiceForm(parent, SWT.NONE);
			}
		};
		pane.addItem(item);

		item.text = "";
		item.itemImage = IconUtils.getSmallIcon("plus.png");
		item.controlBuilder = null;
		pane.addItem(item);

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(958, 297);
	}
}
