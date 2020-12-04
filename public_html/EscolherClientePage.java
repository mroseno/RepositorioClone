package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EscolherClientePage extends BasePage {

    //Declaração de construtor
    public EscolherClientePage(WebDriver navegador){

        super(navegador);

    }

    public EscolherClientePage escolherCliente(String cliente){

        //Terceira aplicação de espera explicita
        WebDriverWait wait3 = new WebDriverWait(navegador, 60);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("idEscolhaCliente")));

        //Escolha do cliente no combobox Clientes com id="idEscolhaCliente"
        WebElement escolheCliente = navegador.findElement(By.id("form_clientes"))
                .findElement(By.id("idEscolhaCliente"));
        new Select(escolheCliente).selectByVisibleText(cliente);

       return this;

    }

    public HomePage clicarAcessar(){

        //Quarta aplicação de espera explicita
        WebDriverWait wait4 = new WebDriverWait(navegador, 60);
        wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnAcessar")));
        //esperarElement(navegador.findElement(By.id("btnAcessar")));

        navegador.findElement(By.id("btnAcessar")).click();

        return new HomePage(navegador);

    }
    //public HomePage acessar(String cliente){

    //    escolherCliente(cliente);
    //    clicarAcessar();

    //    return clicarAcessar();

    //}
}
