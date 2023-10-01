package abhibus.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver abhibus=new ChromeDriver();
		//Launch  Chrome/Edge/Firefox/Safari browser 
		//add  implicitlyWait
		abhibus.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//To launch abhibus.com
		abhibus.get("https://www.abhibus.com");
		abhibus.manage().window().maximize();
		//Click on Bus
		abhibus.findElement(By.xpath("//a[@id='bus-link']")).click();
		//Type "Chennai" in the FROM text box
		abhibus.findElement(By.xpath("//div[@id='search-from']//input")).sendKeys("Chennai");
		//Click the first option from the pop up box
		Thread.sleep(2000);
		abhibus.findElement(By.xpath("//div[@id='search-from']//div/ul[contains(@class,'auto-complete-list')]/li[1]")).click();
		//Type "Bangalore" in the TO text box
		abhibus.findElement(By.xpath("//div[@id='search-to']//input")).sendKeys("Bangalore");
		//Click the first option from the pop up box
		Thread.sleep(2000);
		abhibus.findElement(By.xpath("//div[@id='search-to']//div/ul[contains(@class,'auto-complete-list')]/li[1]")).click();
		//Select tomorrow option 
		abhibus.findElement(By.xpath("//div[@id='jaurney-date']//div[contains(@class, 'suffix')]/a[text()='Tomorrow']")).click();
		//Click Search Buses
		abhibus.findElement(By.xpath("//div[@id='search-button']//a[text()='Search']")).click();
		//Print the name of the first resulting bus (use .getText())
		//abhibus.findElement(By.xpath("//div[@id='service-cards-container']//div[1]/h5[@class='title']"));
		//WebElement firstBusName = abhibus.findElement(By.xpath("//div[@id='service-cards-container']//div[1]/h5[@class='title']"));
		
		WebElement firstBusName = abhibus.findElement(By.xpath("//div/div[@class='container card service  md '][1]//h5[@class='title']"));
		System.out.println(firstBusName.getText());
		//Choose SLEEPER in the left menu from Bus Type
		abhibus.findElement(By.xpath("//div[@id='seat-filter-bus-type']//a/span[text()='Sleeper']")).click();
		//Print the first resulting bus seat count(Example:35 Seats Available)(use .getText())
		WebElement countOfSeats=abhibus.findElement(By.xpath("//div/div[@class='container card service  md '][1]//div[@class='text-grey']/small"));
		System.out.println(countOfSeats.getText());
		//Click Show seats
		abhibus.findElement(By.xpath("//div/div[@class='container card service  md '][1]//div/button")).click();
		//Click SelectSeat
		//abhibus.findElement(By.xpath("//*[@id=\"seat-layout-details\"]/tbody/tr[1]/td[1]/div/button")).click();
		abhibus.findElement(By.xpath("//div[@id='seat-layout-container'][1]//table[@id=\"seat-layout-details\"]/tbody/tr[1]/td[1]")).click();
		//type input
		abhibus.findElement(By.xpath("//div[@id='place-select-container']//div/input[@placeholder='Search Boarding Point']")).sendKeys("SRP");
		//Select boarding option
		abhibus.findElement(By.xpath("//div[@id='place-select-container']//div[1]/input[@class='primary  ']")).click();
		//Search dropping point
		abhibus.findElement(By.xpath("//div[@id='place-select-container']//div/input[@placeholder='Search Dropping Point']")).sendKeys("marathahalli");
		//Select dropping point
		abhibus.findElement(By.xpath("//div[@id='place-select-container']//div[1]/input[@class='primary  ']")).click();
		//print seat selected
		WebElement seat =abhibus.findElement(By.xpath("//div[@id='seating-selected-seat-details']//span[1]/span"));
		//Print Selected seat
		System.out.println("Selected seat-"+ seat.getText());
		WebElement fare =abhibus.findElement(By.xpath("//div[@id='seating-selected-seat-details']//span[2]/span"));
		//Print fare 
		System.out.println("Fare to pay="+fare.getText());
		//Click continue to do reservation
		abhibus.findElement(By.xpath("//div[@id=\"seating-container\"]/div[3]//span[text()='Continue']")).click();

	}
	

}
