package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends PageObjectBase{

    private WebElement botaoCadastro;
    private final By botaoCadastrar;
    public LoginPageObject(AppiumDriver driver){
        super(driver);
        botaoCadastrar = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void BuscarElementos() {
        botaoCadastro = driver.findElement(botaoCadastrar);
    }

    public CadastroPageObjects IrParaTelaDeCadastro(){
        botaoCadastro.click();
        return new CadastroPageObjects(this.driver);
    }
}
