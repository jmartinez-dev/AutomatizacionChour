To freeze dependencies


gherkin

`` 
gradled test
``


Faker

https://faker.readthedocs.io/en/stable/locales/es_CO.html


# Casos de uso
Cucumber - Gherkin 
## Escenario 1
**Funcionalidad**: Inicio de sesión en https://www.utest.com/

  Como usuario
  Quiero registrarme en la plataforma
  Para acceder a las funciones protegidas del sitio

  Escenario: Registro de cuenta exitoso
    Dado que estoy en la página de inicio de utest.com
    Cuando ingrese por el boton Join Today 
    Cuando ingreso mi primer nombre, apellido, correo, fecha de nacimiento
    Y hago clic en el botón Next:Location
    Entonces debería ver la página de direcciones "https://www.utest.com/signup/address"
    Cuando ingreso a el paso "Agrega tu dirección"
    Entonces el sistema lo autodetecta o ingreso los datos solicitados
    Y hago clic en el botón Next:Devices
    Entonces debería ver la página de direcciones "https://www.utest.com/signup/devices"
    Cuando ingrese a el paso "Cuéntanos sobre tus dispositivos"
    Entonces ingreso los datos solicitados
    Y hago clic en el botón Next:Last Step
    Entonces debería ver la página de direcciones "https://www.utest.com/signup/complete"
    Cuando ingrese a el paso "El último paso"
    Cuando complete la contraseña y confirme la contraseña
    y hago clic en aceptar terminos, condiciones y politicas
    Entonces mi usuario se deberia crear correctamente# Reto-QA-automat
