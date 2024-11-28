# Vazamento de Dados API

Este é um aplicativo Android desenvolvido para verificar e validar se um e-mail foi comprometido em vazamentos de dados utilizando uma API externa. Caso o e-mail seja identificado em um vazamento, o aplicativo informa o usuário.

---

## 📱 **Funcionalidades**
- **Verificação de e-mail**: O usuário pode inserir um e-mail e verificar se ele foi comprometido em vazamentos de dados.
- **Notificação de status**: Informa ao usuário se o e-mail está seguro ou foi comprometido.
- **Integração com API**: Utiliza uma [API pública](<https://www.freepublicapis.com/check-e-mail-or-username-for-a-data-breach>) para buscar informações relacionadas ao e-mail.
- **Envio de informações por e-mail**: Após a verificação, é possível enviar o resultado para o próprio e-mail do usuário.

---

## 🚀 **Como funciona**
1. O usuário insere o e-mail que deseja verificar.
2. O aplicativo envia uma requisição para a API com o e-mail.
3. A API responde com o status do e-mail (comprometido ou seguro).
4. O resultado é exibido na interface do usuário.
5. O aplicativo permite enviar o status do e-mail para um destinatário via Intent de compartilhamento.

---

## 🛠 **Tecnologias utilizadas**
- **Linguagem**: Kotlin
- **Min SDK**: 25 (Android 7.1.1 - Nougat)
- **Frameworks e bibliotecas**:
  - [Retrofit](https://square.github.io/retrofit/): Para fazer requisições HTTP.
  - [Gson](https://github.com/google/gson): Para deserialização de respostas JSON.
  - [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout): Para o layout responsivo.
  - [Material Design](https://material.io/): Para design moderno e interativo.

---

## 🛠 **Instalação**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/vazamento-de-dados-api.git
   cd vazamento-de-dados-api
