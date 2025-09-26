package br.com.desafio.SistemaVeiculos.main;

import br.com.desafio.SistemaVeiculos.model.Dados;
import br.com.desafio.SistemaVeiculos.model.Modelos;
import br.com.desafio.SistemaVeiculos.service.ConsumoApi;
import br.com.desafio.SistemaVeiculos.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private String url = "https://parallelum.com.br/fipe/api/v1/";

    Scanner scanner = new Scanner(System.in);
    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();
    private String endereco;

    public void exibeMenu() {
        System.out.println("""
                Escolha o tipo de veículo:
                Carros
                Caminhoes
                Motos
                """);
        var veiculo = scanner.nextLine().toLowerCase();
        if (veiculo.toLowerCase().contains("carr")) {
            endereco = url + "carros/marcas";
        } else if (veiculo.toLowerCase().contains("mot")) {
            endereco = url + "motos/marcas";
        } else {
            endereco = url + "caminhoes/marcas";
        }
        var json = consumoApi.obeterDados(endereco);
        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumoApi.obeterDados(endereco);
        var modeloLista = converteDados.obterDados(json, Modelos.class);
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

    }

}
