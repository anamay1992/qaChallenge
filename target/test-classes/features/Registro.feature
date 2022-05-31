@challengeQA
Feature: Registrarse en el sistema 

Rule: Como usuario del sistema
      quiero ingresar mis datos
      para poder entrar al sistema

@registrar
Scenario: Registrarse en el sistema correctamente
Given como usuario del sistema ingreso al registro
When registrar mis datos
| elemento        | valor             |
| email.input     | prueba@prueba.com |
| password.input  | 123456            |
| register.button | click             |
| msg.label       | texto             |