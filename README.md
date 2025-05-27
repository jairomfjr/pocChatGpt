# 🤖 Integração ChatGPT com Java Spring Boot

Este projeto demonstra como integrar a **API ChatGPT (OpenAI)** em uma aplicação **Java Spring Boot**, utilizando duas abordagens:

- `RestTemplate` (modo síncrono)
- `WebClient` (modo reativo/assíncrono)

---

## 📦 Funcionalidades Implementadas

✅ Integração com API OpenAI  
✅ Envio de perguntas e recebimento de respostas do ChatGPT  
✅ Suporte a comunicação síncrona (RestTemplate)  
✅ Suporte a comunicação assíncrona (WebClient / Reactor)  
✅ Configuração externa via `application.yml`  
✅ Arquitetura com `controller`, `service`, `dto` e `config`  
✅ Testes unitários com JUnit e Mockito  
✅ Suporte a Java 17 e Spring Boot 3.2.x  

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Web / WebFlux
- WebClient
- RestTemplate
- JUnit 5
- Mockito
- Lombok *(opcional)*
- Maven

---

## 🚀 Como Executar

### 1. Clone ou extraia o projeto

```bash
git clone https://seu-repo.git
cd chatgpt-integration
```

### 2. Configure sua API Key da OpenAI

Abra o arquivo:

```yaml
src/main/resources/application.yml
```

E adicione sua chave:

```yaml
openai:
  api-key: sua-chave-aqui
```

> 🔐 Você pode obter a chave em: https://platform.openai.com/account/api-keys

---

### 3. Compile e execute

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 📡 Endpoints Disponíveis

### ✅ Síncrono com `RestTemplate`

```
GET /chat/sync?pergunta=O que é inteligência artificial?
```

### ✅ Assíncrono com `WebClient`

```
GET /chat/async?pergunta=Explique o que é Java Spring Boot
```

---

## 🧪 Testes

O projeto já inclui um teste unitário básico para o serviço ChatGptService:

```bash
./mvnw test
```

---

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/example/chatgpt/
│   │   ├── config/          # Configuração da API e WebClient
│   │   ├── controller/      # Endpoints REST
│   │   ├── dto/             # Objetos de requisição e resposta
│   │   ├── service/         # Lógica de integração com a OpenAI
│   │   └── ChatGptApplication.java
│   └── resources/
│       └── application.yml  # Configuração da API Key
└── test/
    └── java/com/example/chatgpt/service/ChatGptServiceTest.java
```

---

## 📋 Requisitos

- Java 17 ou superior
- Maven 3.6+
- Conta na OpenAI com chave da API válida

---

## 📄 Licença

Este projeto é de uso livre para fins educacionais e profissionais.

---

## ✍️ Autor

Desenvolvido por Jairo Junior.
