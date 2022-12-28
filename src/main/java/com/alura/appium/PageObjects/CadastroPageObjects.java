package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CadastroPageObjects {

    private AppiumDriver driver;
    private WebElement campoSenha;
    private WebElement campoNome;
    private WebElement campoConfirmarSenha;
    private WebElement botaoCadastrar;
    private WebElement mensagemErro;

    public CadastroPageObjects(AppiumDriver driver) {
        this.driver = driver;
    }

    public void BuscarElementos() {
        campoNome = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        campoSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        campoConfirmarSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        botaoCadastrar = driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao) {
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmacao);

    }

    public void Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
    }

    public String MensagemErro() {
        mensagemErro = driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro"));
        return mensagemErro.getText();
    }
}
