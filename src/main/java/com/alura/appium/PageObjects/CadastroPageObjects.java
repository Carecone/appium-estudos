package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CadastroPageObjects extends PageObjectBase {

    private WebElement campoSenha;
    private WebElement campoNome;
    private WebElement campoConfirmarSenha;
    private WebElement botaoCadastrar;
    private WebElement mensagemErro;
    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmacaoID;
    private final By campoCadastroID;

    public CadastroPageObjects(AppiumDriver driver) {
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoCadastroID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        campoNome = driver.findElement((campoNomeID));
        campoSenha = driver.findElement(campoSenhaID);
        campoConfirmarSenha = driver.findElement(campoConfirmacaoID);
        botaoCadastrar = driver.findElement(campoCadastroID);
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao) {
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmacao);

    }

    public LoginPageObject  Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(this.driver);
    }

    public String MensagemErro() {
        mensagemErro = driver.findElement(erroID);
        return mensagemErro.getText();
    }
}
