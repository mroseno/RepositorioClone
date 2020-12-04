package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//public class LoginPage {

    //Proriedade disponivel dentro dessa classe (private)
//    private WebDriver navegador;

    //Declaração de construtor
//    public LoginPage(WebDriver navegador) {

//        this.navegador = navegador;

//    }

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    //-----MÉTODO EM FORMA ESTRUTUAL------//
    //Criação de um método para cada ação-campo

    //public LoginPage fecharModalAvisoInicial() {

    //    //Identificação do WebElement do modal "Avisos" com id="dialog_Avisos"
    //    //Fechar modal avisos com o botão Fechar com xpath="//button[@class='btn btn-primary']"
    //     WebElement avisoFechar = navegador.findElement(By.id("dialog_Avisos"));
    //    avisoFechar.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    //    return this;

    //}

    public LoginFormPage fecharModalAvisoInicial(){

        //Primeira aplicação de espera explicita
        //WebDriverWait wait1 = new WebDriverWait(navegador, 60);
        //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog_Avisos")));
        //esperaExplicitaID("dialog_Avisos");
        esperaExplicitaCliclableID("dialog_Avisos");

        //Identificação do WebElement do modal "Avisos" com id="dialog_Avisos"
        //Fechar modal avisos com o botão Fechar com xpath="//button[@class='btn btn-primary']"
        WebElement avisoFechar = navegador.findElement(By.id("dialog_Avisos"));
        avisoFechar.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        return new LoginFormPage(navegador);

    }
}
