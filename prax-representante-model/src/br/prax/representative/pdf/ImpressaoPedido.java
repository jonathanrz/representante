package br.prax.representative.pdf;

import java.io.IOException;
import java.net.MalformedURLException;

import br.prax.representative.model.Address;
import br.prax.representative.model.BillDetails;
import br.prax.representative.model.Customer;
import br.prax.representative.model.Invoice;
import br.prax.representative.model.InvoiceItem;
import br.prax.representative.model.Representada;
import br.prax.representative.model.Representative;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font.FontFamily;

public class ImpressaoPedido {
	public static final String PDF_PATH = "c:/temp/rep.pdf";
	private PdfGenerator pdf;
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
		pdf.init(PDF_PATH, true/*paisagem*/);
		
		Init();
		
		pdf.getCanvas().saveState();
		
		float y = getHeight() * 0.93f;
		//Não pega o retorno intencionalmente, tem que pegar só o cabeçalho de representante
		imprimeCabecalhoRepresentada(y);

		y = imprimeCabecalhoRepresentante(y);
		
		y = imprimeTabelaCliente(y);
		
		y = imprimeNumeroPedido(y);

		//Não pega o retorno intencionalmente, pega somente da segunda tabela
		imprimeTabelaItens(y, getLeftMargin(), true);
		y = imprimeTabelaItens(y, getInitSegundaTabelaItens(), false);
		
		y = imprimeDadosFinais(y);
		
		pdf.getCanvas().restoreState();
		
