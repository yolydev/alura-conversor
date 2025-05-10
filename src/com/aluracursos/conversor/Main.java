package com.aluracursos.conversor;

import com.aluracursos.conversor.api.ApiService;
import com.aluracursos.conversor.calculate.Converter;
import com.aluracursos.conversor.model.CurrencyConverted;
import com.aluracursos.conversor.model.ExchangeRate;
import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Gson gson = new Gson();
        Converter converter = new Converter();

        String initialCurrency = "NULL";
        String targetCurrency = "NULL";
        int option = 0;

        Scanner scanner = new Scanner(System.in);

        while (option != 7) {
            System.out.println("Escoge la opcion que deseas");
            System.out.println(""" 
                    1. Dolar => peso argentino
                    2. Peso argentino => dolar
                    3. Dolar => real brasileno
                    4. Real brasileno => dolar
                    5. Dolar => peso colombiano
                    6. Peso colombiano => dolar
                    7. salir
                    """);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    initialCurrency = "USD";
                    targetCurrency = "ARS";
                break;
                case 2:
                    initialCurrency = "ARS";
                    targetCurrency = "USD";
                break;
                case 3:
                    initialCurrency = "USD";
                    targetCurrency = "BRL";
                break;
                case 4:
                    initialCurrency = "BRL";
                    targetCurrency = "USD";
                break;
                case 5:
                    initialCurrency = "USD";
                    targetCurrency = "COP";
                break;
                case 6:
                    initialCurrency = "COP";
                    targetCurrency = "USD";
                break;
                case 7:
                    System.out.println("Gracias por usar el conversor");
                break;
                default:
                    System.out.println("Opcion no valida");
                break;
            }
            if(!initialCurrency.equals("NULL") && option != 7) {
                System.out.println("Ingrese el valor que desea convertir");
                double value = scanner.nextDouble();
                String json = apiService.getDataCurrency(initialCurrency, targetCurrency);
                ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);
                CurrencyConverted currencyConverted = new CurrencyConverted(exchangeRate);
                double result = converter.convertToTargetCurrency(value, currencyConverted.getConversionRate());
                System.out.println("El valor " + value +
                        "[" + initialCurrency + "]" + " corresponde al valor final de => "
                        + result + "[" + targetCurrency + "]");
            } else if (option == 7) {
                System.out.println("Vuelve pronto");
            } else {
                System.out.println("Algo inesperado sucedio");
            }

        }
        scanner.close();
    }
}
