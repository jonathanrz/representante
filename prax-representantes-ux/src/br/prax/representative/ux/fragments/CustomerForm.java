package br.prax.representative.ux.fragments;

import java.util.List;

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

import br.prax.representative.model.CustomerModel;
import br.prax.representative.model.ValidationMessage;
import br.prax.representative.ux.IResponseEvent;
import br.prax.representative.ux.Question;

public class CustomerForm extends Composite implements IFormFragment {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private Text txtCode;
	private Text txtName;
	private Text txtStateRegistry;
	private Text txtCNPJ;
	private Text txtCEP;
	private Text txtAddress;
	private Text txtPhone;
	private Text txtCel;
	private Text txtEmail;
	private Text txtCharge;
	private Text txtInvoiceEmail;
	private Text txtNameReport;
	private Text txtBuyer;
	
	private Text[] fields = new Text[] {txtCode, txtName, txtStateRegistry, txtCNPJ, txtCEP, txtAddress, txtPhone, txtCel, txtEmail, txtCharge, txtInvoiceEmail, txtNameReport, txtBuyer};

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public CustomerForm(Composite parent, int style) {
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

		txtCode = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtCode.setText("");
		txtCode.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNome = formToolkit.createLabel(composite, "Nome", SWT.NONE);
		lblNome.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtName = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtName.setText("");
		txtName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblInscrioEstadual = formToolkit.createLabel(composite,
				"Inscrićão estadual", SWT.NONE);
		lblInscrioEstadual.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtStateRegistry = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtStateRegistry.setText("");
		txtStateRegistry.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCnpj = formToolkit.createLabel(composite, "CNPJ", SWT.NONE);
		lblCnpj.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtCNPJ = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtCNPJ.setText("");
		txtCNPJ.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
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

		txtCEP = formToolkit
				.createText(composite_3, "New Text", SWT.NONE);
		txtCEP.setText("");
		txtCEP.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_2 = formToolkit.createLabel(composite_3, "Enderećo",
				SWT.NONE);
		lblNewLabel_2.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtAddress = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		txtAddress.setText("");
		txtAddress.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_3 = formToolkit.createLabel(composite_3, "UF",
				SWT.NONE);
		TableWrapData twd_lblNewLabel_3 = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_lblNewLabel_3.align = TableWrapData.RIGHT;
		lblNewLabel_3.setLayoutData(twd_lblNewLabel_3);

		CCombo cbUF = new CCombo(composite_3, SWT.BORDER);
		TableWrapData twd_cbUF = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_cbUF.align = TableWrapData.FILL;
		cbUF.setLayoutData(twd_cbUF);
		formToolkit.adapt(cbUF);
		formToolkit.paintBordersFor(cbUF);

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

		txtPhone = formToolkit.createText(composite_5, "New Text", SWT.NONE);
		txtPhone.setText("");
		txtPhone.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblCelular = formToolkit.createLabel(composite_5, "Celular",
				SWT.NONE);
		lblCelular.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtCel = formToolkit
				.createText(composite_5, "New Text", SWT.NONE);
		txtCel.setText("");
		txtCel.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblEmail = formToolkit.createLabel(composite_5, "E-Mail",
				SWT.NONE);
		lblEmail.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtEmail = formToolkit.createText(composite_5, "New Text", SWT.NONE);
		txtEmail.setText("");
		txtEmail.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
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

		txtCharge = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		txtCharge.setText("");
		txtCharge.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblEmailPedido = formToolkit.createLabel(composite_6,
				"E-mail pedido:", SWT.NONE);
		lblEmailPedido.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtInvoiceEmail = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		txtInvoiceEmail.setText("");
		txtInvoiceEmail.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNameReport = formToolkit.createLabel(composite_6,
				"Nome p/ relatório", SWT.NONE);
		lblNameReport.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtNameReport = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		txtNameReport.setText("");
		txtNameReport.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblComprador = formToolkit.createLabel(composite_6, "Comprador",
				SWT.NONE);
		lblComprador.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		txtBuyer = formToolkit.createText(composite_6, "New Text", SWT.NONE);
		txtBuyer.setText("");
		txtBuyer.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Composite composite_7 = formToolkit
				.createCompositeSeparator(sctnOutrasInformaes);
		formToolkit.paintBordersFor(composite_7);
		sctnOutrasInformaes.setSeparatorControl(composite_7);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public boolean supportsSave() {
		return true;
	}

	@Override
	public boolean supportsNew() {
		return true;
	}

	@Override
	public boolean supportsCancel() {
		return true;
	}

	@Override
	public List<ValidationMessage> onSave() {
		
		CustomerModel customer = new CustomerModel();
		
		customer.setCnpj(UIUtils.getInt(txtCNPJ.getText()));
		customer.setName(txtName.getText());
		customer.setAddress(txtAddress.getText());
		customer.setCep(UIUtils.getInt(txtCEP.getText()));
		customer.setEmail(txtEmail.getText());
		customer.setPinnedPhone(UIUtils.getInt(txtPhone.getText()));
		customer.setStateRegistry(UIUtils.getInt(txtStateRegistry.getText()));
		
		List<ValidationMessage> msgs = customer.validate();
		
		if (msgs.isEmpty()) {
			_persist(customer);
		}
		
		return msgs;
	}

	private void _persist(CustomerModel customer) {
		//TODO: fazer
	}

	@Override
	public Question onCancel() {
		if (isModified()) {
			return new Question("Há alterações no cadastro deste cliente, gostaria de cancelar?", new IResponseEvent() {
				@Override
				public void onResponse(QuestionOption option) {
					if (option == QuestionOption.YES) {
						//TODO: Rollback fields
					}
				}
			});
		}
		return Question.NULL;
	}

	private boolean isModified() {
		for (Text t : fields) {
			if (!"".equals(t.getText())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Question onNew() {
		if (isModified()) {
			return new Question("Há alterações no cadastro deste cliente, gostaria de cancelar?", new IResponseEvent() {
				@Override
				public void onResponse(QuestionOption option) {
					if (option == QuestionOption.YES) {
						//TODO: Blank fields for a new one
					}
				}
			});
		}
		return Question.NULL;
	}

}
