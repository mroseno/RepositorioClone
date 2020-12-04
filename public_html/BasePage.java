package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //Propriedade disponivel para classe que utilizam extends
    //Protected eprmite utilização nas classes filhos (extends)
    protected WebDriver navegador;

    public BasePage(WebDriver navegador) {

        this.navegador = navegador;

    }

    public void esperaExplicitaID (String espera) {

        WebDriverWait wait = new WebDriverWait(navegador, 180);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(espera)));

    }

    public void esperaExplicitaCliclableID (String espera) {

        WebDriverWait wait = new WebDriverWait(navegador, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(espera)));

    }

    public void esperaExplicitaXPath (String espera) {

        WebDriverWait wait = new WebDriverWait(navegador, 180);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(espera)));

    }

    public void esperaExplicitaCliclableXPath (String espera) {

        WebDriverWait wait = new WebDriverWait(navegador, 180);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(espera)));

    }

}
