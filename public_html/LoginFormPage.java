package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormPage extends BasePage{
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarEmail(String email) {

        navegador.findElement(By.id("loginForm")).findElement(By.id("Email"))
                .sendKeys(email);

        //retornar pagina atual
        return this;

    }

    public LoginFormPage digitarSenha(String senha) {

        navegador.findElement(By.id("loginForm")).findElement(By.id("Senha"))
                .sendKeys(senha);

        //retornar pagina atual
        return this;

    }

    public EscolherClientePage clicarLogin() {

        //Segunda aplicação de espera explicita
        //WebDriverWait wait2 = new WebDriverWait(navegador, 60);
        //wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
        esperaExplicitaXPath("//button[contains(text(),'Login')]");

        navegador.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //return para uma nova página
        return new EscolherClientePage(navegador);

    }

    //-----MÉTODO EM FORMA FUNCIONAL------//
    //Um método só para todos os passos
    //public EscolherClientePage fazerLogin(String email, String senha) {

    //    navegador.findElement(By.id("loginForm")).findElement(By.id("Email"))
    //            .sendKeys(email);
    //    navegador.findElement(By.id("loginForm")).findElement(By.id("Senha"))
    //            .sendKeys(senha);
    //    navegador.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

    //    return new EscolherClientePage(navegador);

    //}

    //-------UTILIZAÇÃO DE MÉTODO ESTRUTURAL COM FUNCIONAL-------//
   //public EscolherClientePage fazerLogin2(String email, String senha) {

    //    digitarEmail(email);
    //    digitarSenha(senha);
    //    clicarLogin();

    //    return clicarLogin();

    //}
}