		pdf.finish();
	}

	private void Init(){
		pdf.setParagraphAndLineHeight(getParagraphInit(), getLineHeight());
		pdf.getCanvas().setLineWidth(0.01f);
	}

	private float getRectHeight(){
		return getHeight() * 0.025f;
	}
	
	private float getRectHeightCabecalhoTabelaItens(){
		return getHeight() * 0.0375f;
	}
	
	private float getParagraphInit(){
		return getHeight() * 0.004f;
	}
	
	private float getLineHeight(){
		return getHeight() * 0.005f;
	}
	
	private float getLeftMargin(){
		return getWidth() * 0.02f;
	}
	
	private float getRightMargin(){
		return getWidth() * 0.98f;
	}
	
	private float getWidthTabelaItens(){
		return getWidth() * 0.475f;
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
		drawVerticalLine(x, y, getRectHeight());
	}
	
	private void drawVerticalLine(float x, float y, float height){
		pdf.drawVerticalLine(x, y, y - height);
	}
	
	private float imprimeCabecalhoRepresentada(float y) throws MalformedURLException, IOException, DocumentException{
		Representada representada = invoice.getRepresentedCompany();
		pdf.addImage(representada.getPathLogo(), getWidth() * 0.02f, getHeight() * 0.92f);

		pdf.setFont(FontFamily.HELVETICA, 30f, false, true);
		
		float x = getWidth() / 2;

		pdf.showTextCentralized(representada.getNome(), x, y);
		
		pdf.setFont(FontFamily.HELVETICA, 20f, false, true);
		
		y -= getRectHeight();

		pdf.setFont(FontFamily.HELVETICA, 12f, false, false);

		Address endereco = representada.getEndereco();
		pdf.showTextCentralized(endereco.getRua() + ", " + endereco.getNumeroCasa() + " - " + endereco.getBairro() + " - Fone/Fax: " + representada.getTelefone(), x, y);
		y -= getRectHeight();
		
		pdf.showTextCentralized(endereco.getCepAsString() + " - " + endereco.getCidade() + " - " + endereco.getEstado() + " - e-mail: " + representada.getEmail(), x, y);
		y -= getRectHeight();
		
		pdf.showTextCentralized(representada.getSite(), x, y);
		y -= getRectHeight();
		
		return y;
	}
	
	private float imprimeCabecalhoRepresentante(float y){
		pdf.setFont(FontFamily.HELVETICA, 30f, true, false);
		
		float x = (float) (getWidth() / 1.13);
		
		Representative representative = invoice.getRepresentative();

		pdf.showTextCentralized(representative.getTitulo(), x, y);
		y -= getRectHeight();
		
		pdf.setFont(FontFamily.HELVETICA, 11f, false, false);
		pdf.showTextCentralized(representative.getSubTitulo(), x, y);
		y -= getRectHeight();
		
		pdf.showTextCentralized(representative.getName(), x, y);
		y -= getRectHeight();
		
		pdf.showTextCentralized(representative.getFone(), x, y);
		y -= getRectHeight();
		
		pdf.showTextCentralized(representative.getEmail(), x, y);
		y -= getRectHeight();
		
		return y;
	}
	
	private float imprimeTabelaCliente(float y){
		pdf.setFont(FontFamily.HELVETICA, 11f, false, false);
		
		//Código, Nome e CNPJ
		pdf.drawRect(getLeftMargin(), y, getRightMargin(), y - getRectHeight());
		float nomeInit = getLeftMargin() + (getWidth() * 0.12f);
        float cnpjInit = getLeftMargin() + (getWidth() * 0.65f);
        drawVerticalLine(nomeInit, y);
        drawVerticalLine(cnpjInit, y);
		y -= getRectHeight();
		
		Customer customer = invoice.getCustomer();

		pdf.showText("Código: " + customer.getCode(), getLeftMargin(), y);
        pdf.showText("Nome: " + customer.getCorporateName(), nomeInit, y);
        pdf.showText("CNPJ: " + customer.getCnpj(), cnpjInit, y);
        
        //End e Insc Estadual
        pdf.drawRect(getLeftMargin(), y, getRightMargin(), y - getRectHeight());
        float inscEstInit = getLeftMargin() + (getWidth() * 0.65f);
        drawVerticalLine(inscEstInit, y);
        y -= getRectHeight();

        pdf.showText("Endereço: " + customer.getAddress().getRua(), getLeftMargin(), y);
        pdf.showText("Insc. Est.: " + customer.getStateInscription(), inscEstInit, y);
        
        //Bairro, cidade, estado e CEP
        pdf.drawRect(getLeftMargin(), y, getRightMargin(), y - getRectHeight());
        float cidadeInit = getLeftMargin() + (getWidth() * 0.30f);
        float estadoInit = getLeftMargin() + (getWidth() * 0.65f);
        float CEPInit = getLeftMargin() + (getWidth() * 0.80f);
        drawVerticalLine(cidadeInit, y);
        drawVerticalLine(estadoInit, y);
        drawVerticalLine(CEPInit, y);
        y -= getRectHeight();

        pdf.showText("Bairro: " + customer.getAddress().getBairro(), getLeftMargin(), y);
        pdf.showText("Cidade: " + customer.getAddress().getCidade(), cidadeInit, y);
        pdf.showText("Estado: " + customer.getAddress().getEstado(), estadoInit, y);
        pdf.showText("CEP: " + customer.getAddress().getCepAsString(), CEPInit, y);
        
        //Contato, fone e e-mail
        pdf.drawRect(getLeftMargin(), y, getRightMargin(), y - getRectHeight());
        float foneInit = getLeftMargin() + (getWidth() * 0.35f);
        float emailInit = getLeftMargin() + (getWidth() * 0.60f);
        drawVerticalLine(foneInit, y);
        drawVerticalLine(emailInit, y);
        y -= getRectHeight();

        pdf.showText("Contato: " + customer.getContactName(), getLeftMargin(), y);
        pdf.showText("Fone: " + customer.getContactPhone(), foneInit, y);
        pdf.showText("Email: " + customer.getContactEmail(), emailInit, y);
        
        //Pagto, entrega e transportadora
        pdf.drawRect(getLeftMargin(), y, getRightMargin(), y - getRectHeight());
        float entregaInit = getLeftMargin() + (getWidth() * 0.35f);
        float transportadoraInit = getLeftMargin() + (getWidth() * 0.60f);
        drawVerticalLine(entregaInit, y);
        drawVerticalLine(transportadoraInit, y);
        y -= getRectHeight();
        
        BillDetails billDetails = invoice.getBillDetails();

        pdf.showText("Pagto: " + billDetails.getPaymentConditions(), getLeftMargin(), y);
        pdf.showText("Entrega: " + billDetails.getDeliveryDate(), entregaInit, y);
        pdf.showText("Transp.: " + billDetails.getDispatch(), transportadoraInit, y);
        
        y -= getRectHeight();
        
        return y;
	}
	
	private float imprimeNumeroPedido(float y) {
		pdf.setFont(FontFamily.HELVETICA, 14f, true, false);
		
		y -= (getRectHeight()/2);
		
		pdf.showTextRightAlign("Pedido: ", getWidth() / 2, y);
		
		pdf.setFont(FontFamily.HELVETICA, 14f, false, true);
		
		pdf.showText("00000", getWidth() / 2, y);
		
		y -= (getRectHeight()/2);
		
		return y;
	}
	
	private float imprimeCabecalhoTabelaItens(float y, float initX){
		pdf.setFont(FontFamily.HELVETICA, 12f, false, false);
		
		float rectHeight = getRectHeightCabecalhoTabelaItens();

		float finalX = initX + getWidthTabelaItens();
		pdf.drawRect(initX, y, finalX, y - rectHeight);
		
		float cellWidth = getWidthCellTabelaItens();
		float halfCellWidth = cellWidth / 2;
		float x = initX;
		float yForText = y - rectHeight;
		float cellWidthRef = cellWidth * 0.7f;
		float cellWidthCor = cellWidth * 1.6f;
		float cellWidthQtd = cellWidth * 0.7f;
		
		//Referência
		drawVerticalLine(x + cellWidthRef, y, rectHeight);
		pdf.showTextCentralized("REF", x + (cellWidthRef/2), yForText);
		x += cellWidthRef;
		
		//Cor
		drawVerticalLine(x + cellWidthCor, y, rectHeight);
		pdf.showTextCentralized("COR", x + (cellWidthCor/2), yForText);
		x += cellWidthCor;
		
		//Tamanhos
		pdf.drawHorizontalLine(y - (rectHeight / 2), x, x + (cellWidth * 2));
		drawVerticalLine(x + (cellWidth * 2), y, rectHeight);
		
		pdf.setFont(FontFamily.HELVETICA, 9f, false, false);
		pdf.showTextCentralized("TAMANHOS", x + cellWidth, yForText + (rectHeight / 2.4f));
		
		pdf.drawVerticalLine(x + halfCellWidth, y - (rectHeight / 2f), y - rectHeight);
		pdf.showTextCentralized("P", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.drawVerticalLine(x + halfCellWidth, y - (rectHeight / 2f), y - rectHeight);
		pdf.showTextCentralized("M", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.drawVerticalLine(x + halfCellWidth, y - (rectHeight / 2f), y - rectHeight);
		pdf.showTextCentralized("G", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		pdf.showTextCentralized("GG", x + (halfCellWidth / 2), yForText - (getLineHeight() / 2));
		x += halfCellWidth;
		
		//Quant
		pdf.setFont(FontFamily.HELVETICA, 12f, false, false);
		
		drawVerticalLine(x + cellWidthQtd, y, rectHeight);
		pdf.showTextCentralized("QTD", x + (cellWidthQtd/2), yForText);
		x += cellWidthQtd;
		
		//Preços
		pdf.drawHorizontalLine(y - (rectHeight / 2), x, x + (cellWidth * 2));
		drawVerticalLine(x + (cellWidth * 2), y, rectHeight);
		
		pdf.setFont(FontFamily.HELVETICA, 9f, false, false);
		pdf.showTextCentralized("PREÇOS R$", x + cellWidth, yForText + (rectHeight / 2.4f));
		
		pdf.drawVerticalLine(x + cellWidth, y - (rectHeight / 2f), y - rectHeight);
		pdf.showTextCentralized("UNITÁRIO", x + halfCellWidth, yForText - (getLineHeight() / 2));
		x += cellWidth;
		
		pdf.showTextCentralized("TOTAL", x + halfCellWidth, yForText - (getLineHeight() / 2));
		x += cellWidth;
		
		y -= rectHeight;
		
		return y;
	}
	
	private float imprimeTabelaItens(float y, float initX, boolean primeiraTabela){
		y = imprimeCabecalhoTabelaItens(y, initX);
		
		pdf.setFont(FontFamily.HELVETICA, 11f, false, false);
		
		float cellWidth = getWidthCellTabelaItens();
		float halfCellWidth = cellWidth / 2;
		float cellWidthRef = cellWidth * 0.7f;
		float cellWidthCor = cellWidth * 1.6f;
		float cellWidthQtd = cellWidth * 0.7f;
		
		for(int i = 0; i < 22; i++){
			InvoiceItem item = null;
			
			float yForText = y - getRectHeight();
			float x = initX;
			
			if(primeiraTabela){
				if(i < invoice.getItems().size()){
					item = invoice.getItems().get(i);
				}
			}
			
			float finalX = initX + getWidthTabelaItens();
			pdf.drawRect(initX, y, finalX, y - getRectHeight());
			
			//Ref
			drawVerticalLine(x + cellWidthRef, y);
			if(item != null){
				pdf.showText(item.getReference(), x, yForText);
			}
			
			x += cellWidthRef;
			
			//Cor
			drawVerticalLine(x + cellWidthCor, y);
			if(item != null){
				pdf.showText(item.getColor(), x, yForText);
			}
			x += cellWidthCor;
			
			//Tamanhos
			drawVerticalLine(x + halfCellWidth, y);
			if(item != null){
				pdf.showText( "" + item.getQuantityP(), x, yForText);
			}
			x += halfCellWidth;
			
			drawVerticalLine(x + halfCellWidth, y);
			if(item != null){
				pdf.showText( "" + item.getQuantityM(), x, yForText);
			}
			x += halfCellWidth;
			
			drawVerticalLine(x + halfCellWidth, y);
			if(item != null){
				pdf.showText( "" + item.getQuantityG(), x, yForText);
			}
			x += halfCellWidth;
			
			drawVerticalLine(x + halfCellWidth, y);
			if(item != null){
				pdf.showText( "" + item.getQuantityGG(), x, yForText);
			}
			
			x += halfCellWidth;
			
			//Quant
			if(item != null)
				totalPecas += item.getQuantity();
			drawVerticalLine(x + cellWidthQtd, y);
			if(item != null){
				pdf.showText( "" + item.getQuantity(), x, yForText);
			}
			x += cellWidthQtd;
			
			//Preços
			if(item != null)
				valorTotal += item.getTotalValue();
			drawVerticalLine(x + (cellWidth * 2), y);
			if(item != null){
				pdf.showTextRightAlign("" + item.getUnitValueAsString(), x + cellWidth, yForText);
			}

			drawVerticalLine(x + cellWidth, y);
			
			x += cellWidth;
			
			if(item != null){
				pdf.showTextRightAlign( "" + item.getTotalValueAsString(), x + cellWidth, yForText);
			}

			x += cellWidth;
			
			y -= getRectHeight();
		}
		
		return y;
	}
	
	private float imprimeDadosFinais(float y){
		pdf.setFont(FontFamily.HELVETICA, 11f, false, false);
		
		float totalPecasInit = getLeftMargin() + (getWidth() * 0.55f);
		
		//Representante, Total de peças e toal
        pdf.drawRect(totalPecasInit, y, getRightMargin(), y - getRectHeight());
        
        float totalInit = getLeftMargin() + (getWidth() * 0.75f);
        //drawVerticalLine(totalPecasInit, y);
        drawVerticalLine(totalInit, y);
        y -= getRectHeight();
        
        String valorTotalAsString = new String();
        //valorTotalAsString += "R$";
        valorTotalAsString += valorTotal / 100;
        valorTotalAsString += ",";
        valorTotalAsString += valorTotal % 100;
        
        pdf.showText("Total de peças: " + totalPecas, totalPecasInit, y);
        pdf.showText("Total R$: " + valorTotalAsString, totalInit, y);
        
        return y;
	}
}