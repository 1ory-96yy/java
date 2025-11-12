import java.util.*;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\n=== LISTA NR 4 - JĘZYK JAVA ===");
            System.out.println("1. Zgadywanie liczby (0–9)");
            System.out.println("2. Największa, najmniejsza i średnia z n losowych liczb (0–99)");
            System.out.println("3. Porządkowanie trzech liczb niemalejąco");
            System.out.println("4. Sprawdzenie, czy liczba jest pierwsza");
            System.out.println("5. NWD (a, b) – dwie metody Euklidesa");
            System.out.println("6. Sortowanie bąbelkowe tablicy");
            System.out.println("7. Rozkład liczby na czynniki pierwsze");
            System.out.println("8. Zamiana liczby dziesiętnej na system o podstawie n");
            System.out.println("9. Problem n hetmanów");
            System.out.println("0. Zakończ program");
            System.out.print("Wybierz zadanie: ");
            wybor = sc.nextInt();

            switch (wybor) {
                case 1 -> zadanie1();
                case 2 -> zadanie2();
                case 3 -> zadanie3();
                case 4 -> zadanie4();
                case 5 -> zadanie5();
                case 6 -> zadanie6();
                case 7 -> zadanie7();
                case 8 -> zadanie8();
                case 9 -> zadanie9();
                case 0 -> System.out.println("Koniec programu.");
                default -> System.out.println("Niepoprawny wybór.");
            }
        } while (wybor != 0);
    }

    // 1. Zgadywanie liczby
    static void zadanie1() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int liczba = rand.nextInt(10);
        int strzal;

        System.out.println("Zgadnij liczbę z przedziału 0–9:");
        do {
            System.out.print("Podaj liczbę: ");
            strzal = sc.nextInt();
            if (strzal < liczba)
                System.out.println("Za mało!");
            else if (strzal > liczba)
                System.out.println("Za dużo!");
            else
                System.out.println("Brawo! Odgadłeś liczbę!");
        } while (strzal != liczba);
    }

    // 2. Największa, najmniejsza, średnia z n losowych liczb
    static void zadanie2() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Podaj ilość liczb n: ");
        int n = sc.nextInt();

        int[] tab = new int[n];
        int min = 100, max = -1, suma = 0;

        System.out.println("Wylosowane liczby:");
        for (int i = 0; i < n; i++) {
            tab[i] = rand.nextInt(100);
            System.out.print(tab[i] + " ");
            if (tab[i] < min) min = tab[i];
            if (tab[i] > max) max = tab[i];
            suma += tab[i];
        }

        System.out.println("\nNajmniejsza: " + min);
        System.out.println("Największa: " + max);
        System.out.println("Średnia: " + (double)suma / n);
    }

    // 3. Porządkowanie trzech liczb
    static void zadanie3() {
        Scanner sc = new Scanner(System.in);
        int[] liczby = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Podaj liczbę " + (i + 1) + ": ");
            liczby[i] = sc.nextInt();
        }
        Arrays.sort(liczby);
        System.out.println("Posortowane: " + Arrays.toString(liczby));
    }

    // 4. Sprawdzenie, czy liczba jest pierwsza
    static void zadanie4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę naturalną: ");
        int n = sc.nextInt();
        boolean pierwsza = n > 1;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) pierwsza = false;
        System.out.println(pierwsza ? "Liczba jest pierwsza." : "Liczba nie jest pierwsza.");
    }

    // 5. NWD – dwie metody
    static void zadanie5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj a: ");
        int a = sc.nextInt();
        System.out.print("Podaj b: ");
        int b = sc.nextInt();

        System.out.println("a) Klasyczna metoda Euklidesa: NWD = " + nwdKlasyczna(a, b));
        System.out.println("b) Zoptymalizowana metoda Euklidesa: NWD = " + nwdOptymalna(a, b));
    }

    static int nwdKlasyczna(int a, int b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    static int nwdOptymalna(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 6. Sortowanie bąbelkowe
    static void zadanie6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj ilość elementów tablicy: ");
        int n = sc.nextInt();
        int[] tab = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) tab[i] = rand.nextInt(100);
        System.out.println("Przed sortowaniem: " + Arrays.toString(tab));

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (tab[j] > tab[j + 1]) {
                    int tmp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = tmp;
                }

        System.out.println("Po sortowaniu: " + Arrays.toString(tab));
    }

    // 7. Rozkład liczby na czynniki pierwsze
    static void zadanie7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą dodatnią: ");
        int n = sc.nextInt();
        int liczba = n;
        System.out.println("Rozkład liczby " + n + " na czynniki pierwsze:");
        for (int i = 2; i * i <= liczba; i++) {
            int krotność = 0;
            while (n % i == 0) {
                n /= i;
                krotność++;
            }
            if (krotność > 0)
                System.out.println(i + "^" + krotność);
        }
        if (n > 1)
            System.out.println(n + "^1");
    }

    // 8. Zamiana liczby dziesiętnej na system o podstawie n
    static void zadanie8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę w systemie dziesiętnym: ");
        int liczba = sc.nextInt();
        System.out.print("Podaj podstawę systemu (2–9): ");
        int podstawa = sc.nextInt();

        String wynik = "";
        int temp = liczba;
        while (temp > 0) {
            wynik = (temp % podstawa) + wynik;
            temp /= podstawa;
        }
        System.out.println("Liczba " + liczba + " w systemie o podstawie " + podstawa + " to: " + wynik);
    }

    // 9. Problem n hetmanów
    static void zadanie9() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj n (rozmiar szachownicy i liczba hetmanów): ");
        int n = sc.nextInt();
        int[] pozycje = new int[n];
        if (rozwiazHetmany(0, pozycje, n)) {
            System.out.println("Rozwiązanie znalezione:");
            drukujSzachownice(pozycje);
        } else {
            System.out.println("Brak rozwiązania.");
        }
    }

    static boolean rozwiazHetmany(int wiersz, int[] pozycje, int n) {
        if (wiersz == n) return true;
        for (int kol = 0; kol < n; kol++) {
            if (bezpieczne(pozycje, wiersz, kol)) {
                pozycje[wiersz] = kol;
                if (rozwiazHetmany(wiersz + 1, pozycje, n)) return true;
            }
        }
        return false;
    }

    static boolean bezpieczne(int[] pozycje, int wiersz, int kol) {
        for (int i = 0; i < wiersz; i++) {
            if (pozycje[i] == kol || Math.abs(pozycje[i] - kol) == Math.abs(i - wiersz))
                return false;
        }
        return true;
    }

    static void drukujSzachownice(int[] pozycje) {
        int n = pozycje.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print((pozycje[i] == j ? "H " : ". "));
            System.out.println();
        }
    }