package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

    //
    @FindBy(how = How.ID, using = "home")

    //Declaração de variaveis globais
    private WebElement home;
    public static WebDriver navegador;

    //Gerador de data e hora
    public static String dataHoraParaArquivo() {

    //Variavel para gravar data e hora no arquivo
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //Descrição do formato da data
        return new SimpleDateFormat("yyyyMMddhhss").format(ts);

    }

    //Método para Re-uso de esperas explicitas
    //public static WebElement esperarElement(WebElement esperaDoElement) {
    //    WebDriverWait esperar = new WebDriverWait(navegador,180);
    //    WebElement element =  esperar.until(ExpectedConditions.visibilityOf(esperaDoElement));
    //    return element;
    //}

}
