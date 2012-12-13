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
import org.eclipse.swt.custom.StyledText;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Link;

public class SettingsForm extends Composite {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	
	private Text txtNewText;
	private Text txtNewText_4;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Text text_4;
	private Text txtNewText_1;
	private Text txtNewText_2;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SettingsForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		ScrolledForm scrldfrmCadastroDeClientes = formToolkit
				.createScrolledForm(this);
		formToolkit.paintBordersFor(scrldfrmCadastroDeClientes);
		scrldfrmCadastroDeClientes.setText("Cadastro de clientes");
		scrldfrmCadastroDeClientes.getBody().setLayout(new ColumnLayout());
		
				Section sctnUserInfo = formToolkit.createSection(
						scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
								| Section.TITLE_BAR);
				formToolkit.paintBordersFor(sctnUserInfo);
				sctnUserInfo.setText("Dados do usuário");
				sctnUserInfo.setExpanded(true);
				
						Composite composite_6 = formToolkit.createComposite(
								sctnUserInfo, SWT.NONE);
						formToolkit.paintBordersFor(composite_6);
						sctnUserInfo.setClient(composite_6);
						{
							TableWrapLayout twl_composite_6 = new TableWrapLayout();
							twl_composite_6.numColumns = 2;
							composite_6.setLayout(twl_composite_6);
						}
						
								Label lblCobrana = formToolkit.createLabel(composite_6, "Nome",
										SWT.NONE);
								lblCobrana.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
										TableWrapData.TOP, 1, 1));
								lblCobrana.setBounds(0, 0, 68, 21);
								
										text_3 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
										text_3.setText("");
										text_3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
												TableWrapData.TOP, 1, 1));
										
												Label lblEmailPedido = formToolkit.createLabel(composite_6,
														"E-mail", SWT.NONE);
												lblEmailPedido.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
														TableWrapData.TOP, 1, 1));
												
														text_4 = formToolkit.createText(composite_6, "New Text", SWT.NONE);
														text_4.setText("");
														text_4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
																TableWrapData.TOP, 1, 1));
														
														Composite composite_7 = formToolkit.createCompositeSeparator(sctnUserInfo);
														formToolkit.paintBordersFor(composite_7);
														sctnUserInfo.setSeparatorControl(composite_7);
		
				Section sctnContato = formToolkit.createSection(
						scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
								| Section.TITLE_BAR);
				formToolkit.paintBordersFor(sctnContato);
				sctnContato.setText("E-mail");
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
								
										Label lblTelefone = formToolkit.createLabel(composite_5, "Assunto",
												SWT.NONE);
										lblTelefone.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
												TableWrapData.TOP, 1, 1));
										lblTelefone.setBounds(0, 0, 68, 21);
										
												text_1 = formToolkit.createText(composite_5, "New Text", SWT.NONE);
												text_1.setText("");
												text_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
														TableWrapData.TOP, 1, 1));
												
														Label lblCelular = formToolkit.createLabel(composite_5, "Corpo",
																SWT.NONE);
														lblCelular.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
																TableWrapData.TOP, 1, 1));
														new Label(composite_5, SWT.NONE);

		Section sctnSysInfo = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		ColumnLayoutData cld_sctnSysInfo = new ColumnLayoutData();
		cld_sctnSysInfo.heightHint = 345;
		sctnSysInfo.setLayoutData(cld_sctnSysInfo);
		formToolkit.paintBordersFor(sctnSysInfo);
		sctnSysInfo.setText("Parâmetros para o sistema");
		sctnSysInfo.setExpanded(true);

		Composite composite = formToolkit.createComposite(sctnSysInfo,
				SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnSysInfo.setClient(composite);
		{
			TableWrapLayout twl_composite = new TableWrapLayout();
			twl_composite.numColumns = 2;
			composite.setLayout(twl_composite);
		}

		Label lblNewLabel = formToolkit.createLabel(composite, "Diretório de PDFs",
				SWT.NONE);
		lblNewLabel.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblNewLabel.setBounds(0, 0, 68, 21);

		txtNewText = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText.setText("");
		txtNewText.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Composite composite_1 = formToolkit
				.createCompositeSeparator(sctnSysInfo);
		formToolkit.paintBordersFor(composite_1);
		sctnSysInfo.setSeparatorControl(composite_1);

		Section sctnSellParams = formToolkit.createSection(
				scrldfrmCadastroDeClientes.getBody(), Section.TWISTIE
						| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnSellParams);
		sctnSellParams.setText("Parâmetros de venda");
		sctnSellParams.setExpanded(true);

		Composite composite_2 = formToolkit
				.createCompositeSeparator(sctnSellParams);
		formToolkit.paintBordersFor(composite_2);
		sctnSellParams.setSeparatorControl(composite_2);

		Composite composite_3 = formToolkit.createComposite(sctnSellParams,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_3);
		sctnSellParams.setClient(composite_3);
		{
			TableWrapLayout twl_composite_3 = new TableWrapLayout();
			twl_composite_3.numColumns = 2;
			composite_3.setLayout(twl_composite_3);
		}

		Label lblNewLabel_1 = formToolkit.createLabel(composite_3, "Condićões de pagamento",
				SWT.NONE);
		lblNewLabel_1.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));
		lblNewLabel_1.setBounds(0, 0, 68, 21);

		txtNewText_4 = formToolkit
				.createText(composite_3, "New Text", SWT.NONE);
		txtNewText_4.setText("");
		txtNewText_4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_2 = formToolkit.createLabel(composite_3, "Entrega padrão",
				SWT.NONE);
		lblNewLabel_2.setLayoutData(new TableWrapData(TableWrapData.RIGHT,
				TableWrapData.TOP, 1, 1));

		text = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		text.setText("");
		text.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,
				TableWrapData.TOP, 1, 1));

		Label lblNewLabel_3 = formToolkit.createLabel(composite_3, "Adicional tamanho especial",
				SWT.NONE);
		TableWrapData twd_lblNewLabel_3 = new TableWrapData(TableWrapData.LEFT,
				TableWrapData.TOP, 1, 1);
		twd_lblNewLabel_3.align = TableWrapData.RIGHT;
		lblNewLabel_3.setLayoutData(twd_lblNewLabel_3);
		
		txtNewText_1 = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		txtNewText_1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		
		Label lblValorFreteCif = formToolkit.createLabel(composite_3, "Valor frete CIF", SWT.NONE);
		TableWrapData twd_lblValorFreteCif = new TableWrapData(TableWrapData.LEFT, TableWrapData.TOP, 1, 1);
		twd_lblValorFreteCif.align = TableWrapData.RIGHT;
		lblValorFreteCif.setLayoutData(twd_lblValorFreteCif);
		
		txtNewText_2 = formToolkit.createText(composite_3, "New Text", SWT.NONE);
		txtNewText_2.setText("");
		txtNewText_2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
