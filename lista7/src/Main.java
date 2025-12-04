import java.io.*;
import java.util.*;

    public static void main(String[] args) {
        // ==== ODKOMENTUJ to zadanie, które chcesz uruchomić ====

        // zadanie1();
        // zadanie2();
        // zadanie3();
        // zadanie4();
        // zadanie5();
    }

    // =======================
    // ====== ZADANIE 1 ======
    // =======================
    // Tworzy plik wyjście.txt i zapisuje dwie liczby
    public static void zadanie1() {
        try (PrintWriter pw = new PrintWriter("wyjście.txt")) {
            pw.println(12);
            pw.println(34);
            System.out.println("Zapisano liczby do pliku wyjście.txt");
        } catch (Exception e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }

    // =======================
    // ====== ZADANIE 2 ======
    // =======================
    // Czyta dwie liczby z prostokąt.txt i oblicza pole
    public static void zadanie2() {
        try (Scanner sc = new Scanner(new File("prostokąt.txt"))) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Pole prostokąta = " + (a * b));
        } catch (Exception e) {
            System.out.println("Błąd odczytu pliku prostokąt.txt: " + e.getMessage());
        }
    }

    // =======================
    // ====== ZADANIE 3 ======
    // =======================
    // Porównanie dwóch tablic String
    public static void zadanie3() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj rozmiar tablic: ");
        int n = sc.nextInt();
        sc.nextLine(); // enter

        String[] tab1 = new String[n];
        String[] tab2 = new String[n];

        System.out.println("Podaj dane do tablicy 1:");
        for (int i = 0; i < n; i++) {
            tab1[i] = sc.nextLine();
        }

        System.out.println("Podaj dane do tablicy 2:");
        for (int i = 0; i < n; i++) {
            tab2[i] = sc.nextLine();
        }

        if (Arrays.equals(tab1, tab2)) {
            System.out.println("Tablice są takie same.");
        } else {
            System.out.println("Tablice różnią się.");
        }
    }

    // =======================
    // ====== ZADANIE 4 ======
    // =======================
    // OOP: Student -> Czytaj, Zapisz, Wyświetl
    public static void zadanie4() {
        Student s = new Student();
        s.Czytaj_dane();
        s.Zapisz_dane_do_pliku();
        s.Wyświetl_wynik();
    }

    static class Student {
        private String imie;
        private String nazwisko;

        public void Czytaj_dane() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Podaj imię: ");
            imie = sc.nextLine();
            System.out.print("Podaj nazwisko: ");
            nazwisko = sc.nextLine();
        }

        public void Zapisz_dane_do_pliku() {
            try (PrintWriter pw = new PrintWriter("dane.txt")) {
                pw.println(imie);
                pw.println(nazwisko);
            } catch (Exception e) {
                System.out.println("Błąd zapisu pliku dane.txt: " + e.getMessage());
            }
        }

        public void Wyświetl_wynik() {
            try (Scanner sc = new Scanner(new File("dane.txt"))) {
                String im = sc.nextLine();
                String nz = sc.nextLine();
                System.out.println("Odczytano z pliku:");
                System.out.println(im + " " + nz);
            } catch (Exception e) {
                System.out.println("Błąd odczytu pliku dane.txt: " + e.getMessage());
            }
        }
    }

    // =======================
    // ====== ZADANIE 5 ======
    // =======================
    // Wczytuje tekst z pliku i liczy zdania zakończone kropką.
    public static void zadanie5() {
        try {
            StringBuilder sb = new StringBuilder();

            try (Scanner sc = new Scanner(new File("tekst.txt"))) {
                while (sc.hasNextLine()) {
                    sb.append(sc.nextLine()).append("\n");
                }
            }

            String tekst = sb.toString();
            System.out.println("Treść pliku:\n" + tekst);

            int liczbaZdan = liczZdania(tekst);
            System.out.println("Liczba zdań: " + liczbaZdan);

        } catch (Exception e) {
            System.out.println("Błąd odczytu pliku tekst.txt: " + e.getMessage());
        }
    }

    // Liczenie zdań: kropka + spacja + wielka litera
    public static int liczZdania(String t) {
        int count = 0;

        for (int i = 0; i < t.length() - 2; i++) {
            if (t.charAt(i) == '.' &&
                    t.charAt(i + 1) == ' ' &&
                    Character.isUpperCase(t.charAt(i + 2))) {
                count++;
            }
        }

        // Jeśli tekst nie jest pusty, dolicz pierwsze zdanie
        if (t.contains(".")) count++;

        return count;
    }
