package PdfCompare;

import java.io.IOException;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;

public class pdfcompare {

	public static void main(String[] args) throws IOException {
		
		String pdf1 = System.getProperty("user.dir")+"./pdf_files/RentReceipt_1.pdf";
		String pdf2 = System.getProperty("user.dir")+"./pdf_files/RentReceipt_2.pdf";
		
		System.out.println(pdf1);
		
		String resultpdf1 = System.getProperty("user.dir")+"./pdf_files/ResultPDF/result1";
		String resultpdf2 = System.getProperty("user.dir")+"./pdf_files/ResultPDF/result2";
		
		
		//method 1
		new PdfComparator(pdf1,pdf2).withIgnore("ignore.conf").compare().writeTo(resultpdf1);
		
		//method 2
		final CompareResult result = new PdfComparator(pdf1, pdf2).withIgnore("ignore.conf").compare();
		if (result.isNotEqual()) {
		    System.out.println("Differences found!");
		}
		if (result.isEqual()) {
		    System.out.println("No Differences found!");
		}
		if (result.hasDifferenceInExclusion()) {
		    System.out.println("Differences in excluded areas found!");
		}
		
		
		//method 3
		boolean isEquals = new PdfComparator(pdf1,pdf2).compare().writeTo(resultpdf2);
		if (!isEquals) {
		    System.out.println("Differences found!");
		}
		
		System.out.println("Process Completed");
		
		

	}

}
