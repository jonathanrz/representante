package br.prax.representative.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {
	private PdfContentByte mCanvas;
	private Rectangle mRectangle;
	private Document mDocument ;
	private float mParagraphSize = 0;
	private float mLineHeight = 0;
	
	public Rectangle getRectangle(){
		return mRectangle;
	}
	
	public PdfContentByte getCanvas(){
		return mCanvas;
	}
	
	public void drawLine(float initX, float initY, float finalX, float finalY){
		mCanvas.moveTo(initX, initY);
		mCanvas.lineTo(finalX, finalY);
		mCanvas.stroke();
	}
	
	public void drawHorizontalLine(float y, float initX, float finalX){
		drawLine(initX, y, finalX, y);
	}
	
	public void drawVerticalLine(float x, float initY, float finalY){
		drawLine(x, initY, x, finalY);
	}
	
	public void drawRect(float initX, float initY, float finalX, float finalY){
		drawHorizontalLine(initY, initX, finalX);
		drawVerticalLine(initX, initY, finalY);
		drawVerticalLine(finalX, initY, finalY);
		drawHorizontalLine(finalY, initX, finalX);
	}
	
	public void setFont(FontFamily fontName, float size, boolean bold, boolean italic){
		Font font = new Font(fontName, size);
		
		if(bold && italic)
			font.setStyle(Font.BOLDITALIC);
		else if(bold)
			font.setStyle(Font.BOLD);
		else if(italic)
			font.setStyle(Font.ITALIC);
			
        BaseFont bf_font = font.getCalculatedBaseFont(false);
        mCanvas.setFontAndSize(bf_font, size);
	}
	
	public void setParagraphAndLineHeight(float paragraph, float lineHeight){
		mParagraphSize = paragraph;
		mLineHeight = lineHeight;
	}
	
	public void showText(String text, float x, float y){
		mCanvas.beginText();
		mCanvas.showTextAligned(Element.ALIGN_LEFT, text, x + mParagraphSize, y + mLineHeight, 0);
		mCanvas.endText();
	}
	
	public void showTextRightAlign(String text, float x, float y){
		mCanvas.beginText();
		mCanvas.showTextAligned(Element.ALIGN_RIGHT, text, x - mParagraphSize, y + mLineHeight, 0);
		mCanvas.endText();
	}
	
	public void showTextCentralized(String text, float x, float y){
		mCanvas.beginText();
		mCanvas.showTextAligned(Element.ALIGN_CENTER, text, x, y + mLineHeight, 0);
		mCanvas.endText();
	}
	
	public void addImage(String path, float x, float y) throws MalformedURLException, IOException, DocumentException{
		Image img = Image.getInstance(path);
        img.setAbsolutePosition(x, y - img.getDpiY());
        mDocument.add(img);
	}
	
	public void addImage(Image img) throws DocumentException{
		mDocument.add(img);
	}
	
	public void init(String path, boolean paisagem) throws FileNotFoundException, DocumentException{
		if(paisagem)
			mDocument = new Document(PageSize.A4.rotate());
		else
			mDocument = new Document(PageSize.A4);

        PdfWriter writer = PdfWriter.getInstance(mDocument , new FileOutputStream(path));
        
        mDocument.open();
        
        mCanvas = writer.getDirectContent();
        mRectangle = writer.getPageSize();
	}
	
	public void finish(){
		mDocument.close();
	}	
}
