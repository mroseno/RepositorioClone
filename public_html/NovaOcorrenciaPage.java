package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovaOcorrenciaPage extends BasePage {
    public NovaOcorrenciaPage(WebDriver navegador) {
        super(navegador);
    }

    public NovaOcorrenciaPage selecionarProjeto(String projeto){

        //Oitava aplicação de espera explícita
        //WebDriverWait wait8 = new WebDriverWait(navegador, 60);
        //wait8.until(ExpectedConditions.elementToBeClickable(By.id("IdProjeto")));
        esperaExplicitaID("IdProjeto");

        WebElement selecaoProjeto = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("IdProjeto"));
        new Select(selecaoProjeto).selectByVisibleText(projeto);

        return this;
    }

    public NovaOcorrenciaPage preencherTitulo(String titulo){

        navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("Titulo")).sendKeys(titulo);

        return this;

    }

    public NovaOcorrenciaPage selecionarDisciplina(String disciplina){

        WebElement perfilDisciplina = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("IdPerfilDisciplina"));
        new Select(perfilDisciplina).selectByVisibleText(disciplina);

        return this;

    }

    public NovaOcorrenciaPage selecionarFase(String fase){

        WebElement fase2 = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("IdFase"));
        new Select(fase2).selectByVisibleText(fase);

        return this;

    }

    public NovaOcorrenciaPage selecionarAtribuicao(String atribuicao){

        WebElement atribuidoPara = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("IdUsuarioAtribuido"));
        new Select(atribuidoPara).selectByVisibleText(atribuicao);

        return this;

    }

    public NovaOcorrenciaPage preencerDescricao(String descricao){

        navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("Descricao")).sendKeys(descricao);

        return this;
    }

    public NovaOcorrenciaPage preencherData(String data){

        //Criação de uma instacia de JavaScript
        JavascriptExecutor je = (JavascriptExecutor) navegador;

        //Identificação do WebElement que irá aparecer após realizar o scroll
        WebElement dataResponderAte = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.id("DataResponder"));

        //Execução da query que realizará o scroll até o element aparecer na pagina
        je.executeScript("arguments[0].scrollIntoView(true);",dataResponderAte);

        //Preencher uma data no campo de data "Responder até" com id="DataResponder"
        navegador.findElement(By.id("DataResponder")).sendKeys(data);

        return this;

    }

    public ResumoOcorrenciaPage clicarSalvarOcorrencia(){

        navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"))
                .findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();

        return new ResumoOcorrenciaPage(navegador);

    }
}
