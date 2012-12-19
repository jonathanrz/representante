package br.prax.representative.ux.fragments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
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

public class InvoiceForm extends Composite {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	
	private Text txtNewText;
	private Text txtNewText_1;
	private Text txtNewText_2;
	private Text txtNewText_3;
	private Text txtNewText_4;
	private Text text;
	private Text text_1;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public InvoiceForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		ScrolledForm scrldfrmCadastroDeClientes = formToolkit
				.createScrolledForm(this);
		formToolkit.paintBordersFor(scrldfrmCadastroDeClientes);
		scrldfrmCadastroDeClientes.setText("Pedido");
		scrldfrmCadastroDeClientes.getBody().setLayout(new ColumnLayout());

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

		Label lblNome = formToolkit.createLabel(composite, "Cliente", SWT.NONE);
		lblNome.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_1 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		txtNewText_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblInscrioEstadual = formToolkit.createLabel(composite,
				"Transportadora", SWT.NONE);
		lblInscrioEstadual.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_2 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_2.setText("");
		txtNewText_2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCnpj = formToolkit.createLabel(composite, "Cond. Pagto", SWT.NONE);
		lblCnpj.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_3 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_3.setText("");
		txtNewText_3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));
		
		Label lblNewLabel_4 = formToolkit.createLabel(composite, "Entrega", SWT.NONE);
		lblNewLabel_4.setLayoutData(new TableWrapData(TableWrapData.RIGHT, TableWrapData.TOP, 1, 1));
		
		text_1 = formToolkit.createText(composite, "New Text", SWT.NONE);
		text_1.setText("");
		text_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));

		Composite composite_1 = formToolkit
				.createCompositeSeparator(sctnIdentificao);
		formToolkit.paintBordersFor(composite_1);
		sctnIdentificao.setSeparatorControl(composite_1);

		Section sctnLocalizao = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnLocalizao);
		sctnLocalizao.setText("Produto");
		sctnLocalizao.setExpanded(true);

		Composite composite_2 = formToolkit
				.createCompositeSeparator(sctnLocalizao);
		formToolkit.paintBordersFor(composite_2);
		sctnLocalizao.setSeparatorControl(composite_2);

		Composite composite_3 = formToolkit.createComposite(sctnLocalizao,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_3);
		sctnLocalizao.setClient(composite_3);
		{
			TableWrapLayout twl_composite_3 = new TableWrapLayout();
			twl_composite_3.numColumns = 2;
			composite_3.setLayout(twl_composite_3);
		}

		Label lblNewLabel_1 = formToolkit.createLabel(composite_3, "Tipo",
				SWT.NONE);
		lblNewLabel_1.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblNewLabel_1.setBounds(0, 0, 68, 21);

		txtNewText_4 = formToolkit
				.createText(composite_3, "New Text", SWT.NONE);
		txtNewText_4.setText("Cinto");
		txtNewText_4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_2 = formToolkit.createLabel(composite_3, "Prećo",
				SWT.NONE);
		lblNewLabel_2.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		text.setText("");
		text.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_3 = formToolkit.createLabel(composite_3, "Aqui campos dinâmicos com características",
				SWT.NONE);
		TableWrapData twd_lblNewLabel_3 = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_lblNewLabel_3.align = TableWrapData.RIGHT;
		lblNewLabel_3.setLayoutData(twd_lblNewLabel_3);
		new Label(composite_3, SWT.NONE);
		
		Label lblAquiCamposCom = formToolkit.createLabel(composite_3, "Aqui campos com qtd. da grade de produtos", SWT.NONE);
		new Label(composite_3, SWT.NONE);

		getShell().pack();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
