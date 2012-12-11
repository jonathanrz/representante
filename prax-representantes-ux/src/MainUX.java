import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import swing2swt.layout.BorderLayout;


public class MainUX extends ApplicationWindow {

	/**
	 * Create the application window.
	 */
	public MainUX() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new BorderLayout(0, 0));
		{
			ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
			scrolledComposite.setLayoutData(BorderLayout.CENTER);
			scrolledComposite.setExpandHorizontal(true);
			scrolledComposite.setExpandVertical(true);
			
			Composite composite = new Composite(scrolledComposite, SWT.NONE);
			composite.setLayout(new StackLayout());
			scrolledComposite.setContent(composite);
			scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			
			Composite composite_1 = new Composite(container, SWT.NONE);
			composite_1.setLayoutData(BorderLayout.WEST);
			RowLayout rl_composite_1 = new RowLayout(SWT.VERTICAL);
			rl_composite_1.fill = true;
			rl_composite_1.marginBottom = 0;
			rl_composite_1.marginLeft = 0;
			rl_composite_1.marginRight = 0;
			rl_composite_1.marginTop = 0;
			rl_composite_1.spacing = 0;
			composite_1.setLayout(rl_composite_1);
			
			
			Button btnNewButton = new Button(composite_1, SWT.TOGGLE);
			btnNewButton.setToolTipText("Test");
			btnNewButton.setText("New Button");
			
			Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
			btnNewButton_1.setText("New Button");
			
			Button btnNewButton_2 = new Button(composite_1, SWT.NONE);
			btnNewButton_2.setText("New Button");
			
			Button btnNewButton_3 = new Button(composite_1, SWT.NONE);
			btnNewButton_3.setText("New Button");
			
			Button btnNewButton_4 = new Button(composite_1, SWT.NONE);
			btnNewButton_4.setText("New Button");
			
			Button btnNewButton_5 = new Button(composite_1, SWT.NONE);
			btnNewButton_5.setText("New Button");
			
			Button btnNewButton_6 = new Button(composite_1, SWT.NONE);
			btnNewButton_6.setText("New Button");
			
			Button btnNewButton_7 = new Button(composite_1, SWT.NONE);
			btnNewButton_7.setText("New Button");
			
			Button btnNewButton_8 = new Button(composite_1, SWT.NONE);
			btnNewButton_8.setText("New Button");
			
			Button btnNewButton_9 = new Button(composite_1, SWT.NONE);
			btnNewButton_9.setText("New Button");
			
			Button btnNewButton_10 = new Button(composite_1, SWT.NONE);
			btnNewButton_10.setText("New Button");
			
			Button btnNewButton_11 = new Button(composite_1, SWT.NONE);
			btnNewButton_11.setText("New Button");
		}

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
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			MainUX window = new MainUX();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
