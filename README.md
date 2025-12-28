🖼️ OpenCV Image Manipulation (Java)

Bu proje, Java programlama dili ve OpenCV kütüphanesi kullanılarak temel görüntü işleme işlemlerinin uygulanmasını amaçlamaktadır.
Proje kapsamında bir görüntü dosyası okunur, işlenir ve çıktı olarak kaydedilir.

🚀 Proje Özeti

Uygulama aşağıdaki adımları sırasıyla gerçekleştirmektedir:

OpenCV kütüphanesinin yüklenip yüklenmediğini kontrol eder

Belirtilen dizindeki görüntüyü okur

Görüntü okunamazsa hata kontrolü yapar

Görüntüyü oranı korunarak yeniden boyutlandırır

Görüntüyü gri tonlamaya çevirir

İşlenmiş görüntüyü dosya olarak kaydeder

🛠️ Kullanılan Teknolojiler

Java (JDK 17)

OpenCV

IntelliJ IDEA

Maven

📁 Proje Yapısı
opencv-image-manipulation
│
├── src
│   └── main
│       └── java
│           └── org.example
│               └── Main.java
│
├── input.jpg
├── output_manipulated.jpg
├── pom.xml
└── README.md

📸 Gerçekleştirilen Görüntü İşleme İşlemleri
✔ Görüntü Okuma
Mat image = Imgcodecs.imread(inputImagePath, Imgcodecs.IMREAD_COLOR);

✔ Yeniden Boyutlandırma (Oran Korunarak)
double newWidth = 400;
double aspectRatio = (double) image.rows() / image.cols();
int newHeight = (int) (newWidth * aspectRatio);

✔ Gri Tonlama
Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

✔ Görüntü Kaydetme
Imgcodecs.imwrite(outputImagePath, grayImage);

🧪 Örnek Çalışma Çıktısı

Konsol çıktısı:

OpenCV Kütüphanesi Başarıyla Yüklendi!
Görüntü Başarıyla Okundu. Orijinal Boyut: 505x900
Görüntü Yeniden Boyutlandırıldı: 400x712
Görüntü Gri Tonlamaya Çevrildi.
İşlenmiş Görüntü Başarıyla Kaydedildi.

▶️ Nasıl Çalıştırılır?

OpenCV kütüphanesini sisteminize kurun

input.jpg dosyasını proje ana dizinine ekleyin

Projeyi IntelliJ IDEA üzerinden açın

Main.java dosyasını çalıştırın

İşlenmiş görüntü output_manipulated.jpg olarak kaydedilecektir

🎯 Projenin Kazanımları

OpenCV ile Java entegrasyonu

Temel görüntü işleme kavramları

Dosya okuma ve hata kontrolü

Oran korunarak yeniden boyutlandırma

Gri tonlama dönüşümü

🔮 Geliştirilebilir Alanlar

Kenar tespiti (Canny)

Yüz / nesne tanıma

Gerçek zamanlı kamera işleme

GUI (Swing / JavaFX) entegrasyonu

👤 Geliştirici

Muhammed Özbek
|Software Engineering Student
