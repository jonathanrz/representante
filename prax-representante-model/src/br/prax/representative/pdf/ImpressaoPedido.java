package br.prax.representative.pdf;

import java.io.IOException;
import java.net.MalformedURLException;

import br.prax.representative.model.BillDetails;
import br.prax.representative.model.Customer;
import br.prax.representative.model.Invoice;
import br.prax.representative.model.InvoiceItem;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font.FontFamily;

public class ImpressaoPedido {
	public static final String PDF_PATH = "c:/temp/rep.pdf";
	private PdfGenerator pdf;
	private float mY = 0;
	private float leftMargin = 0;
	private float rightMargin = 0;
	private float rectHeight = 0;
	private boolean paisagem = true;
	private Invoice invoice;
	private int totalPecas = 0;
	private int valorTotal = 0;
	
	public static void main(String[] args) throws IOException, DocumentException {
		ImpressaoPedido imp = new ImpressaoPedido();
		Invoice invoice = new Invoice();
		invoice.Fill();
		imp.setInvoice(invoice);
		imp.Generate();
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public void Generate() throws DocumentException, MalformedURLException, IOException{
		pdf = new PdfGenerator();
		paisagem = false;
		pdf.init(PDF_PATH, paisagem);
		
		Init();
		
		pdf.getCanvas().saveState();
		
		imprimeCabecalhoRepresentada();
		imprimeTabelaCliente();
		float y = mY;
		imprimeTabelaItens(leftMargin, true);
		if(paisagem)
		{
			mY = y;		
			imprimeTabelaItens(getInitSegundaTabelaItens(), false);
		}
		imprimeDadosFinais();
		
		pdf.getCanvas().restoreState();
		
		pdf.finish();
	}
	
	public void Init(){
		mY = getHeight() * 0.93f;
		leftMargin = getLeftMargin();
		rightMargin = getRightMargin();
		rectHeight = getRectHeight();
		
		pdf.setParagraphAndLineHeight(getParagraphInit(), getLineHeight());
		pdf.getCanvas().setLineWidth(0.01f);
	}

	private float getRectHeight(){
		if(paisagem)
			return getHeight() * 0.025f;
		else
			return getHeight() * 0.017f;
	}
	
	private float getParagraphInit(){
		if(paisagem)
			return getHeight() * 0.004f;
		else
			return getHeight() * 0.003f;
	}
	
	private float getLineHeight(){
		if(paisagem)
			return getHeight() * 0.005f;
		else
			return getHeight() * 0.0035f;
	}
	
	private float getLeftMargin(){
		return getWidth() * 0.02f;
	}
	
	private float getRightMargin(){
		return getWidth() * 0.98f;
	}
	
	private float getWidthTabelaItens(){
		if(paisagem)
			return getWidth() * 0.475f;
		else
			return getWidth() * 0.96f;
	}
	
	private float getInitSegundaTabelaItens(){
		return getWidth() * 0.505f;
	}
	
	private float getQtdColunasTabelaItens(){
		return 7;
	}
	
	private float getWidthCellTabelaItens(){
		return getWidthTabelaItens() / getQtdColunasTabelaItens();
	}
	
	private float getHeight(){
		return pdf.getRectangle().getHeight();
	}
	
	private float getWidth(){
		return pdf.getRectangle().getWidth();
	}
	
	private void drawVerticalLine(float x, float y){
		pdf.drawVerticalLine(x, y, y - rectHeight);
	}
	
	public void imprimeCabecalhoRepresentada() throws MalformedURLException, IOException, DocumentException{
		pdf.addImage("logos/decelo.jpg", getWidth() * 0.02f, getHeight() * 0.92f);

		pdf.setFont(FontFamily.HELVETICA, paisagem ? 30f : 26f, false, true);
		
		float x = getWidth() / 2;

		pdf.showTextCentralized("MALHAS DE' CELO", x, mY);
		
		pdf.setFont(FontFamily.HELVETICA, paisagem ? 20f : 16f, false, true);
		pdf.showTextRightAlign("PEDIDO", rightMargin, mY);
		mY -= rectHeight;

		pdf.setFont(FontFamily.HELVETICA, paisagem ? 12f : 10f, false, false);
		if(paisagem)
		{
			pdf.showTextCentralized("Av. Presidente Wenceslau Braz, 2614 - Guaíra - Fone/Fax: (41)3248-1793 / 3248-4764", x, mY);
			mY -= rectHeight;
		}
		else
		{
			pdf.showTextCentralized("Av. Presidente Wenceslau Braz, 2614", x, mY);
			mY -= rectHeight;
			
			pdf.showTextCentralized("Guaíra - Fone/Fax: (41)3248-1793 / 3248-4764", x, mY);
			mY -= rectHeight;
		}
		
		pdf.showTextCentralized("81010-00 - Curitiba - Paraná - e-mail: decelo@decelo.com.br", x, mY);
		mY -= rectHeight;
		
		pdf.showTextCentralized("www.decelo.com.br", x, mY);
		mY -= rectHeight;
	}
	
	public void imprimeTabelaCliente(){
		pdf.setFont(FontFamily.HELVETICA, 11f, false, false);
		
		//Nome e CNPJ
		pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float cnpjInit = leftMargin + (getWidth() * 0.65f);
        drawVerticalLine(cnpjInit, mY);
		mY -= rectHeight;
		
		Customer customer = invoice.getCustomer();

        pdf.showText("Nome: " + customer.getCorporateName(), leftMargin, mY);
        pdf.showText("CNPJ: " + customer.getCnpj(), cnpjInit, mY);
        
        //End e Insc Estadual
        pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float inscEstInit = leftMargin + (getWidth() * 0.65f);
        drawVerticalLine(inscEstInit, mY);
        mY -= rectHeight;

        pdf.showText("Endereço: " + customer.getAddress().getRua(), leftMargin, mY);
        pdf.showText("Insc. Est.: " + customer.getStateInscription(), inscEstInit, mY);
        
        //Bairro, cidade, estado e CEP
        pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float cidadeInit = leftMargin + (getWidth() * 0.30f);
        float estadoInit = leftMargin + (getWidth() * 0.65f);
        float CEPInit = leftMargin + (getWidth() * 0.80f);
        drawVerticalLine(cidadeInit, mY);
        drawVerticalLine(estadoInit, mY);
        drawVerticalLine(CEPInit, mY);
        mY -= rectHeight;

        pdf.showText("Bairro: " + customer.getAddress().getBairro(), leftMargin, mY);
        pdf.showText("Cidade: " + customer.getAddress().getCidade(), cidadeInit, mY);
        pdf.showText("Estado: " + customer.getAddress().getEstado(), estadoInit, mY);
        pdf.showText("CEP: " + customer.getAddress().getCepAsString(), CEPInit, mY);
        
        //Contato, fone e e-mail
        pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float foneInit = leftMargin + (getWidth() * 0.35f);
        float emailInit = leftMargin + (getWidth() * 0.60f);
        drawVerticalLine(foneInit, mY);
        drawVerticalLine(emailInit, mY);
        mY -= rectHeight;

        pdf.showText("Contato: " + customer.getContactName(), leftMargin, mY);
        pdf.showText("Fone: " + customer.getContactPhone(), foneInit, mY);
        pdf.showText("Email: " + customer.getContactEmail(), emailInit, mY);
        
        //Pagto, entrega e transportadora
        pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float entregaInit = leftMargin + (getWidth() * 0.35f);
        float transportadoraInit = leftMargin + (getWidth() * 0.60f);
        drawVerticalLine(entregaInit, mY);
        drawVerticalLine(transportadoraInit, mY);
        mY -= rectHeight;
        
        BillDetails billDetails = invoice.getBillDetails();

        pdf.showText("Pagto: " + billDetails.getPaymentConditions(), leftMargin, mY);
        pdf.showText("Entrega: " + billDetails.getDeliveryDate(), entregaInit, mY);
        pdf.showText("Transp.: " + billDetails.getDispatch(), transportadoraInit, mY);
	}
	
	public void imprimeCabecalhoTabelaItens(float initX){
		pdf.setFont(FontFamily.HELVETICA, 12f, false, false);
		mY -= rectHeight;
		
		float finalX = initX + getWidthTabelaItens();
		pdf.drawRect(initX, mY, finalX, mY - rectHeight);
		
		float cellWidth = getWidthCellTabelaItens();
		float halfCellWidth = cellWidth / 2;
		float x = initX;
		float yForText = mY - rectHeight;
		
		//Referência
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("REF.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Cor
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("COR.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Tamanhos
		pdf.drawHorizontalLine(mY - (rectHeight / 2), x, x + (cellWidth * 2));
		drawVerticalLine(x + (cellWidth * 2), mY);
		
		pdf.setFont(FontFamily.HELVETICA, 7f, false, false);
		pdf.showTextCentralized("TAMANHOS", x + cellWidth, yForText + (rectHeight / 2.4f));
		
		pdf.drawVerticalLine(x + halfCellWidth, mY - (rectHeight / 2f), mY - rectHeight);
		pdf.showTextCentralized("P", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.drawVerticalLine(x + halfCellWidth, mY - (rectHeight / 2f), mY - rectHeight);
		pdf.showTextCentralized("M", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.drawVerticalLine(x + halfCellWidth, mY - (rectHeight / 2f), mY - rectHeight);
		pdf.showTextCentralized("G", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.showTextCentralized("GG", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		//Quant
		pdf.setFont(FontFamily.HELVETICA, 12f, false, false);
		
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("QUANT.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Preços
		pdf.drawHorizontalLine(mY - (rectHeight / 2), x, x + (cellWidth * 2));
		drawVerticalLine(x + (cellWidth * 2), mY);
		
		pdf.setFont(FontFamily.HELVETICA, 7f, false, false);
		pdf.showTextCentralized("PREÇOS R$", x + cellWidth, yForText + (rectHeight / 2.4f));
		
		pdf.drawVerticalLine(x + cellWidth, mY - (rectHeight / 2f), mY - rectHeight);
		pdf.showTextCentralized("UNITÁRIO", x + halfCellWidth, yForText - (getLineHeight() / 2));
		x += cellWidth;
		
		pdf.showTextCentralized("TOTAL", x + halfCellWidth, yForText - (getLineHeight() / 2));
		x += cellWidth;
		
		mY -= rectHeight;
	}
	
	public void imprimeCabecalhoTabelaItens2(float initX){
		pdf.setFont(FontFamily.HELVETICA, 10f, false, false);
		mY -= rectHeight;
		
		float finalX = initX + getWidthTabelaItens();
		pdf.drawRect(initX, mY, finalX, mY - rectHeight);
		
		float cellWidth = getWidthCellTabelaItens();
		float halfCellWidth = cellWidth / 2;
		float x = initX;
		float yForText = mY - rectHeight;
		
		//Referência
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("REF.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Cor
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("COR.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Tamanhos
		pdf.drawVerticalLine(x + halfCellWidth, mY - rectHeight, mY);
		pdf.showTextCentralized("P", x + (halfCellWidth / 2), yForText);
		x += halfCellWidth;

		pdf.drawVerticalLine(x + halfCellWidth, mY - rectHeight, mY);
		pdf.showTextCentralized("M", x + (halfCellWidth / 2), yForText);
		x += halfCellWidth;

		pdf.drawVerticalLine(x + halfCellWidth, mY - rectHeight, mY);
		pdf.showTextCentralized("G", x + (halfCellWidth / 2), yForText);
		x += halfCellWidth;

		pdf.showTextCentralized("GG", x + (halfCellWidth / 2), yForText);
		x += halfCellWidth;

		//Quant
		drawVerticalLine(x + cellWidth, mY);
		pdf.showTextCentralized("QUANT.", x + halfCellWidth, yForText);
		x += cellWidth;
		
		//Preços
		drawVerticalLine(x + (cellWidth * 2), mY);

		pdf.drawVerticalLine(x + cellWidth, mY - (rectHeight / 2f), mY - rectHeight);
		pdf.showTextCentralized("VLR UNIT.", x + halfCellWidth, yForText);
		x += cellWidth;

		pdf.showTextCentralized("VLR TOTAL", x + halfCellWidth, yForText);
		x += cellWidth;
	}
	
	public void imprimeTabelaItens(float initX, boolean primeiraTabela){
		imprimeCabecalhoTabelaItens2(initX);
		
		int max = 24;
		
		if(!paisagem)
			max = 40;
		
		for(int i = 0; i < max; i++){
			InvoiceItem item = null;
			
			if(primeiraTabela){
				if(i < invoice.getItems().size()){
					item = invoice.getItems().get(i);
				}
			}
			
			float finalX = initX + getWidthTabelaItens();
			pdf.drawRect(initX, mY, finalX, mY - rectHeight);
			
			float cellWidth = getWidthCellTabelaItens();
			float halfCellWidth = cellWidth / 2;
			float x = initX;
			float yForText = mY - rectHeight - rectHeight;
			
			//Ref
			drawVerticalLine(x + cellWidth, mY);
			if(item != null){
				pdf.showText(item.getReference(), x, yForText);
			}
			
			x += cellWidth;
			
			//Cor
			drawVerticalLine(x + cellWidth, mY);
			if(item != null){
				pdf.showText(item.getColor(), x, yForText);
			}
			x += cellWidth;
			
			//Tamanhos
			drawVerticalLine(x + (cellWidth * 2), mY);
			
			drawVerticalLine(x + halfCellWidth, mY);
			if(item != null){
				pdf.showText( "" + item.getQuantityP(), x, yForText);
			}
			x += halfCellWidth;
			
			drawVerticalLine(x + halfCellWidth, mY);
			if(item != null){
				pdf.showText( "" + item.getQuantityM(), x, yForText);
			}
			x += halfCellWidth;
			
			drawVerticalLine(x + halfCellWidth, mY);
			if(item != null){
				pdf.showText( "" + item.getQuantityG(), x, yForText);
			}
			x += halfCellWidth;
			
			if(item != null){
				pdf.showText( "" + item.getQuantityGG(), x, yForText);
			}
			
			x += halfCellWidth;
			
			//Quant
			if(item != null)
				totalPecas += item.getQuantity();
			drawVerticalLine(x + cellWidth, mY);
			if(item != null){
				pdf.showText( "" + item.getQuantity(), x, yForText);
			}
			x += cellWidth;
			
			//Preços
			if(item != null)
				valorTotal += item.getTotalValue();
			drawVerticalLine(x + (cellWidth * 2), mY);
			if(item != null){
				pdf.showTextRightAlign("" + item.getUnitValueAsString(), x + cellWidth, yForText);
			}

			drawVerticalLine(x + cellWidth, mY);
			
			x += cellWidth;
			
			if(item != null){
				pdf.showTextRightAlign( "" + item.getTotalValueAsString(), x + cellWidth, yForText);
			}

			x += cellWidth;
			
			mY -= rectHeight;
		}
	}
	
	public void imprimeDadosFinais(){
		//Visto comprador, Representante, Total de peças e toal
        pdf.drawRect(leftMargin, mY, rightMargin, mY - rectHeight);
        float representanteInit = leftMargin + (getWidth() * 0.28f);
        float totalPecasInit = leftMargin + (getWidth() * 0.55f);
        float totalInit = leftMargin + (getWidth() * 0.75f);
        drawVerticalLine(representanteInit, mY);
        drawVerticalLine(totalPecasInit, mY);
        drawVerticalLine(totalInit, mY);
        mY -= rectHeight;
        
        String valorTotalAsString = new String();
        valorTotalAsString += "R$";
        valorTotalAsString += valorTotal / 100;
        valorTotalAsString += ",";
        valorTotalAsString += valorTotal % 100;
 
        pdf.setFont(FontFamily.HELVETICA, 12f, false, false);
        pdf.showText("Visto comprador:", leftMargin, mY);
        pdf.showText("Representante:", representanteInit, mY);
        pdf.showText("Total de peças: " + totalPecas, totalPecasInit, mY);
        pdf.showText("Total R$: " + valorTotalAsString, totalInit, mY);
	}
}