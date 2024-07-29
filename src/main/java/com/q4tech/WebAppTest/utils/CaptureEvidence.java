package com.q4tech.WebAppTest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureEvidence {
	
	//Captura de pantalla del navegador y la agrega a un documento de Word.
	public static void captureScreenshotToDocument(WebDriver driver, String rutaImagen, String nombreDocumento, String tituloEvidencia) throws IOException, InvalidFormatException, InterruptedException {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File imageFile = new File(rutaImagen);
		FileUtils.copyFile(screen, imageFile);

		File fichero = new File(nombreDocumento); 
		XWPFDocument docx;

		if (!fichero.exists()) {
		docx = new XWPFDocument();
		} else {
		FileInputStream ficheroStream = new FileInputStream(fichero);
		docx = new XWPFDocument(ficheroStream);
		}

		    XWPFParagraph paragraph = docx.createParagraph();    
		    XWPFRun run = paragraph.createRun();
		    run.setText(tituloEvidencia);
		    run.setFontSize(13);

		    InputStream pic = new FileInputStream(rutaImagen);
		run.addPicture(pic, Document.PICTURE_TYPE_PNG, rutaImagen, Units.toEMU(500), Units.toEMU(200));
		    pic.close();
		    
		    FileOutputStream out = new FileOutputStream(nombreDocumento);
		    docx.write(out);
		    out.flush();
		    out.close();
		    docx.close();

		    TimeUnit.SECONDS.sleep(1);
		}

		public static void writeTitleToDocument(String nombreDocumento, String tituloEvidencia, int fontSize) throws IOException, InvalidFormatException, InterruptedException {
		File fichero = new File(nombreDocumento); 
		XWPFDocument docx;

		if (!fichero.exists()) {
		docx = new XWPFDocument();
		} else {
		FileInputStream ficheroStream = new FileInputStream(fichero);
		docx = new XWPFDocument(ficheroStream);
		}

		    XWPFParagraph paragraph = docx.createParagraph();    
		    XWPFRun run = paragraph.createRun();
		    run.setText(tituloEvidencia);
		    run.setFontSize(fontSize);

		    FileOutputStream out = new FileOutputStream(nombreDocumento);
		    docx.write(out);
		    out.flush();
		    out.close();
		    docx.close();

		    TimeUnit.SECONDS.sleep(1);
		}
		
		// Captura pantalla del navegador y la guarda como un archivo con una marca de tiempo.
		public static String getScreenshot(WebDriver driver, String rutaImagen, String nombreBase) throws IOException { 
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			// Generar nombre de archivo con marca de tiempo
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String nombreFile = nombreBase + "_" + timestamp + ".png";
			
			File destino = new File(rutaImagen + nombreFile);
			FileUtils.copyFile(screen, destino);
			
			return nombreFile; // Devuelve el nombre del archivo generado
		}

}
