package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResumoOcorrenciaPage extends BasePage {
    public ResumoOcorrenciaPage(WebDriver navegador) {
        super(navegador);
    }

    public String capturarTituloOcorrencia() {

        //Nona aplicação de espera explícita
        //WebDriverWait wait9 = new WebDriverWait(navegador, 60);
        //wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("AbaResumo")));
        esperaExplicitaID("AbaResumo");

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//div[@id='AbaResumo']/div/div/child::h5")).getText();

    }

    public String capturarProjetoOcorrencia() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Projeto:')]/following-sibling::p")).getText();

    }

    public String capturarPrioridadeOcorrencia() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Prioridade:')]/following-sibling::p")).getText();

    }

    public String capturarPerfilDisci() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Perfil de Disciplina:')]/following-sibling::p")).getText();

    }

    public String capturarFase() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Fase:')]/following-sibling::p")).getText();

    }

    public String capturarAtribuicao() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Atribuição:')]/following-sibling::p")).getText();

    }

    public String capturarDescricao() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Descrição:')]/following-sibling::p")).getText();

    }

    public String capturarData() {

        return navegador.findElement(By.id("AbaResumo"))
                .findElement(By.xpath("//span[contains(text(),'Responder até:')]/following-sibling::p")).getText();

    }



}
