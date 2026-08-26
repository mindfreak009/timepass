//package powerbi;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.time.Duration;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PowerBiFlow {
//    WebElement report;
//
//    // public EdgeDriver driver;
//    public ChromeDriver driver;
//
//    public WebDriverWait wait;
//
//    String url = "https://app.powerbi.com/groups/me/reports/4b3dd440-6ab6-4a05-874c-afaf94e1016a/ReportSection34ddde8a23002d23b213?ctid=e9cb3c80-4156-4c39-a7fe-68fe427a3d46&openReportSource=SubscribeOthers&experience=power-bi";
//
//    public static void main(String[] args) {
//        PowerBiFlow instance = new PowerBiFlow();
//        try {
//
//            instance.beforeTest();
//            instance.dashboardFilterTest();
//        } finally {
//            instance.afterTest();
//        }
//
//    }
//
//    public void beforeTest() {
//        File file = new File("D:\\Users\\ppangeni\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        System.out.println("driver proeprty ::: " +System.getProperty("webdriver.chrome.driver"));
//
//        // var options = new EdgeOptions();
//        var options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        // options.addArguments("--user-data-dir="+userProfile);
//        options.addArguments("--profile-directory=Default");
//
//        options.setCapability("webSocketUrl", true);
//        Map<String, Object> prefs = new LinkedHashMap<>();
//        prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.TRUE);
//        options.setExperimentalOption("prefs", prefs);
//
//       //  driver = new EdgeDriver(options);
//        driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        // wait = new WebDriverWait(driver, 20);
//        driver.get(url);
//
//        // Find username input field and enter username
//        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"emailCollection\"]/div[2]/div[2]/div/div[1]/div[2]/input"));
//        System.out.println("usrenameField" +usernameField);
//        sleep(2000);
//        usernameField.sendKeys("ppangeni@altimetrik.com");
//        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
//        sleep(5000);
//        // altimetrik.com\ppangeni
//        WebElement password = driver.findElement(By.xpath("//*[@id=\"passwordArea\"]/input"));
//        System.out.println("password" +password);
//        password.sendKeys("Oneplus@123");
//        sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
//        sleep(15000);
//        driver.findElement(By.xpath("//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[3]/div[1]/div/label/input")).click();
//        sleep(5000);
//        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
//        sleep(1000);
//        //*[@id="idSIButton9"]
//    }
//
//    public void afterTest() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public static void cropImage(String inputPath, String outputPath) {
//        try {
//            var originalImage = ImageIO.read(new File(inputPath));
//            int x = 0;
//            int y = 0;
//            int width = originalImage.getWidth();
//            int height = 205;
//            var croppedImage = originalImage.getSubimage(x, y, width, height);
//            ImageIO.write(croppedImage, "png", new File(outputPath));
//            System.out.println("Cropped screenshot saved successfully!");
//        } catch (IOException e) {
//            System.err.println("Error while Cropping screenshot: " + e.getMessage());
//        }
//    }
//
//    public static void sleep(int timeout) {
//        try {
//            Thread.sleep(timeout);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dashboardFilterTest() {
//        handleScreenshot("All");
//        sleep(5000);
//        By dropdownLocator = By.xpath("//h3[normalize-space()='Demand Type']/ancestor::div[3]/following-sibling::div/div[@role='combobox']");
//        var dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
//
//        // Proactive Report
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
//        selectDropdownOption("Proactive");
//
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "false"));
//        handleScreenshot("Proactive");
//
//        //All Demand Types except Proactive Report
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
//        multiSelectCheckBoxes();
//        dropdown.click();
//
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "false"));
//        handleScreenshot("All except Proactive");
//    }
//
//    private void selectDropdownOption(String optionText) {
//        //    //*[@id="pvExplorationHost"]/div/div/exploration/div/explore-canvas/div/div[2]/div/div[2]/div[1]
//        //    //*[@id="pvExplorationHost"]/div/div/exploration/div/explore-canvas/div/div[2]/div/div[2]/div[2]/visual-container-repeat/visual-container[9]/transform/div/div[3]/div/div/visual-modern/div/div
//        // String optionXpath = "//div[@class='visibleGroup']/div[normalize-space()='%s']";
//        // String optionXpath = "//*[@id=\"slicer-dropdown-popup-6334ef7e-b211-20de-7561-f52973ce9f64\"]/div[1]/div/div[2]/div/div[1]/div/div/div/div";
//        // WebElement els = driver.findElement(By.xpath("//input[@type='checkbox']"));
//
//        WebElement els = driver.findElement(By.xpath("//*[@id=\"pvExplorationHost\"]/div/div/exploration/div/explore-canvas/div/div[2]/div/div[2]/div[2]/visual-container-repeat/visual-container[9]/transform/div/div[3]/div/div/visual-modern/div/div"));
//        els.click();
//
//        // By optionLocator = By.xpath(String.format(optionXpath, optionText));
//        // sleep(5000);
//        // WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
//        // option.click();
//        // sleep(1000);
//
//    }
//
//    private void multiSelectCheckBoxes() {
//        var options = By.xpath("//div[@class='visibleGroup']/div");
//        var elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options));
//        var actions = new Actions(driver).keyDown(Keys.CONTROL);
//
//        elements.forEach(element -> {
//            boolean isSelected = Boolean.parseBoolean(element.findElement(By.xpath("./div")).getAttribute("aria-selected"));
//            if (!isSelected) {
//                actions.click(element);
//            } else if (element.getText().equalsIgnoreCase("Proactive") && isSelected) {
//                actions.click(element);
//            }
//        });
//
//        actions.keyUp(Keys.CONTROL)
//                .build()
//                .perform();
//        sleep(5000);
//    }
//
//    private void handleScreenshot(String suffix) {
//        String fileName = "BI Report";
//        String resources = "D:\\timepass\\src\\main\\java\\powerbi\\resources";
//        String imagePath = String.format("%s/%s - %s.png", resources, fileName, suffix);
//        String croppedImagePath = String.format("%s/%s - %s-cropped.png", resources, fileName, suffix);
//        report = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pvExplorationHost\"]/div/div/exploration/div/explore-canvas/div/div[2]/div/div[2]/div[2]")));
//        // report = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Power BI Report']")));
//        captureElementScreenshot(report, imagePath);
//        cropImage(imagePath, croppedImagePath);
//
//    }
//
//    private void captureElementScreenshot(WebElement report, String imagePath) {
//
//    }
//
//}
