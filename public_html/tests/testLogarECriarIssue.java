package tests;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class testLogarECriarIssue {

    //Declaração de variaveis globais
    WebDriver navegador;

    //Utilização da anotação Before
    //Before - antes: comandos que serão executados antes dos testes
    @Before
    public void SetUp(){

        //Abrir o Navegador Google Chrome
        System.setProperty("webdriver.chrome.driver", "F:\\Projetos Selenium\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();

        //Abrir o Navegador Mozila Firefox
        //System.setProperty("webdriver.gecko.driver", "F:\\Projetos Selenium\\Drivers\\geckodriver.exe");
        //navegador = new FirefoxDriver();

        //Maximizar a janela do navegador
        navegador.manage().window().maximize();

        //Acesso a página do Projetos
        navegador.get("https://homolog.autodoc.com.br/projetos3-v3/Login/");

        //Clicar no botão que possui o id="details-button" - Chrome apenas
        navegador.findElement(By.id("details-button")).click();

        //Clicar no botão que possui o id="proceed-link" - Chrome apenas
        navegador.findElement(By.id("proceed-link")).click();

        //Primeira aplicação de espera explicita
        WebDriverWait wait1 = new WebDriverWait(navegador, 60);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog_Avisos")));

        //Identificação do WebElement do modal "Avisos" com id="dialog_Avisos"
        //Fechar modal avisos com o botão Fechar com xpath="//button[@class='btn btn-primary']"
        WebElement avisoFechar = navegador.findElement(By.id("dialog_Avisos"));
        avisoFechar.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }

    //Utilização da anotação Test
    //Cada anotação Test é responsável por rodar um caso de teste
    //Nomear de acordo com o teste que será executado
    @Test
    public void logarNoProjetosEAdicionarIssue(){

        //Login

        //Identificação do formulário de login com id="loginForm"
        WebElement formularioLogin = navegador.findElement(By.id("loginForm"));

        //Preenchimento das informações de login utilizando WebElement do formulário
        formularioLogin.findElement(By.id("Email")).sendKeys("lsantos@autodoc.com.br");
        formularioLogin.findElement(By.id("Senha")).sendKeys("Tri8952!");
        formularioLogin.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //Confirmação do Cliente à Acessar

        //Segunda aplicação de espera explicita
        WebDriverWait wait2 = new WebDriverWait(navegador, 60);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("idEscolhaCliente")));

        //Escolha do cliente no combobox Clientes com id="idEscolhaCliente"
        WebElement escolherCliente = navegador.findElement(By.id("idEscolhaCliente"));
        //Cliente _Administradores
        new Select(escolherCliente).selectByVisibleText("_Administradores");

        //Terceira aplicação de espera explicita
        WebDriverWait wait3 = new WebDriverWait(navegador, 60);
        wait3.until(ExpectedConditions.elementToBeClickable(By.id("btnAcessar")));

        //Seleção do botão Acessar com id="btnAcessar"
        navegador.findElement(By.id("btnAcessar")).click();

        //Tela Inicial - Home

        //Quarta aplicação de espera explicita
        WebDriverWait wait4 = new WebDriverWait(navegador, 180);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalTutorialVideo']")));

        //Fechar modal de avisos
        navegador.findElement(By.xpath("//button[@class='close']")).click();

        //Seleção do menu "hamburguer" com xpath="//button[@class='close']"
        WebElement menu = navegador.findElement(By.id("mobile-collapse"));
        menu.click();

        //Seleção do módulo 4COLLAB
        menu.findElement(By.xpath("//span[contains(.,'4COLLAB')]")).click();

        //Quinta aplicação de espera explicita
        WebDriverWait wait5 = new WebDriverWait(navegador, 60);
        wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Ocorrências')]")));

        //Seleção da opção Ocorrências do módulo 4COLLAB
        menu.findElement(By.xpath("//span[contains(text(),'Ocorrências')]")).click();

        //Módulo Ocorrências - 4Collab

        //Sexta aplicação de espera explicita
        WebDriverWait wait6 = new WebDriverWait(navegador, 60);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdown-4']")));

        //Seleção do botão Criar com xpath="//button[@id='dropdown-4']"
        navegador.findElement(By.xpath("//button[@id='dropdown-4']")).click();

        //Seleção da opção Nova Ocorrência com link text
        navegador.findElement(By.linkText("Nova Ocorrência")).click();

        //Modal Criar Nova Ocorrência

        //Sétima aplicação de espera explícita
        WebDriverWait wait7 = new WebDriverWait(navegador, 60);
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalFormularioOcorrecia']")));

        //Declaração do WebElement do Modal Nova Ocorrência
        //Indentificação do modal nova ocorrencia com o xpath="//div[@id='modalFormularioOcorrecia']"
        WebElement modalNovaIssue = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"));

        //Seleção de um projeto do combobox Projeto* com o id="IdProjeto"
        //Utilização da classe Select para o combobox
        WebElement selecaoProjeto = modalNovaIssue.findElement(By.id("IdProjeto"));
        new Select(selecaoProjeto).selectByVisibleText("_RONDAO03");

        //Preenchimento de texto do campo de texto Titulo* com o id="Titulo*"
        modalNovaIssue.findElement(By.id("Titulo")).sendKeys("Teste Automatizado 01");

        //Seleção de um perfil de disc do combobox Perfil de Disciplina* com o id="IdPerfilDisciplina"
        //Utilização da classe Select para o combobox
        WebElement perfilDisciplina = modalNovaIssue.findElement(By.id("IdPerfilDisciplina"));
        new Select(perfilDisciplina).selectByVisibleText("DEVELOPER");

        //Seleção de uma fase do combobox Fase* com o id="IdFase"
        //Utilização da classe Select para o combobox
        WebElement fase = modalNovaIssue.findElement(By.id("IdFase"));
        new Select(fase).selectByVisibleText("01.Teste Migração");

        //Seleção de atribuição do combobox Atribuído para* com id="IdUsuarioAtribuido"
        //Utilização da classe Select para o combobox
        WebElement atribuidoPara = modalNovaIssue.findElement(By.id("IdUsuarioAtribuido"));
        new Select(atribuidoPara).selectByVisibleText("Administrador");

        //Preenchimento de texto do campo de texto Descrição* com id="Descricao"
        modalNovaIssue.findElement(By.id("Descricao")).sendKeys("Descrição teste auto 01");

        //Criação de uma instacia de JavaScript
        JavascriptExecutor je = (JavascriptExecutor) navegador;

        //Identificação do WebElement que irá aparecer após realizar o scroll
        WebElement dataResonderAte = modalNovaIssue.findElement(By.id("DataResponder"));

        //Execução da query que realizará o scroll até o element aparecer na pagina
        je.executeScript("arguments[0].scrollIntoView(true);",dataResonderAte);

        //Preencher uma data no campo de data "Responder até" com id="DataResponder"
        modalNovaIssue.findElement(By.id("DataResponder")).sendKeys("02/10/2020");

        //Seleção do botão Salvar com xpath="//button[contains(text(),'Salvar')]"
        modalNovaIssue.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();

        //Modal do Resumo da Ocorrência
        //Validação

        //Oitava aplicação de espera explícita
        WebDriverWait wait8 = new WebDriverWait(navegador, 60);
        wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("AbaResumo")));

        //Identificação do modal Resumo com o id="AbaResumo"
        WebElement modalResumo = navegador.findElement(By.id("AbaResumo"));

        //Validação do Titulo da ocorrência com xpath="//h5[contains(text(),'Teste Automatizado 01')]"
        WebElement titulo = modalResumo.findElement(By.xpath("//h5[contains(text(),'Teste Automatizado 01')]"));
        String validartitulo = titulo.getText();
        assertEquals("Teste Automatizado 01", validartitulo);

        //Validação do Projeto da ocorrência com xpath="//p[contains(text(),'_RONDAO03')]"
        WebElement projeto = modalResumo.findElement(By.xpath("//p[contains(text(),'_RONDAO03')]"));
        String validarProjeto = projeto.getText();
        assertEquals("_RONDAO03", validarProjeto);

        //Validação da Prioridade da ocorrência com xpath="//p[contains(text(),'Normal')]"
        WebElement prioridade = modalResumo.findElement(By.xpath("//p[contains(text(),'Normal')]"));
        String validarPrioridade = prioridade.getText();
        assertEquals("Normal",validarPrioridade);

        //Validação do Perfil de Disciplina da ocorrência com xpath="//p[contains(text(),'DEVELOPER')]"
        WebElement perfilDisc = modalResumo.findElement(By.xpath("//p[contains(text(),'DEVELOPER')]"));
        String validarPefil = perfilDisc.getText();
        assertEquals("DEVELOPER", validarPefil);

        //Validação da Fase da ocorrência com xpath="//p[contains(text(),'01.Teste Migração')]"
        WebElement fase2 = modalResumo.findElement(By.xpath("//p[contains(text(),'01.Teste Migração')]"));
        String validarFase = fase2.getText();
        assertEquals("01.Teste Migração", validarFase);

        //Validação do Atribuído para da ocorrência com xpath="//p[contains(text(),'Administrador')]"
        WebElement atribuicao = modalResumo.findElement(By.xpath("//p[contains(text(),'Administrador')]"));
        String validarAtribuicao = atribuicao.getText();
        assertEquals("Administrador", validarAtribuicao);

        //Validação da Descrição da ocorrência com xpath="//p[contains(text(),'Descrição teste auto 01')]"
        WebElement descricao = modalResumo.findElement(By.xpath("//p[contains(text(),'Descrição teste auto 01')]"));
        String validarDescricao = descricao.getText();
        assertEquals("Descrição teste auto 01", validarDescricao);

        //Validação da data Responder até da ocorrência com xpath="//body/div[@id='modalResumoAcao']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[5]/div[1]/p[1]"
        WebElement responderAte = modalResumo.findElement(By.xpath("//body/div[@id='modalResumoAcao']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[5]/div[1]/p[1]"));
        String validarData = responderAte.getText();
        assertEquals("02/10/2020", validarData);

        //
        //WebElement modalOcorrencia = navegador.findElement(By.id("modalResumoAcao"));

        //Captura do código da Ocorrência utilizando String
        //WebElement codigoOcorrencia = modalOcorrencia.findElement(By)

        //Fechar modal Resumo selecionando 'X' com xpath="//span[contains(text(),'×')]"
        //modalResumo.findElement(By.xpath("//span[contains(text(),'×')]")).click();

        //Listagem da Ocorrencia

        //Nona aplicação de espera explicita
        //WebDriverWait wait9 = new WebDriverWait(navegador,60);
        //wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdown-4']")));

        //Validação da listagem da nova ocorrência Teste Automatizado 01
        //WebElement listagemOcorrencias = navegador.findElement(By.xpath("id=\"_4collab-table-list_wrapper\""));

    }

    //Utilização da anotação After
    //After - depois: comandos que serão executados depois dos testes
    //@After
    //public void tearDown() {

        //Fechar o navegador
        //navegador.quit();

    //}
}
