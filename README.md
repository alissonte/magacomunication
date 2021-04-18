# Magalu App

Pequeno projeto simulando um agendamento de envio de notificações.

## 🚀 Começando

Primeiramente, clonar o projeto em algum caminho a sua escolha.
```
git clone https://github.com/alissonte/magacomunication.git
```

### 📋 Pré-requisitos

Necessários instalados na máquina host o **docker** e **docker-compose**

### 🔧 Instalação docker

* [Linux](https://docs.docker.com/engine/install/ubuntu/) - Procedimento de instalação no Linux ubuntu
* [Windows](https://docs.docker.com/docker-for-windows/install/) - Procedimento de instalação no Windows

## ⚙️ Executando o projeto

```
cd $PROJETO-CLONADO
docker-compose up -d
```

## ⚙️ Acessando o serviço
Foi adotado o padrão **Rest** e para melhor acesso e entendimento, foi utilizado o **Swagger**. Para acessar o serviço basta ir no browser e inseridor a URL
**http://localhost:8080/swagger-ui.html**. Uma tela, com as informações do serviço, deverá aparecer.

![image](https://user-images.githubusercontent.com/585455/115149723-c6937800-a03b-11eb-8d16-72222b95ecf6.png)

## 📦 Serviços

* GET: **/communication** - Consulta os envios.
![image](https://user-images.githubusercontent.com/585455/115149754-e9be2780-a03b-11eb-8bba-b73fae40e9f0.png)

* GET: **/communication/{id}** - Consulta um agendamento por ID.
![image](https://user-images.githubusercontent.com/585455/115149784-0f4b3100-a03c-11eb-9f69-0c48d539cd8f.png)

* GET: **/communication/recipient/{name}** - Consulta agendamento para um determinado destinatário.
![image](https://user-images.githubusercontent.com/585455/115149813-2853e200-a03c-11eb-9fa0-95f12b1569c5.png)

* POST: **/communication** - Salva um novo agendamento
![image](https://user-images.githubusercontent.com/585455/115149840-402b6600-a03c-11eb-8840-467b0a9c7b5f.png)

* PATCH: **/communication/cancel/{id}** - Cancela um agendamento
![image](https://user-images.githubusercontent.com/585455/115149868-651fd900-a03c-11eb-8ead-ef1a635f0959.png)

* PUT: **/communication/{id}** - Atualiza um agendamento
![image](https://user-images.githubusercontent.com/585455/115149893-7c5ec680-a03c-11eb-85de-1b0fc5989f9f.png)

* DELETE: **/communication/{id}** - Deleta um agendamento
![image](https://user-images.githubusercontent.com/585455/115149911-90a2c380-a03c-11eb-9049-ddfa7cb0cae4.png)

Para os métodos POST e PUT é necessário um body semelhante ao exemplo abaixo:
```javascript
{
  "Data/Hora": "20-04-2021 15:00:00", ==> Exemplo de Data.
  "Destinatário": "alisson", ==> Destinatário no qual a mensagem será enviada.
  "Id": 0, ==> Campo não é obrigatório no body.
  "Mensagem": "Mensagem a ser enviada", ==> Mensagem a ser enviada.
  "Status": "PENDING", ==> Status inicial do registro, esse campo não é obrigatório no body.
  "Tipo de Envio": "Email" ==> Tipo de envio, pode ser entre os 4 definidos no documento: SMS, Whatsapp, Email ou Push. Esse campo não é obrigatório no body.
}
```

---
⌨️ por [Alisson Rodrigues] 😊
