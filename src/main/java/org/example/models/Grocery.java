package org.example.models;

import java.util.*;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();


    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📦 Grocery List Uygulamasına Hoşgeldiniz!");
        System.out.println("0 -> Çıkış\n1 -> Ekleme\n2 -> Çıkarma");

        while (running) {
            System.out.print("Seçiminizi yapınız: ");
            int choice = -1;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("⚠️ Geçersiz giriş. Lütfen 0, 1 veya 2 giriniz.");
                continue;
            }

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("👋 Uygulama kapatılıyor...");
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz ürün(ler)i giriniz: ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz ürün(ler)i giriniz: ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                default:
                    System.out.println("⚠️ Yanlış seçim yaptınız. 0, 1 veya 2 giriniz.");
            }
        }
    }


    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim().toLowerCase();
            if (!trimmed.isEmpty() && !checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            } else if (checkItemIsInList(trimmed)) {
                System.out.println("⚠️ '" + trimmed + "' zaten listede var.");
            }
        }
        sortList();
    }


    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim().toLowerCase();
            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
            } else {
                System.out.println("⚠️ '" + trimmed + "' listede bulunamadı.");
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.toLowerCase().trim());
    }


    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("📋 Güncel Liste: " + groceryList);
    }



    private static void sortList() {
        Collections.sort(groceryList);
    }
}
