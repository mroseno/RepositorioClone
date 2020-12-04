package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ResumoOcorrenciaPage;
import suporte.Web;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

//Utilização da anotação RunWith
//Utilização da biblioteca easytest - DataDrivenTestRunner
@RunWith(DataDrivenTestRunner.class)

//Utilização da anotação DataLoader
//filePath - arquivo onde será o repositório dos dados dos testes
//Utilização do arquivo csv para guardar os dados dos testes
@DataLoader(filePaths = "test4Data.csv") //Recomendado utilizar o nome da classe

public class testPageObjects {

    //Declaração de variaveis globais
    private WebDriver navegador;

    //Utilização da anotação Before
    //Before - antes: comandos que serão executados antes dos testes
    @Before
    public void SetUp(){

        //Atribuição da variavel navegador ao método de iniciar o Chrome
        navegador = Web.createBrowserStack();

        //navegador = Web.createBrowserStack();

    }

    //Utilização da anotação Test
    //Cada anotação Test é responsável por rodar um caso de teste
    //Nomear de acordo com o teste que será executado
    @Test
    //Utilização da anotação Param para informar os dados das colunas do arquivo csv
    public void testadicionarIssue(@Param(name="preenchimentoEmail")String preencherEmail,
                                   @Param(name="preenchimentoSenha")String preencherSenha,
                                   @Param(name="escolhaCliente")String escolherCliente,
                                   @Param(name="selecaoProjeto")String selecionarProjeto2,
                                   @Param(name="preenchimentoTitulo")String preencherTitulo2,
                                   @Param(name="selecaoDisciplina")String selecionarDisciplina2,
                                   @Param(name="selecaoFase")String selecionarFase2,
                                   @Param(name="selecaoAtribuicao")String selecionarAtribuicao2,
                                   @Param(name="preenchimentoDescricao")String preencerDescricao2,
                                   @Param(name="preenchimentoData")String preencherData2,
                                   @Param(name="validacaoTitulo")String validarTitulo2,
                                   @Param(name="validacaoProjeto")String validarProjeto2,
                                   @Param(name="validacaoPrioridade")String validarPrioridade2,
                                   @Param(name="validacaoPerfil")String validarPerfil2,
                                   @Param(name="validacaoFase")String validarFase2,
                                   @Param(name="validacaoAtribuicao")String validarAtribuicao2,
                                   @Param(name="validacaoDescricao")String validarDescricao2,
                                   @Param(name="validacaoData")String validarData2)
    {

        //Execução método estrutural
        new LoginPage(navegador)
                .fecharModalAvisoInicial()
                .digitarEmail(preencherEmail)
                .digitarSenha(preencherSenha)
                .clicarLogin()
                .escolherCliente(escolherCliente)
                .clicarAcessar()
                .fecharModalTutorialVideo()
                .clicarMenu()
                .selecionar4Collab()
                .selecionarOcorrencias()
                .selecionarCriar()
                .selecionarTipo()
                .selecionarProjeto(selecionarProjeto2)
                .preencherTitulo(preencherTitulo2)
                .selecionarDisciplina(selecionarDisciplina2)
                .selecionarFase(selecionarFase2)
                .selecionarAtribuicao(selecionarAtribuicao2)
                .preencerDescricao(preencerDescricao2)
                .preencherData(preencherData2)
                .clicarSalvarOcorrencia();

        //Validação do título através do método capturarTituloOcorrencia
        String validarTitulo = new ResumoOcorrenciaPage(navegador)
                .capturarTituloOcorrencia();
        assertEquals(validarTitulo, validarTitulo2);

        //Validação do projeto através do método capturarProjetoOcorrencia
        String validarProjeto = new ResumoOcorrenciaPage(navegador)
                .capturarProjetoOcorrencia();
        assertEquals(validarProjeto, validarProjeto2);

        //Validação da prioridade através do método capturarPrioridadeOcorrencia
        String validarPrioridade = new ResumoOcorrenciaPage(navegador)
                .capturarPrioridadeOcorrencia();
        assertEquals(validarPrioridade, validarPrioridade2);

        //Validação do perfil de disciplina através do método capturarPerfilDisci
        String validarPerfilDisci = new ResumoOcorrenciaPage(navegador)
                .capturarPerfilDisci();
        assertEquals(validarPerfilDisci, validarPerfil2);

        //Validação da fase através do método capturarFase
        String validarFase = new ResumoOcorrenciaPage(navegador)
                .capturarFase();
        assertEquals(validarFase, validarFase2);

        //Validação da atribuição através do método capturarAtribuicao
        String validarAtribuicao = new ResumoOcorrenciaPage(navegador)
                .capturarAtribuicao();
        assertEquals(validarAtribuicao, validarAtribuicao2);

        //Validação da descrição através do método capturarDescricao
        String validarDescricao = new ResumoOcorrenciaPage(navegador)
                .capturarDescricao();
        assertEquals(validarDescricao, validarDescricao2);

        //Validação da data Responder até através do método capturarData
        String validarData = new ResumoOcorrenciaPage(navegador)
                .capturarData();
        assertEquals(validarData, validarData2);

        //Execução método funcional
        //new LoginPage(navegador)
        //        .fecharModalAvisoInicial()
        //        .fazerLogin("lsantos@autodoc.com.br","Tri8952!")

        //Execução método funcional com estrutual
        //new LoginPage(navegador)
        //        .fecharModalAvisoInicial()
        //        .fazerLogin2("lsantos@autodoc.com.br","Tri8952!")
        //        .acessar("_Administradores")
        //        .fecharModalTutorialVideo();

    }

    //Utilização da anotação After
    //After - depois: comandos que serão executados depois dos testes
    //@After
    //public void tearDown() {

    //Fechar o navegador
    //navegador.quit();

    //}

}
