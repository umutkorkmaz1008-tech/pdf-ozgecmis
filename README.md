# Java PDF Özgeçmiş Oluşturucu (Java PDF Resume Builder)

Bu proje, Java programlama dili kullanılarak konsol üzerinden otomatik olarak PDF formatında profesyonel bir özgeçmiş (CV) oluşturan bir uygulamadır.

## 🛠️ Kullanılan Teknolojiler ve Bileşenler
- **Java**: Projenin temel dili.
- **iText Kütüphanesi (v5.5.13.3)**: PDF dosyalarını sıfırdan oluşturmak, metin biçimlendirmek ve görsel eklemek için kullanılan ana kütüphane.
- **Maven**: Proje bağımlılıklarını (iText) yönetmek için kullanıldı.

## 🧩 Sınıf Yapısı ve Nesneler
Proje "Clean Code" prensiplerine uygun olarak sorumlulukların ayrılması (Separation of Concerns) mantığıyla iki ana sınıfa bölünmüştür:

1. `Main.java`: Uygulamanın giriş noktasıdır. Yalnızca PDF oluşturucu nesneyi örnekler (instantiate) ve gerekli parametreleri iletir. Yönerge gereği ana PDF işlemleri bu dosyanın dışında tutulmuştur.
2. `ResumeGenerator.java`: Bütün iş mantığının ve PDF oluşturma işlemlerinin yer aldığı sınıftır.
   - **Kullanılan Sınıf İçi Nesneler:**
     - `Document`: iText kütüphanesinin temel nesnesidir. Oluşturulacak PDF sayfasını ve yapısını temsil eder.
     - `PdfWriter`: Belgedeki içerikleri bilgisayardaki fiziksel dosya sistemine yazmaktan sorumlu köprü nesnesidir.
     - `Paragraph`: Metinleri başlık veya düz metin olarak şekillendirmek ve PDF içine basmak için kullanılmıştır.
     - `Image`: Özgeçmişteki kişisel fotoğrafın bellek üzerine alınıp PDF'e aktarılması için kullanılmıştır.

## 🚀 Neden Bu Nesneler Kullanıldı?
Kodların tamamını tek bir "Main" bloğuna yığmak yerine `ResumeGenerator` sınıfını oluşturmak, kodu modüler hale getirmiş ve nesne yönelimli programlamanın temellerine uygun hareket edilmesini sağlamıştır. `Document` ve `PdfWriter` iText mimarisinin zorunlu işleyici nesneleri olduğu için, `Paragraph` ve `Image` ise görsel düzenlemeler için tercih edilmiştir.

## ⚙️ Nasıl Çalıştırılır?
1. Projeyi bilgisayarınıza indirin.
2. Projenin kök dizinine (pom.xml ile aynı yere) `profile.jpg` adında bir fotoğraf ekleyin.
3. Maven aracılığıyla bağımlılıkları yükleyin.
4. `Main.java` sınıfını çalıştırın ve ana dizinde oluşan `Ozgecmis.pdf` dosyasını görüntüleyin.
