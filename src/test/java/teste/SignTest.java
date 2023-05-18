package teste;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class SignTest {
    private WebDriver navegador;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/faugusdo/Documents/driver/chromedriver");
    }
    @After
    public void teardown() {
    navegador.quit();
    }
    @Test
    public void testFazerLoginNoTaskit() throws InterruptedException {
        navegador = new ChromeDriver();
        navegador.get("https://www.google.com.br/");
        navegador.findElement(By.xpath("//textarea[@title='Pesquisar']")).click();
        navegador.findElement(By.xpath("//textarea[@title='Pesquisar']")).sendKeys("nttdata");
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//span[text()='NTT DATA Corporation']")).click();
        navegador.findElement(By.xpath("//h3[text()='NTT DATA Business Solutions']")).click();
        navegador.findElement(By.xpath("//button[@id='all']")).click();
        navegador.findElement(By.xpath("//*[@id=\"menu-item-32094\"]/a/span")).click();
        navegador.findElement(By.xpath("//button[@id='all']")).click();
        navegador.findElement(By.xpath("//a[text()='Junte-se a nossa equipe']")).click();
        ArrayList<String> tabs = new ArrayList<>(navegador.getWindowHandles());
        navegador.switchTo().window(tabs.get(1));
        Thread.sleep(25000);
        navegador.findElement(By.xpath("//*[@id='pesquisar-vaga-localidade-etc']")).sendKeys("Arquiteto");
        Thread.sleep(2000);
        String vaga = navegador.findElement(By.xpath("//div/h4[contains(text(),'Arquiteto(a) de Solução SAP - Manufatura')]")).getText();

        assertEquals( "Arquiteto(a) de Solução SAP - Manufatura",vaga);
    }



}
