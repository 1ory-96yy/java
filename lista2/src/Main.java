import java.util.*;
// Zadanie 1
class Prostokat {
    double a, b, pole;

    public void czytaj_dane() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj bok a: ");
        a = sc.nextDouble();
        System.out.print("Podaj bok b: ");
        b = sc.nextDouble();
    }

    public void przetworz_dane() {
        pole = a * b;
    }

    public void wyswietl_wyniki() {
        System.out.printf("Pole prostokąta wynosi: %.2f\n", pole);
    }
}
// Zadanie 2
class RownanieLiniowe {
    double a, b, x;

    public void czytaj_dane() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj a: ");
        a = sc.nextDouble();
        System.out.print("Podaj b: ");
        b = sc.nextDouble();
    }

    public void przetworz_dane() {
        if (a == 0) {
            if (b == 0) System.out.println("Nieskończenie wiele rozwiązań");
            else System.out.println("Brak rozwiązań");
        } else {
            x = -b / a;
            System.out.printf("x = %.2f\n", x);
        }
    }

    public void wyswietl_wyniki() {
    }
}
// Zadanie 3
class TablicaPrzekatna {
    int[][] tab = new int[10][10];
    int suma = 0;

    public void czytaj_dane() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    tab[i][j] = r.nextInt(10);
                } else {
                    tab[i][j] = 0;
                }
            }
        }
    }

    public void przetworz_dane() {
        for (int i = 0; i < 10; i++) {
            suma += tab[i][i];
        }
    }

    public void wyswietl_wyniki() {
        System.out.println("Tablica 10x10:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Suma liczb na przekątnej: " + suma);
    }
}
// Zadanie 4
class Student {
    String numer_indeksu, imie, nazwisko, kierunek;

    public void czytaj_dane() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numer indeksu: ");
        numer_indeksu = sc.nextLine();
        System.out.print("Imię: ");
        imie = sc.nextLine();
        System.out.print("Nazwisko: ");
        nazwisko = sc.nextLine();
        System.out.print("Kierunek studiów: ");
        kierunek = sc.nextLine();
    }

    public void przetworz_dane() {
    }

    public void wyswietl_wyniki() {
        System.out.println("Dane studenta:");
        System.out.println("Indeks: " + numer_indeksu);
        System.out.println("Imię i nazwisko: " + imie + " " + nazwisko);
        System.out.println("Kierunek: " + kierunek);
    }
}
// Zadanie 5
class RownanieKwadratowe {
    double a, b, c, delta, x1, x2;

    public void czytaj_dane() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj a: ");
        a = sc.nextDouble();
        System.out.print("Podaj b: ");
        b = sc.nextDouble();
        System.out.print("Podaj c: ");
        c = sc.nextDouble();

        if (a == 0) {
            System.out.println("To nie jest równanie kwadratowe!");
        }
    }

    public void przetworz_dane() {
        delta = b * b - 4 * a * c;
        int przypadek;
        if (delta > 0) przypadek = 1;
        else if (delta == 0) przypadek = 2;
        else przypadek = 3;

        switch (przypadek) {
            case 1 -> {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.printf("Dwa rozwiązania: x1 = %.2f, x2 = %.2f\n", x1, x2);
            }
            case 2 -> {
                x1 = -b / (2 * a);
                System.out.printf("Jedno rozwiązanie: x = %.2f\n", x1);
            }
            case 3 -> System.out.println("Brak rozwiązań rzeczywistych");
        }
    }

    public void wyswietl_wyniki() {
    }
}
// Zadanie 6
class PoleFigury {
    public void czytaj_dane() {
    }

    public void przetworz_dane() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz figurę:");
        System.out.println("1 - Trójkąt");
        System.out.println("2 - Prostokąt");
        System.out.println("3 - Trapez");
        System.out.println("4 - Koło");
        int wybor = sc.nextInt();

        double pole = 0;

        switch (wybor) {
            case 1 -> {
                System.out.print("Podaj podstawę: ");
                double a = sc.nextDouble();
                System.out.print("Podaj wysokość: ");
                double h = sc.nextDouble();
                if (a <= 0 || h <= 0) {
                    System.out.println("Błędne dane!");
                    return;
                }
                pole = (a * h) / 2;
                System.out.printf("Pole trójkąta: %.2f\n", pole);
            }
            case 2 -> {
                System.out.print("Podaj bok a: ");
                double a = sc.nextDouble();
                System.out.print("Podaj bok b: ");
                double b = sc.nextDouble();
                if (a <= 0 || b <= 0) {
                    System.out.println("Błędne dane!");
                    return;
                }
                pole = a * b;
                System.out.printf("Pole prostokąta: %.2f\n", pole);
            }
            case 3 -> {
                System.out.print("Podaj podstawę a: ");
                double a = sc.nextDouble();
                System.out.print("Podaj podstawę b: ");
                double b = sc.nextDouble();
                System.out.print("Podaj wysokość h: ");
                double h = sc.nextDouble();
                if (a <= 0 || b <= 0 || h <= 0) {
                    System.out.println("Błędne dane!");
                    return;
                }
                pole = ((a + b) * h) / 2;
                System.out.printf("Pole trapezu: %.2f\n", pole);
            }
            case 4 -> {
                System.out.print("Podaj promień r: ");
                double r = sc.nextDouble();
                if (r <= 0) {
                    System.out.println("Błędne dane!");
                    return;
                }
                pole = Math.PI * r * r;
                System.out.printf("Pole koła: %.2f\n", pole);
            }
            default -> System.out.println("Niepoprawny wybór!");
        }
    }

    public void wyswietl_wyniki() {
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz zadanie (1–6): ");
        int zad = sc.nextInt();

        switch (zad) {
            case 1 -> {
                Prostokat p = new Prostokat();
                p.czytaj_dane();
                p.przetworz_dane();
                p.wyswietl_wyniki();
            }
            case 2 -> {
                RownanieLiniowe r = new RownanieLiniowe();
                r.czytaj_dane();
                r.przetworz_dane();
                r.wyswietl_wyniki();
            }
            case 3 -> {
                TablicaPrzekatna t = new TablicaPrzekatna();
                t.czytaj_dane();
                t.przetworz_dane();
                t.wyswietl_wyniki();
            }
            case 4 -> {
                Student s = new Student();
                s.czytaj_dane();
                s.przetworz_dane();
                s.wyswietl_wyniki();
            }
            case 5 -> {
                RownanieKwadratowe q = new RownanieKwadratowe();
                q.czytaj_dane();
                q.przetworz_dane();
                q.wyswietl_wyniki();
            }
            case 6 -> {
                PoleFigury f = new PoleFigury();
                f.czytaj_dane();
                f.przetworz_dane();
                f.wyswietl_wyniki();
            }
            default -> System.out.println("Nie ma takiego zadania.");
        }
    }
}
