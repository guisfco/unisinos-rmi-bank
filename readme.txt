## M3 | Tarefa - Tarefa Módulo 3

### ⚙️ Requisitos
- Java 17

### ⚠️ Informações importantes
- O Java 17 será utilizado para compilar o projeto e executá-lo. Dessa forma, essa versão deve estar configurada como padrão na máquina para que os comandos abaixo funcionem.

### 📝 Instruções
- Abrir um terminal (PowerShell ou equivalente)
- Entrar na pasta raiz do projeto (unisinos-rmi-bank)
- Executar o comando abaixo
    ```console
    javac --release 17 -d ./out/ ./src/*.java
    ```
- Executar o comando abaixo para iniciar o servidor
    ```console
    java -cp ./out/ Server
    ```
- Em outro terminal, após abrir a pasta raíz do projeto, executar o comando abaixo para iniciar o cliente
    ```console
    java -cp ./out/ Client
    ```
  
### 🧪 Exemplo
![Exemplo](./example.png)