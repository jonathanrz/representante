package br.prax.representative.ux.fragments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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
	private Text txtNewText_5;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	
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
		scrldfrmCadastroDeClientes.setText("Cadastro de clientes");
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

		Label lblNome = formToolkit.createLabel(composite, "Nome", SWT.NONE);
		lblNome.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_1 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		txtNewText_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblInscrioEstadual = formToolkit.createLabel(composite,
				"Inscrićão estadual", SWT.NONE);
		lblInscrioEstadual.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_2 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_2.setText("");
		txtNewText_2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCnpj = formToolkit.createLabel(composite, "CNPJ", SWT.NONE);
		lblCnpj.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_3 = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_3.setText("");
		txtNewText_3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Composite composite_1 = formToolkit
				.createCompositeSeparator(sctnIdentificao);
		formToolkit.paintBordersFor(composite_1);
		sctnIdentificao.setSeparatorControl(composite_1);

		Section sctnLocalizao = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnLocalizao);
		sctnLocalizao.setText("Localizaćão");
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

		Label lblNewLabel_1 = formToolkit.createLabel(composite_3, "CEP",
				SWT.NONE);
		lblNewLabel_1.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblNewLabel_1.setBounds(0, 0, 68, 21);

		txtNewText_4 = formToolkit
				.createText(composite_3, "New Text", SWT.NONE);
		txtNewText_4.setText("");
		txtNewText_4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_2 = formToolkit.createLabel(composite_3, "Enderećo",
				SWT.NONE);
		lblNewLabel_2.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		text.setText("");
		text.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_3 = formToolkit.createLabel(composite_3, "UF",
				SWT.NONE);
		TableWrapData twd_lblNewLabel_3 = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_lblNewLabel_3.align = TableWrapData.RIGHT;
		lblNewLabel_3.setLayoutData(twd_lblNewLabel_3);

		CCombo combo = new CCombo(composite_3, SWT.BORDER);
		TableWrapData twd_combo = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_combo.align = TableWrapData.FILL;
		combo.setLayoutData(twd_combo);
		formToolkit.adapt(combo);
		formToolkit.paintBordersFor(combo);

		Section sctnContato = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnContato);
		sctnContato.setText("Contato");
		sctnContato.setExpanded(true);

		Composite composite_4 = formToolkit
				.createCompositeSeparator(sctnContato);
		formToolkit.paintBordersFor(composite_4);
		sctnContato.setSeparatorControl(composite_4);

		Composite composite_5 = formToolkit.createComposite(sctnContato,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_5);
		sctnContato.setClient(composite_5);
		{
			TableWrapLayout twl_composite_5 = new TableWrapLayout();
			twl_composite_5.numColumns = 2;
			composite_5.setLayout(twl_composite_5);
		}

		Label lblTelefone = formToolkit.createLabel(composite_5, "Telefone",
				SWT.NONE);
		lblTelefone.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblTelefone.setBounds(0, 0, 68, 21);

		text_1 = formToolkit.createText(composite_5, "New Text", SWT.NONE);
		text_1.setText("");
		text_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCelular = formToolkit.createLabel(composite_5, "Celular",
				SWT.NONE);
		lblCelular.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNewText_5 = formToolkit
				.createText(composite_5, "New Text", SWT.NONE);
		txtNewText_5.setText("");
		txtNewText_5.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblEmail = formToolkit.createLabel(composite_5, "E-Mail",
				SWT.NONE);
		lblEmail.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text_2 = formToolkit.createText(composite_5, "New Text", SWT.NONE);
		text_2.setText("");
		text_2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Section sctnOutrasInformaes = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnOutrasInformaes);
		sctnOutrasInformaes.setText("Outras informaćões");
		sctnOutrasInformaes.setExpanded(true);

		Composite composite_6 = formToolkit.createComposite(
				sctnOutrasInformaes, SWT.NONE);
		formToolkit.paintBordersFor(composite_6);
		sctnOutrasInformaes.setClient(composite_6);
		{
			TableWrapLayout twl_composite_6 = new TableWrapLayout();
			twl_composite_6.numColumns = 2;
			composite_6.setLayout(twl_composite_6);
		}

		Label lblCobrana = formToolkit.createLabel(composite_6, "Cobranća",
				SWT.NONE);
		lblCobrana.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblCobrana.setBounds(0, 0, 68, 21);

		text_3 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		text_3.setText("");
		text_3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblEmailPedido = formToolkit.createLabel(composite_6,
				"E-mail pedido:", SWT.NONE);
		lblEmailPedido.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text_4 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		text_4.setText("");
		text_4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNomePrelatrio = formToolkit.createLabel(composite_6,
				"Nome p/ relatório", SWT.NONE);
		lblNomePrelatrio.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text_5 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		text_5.setText("");
		text_5.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));
		
		Label lblComprador = formToolkit.createLabel(composite_6, "Comprador", SWT.NONE);
		lblComprador.setLayoutData(new TableWrapData(TableWrapData.RIGHT, TableWrapData.TOP, 1, 1));
		
		text_6 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		text_6.setText("");
		text_6.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		
		Composite composite_7 = formToolkit.createCompositeSeparator(sctnOutrasInformaes);
		formToolkit.paintBordersFor(composite_7);
		sctnOutrasInformaes.setSeparatorControl(composite_7);

		getShell().pack();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
