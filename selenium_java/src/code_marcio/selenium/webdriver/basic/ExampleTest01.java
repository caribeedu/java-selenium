package code_marcio.selenium.webdriver.basic;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest01 {

	public static WebDriver driver = null;
			
	public static void main(String[] args) throws InterruptedException
	{	
		long setResizeDelay = 2000L;
		TimerTask task = new TimerTask() {
			public void run() {
				driver.manage().window().setSize(new Dimension(1000,800));
				driver.manage().window().setPosition(new Point(200,200));
	        }
		};
		
		Timer timer = new Timer();
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.amazon.com.br/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais.")) {
			System.out.println("Titulo correto!");
		} else {
			System.out.println(title);
		}
			
		timer.schedule(task, setResizeDelay);
		driver.close()
	}

}
