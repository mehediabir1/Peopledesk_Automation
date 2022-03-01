package ibos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class login {
    public static WebDriver driver;

    public static void main(String[] args) {
        ChromeOpen();
        login_001();
        employee_mng();
    }

    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ibos.peopledesk.io/");
    }

    //-- CREDENTIAL OF MANAGEMENT--//
    public static void login_001(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input")).sendKeys("abir@ibos.io");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input")).sendKeys("@demo123");
        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static void employee_mng(){
        String searchName = "No";
        System.out.println("Module: Employee Management");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div[2]/div/div[2]/div/div")).click();
       // WebElement datas = driver.findElement(By.className("tableBody-title"));
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[1]/ul/li[1]/div/div/input"));
        searchBar.sendKeys(searchName);

        try {
            boolean result = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]/div/div[2]/span")).isDisplayed();
        }
        catch (NoSuchElementException e){
            System.out.println("No Search Result");
        }

            System.out.println("Search Result Came");

        //System.out.println(result.contains(searchName));
    }
}