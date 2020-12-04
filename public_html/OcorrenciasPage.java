package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OcorrenciasPage extends BasePage {
    public OcorrenciasPage(WebDriver navegador) {
        super(navegador);
    }

    public OcorrenciasPage selecionarCriar() {

        //Sétima aplicação de espera explicita
        // wait7 = new WebDriverWait(navegador, 60);
        //wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdown-4']")));
        esperaExplicitaXPath("//button[@id='dropdown-4']");

        //Seleção do botão Criar com xpath="//button[@id='dropdown-4']"
        navegador.findElement(By.xpath("//button[@id='dropdown-4']")).click();

        return this;

    }

    public NovaOcorrenciaPage selecionarTipo(){

        //Seleção da opção Nova Ocorrência com link text
        navegador.findElement(By.linkText("Nova Ocorrência")).click();

        return new NovaOcorrenciaPage(navegador);

    }
}
