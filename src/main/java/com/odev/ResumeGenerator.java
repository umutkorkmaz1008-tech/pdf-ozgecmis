package com.odev;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class ResumeGenerator {

    public void createResume(String destPdf, String imagePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(destPdf));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            Paragraph name = new Paragraph("Ahmet Yilmaz", titleFont);
            name.setAlignment(Element.ALIGN_CENTER);
            document.add(name);
            document.add(new Paragraph(" "));

            try {
                Image profilePic = Image.getInstance(imagePath);
                profilePic.scaleAbsolute(100f, 120f);
                profilePic.setAlignment(Element.ALIGN_CENTER);
                document.add(profilePic);
            } catch (Exception e) {
                System.out.println("Fotograf bulunamadi!");
                document.add(new Paragraph("[Fotograf Yeri - Dosya Bulunamadi]", normalFont));
            }
            
            document.add(new Paragraph(" "));

            Paragraph contact = new Paragraph("E-posta: ahmet.yilmaz@email.com | Telefon: +90 555 123 45 67\nAdres: Kadikoy, Istanbul", normalFont);
            contact.setAlignment(Element.ALIGN_CENTER);
            document.add(contact);
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------"));

            document.add(new Paragraph("Egitim Bilgileri", headerFont));
            document.add(new Paragraph("- XYZ Universitesi, Bilgisayar Muhendisligi (2020 - 2024)", normalFont));
            document.add(new Paragraph("- ABC Anadolu Lisesi (2016 - 2020)", normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Is Deneyimleri", headerFont));
            document.add(new Paragraph("1. Kidemli Yazilim Gelistirici - TechNova Co. (2024 - Devam Ediyor)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            document.add(new Paragraph("   - Java ve Spring Boot kullanarak mikroservis mimarileri gelistirildi.", normalFont));
            
            document.add(new Paragraph("2. Sistem Analisti - Global Data Solutions (2022 - 2024)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            document.add(new Paragraph("   - Musteri ihtiyaclarina yonelik UML diyagramlari cizildi ve raporlandi.", normalFont));
            
            document.add(new Paragraph("3. Yazilim Stajyeri - FutureSoft YAZILIM (2021 Yazi)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            document.add(new Paragraph("   - RESTful API testleri yazildi (JUnit ve Mockito kullanilarak).", normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Yetenekler ve Teknolojiler", headerFont));
            document.add(new Paragraph("Diller: Java, SQL, JavaScript, HTML, CSS", normalFont));
            document.add(new Paragraph("Araclar: Git, Maven, Docker, IntelliJ IDEA, Eclipse", normalFont));
            
            document.close();
            System.out.println("Basarili! Ozgecmis PDF formatiyla olusturuldu.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}