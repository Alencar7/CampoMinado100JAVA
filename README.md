# Campo Minado 100% Java

## Descrição
Campo Minado 100% Java é uma implementação do clássico jogo Campo Minado, desenvolvido inteiramente em Java. O objetivo do jogo é revelar todas as células de um tabuleiro sem detonar as minas escondidas, utilizando lógica e estratégia. O projeto foi criado como uma forma de praticar conceitos de programação em Java, incluindo lógica de jogo, manipulação de matrizes e interação com o usuário.

## Tecnologias Utilizadas
Java 17: Linguagem principal do projeto.

Maven: Gerenciamento de dependências (se aplicável).

33 Funcionalidades
Geração de um tabuleiro com minas distribuídas aleatoriamente.

Marcação de células com bandeiras para indicar possíveis minas.

Revelação de células seguras, com contagem de minas adjacentes.

Verificação de vitória (todas as células seguras reveladas) ou derrota (detonação de uma mina).

## Como Executar
Siga os passos abaixo para rodar o jogo localmente:
## Pré-requisitos:
Java 17 ou superior instalado.

Maven instalado (se o projeto usar Maven).

Git para clonar o repositório.

## Clonar o Repositório:
```bash

git clone https://github.com/Alencar7/CampoMinado100JAVA.git
cd CampoMinado100JAVA
```
Compilar o Projeto (se usar Maven):
```bash

mvn clean package
```
Executar o Jogo:
Se for uma aplicação de console:
```bash

java -jar target/CampoMinado100JAVA-1.0-SNAPSHOT.jar
```
Ou, se for um único arquivo Java:
```bash

javac src/main/java/CampoMinado.java
java src.main.java.CampoMinado
```

## Estrutura do Projeto
src/main/java: Contém o código-fonte do jogo, incluindo classes para o tabuleiro, lógica do jogo e interação com o usuário.

src/main/resources (se aplicável): Arquivos de configuração ou recursos adicionais.

target (se usar Maven): Diretório gerado com o arquivo .jar após o build.

## Status do Projeto
O projeto está em desenvolvimento ativo. As próximas etapas incluem:
Adição de diferentes níveis de dificuldade (fácil, médio, difícil)(deu preguiça kkkkk)

Possível dockerização para facilitar a execução em diferentes ambientes.

Contato
Desenvolvedor: Adriano de Alencar

GitHub: Alencar7

E-mail: contato.adealencar@gmail.com

