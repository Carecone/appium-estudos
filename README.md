### Instalação
Instalação do Appium server
```hash
npm install -g appium
```

### Configuração 
Antes de inciar um projeto, é preciso configurar as dependências que o appium tem(emulador do Android, sdk do Android, adb etc...), para isso o appium disponibiliza um script para verificar as dependências que estão faltando. </br>
Você pode executar o script sem instalar na sua máquina, utilizando o script abaixo:
```hash
npx appium-doctor
```
Caso dê algum erro, será preciso instalar antes de executar:
```hash
npm install -g appium-doctor
```
As configurações obrigatórios estarão dentro do ### Diagnostic for necessary dependencies starting ###. 
Após tudo configurado, podemos rodar nosso servidor do appium (Foi instalado o Appium server e não a versão desktop)

### Device
Criar um device no android studio para que possamos realizar os testes. O device não tem segredo, vai da necessidade ou do desempenho da sua máquina. 

### Driver utilizado
<a href="http://appium.io/docs/en/drivers/android-uiautomator2/index.html"> UiAutomator2 Driver</a>

### Políticas de segurança
Caso utilize o PowerShell, você não vai conseguir executar o Appium sem alterar a política de segurança. Como a política de segurança vem instalada com Default, que é restritiva e só executa scripts que são confiáveis, e como o appium não é um script confiável, precisamos mudar a política para Bypass, fazendo que o PowerShell execute apenas o que você pedir.
```hash
Set-ExecutionPolicy Bypass
```