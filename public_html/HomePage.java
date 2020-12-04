package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public HomePage fecharModalTutorialVideo() {

        //Quinta aplicação de espera explicita
        //WebDriverWait wait5 = new WebDriverWait(navegador, 180);
        //wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalTutorialVideo']")));
        //esperaExplicitaXPath("//div[@id='modalTutorialVideo']");
        esperaExplicitaCliclableXPath("//button[@class='close']");

        //Fechar modal de avisos
        navegador.findElement(By.xpath("//button[@class='close']")).click();

        return this;

    }

    public HomePage clicarMenu() {

        //Seleção do menu "hamburguer" com xpath="//button[@class='close']"
        navegador.findElement(By.id("mobile-collapse")).click();

        return this;

    }

    public HomePage selecionar4Collab() {

        //Seleção do módulo 4COLLAB
        navegador.findElement(By.xpath("//span[contains(.,'4COLLAB')]")).click();

        return this;

    }

    public OcorrenciasPage selecionarOcorrencias() {

        //Sexta aplicação de espera explicita
        //WebDriverWait wait6 = new WebDriverWait(navegador, 60);
        //wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Ocorrências')]")));
        //esperaExplicitaXPath("//span[contains(text(),'Ocorrências')]");
        esperaExplicitaCliclableXPath("//span[contains(text(),'Ocorrências')]");

        //Seleção da opção Ocorrências do módulo 4COLLAB
        navegador.findElement(By.xpath("//span[contains(text(),'Ocorrências')]")).click();

        return new OcorrenciasPage(navegador);

    }

}
