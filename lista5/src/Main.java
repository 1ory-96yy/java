import java.util.*;
    // ===== Zadanie 1 =====
    public static void obliczPodatek() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj dochód w PLN: ");
        double dochod = sc.nextDouble();
        double podatek;

        if (dochod <= 85528) {
            podatek = 0.18 * dochod;
        } else {
            podatek = 14839.02 + 0.32 * (dochod - 85528);
        }

        System.out.printf("Podatek dochodowy wynosi: %.2f PLN%n", podatek);
    }

    // ===== Zadanie 2 =====
    public static void sredniaIMediana() {
        double[] liczby = new double[20];
        Random rand = new Random();

        System.out.println("\nTablica 20 losowych liczb:");
        for (int i = 0; i < liczby.length; i++) {
            liczby[i] = rand.nextDouble() * 100; // losowe liczby od 0 do 100
            System.out.printf("%.2f ", liczby[i]);
        }

        // Średnia
        double suma = 0;
        for (double x : liczby) suma += x;
        double srednia = suma / liczby.length;

        // Mediana
        Arrays.sort(liczby);
        double mediana;
        if (liczby.length % 2 == 0)
            mediana = (liczby[liczby.length / 2 - 1] + liczby[liczby.length / 2]) / 2.0;
        else
            mediana = liczby[liczby.length / 2];

        System.out.printf("%nŚrednia: %.2f%n", srednia);
        System.out.printf("Mediana: %.2f%n", mediana);
    }

    // ===== Zadanie 3 =====
    public static int oddElementsSum(int[] tab) {
        int suma = 0;
        for (int x : tab) {
            if (x % 2 != 0)
                suma += x;
        }
        return suma;
    }

    public static void testOddElementsSum() {
        int[] dane = {2, 3, 5, 8, 10, 13};
        System.out.println("\nZadanie 3 – suma nieparzystych liczb w tablicy:");
        System.out.println("Tablica: " + Arrays.toString(dane));
        System.out.println("Suma nieparzystych = " + oddElementsSum(dane));
    }

    // ===== Zadanie 4 =====
    public static boolean czyPalindrom(String tekst) {
        tekst = tekst.replaceAll("\\s+", "").toLowerCase();
        int n = tekst.length();
        for (int i = 0; i < n / 2; i++) {
            if (tekst.charAt(i) != tekst.charAt(n - 1 - i))
                return false;
        }
        return true;
    }

    public static void testPalindrom() {
        String[] testy = {"Kajak", "Anna", "Java", "A to kanapa pana Kota"};
        System.out.println("\nZadanie 4 – test palindromów:");
        for (String t : testy) {
            System.out.printf("\"%s\" → %s%n", t, czyPalindrom(t) ? "palindrom" : "nie jest palindromem");
        }
    }

    // ===== Zadanie 5 =====
    public static void minKolumny() {
        int wiersze = 5, kolumny = 7;
        int[][] tab = new int[wiersze][kolumny];
        Random rand = new Random();

        System.out.println("\nTablica 5x7:");
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                tab[i][j] = rand.nextInt(10); // 0–9
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMinimum w każdej kolumnie:");
        for (int j = 0; j < kolumny; j++) {
            int min = tab[0][j];
            for (int i = 1; i < wiersze; i++) {
                if (tab[i][j] < min)
                    min = tab[i][j];
            }
            System.out.println("Kolumna " + (j + 1) + ": " + min);
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        System.out.println("=== Lista 5 – JAVA ===\n");

        // 1. Podatek
        obliczPodatek();

        // 2. Średnia i mediana
        sredniaIMediana();

        // 3. Suma nieparzystych
        testOddElementsSum();

        // 4. Palindromy
        testPalindrom();

        // 5. Minimum w kolumnach
        minKolumny();

        System.out.println("\n=== Koniec programu ===");
    }
