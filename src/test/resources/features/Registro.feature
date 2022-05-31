@challengeQA
Feature: Registrarse en el sistema 

Rule: Como usuario del sistema
      quiero ingresar mis datos
      para poder entrar al sistema

#@registrar
Scenario: Registrarse en el sistema correctamente
Given como usuario del sistema ingreso al registro
When registrar mis datos
| elemento        | valor             |
| email.input     | prueba@prueba.com |
| password.input  | 123456            |
| register.button | click             |
| msg.label       | texto             |

#@registrar
Scenario: Registrarse en el sistema con contraseña incorrecta
Given como usuario del sistema ingreso al registro
When registrar mis datos
| elemento        | valor              |
| email.input     | prueba2@prueba.com |
| password.input  | 1234               |
| register.button | click              |
| msg.label       | texto              |

@registrar
Scenario: Registrarse en el sistema con correo incorrecto
Given como usuario del sistema ingreso al registro
When registrar mis datos
| elemento        | valor              |
| email.input     | prueba2prueba.com  |
| password.input  | 12345              |
| register.button | click              |
| msg.label       | texto              |
