import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        try {
            nu.pattern.OpenCV.loadLocally(); // Otomatik yükleme
            System.out.println("✅ OpenCV Kütüphanesi Başarıyla Yüklendi!");
        } catch (Exception e) {
            System.err.println("❌ Hata: OpenCV native kütüphanesi yüklenirken bir hata oluştu.");
            System.err.println("Lütfen Maven (veya Gradle) senkronizasyonunun ve 'pom.xml' dosyanızın doğru olduğundan emin olun.");
            System.err.println("Hata Detayı: " + e.getMessage());
            return;
        }


        String inputImagePath = "input.jpg";
        String outputImagePath = "output_manipulated.jpg";

        Mat image = Imgcodecs.imread(inputImagePath, Imgcodecs.IMREAD_COLOR);

        if (image.empty()) {
            System.err.println("❌ Hata: Görüntü dosyası okunamadı. Lütfen yolu kontrol edin: " + inputImagePath);

            if (!new File(inputImagePath).exists()) {
                System.err.println("Dosya yolu fiziksel olarak mevcut değil.");
            }
            return;
        }
        System.out.println("✔️ Görüntü Başarıyla Okundu. Orijinal Boyut: " + image.cols() + "x" + image.rows());


        Mat resizedImage = new Mat();
        double newWidth = 400; // Yeni genişlik
        double aspectRatio = (double) image.rows() / image.cols();
        int newHeight = (int) (newWidth * aspectRatio);

        Size newSize = new Size(newWidth, newHeight);

        Imgproc.resize(image, resizedImage, newSize, 0, 0, Imgproc.INTER_LINEAR);
        System.out.println("✔️ Görüntü Yeniden Boyutlandırıldı: " + resizedImage.cols() + "x" + resizedImage.rows());


        Mat grayImage = new Mat();

        Imgproc.cvtColor(resizedImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        System.out.println("✔️ Görüntü Gri Tonlamaya Çevrildi.");

        boolean success = Imgcodecs.imwrite(outputImagePath, grayImage);

        if (success) {
            String absoluteOutputPath = new File(outputImagePath).getAbsolutePath();
            System.out.println("✔️ İşlenmiş Görüntü Başarıyla Kaydedildi: " + absoluteOutputPath);
        } else {
            System.err.println("❌ Hata: İşlenmiş Görüntü Kaydedilemedi.");
        }

        image.release();
        resizedImage.release();
        grayImage.release();
    }
}

