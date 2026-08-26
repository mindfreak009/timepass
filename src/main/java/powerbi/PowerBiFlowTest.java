//package powerbi;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.time.Duration;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class PowerBiFlowTest {
//    WebElement report;
//    public EdgeDriver driver;
//    public WebDriverWait wait;
//    String url = "https://app.powerbi.com/groups/me/reports/4b3dd440-6ab6-4a05-874c-afaf94e1016a/ReportSection34ddde8a23002d23b213?ctid=e9cb3c80-4156-4c39-a7fe-68fe427a3d46&openReportSource=SubscribeOthers&experience=power-bi";
//
//    public static void main(String[] args) {
//        var instance = new PowerBiFlowTest();
//        try {
//            instance.beforeTest();
//            instance.dashboardFilterTest();
//        } finally {
//            instance.afterTest();
//        }
//
//    }
//
//
//    public void beforeTest() {
//        var options = new EdgeOptions();
//        options.addArguments("--start-maximized");
//        options.setCapability("webSocketUrl", true);
//        Map<String, Object> prefs = new LinkedHashMap<>();
//        prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.TRUE);
//        options.setExperimentalOption("prefs", prefs);
//        driver = new EdgeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        driver.get(url);
//        sleep(15000);
//    }
//
//    public void afterTest() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public void captureElementScreenshot(WebElement element, String screenshotPath) {
//        try {
//            var screenshot = element.getScreenshotAs(OutputType.FILE);
//            Files.copy(screenshot.toPath(), Path.of(screenshotPath), StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Screenshot captured successfully and saved to: " + screenshotPath);
//        } catch (IOException e) {
//            System.err.println("Error while saving screenshot: " + e.getMessage());
//        }
//    }
//
//    public void cropImage(String inputPath, String outputPath) {
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
//    public void sleep(int timeout) {
//        try {
//            Thread.sleep(timeout);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dashboardFilterTest() {
//
//        handleScreenshot("All");
//
//        By dropdownLocator = By.xpath("//h3[normalize-space()='Demand Type']/ancestor::div[3]/following-sibling::div/div[@role='combobox']");
//        var dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
//
//        // Proactive Report
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
//        selectDropdownOption("Proactive");
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "false"));
//
//        handleScreenshot("Proactive");
//
//        //All Demand Types except Proactive Report
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
//        multiSelectCheckBoxes();
//        dropdown.click();
//        wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "false"));
//        handleScreenshot("All except Proactive");
//    }
//
//    private void selectDropdownOption(String optionText) {
//        String optionXpath = "//div[@class='visibleGroup']/div[normalize-space()='%s']";
//        By optionLocator = By.xpath(String.format(optionXpath, optionText));
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
//        option.click();
//        sleep(1000);
//    }
//
//    private void multiSelectCheckBoxes() {
//        var options = By.xpath("//div[@class='visibleGroup']/div");
//        var elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options));
//        var actions = new Actions(driver).keyDown(Keys.CONTROL);
//        elements.forEach(element -> {
//            boolean isSelected = Boolean.parseBoolean(element.findElement(By.xpath("./div")).getAttribute("aria-selected"));
//            if (!isSelected) {
//                actions.click(element);
//            } else if (element.getText().equalsIgnoreCase("Proactive") && isSelected) {
//                actions.click(element);
//            }
//        });
//        actions.keyUp(Keys.CONTROL)
//                .build()
//                .perform();
//        sleep(5000);
//    }
//
//    private void handleScreenshot(String suffix) {
//
//        String fileName = "BI Report";
//        // String resources = "D:\\workspace\\power-bi\\src\\test\\resources";
//        String resources = "D:\\timepass\\src\\main\\java\\powerbi\\resources";
//        String imagePath = String.format("%s/%s - %s.png", resources, fileName, suffix);
//        String croppedImagePath = String.format("%s/%s - %s-cropped.png", resources, fileName, suffix);
//        report = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Power BI Report']")));
//        captureElementScreenshot(report, imagePath);
//        cropImage(imagePath, croppedImagePath);
//    }
//}
//
