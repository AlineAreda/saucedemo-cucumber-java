@login
Feature: Login
  Como usuario
  Quero realizar login
  Para acessar a conta

  Background: Acessar a tela de login
    Given que eu esteja na tela de login

  @loginPositivo
  Scenario: Login com sucesso
    And preencher o usuario
    And preencher a senha
    When realizar o login
    Then login realizado com sucesso

  @loginNegativo @loginBlock
  Scenario: User bloqueado
    But preencher com usuario bloqueado
    And preencher a senha
    When realizar o login
    Then sistema deve exibir mensagem de usuario bloqueado

  @loginNegativo
  Scenario: Login com dados invalidos
    But preencher com usuario invalido
    And preencher a senha invalida
    When realizar o login
    Then sistema deve exibir mensagem de usuario e senha invalidos

  @loginNegativo
  Scenario: Login com dados em branco
    But nao preencher nenhum dado
    When realizar o login
    Then sistema deve exibir mensagem de dados em branco
