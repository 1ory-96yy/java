import java.util.*;

    static class Sortowanie {
        int[] liczby;
        void Czytaj_dane() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Podaj ilość liczb: ");
            int n = sc.nextInt();
            liczby = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Podaj liczbę " + (i + 1) + ": ");
                liczby[i] = sc.nextInt();
            }
        }
        void Przetworz_dane() {
            for (int i = 0; i < liczby.length - 1; i++)
                for (int j = 0; j < liczby.length - 1 - i; j++)
                    if (liczby[j] > liczby[j + 1]) {
                        int temp = liczby[j];
                        liczby[j] = liczby[j + 1];
                        liczby[j + 1] = temp;
                    }
        }
        void Wyswietl_wynik() {
            System.out.println("Posortowane (odwrotnie):");
            for (int i = liczby.length - 1; i >= 0; i--)
                System.out.print(liczby[i] + " ");
            System.out.println();
        }
    }

    static long silnia(int n) {
        if (n <= 1) return 1;
        return n * silnia(n - 1);
    }

    static int trojkatna(int n) {
        if (n == 1) return 1;
        return n + trojkatna(n - 1);
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static class Pracownik {
        String imie, nazwisko, ulica, kod, miasto;
        void inicjuj() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Imię: "); imie = sc.nextLine();
            System.out.print("Nazwisko: "); nazwisko = sc.nextLine();
            System.out.print("Ulica: "); ulica = sc.nextLine();
            System.out.print("Kod pocztowy: "); kod = sc.nextLine();
            System.out.print("Miasto: "); miasto = sc.nextLine();
        }
        void drukuj() {
            System.out.println(imie + " " + nazwisko + ", " + ulica + ", " + kod + " " + miasto);
        }
    }

    static class Kadra extends Pracownik {
        String wyksztalcenie, stanowisko;
        @Override
        void inicjuj() {
            super.inicjuj();
            Scanner sc = new Scanner(System.in);
            System.out.print("Wykształcenie: "); wyksztalcenie = sc.nextLine();
            System.out.print("Stanowisko: "); stanowisko = sc.nextLine();
        }
        @Override
        void drukuj() {
            super.drukuj();
            System.out.println("Wykształcenie: " + wyksztalcenie + ", Stanowisko: " + stanowisko);
        }
    }

    static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Przenieś dysk z " + from + " na " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Przenieś dysk z " + from + " na " + to);
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        // 1
        Sortowanie s = new Sortowanie();
        s.Czytaj_dane();
        s.Przetworz_dane();
        s.Wyswietl_wynik();

        // 2
        System.out.println("Silnia 10!: " + silnia(10));

        // 3
        System.out.println("10 liczb trójkątnych:");
        for (int i = 1; i <= 10; i++) System.out.print(trojkatna(i) + " ");
        System.out.println();

        // 4
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj n dla Fibonacciego: ");
        int n = sc.nextInt();
        System.out.println(n + " liczb Fibonacciego:");
        for (int i = 0; i < n; i++) System.out.print(fibonacci(i) + " ");
        System.out.println();

        // 5
        Pracownik p = new Pracownik();
        p.inicjuj();
        p.drukuj();

        // 6
        Kadra k = new Kadra();
        k.inicjuj();
        k.drukuj();

        // 7
        System.out.println("Wieże Hanoi dla 3 dysków:");
        hanoi(3, 'A', 'C', 'B');
    }

