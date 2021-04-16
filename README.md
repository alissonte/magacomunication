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
Foi adotado o padrão **Rest** e para melhor acesso e entendimento, foi utilizado o **Swagger**. Para acessar o serviço basta acessar o endereço
**http://localhost:8080/swagger-ui.html** no browser. Irá abrir uma tela semelhante a essa abaixo:

![image](https://user-images.githubusercontent.com/585455/114957888-4b15a900-9e38-11eb-9a36-8d38e76a1996.png)

## 📦 Serviços

* GET: **/communication** - Consulta os envios.
* GET: **/communication/{id}** - Consulta um agendamento por ID.
* GET: **/communication/recipient/{name}** - Consulta agendamento para um determinado destinatário.
* POST: **/communication** - Salva um novo agendamento
* PUT: **/communication/{id}** - Cancela um agendamento
* DELETE: **/communication/{id}** - Deleta um agendamento

Para o metodo POST é necessário de um body correspondente, segue um exemplo:
```java
{
  "Data/Hora": "2021-04-16T01:25:14.447Z", ==> Exemplo de Data.
  "Destinatário": "alisson", ==> Destinatário no qual a mensagem será enviada.
  "Id": 0, ==> Não  necessário.
  "Mensagem": "Mensagem deve ser enviada em uma determinada data", ==> Mensagem a ser enviada.
  "Status": "PENDING", ==> Status inicial do registro, esse campo não é obrigatório.
  "Tipo de Envio": "Email" ==> Tipo de envio, pode ser entre os 4 definidos no documento: SMS, Whatsapp, Email ou Push. Esse campo não é obrigatório.
}
```

---
⌨️ por [Alisson Rodrigues] 😊
