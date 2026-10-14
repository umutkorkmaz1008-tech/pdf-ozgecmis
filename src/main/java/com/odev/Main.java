package com.odev;

public class Main {
    public static void main(String[] args) {
        
        ResumeGenerator generator = new ResumeGenerator();
        
        String pdfPath = "Ozgecmis.pdf";
        String imagePath = "profile.jpg";  
        
        System.out.println("Ozgecmis olusturma islemi baslatiliyor...");
        generator.createResume(pdfPath, imagePath);
    }
}