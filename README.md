# Sistema de Automóveis - Tabela FIPE

Este projeto é um sistema de consulta de veículos desenvolvido em Java, que permite ao usuário pesquisar o valor médio de carros, motos e caminhões de acordo com a Tabela FIPE. A aplicação é executada no terminal e consome a API pública da FIPE para obter os dados.

Este foi um desafio proposto pela Alura para consolidar conhecimentos em Java, consumo de APIs e manipulação de dados.

## ☕ Funcionalidades

* **Consulta por Tipo de Veículo:** O usuário pode escolher entre Carros, Motos e Caminhões.
* **Listagem de Marcas e Modelos:** A aplicação exibe todas as marcas disponíveis para o tipo de veículo escolhido e, em seguida, todos os modelos da marca selecionada.
* **Filtro de Modelos:** Permite que o usuário digite um trecho do nome de um modelo para filtrar a lista.
* **Avaliação Completa:** Ao escolher um modelo, o sistema exibe o valor do veículo para **todos os anos** disponíveis, de uma só vez.

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot:** Utilizado para criar a estrutura da aplicação de linha de comando.
* **Maven:** Para gerenciamento de dependências.
* **Jackson:** Biblioteca para converter os dados da API (JSON) em objetos Java.

## Fluxo da Aplicação

O sistema funciona da seguinte forma:

1.  Você digita o tipo de veículo (carro, moto ou caminhão).
2.  A aplicação lista todas as marcas e pede para você informar o código da marca desejada.
3.  Em seguida, são listados todos os modelos daquela marca.
4.  Você pode digitar um trecho do nome do veículo para refinar a busca.
5.  Por fim, você informa o código do modelo e a aplicação exibe uma lista com o valor do veículo para cada ano disponível.
