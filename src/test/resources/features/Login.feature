@challengeQA
Feature: Ingresar al sistema

Rule: Como usuario del sistema
      quiero ingresar mis datos
      para poder entrar al sistema

#@login
Scenario: Ingresar al sistema correctamente
Given como usuario del sistema ingreso al login
When ingresar mis datos
| elemento       | valor             |
| email.input    | prueba@prueba.com |
| password.input | 123456            |
| login.button   | click             |
| msg.label      | texto             |

#@login
Scenario: Ingresar al sistema con password incorrecto 
Given como usuario del sistema ingreso al login
When ingresar mis datos
| elemento       | valor             |
| email.input    | prueba@prueba.com |
| password.input | 1234567           |
| login.button   | click             |
| msg.label      | texto             |

@login
Scenario: Ingresar al sistema con correo incorrecto
Given como usuario del sistema ingreso al login
When ingresar mis datos
| elemento       | valor              |
| email.input    | prueba3@prueba.com |
| password.input | 123456             |
| login.button   | click              |
| msg.label      | texto              |
