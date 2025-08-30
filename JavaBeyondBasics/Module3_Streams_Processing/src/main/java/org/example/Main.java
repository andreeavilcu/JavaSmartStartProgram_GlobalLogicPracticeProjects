package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale("Smartphone", 500, "C001", LocalDate.of(2022, 12, 15)),
                new Sale("Laptop", 1200, "C002", LocalDate.of(2023, 2, 10)),
                new Sale("Smartphone", 300, "C003", LocalDate.of(2023, 1, 5)),
                new Sale("Tablet", 150, "C001", LocalDate.of(2023, 3, 20)),
                new Sale("Smartphone", 800, "C004", LocalDate.of(2022, 11, 30)),
                new Sale("Headphones", 75, "C005", LocalDate.of(2023, 1, 25))
        );

        LocalDate cutoffDate = LocalDate.of(2023,1,1);
        List<Sale> filteredSales = sales.stream()
                .filter(sale -> !sale.getDate().isAfter(cutoffDate))
                .collect(Collectors.toList());

        System.out.println("i) Filter out all sales that occurred after January 1, 2023 ");
        System.out.println(filteredSales);
        System.out.println();

        List<String> productNames = sales.stream()
                .map(Sale::getProductName)
                .collect(Collectors.toList());
        System.out.println("ii) Map the sales to their corresponding product names: " +  productNames);
        System.out.println();

        double smartphoneSales = sales.stream()
                        .filter(sale -> sale.getProductName().equalsIgnoreCase("Smartphone"))
                        .mapToDouble(Sale::getAmount)
                        .sum();

        System.out.println("iii) Calculate the total sales amount for Smartphone: " + smartphoneSales);
        System.out.println();


        List<Sale> sortedSales = sales.stream()
                        .sorted(Comparator.comparingDouble(Sale::getAmount).reversed())
                        .collect(Collectors.toList());
        System.out.println("iv) Sort the sales by sale amount in descending order");
        System.out.println(sortedSales);
        System.out.println();

        Set<String> customerIds = sales.stream()
                        .map(Sale::getCustomerId)
                        .collect(Collectors.toSet());
        System.out.println("v) Collect the distinct customer IDs: " + customerIds);
        System.out.println();

        Map<String,List<Sale>> salesByProduct  = sales.stream()
                        .collect(Collectors.groupingBy(Sale::getProductName));
        System.out.println("vi) Group the sales by product name:");
        System.out.println(salesByProduct);
        System.out.println();

        double totalHighValueSales = sales.stream()
                .filter(sale -> sale.getAmount() > 100)
                .mapToDouble(Sale::getAmount)
                .sum();
        System.out.println("vii) Filter sales > $100, then calculate total sales amount: " + totalHighValueSales);
        System.out.println();

        double parallelTotalHighValueSales = sales.parallelStream()
                .filter(sale -> sale.getAmount() > 100)
                .mapToDouble(Sale::getAmount)
                .sum();
        System.out.println("viii) Perform one of the operations using parallel streams: " + parallelTotalHighValueSales);
        System.out.println();

        List<SaleSummary> summaries = sales.stream()
                .collect(Collectors.groupingBy(Sale::getProductName,
                Collectors.summingDouble(Sale::getAmount)))
                        .entrySet().stream()
                        .map(e -> new SaleSummary(e.getKey(), e.getValue()))
                                .collect(Collectors.toList());
        System.out.println("ix) Map the sales to a new object SaleSummary (product + total amount): ");
        System.out.println(summaries);


        double averageSales = sales.stream()
                        .mapToDouble(Sale::getAmount)
                                .average()
                                        .orElse(0.0);
        System.out.println("x) Calculate the average sales amount across all sales: " + averageSales);
        System.out.println();

    }
}