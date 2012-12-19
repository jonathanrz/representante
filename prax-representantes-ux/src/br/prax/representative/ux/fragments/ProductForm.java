package br.prax.representative.ux.fragments;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

public class ProductForm extends Composite {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private Text txtNewText;
	private Text txtNewText_1;
	private Text text_4;
	private Text text_5;
	private Text text_1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ProductForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		ScrolledForm scrldfrmCadastroDeClientes = createFormToolkit();
		createIdentificationSection(scrldfrmCadastroDeClientes);

		createDetailsSection(scrldfrmCadastroDeClientes);

		createGradeSection(scrldfrmCadastroDeClientes);

	}

	private ScrolledForm createFormToolkit() {
		ScrolledForm scrldfrmCadastroDeClientes = formToolkit
				.createScrolledForm(this);
		formToolkit.paintBordersFor(scrldfrmCadastroDeClientes);
		scrldfrmCadastroDeClientes.setText("Cadastro de produtos");
		scrldfrmCadastroDeClientes.getBody().setLayout(new ColumnLayout());
		return scrldfrmCadastroDeClientes;
	}

	private void createGradeSection(ScrolledForm scrldfrmCadastroDeClientes) {
		Section sctnOutrasInformaes = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnOutrasInformaes);
		sctnOutrasInformaes.setText("Grade");
		sctnOutrasInformaes.setExpanded(true);

		final Composite composite_6 = formToolkit.createComposite(
				sctnOutrasInformaes, SWT.NONE);
		formToolkit.paintBordersFor(composite_6);
		sctnOutrasInformaes.setClient(composite_6);
		{
			TableWrapLayout twl_composite_6 = new TableWrapLayout();
			twl_composite_6.numColumns = 2;
			composite_6.setLayout(twl_composite_6);
		}

		new Label(composite_6, SWT.NONE);

		Button btnAdicionarDimenso = formToolkit.createButton(composite_6,
				"Adicionar dimensão", SWT.NONE);
		btnAdicionarDimenso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addFieldTo(composite_6, "Por favor informe o nome da nova característica.");
				getShell().layout(true, true);
			}
		});
		TableWrapData twd_btnAdicionarDimenso = new TableWrapData(
				TableWrapData.LEFT, TableWrapData.TOP, 1, 1);
		twd_btnAdicionarDimenso.align = TableWrapData.RIGHT;
		btnAdicionarDimenso.setLayoutData(twd_btnAdicionarDimenso);

		Composite composite_7 = formToolkit
				.createCompositeSeparator(sctnOutrasInformaes);
		formToolkit.paintBordersFor(composite_7);
		sctnOutrasInformaes.setSeparatorControl(composite_7);
	}

	private void createDetailsSection(ScrolledForm scrldfrmCadastroDeClientes) {
		Section sctnCaractersticas = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnCaractersticas);
		sctnCaractersticas.setText("Características");
		sctnCaractersticas.setExpanded(true);

		Composite composite_2 = formToolkit
				.createCompositeSeparator(sctnCaractersticas);
		formToolkit.paintBordersFor(composite_2);
		sctnCaractersticas.setSeparatorControl(composite_2);

		final Composite composite_3 = formToolkit.createComposite(
				sctnCaractersticas, SWT.NONE);
		formToolkit.paintBordersFor(composite_3);
		sctnCaractersticas.setClient(composite_3);
		{
			TableWrapLayout twl_composite_3 = new TableWrapLayout();
			twl_composite_3.numColumns = 2;
			composite_3.setLayout(twl_composite_3);
		}
		
		formToolkit.createLabel(composite_3, "", SWT.NONE);

		Button btnAdicionarCaracterstica = formToolkit.createButton(
				composite_3, "Adicionar característica", SWT.NONE);
		btnAdicionarCaracterstica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addFieldTo(composite_3, "Por favor informe o nome da nova característica.");
				getShell().layout(true, true);
			}

			
		});

		TableWrapData twd_btnAdicionarCaracterstica = new TableWrapData(
				TableWrapData.LEFT, TableWrapData.TOP, 1, 1);
		twd_btnAdicionarCaracterstica.align = TableWrapData.RIGHT;
		btnAdicionarCaracterstica.setLayoutData(twd_btnAdicionarCaracterstica);
	}
	
	private void addFieldTo(Composite parentForm, String message) {
		InputDialog inDialog = new InputDialog(getShell(),
				message,
				"Informe o nome do campo a seguir", "Nome do campo aqui",
				null);
		
		inDialog.setBlockOnOpen(true);
		inDialog.open();
		
		String fieldName = inDialog.getValue();

		Label l = formToolkit.createLabel(parentForm, fieldName,
				SWT.NONE);
		l.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Text t = formToolkit.createText(parentForm, "", SWT.NONE);
		t.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));
	}

	private void createIdentificationSection(
			ScrolledForm scrldfrmCadastroDeClientes) {
		Section sctnIdentificao = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		ColumnLayoutData cld_sctnIdentificao = new ColumnLayoutData();
		cld_sctnIdentificao.heightHint = 345;
		sctnIdentificao.setLayoutData(cld_sctnIdentificao);
		formToolkit.paintBordersFor(sctnIdentificao);
		sctnIdentificao.setText("Identificaćão");
		sctnIdentificao.setExpanded(true);

		Composite composite = formToolkit.createComposite(sctnIdentificao,
				SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnIdentificao.setClient(composite);
		{
			TableWrapLayout twl_composite = new TableWrapLayout();
			twl_composite.numColumns = 2;
			composite.setLayout(twl_composite);
		}

		Label lblNewLabel = formToolkit.createLabel(composite, "Código",
				SWT.NONE);
		lblNewLabel.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblNewLabel.setBounds(0, 0, 68, 21);

		txtNewText = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText.setText("");
		txtNewText.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNome = formToolkit.createLabel(composite, "Nome", SWT.NONE);
		lblNome.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_1 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		txtNewText_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCategoria = formToolkit.createLabel(composite, "Categoria",
				SWT.NONE);
		lblCategoria.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text_1 = formToolkit.createText(composite, "New Text", SWT.NONE);
		text_1.setText("");
		text_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Composite composite_1 = formToolkit
				.createCompositeSeparator(sctnIdentificao);
		formToolkit.paintBordersFor(composite_1);
		sctnIdentificao.setSeparatorControl(composite_1);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
