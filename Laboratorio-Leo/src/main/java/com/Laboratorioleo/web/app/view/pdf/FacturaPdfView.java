package com.Laboratorioleo.web.app.view.pdf;

import java.awt.Color;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.Laboratorioleo.web.app.models.entity.Factura;
import com.Laboratorioleo.web.app.models.entity.ItemFactura;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


//nombre de redireccion por parte del controlador factura/ver
@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView {

	//@Autowired
  //  private MessageSource messageSource;
	
	//@Autowired
    //private LocaleResolver localeResolver;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Factura factura = (Factura) model.get("factura");
		
		
		
		//Locale locale = localeResolver.resolveLocale(request);
		
		//MessageSourceAccessor mensajes =  getMessageSourceAccessor();
		
		
	    //Image jpg = Image.getInstance("C:\\Logo3.png");
		//document.add(jpg);
		
		 PdfPTable tablad = new PdfPTable(1);
		// tablad.setWidths(new float [] {3, 3});
	     tablad.setSpacingAfter(30);
	     
	     
		   PdfPCell celld = null;
		   
		   // quita el borde de la tabla 
		   tablad.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		   
		   Font font1 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
		    
			celld = new PdfPCell(new Phrase("N° de Factura: "  +  factura.getId(), font1 ) );
			
			
			// quita el borde  del Cell
			celld.setBorder(Rectangle.NO_BORDER);
			
			//celld.setBackgroundColor(new Color(184, 218, 255));
			//celld.setPadding(8f);
			  
			tablad.getDefaultCell().setHorizontalAlignment(Element.ALIGN_TOP);
			tablad.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			
			
			
			tablad.addCell(celld);
			//tablad.addCell("");
			
			tablad.addCell("Col. Universidad ");
			
			//tablad.addCell("");
			tablad.addCell("Av. Ignacion Allende 1211");
		    //tablad.addCell("");
		    tablad.addCell("50130 Toluca de Lerdo, Méx.");
			//tablad.addCell("");
			
			document.add(tablad);
			
			
			
			
			//Image jpg = Image.getInstance("C:\\Logo3.png");
			//document.add(jpg);
			  //creacion de una instancia para la imagen
		    // Image header = Image.getInstance("C:\\Logo3.png");
		    	//	 header.scaleToFit(400, 750);
		    		// document.add(header);
		    		 
		    		 // ruta relativa
			Image imagen = Image.getInstance(getClass().getClassLoader().getResource("static/images/logo3.png"));
			
				
		    		 //tamano de imagen
		    		 // el primer parametro es
		    		 imagen.scaleToFit(190 ,280 );
		    		 Paragraph p = new Paragraph();
		    		 // el primer parametro es horizontal
		    		 // el segundo parametro es el vertical
		    		 p.add(new Chunk(imagen, -50 , 40));
		    		 
		    		 p.setAlignment(Element.ALIGN_RIGHT);
		    		  
		    		 document.add(p);  		 
		    		 
		    	
		//tabla numero 2
		    		 
		PdfPTable tabla = new PdfPTable(2);
		tabla.setSpacingAfter(20);
		
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("Datos del Cliente: ", font1));
		cell.setColspan(2);
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		tabla.addCell(cell);
		
		tabla.addCell("Nombre del Cliente: ");
	
		tabla.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		tabla.addCell("Dirrecion de Correo Eletronico: ");
		tabla.addCell(factura.getCliente().getEmail());
		
       

		//aqui empieza la tabla 2
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);
		
		
		cell = new PdfPCell(new Phrase("Datos de la Factura",font1));
		cell.setBackgroundColor(new Color(195, 230, 203));
		cell.setPadding(8f);
		
		tabla2.addCell(cell);
		tabla2.addCell("Folio: "  +  factura.getId());
		tabla2.addCell("Descrpcion: "  + factura.getDescripcion());
		tabla2.addCell("fecha: "  + factura.getCreateAt());
		
		document.add(tabla);
		document.add(tabla2);
		// empieza la tabla 3
		PdfPTable tabla3 = new PdfPTable(4);
		tabla3.setWidths(new float [] {3.5f, 1, 1, 1});
		tabla3.getDefaultCell();
		tabla3.addCell("Nombre de Productos: ");
		tabla3.addCell("Precio: ");
		tabla3.addCell("Cantidad: ");
		tabla3.addCell("Total: ");
		
		for(ItemFactura item: factura.getItems()) {
			tabla3.addCell(item.getProducto().getNombre());
			tabla3.addCell(item.getProducto().getPrecio().toString());
			
			cell = new PdfPCell(new Phrase(item.getCantidad().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			tabla3.addCell(item.calcularImporte().toString());
		}
		
	    cell = new PdfPCell(new Phrase("Total: "));
	    cell.setColspan(3);
	    cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	    tabla3.addCell(cell);
	    tabla3.addCell(factura.getTotal().toString());
	    
	    document.add(tabla3);
		
	}

}
