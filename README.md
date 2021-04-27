# API - Challenge

Projeto de API REST utilizando conceitos de arquitetura limpa.

## Introdução

O objetivo principal do projeto é a implementação de uma API REST para validação de uma senha.
Para ser considerada válida, uma senha deve possuir os seguintes características:

* Nove ou mais caracteres;
* Ao menos 1 dígito;
* Ao menos 1 letra minúscula;
* Ao menos 1 letra maiúscula;
* Ao menos 1 caractere especial do conjunto: '!@#$%^&*()-+';
* Não possuir caracteres repetidos dentro do conjunto;

## Implementação

A API implementa conceitos da [arquitetura limpa](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), como referência:


* **Entities:** local onde objetos de domínio, regras de negócios, contratos de serviço e outras funções relacionadas à manipulação de dados do sistema estão localizados;
* **Infrastructure:** esponsável pela configuração de todos os __frameworks__ técnicos utilizados no projeto;.

* **Use cases:** objetos que representam uma ação dentro do sistema, realizam a orquestração do fluxo de dados, ou seja, direcionam os dados para aplicação da regra de negócio, validações e posteriormente para persistência;

* **Interface:** responsável pela comunicação entre entidades e componentes externos do aplicativo.
    * **Controller:** recebe entradas, converte-as no modelo de solicitação definido pelo interagente de caso de uso e passa para o mesmo;
    * **Gateways:** adaptadores de interface que permitem que que o serviço solicite serviços para clientes REST HTTP, Message Broker Client ou qualquer outrs API;

O projeto também aplicou os seguintes princípios SOLID para a construção do projeto:

* Principio da responsabilidade única: uma classe deve somente uma tarefa ou ação para realizar, exemplo: ```CheckPasswordUseCase```;
* Princípio da segregação da interface:  muitas interfaces específicas são melhores do que uma interface única, exemplo: ```UseCase```,```Input```,```Output```;
* Princípio da inversão da dependência: dependa de uma abstração e não de uma implementação: exemplo: ```SecurityController```.

Devido a quantidade de artefatos produzidos pelo projeto, outros princípios SOLID: "Princípio Aberto-Fechado" e "Princípio da Substituição de Liskov" não foram implementados integralmente.

O projeto utiza o [Spring Boot](https://spring.io/projects/spring-boot) para facilitar a configuração e execução da API. E o próprio framework [Spring](https://spring.io/) para implementação dos padrões de projeto inversão de controle e injeção de dependência.

## Regra de negócio

A regra de negócio foi aplicada no __Use Case__ ```CheckPasswordUseCase```. 
A validação da senha pode ser realizada através da utilização de exressões regulares, porém optei em utilizar recursos da próŕia linguagem java, para um código mais limpo.
## Pré-requisitos
* Java 9 (ou superior);
* Maven;

## Instruções para executar o projeto


### Compilando o projeto

```
mvn compile
```

### Executando os testes

```
mvn test
```

### Executando o projeto em linha de comando

```
mvn exec:java -Dexec.mainClass="com.challenge.ChallengeApplication"
```

### Executando o projeto pelo VS Code

Um arquivo ```launch.json``` foi criando na pasta ```.vscode```.

### Invocando a API

Através de um HTTP/REST Client (postman, Insomnia, curl, etc) invocar a API GET: ```http://localhost:8080/v1/itidigital/security/validate``` enviando o payload com a senha, no formato json: 

```json
{
  "password": "AbTp9!fok"
}
```