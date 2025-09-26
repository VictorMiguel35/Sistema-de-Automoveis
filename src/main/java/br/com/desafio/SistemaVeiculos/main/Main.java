package br.com.desafio.SistemaVeiculos.main;

import br.com.desafio.SistemaVeiculos.model.Dados;
import br.com.desafio.SistemaVeiculos.model.DadosVeiculo;
import br.com.desafio.SistemaVeiculos.model.Modelos;
import br.com.desafio.SistemaVeiculos.service.ConsumoApi;
import br.com.desafio.SistemaVeiculos.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private String url = "https://parallelum.com.br/fipe/api/v1/";

    Scanner scanner = new Scanner(System.in);
    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();
    private String endereco;

    public void exibeMenu() {
        System.out.println("""
                Digite o tipo de veículo:
                Carro
                Caminhão
                Moto
                """);
        var opcao = scanner.nextLine().toLowerCase();
        if (opcao.toLowerCase().contains("car")) {
            endereco = url + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = url + "motos/marcas";
        } else {
            endereco = url + "caminhoes/marcas";
        }
        var json = consumoApi.obeterDados(endereco);
        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nInforme o código da marca para consulta: ");
        var codigoMarca = scanner.next() + scanner.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumoApi.obeterDados(endereco);
        var modeloLista = converteDados.obterDados(json, Modelos.class);
        System.out.println("\nModelos dessa marca: \n");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado: ");
        var nomeVeiculo = scanner.nextLine();
        modeloLista.modelos().stream()
                .filter(d -> d.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para consultar valores: ");
        var codigoModelo = scanner.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumoApi.obeterDados(endereco);
        var anos = converteDados.obterLista(json, Dados.class);

        List<DadosVeiculo> veiculos = new ArrayList<>();

        for (int i=0; i<anos.size(); i++) {
            json = consumoApi.obeterDados(endereco + "/" + anos.get(i).codigo());
            var resultado = converteDados.obterDados(json, DadosVeiculo.class);
            veiculos.add(resultado);
        }
        veiculos.forEach(System.out::println);
    }

}
