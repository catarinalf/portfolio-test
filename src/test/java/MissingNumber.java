import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MissingNumber {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.edge.driver", "edgedriver_win64/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://catarinalf.github.io/#contact");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Test name");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("test@test.com");

        WebElement numberField = driver.findElement(By.name("number"));
        numberField.sendKeys("");

        WebElement messageField = driver.findElement(By.name("message"));
        messageField.sendKeys("This is a test message");

        // Find the submit button and click it

        WebElement button = driver.findElement(By.id("formButton"));
        button.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the message is sent without the Name field
        
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        String expectedMessage = "Sent!";
        
        if (alertMessage.equals(expectedMessage)) {
        System.out.println("Alert message was displayed correctly");
        } 
        
        else {
        System.out.println("Alert message was not displayed correctly");
        }
    
    driver.quit();

    }

}

