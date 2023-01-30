#Seja Bem-Vindo a API-REST-JAVA!

<br />
<p align="center">
    <img src='./src/main/java/br/com/teste/apirestjava/assets/logo.png' alt="Logo" width="200">

  <h3 align="center"></h3>
 <br />
  <p align="center">
     Sumário
      <p align="center">
  <a href="#sobre"> Sobre </a> |
  <a href="#conhecimentos-praticados"> Conhecimentos Praticados </a> |
  <a href="#rodando-o-projeto"> Rodando o Projeto </a> |
  <a href="#desenvolvido-por"> Desenvolvido por </a> |
  <a href="#observações"> Observações </a>       
       <br />
    <br />
    <h1 align="center">
 </h1>
  </p>
</p>

Este projeto foi iniciado com [Spring Boot](https://start.spring.io/).

## Sobre

Este projeto foi desenvolvido durante um curso que eu concluí no meu estágio de programação. Foi minha primeira API com Spring Boot.

## Conhecimentos Praticados

✔ Java <br>
✔ Spring Boot 
✔ MVC <br>
✔ DTO <br>

## Rodando o Projeto
- Utilize o Git Clone no repositório.
- Abra o projeto no Vs Code
- Certifique-se de instalar todas as dependências no arquivo pom.xml
- E de ter instalado essas extensões: Java Extension Pack e Spring Boot Extension Pack.
- Crie uma pasta .vscode fora da pasta raiz do projeto
- Crie um arquivo chamado launch.json
- Dentro deste arquivo insira este trecho de código:
```javascript
{
  "configurations": [
    {
      "type": "java",
      "name": "Spring Boot-ApiRestJavaApplication<api-rest-java>",
      "request": "launch",
      "cwd": "${workspaceFolder}",
      "mainClass": "br.com.teste.apirestjava.ApiRestJavaApplication",
      "projectName": "api-rest-java",
      "args": "",
      "envFile": "${workspaceFolder}/.env",
      "env": {
        "DB_CHECK_LEARNING_URL": "URL DO BANCO DE DADOS",
        "DB_USERNAME": "NOME DE LOGIN NO SEU BANCO DE DADOS",
        "DB_PASSWORD": "SENHA DO SEU BANCO DE DADOS"
      }
    }
  ]
}
```
- Isso vai garantir que a API funcione com as variáveis de ambiente definidas no application.properties

- Agora é só rodar a aplicação no dashboard do Spring Boot 

<img src="./src/main/java/br/com/teste/apirestjava/assets/springRun.png"/>

## Desenvolvido por

- [Cibele Martins](https://github.com/CibeleMartins)

## Observações

Este projeto está sujeito à novas implementações. Sinta-se a vontade para explorar todo seu conhecimento utilizando este projeto, qualquer dúvida ou sugestão me procure no <a href='www.linkedin.com/in/cibelemartinssss'>Linkedin</a>.