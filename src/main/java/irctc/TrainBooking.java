package irctc;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class TrainBooking {
    public static void main(String[] args) throws TesseractException {

       // WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        long startTime = System.currentTimeMillis();

        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // login code
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));
        loginButton.click();

        // Enter username and password and click on login button
        WebElement username = driver.findElement(By.xpath("//input[@formcontrolname='userid']"));
        username.sendKeys("pakya009");

        WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        password.sendKeys("Jacobs8595@!");

        // Find the CAPTCHA image element
        WebElement captchaImageElement = driver.findElement(By.xpath("//img[@class='captcha-img']"));

        // Extract the base64 encoded string from the src attribute
        String base64EncodedString = captchaImageElement.getAttribute("src").split(",")[1];

        // Decode the base64 encoded string
        byte[] imageBytes = Base64.getDecoder().decode(base64EncodedString);

        System.out.println("arr ::: " + Arrays.toString(imageBytes));

        // Use Tesseract OCR to extract text from the CAPTCHA image
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\ppamgeni\\AppData\\Local\\Tesseract-OCR\\tesseract.exe"); // Path to tessdata directory containing language files
        // ADDED LATER
        tesseract.setLanguage("eng");
        //tesseract.setPageSegMode(1);
        //tesseract.setOcrEngineMode(1);

        File file = new File(Arrays.toString(imageBytes));
       //  String captchaText = tesseract.doOCR(new ByteArrayInputStream(imageBytes));

        // Perform OCR on the CAPTCHA image to extract text
        String captchaText = performOCR(imageBytes);
        // String captchaText = tesseract.doOCR(file);
       System.out.println("CAPTCHA Text: " + captchaText);


        long endTime = System.currentTimeMillis() - startTime;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(endTime);

        System.out.println("Total time taken :: " +seconds + " in seconds");

        // Extract the Captcha image amd click on submit button
        //Tesseract tesseract = getTesseract();


        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]"));


//        WebElement from = driver.findElement(By.xpath("//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[3]/div[1]/div/label/span"));
//        from.sendKeys("LTT");
    }

    private static String performOCR(byte[] imageBytes) {
        // Initialize Tesseract OCR engine
        ITesseract tesseract = new Tesseract();
        // tesseract.setLanguage("eng"); // Set language

        try {
            // Perform OCR on the image bytes
            // String captchaText = tesseract.doOCR(new ByteArrayInputStream(imageBytes));

            String captchaText = tesseract.doOCR(createImageFromBytes(imageBytes));
            System.out.println("captchaText :: " +captchaText);
            return captchaText.trim(); // Trim any leading/trailing whitespaces
        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Tesseract getTesseract() {
        Tesseract instance = new Tesseract();
        //instance.setDatapath();

        return null;
    }
}
