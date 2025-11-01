import java.util.Scanner;

void main() {
    //1
    System.out.println("TO JEST MÓJ");
    System.out.println("PIERWSZY PROGRAM");
    System.out.println("W JĘZYKU JAVA");
    //2
    Scanner sc = new Scanner(System.in);
    System.out.print("Podaj pierwszą liczbę: ");
    int a = sc.nextInt();
    System.out.print("Podaj drugą liczbę: ");
    int b = sc.nextInt();
    int wynik = a / b;
    int reszta = a % b;
    System.out.println("Wynik dzielenia: " + wynik);
    System.out.println("Reszta z dzielenia: " + reszta);
    //3
    Scanner sc1 = new Scanner(System.in);
    System.out.print("Podaj liczbę: ");
    int x = sc1.nextInt();

    if (x > 0)
        System.out.println("Liczba dodatnia");
    else if (x < 0)
        System.out.println("Liczba ujemna");
    else
        System.out.println("Zero");
    //4
    Scanner sc2 = new Scanner(System.in);
    System.out.print("Podaj pierwszą liczbę: ");
    int a1 = sc2.nextInt();
    System.out.print("Podaj drugą liczbę: ");
    int b1 = sc2.nextInt();
    System.out.print("Podaj trzecią liczbę: ");
    int c1 = sc2.nextInt();

    int min = a1;
    if (b1 < min) min = b1;
    if (c1 < min) min = c1;

    System.out.println("Najmniejsza wartość to: " + min);
    //5
    Scanner sc3 = new Scanner(System.in);
    System.out.print("Który blok zajęć się rozpoczął? ");
    int blok = sc3.nextInt();

    switch (blok) {
        case 1 -> System.out.println("Rozpoczął się pierwszy blok zajęć.");
        case 2 -> System.out.println("Rozpoczął się drugi blok zajęć.");
        case 3 -> System.out.println("Rozpoczął się trzeci blok zajęć.");
        default -> System.out.println("Nie ma takiego bloku zajęć.");
    }
    //6
    for (int i = 0; i <= 20; i++) {
    if (i % 3 != 0)
        System.out.println(i + " - niepodzielna przez 3");
    else
        System.out.println(i);
    }
    //7
    Scanner sc4 = new Scanner(System.in);
    char znak;

    do {
        System.out.print("Podaj znak: ");
        znak = sc4.next().charAt(0);
        System.out.println("Wprowadzono: " + znak);
    } while (znak != 'k');

    System.out.println("Koniec programu.");
    //8
    Scanner sc5 = new Scanner(System.in);
    System.out.print("1 - Celsjusz → Fahrenheit\n2 - Fahrenheit → Celsjusz\nWybierz: ");
    int wybor = sc5.nextInt();

    System.out.print("Podaj wartość: ");
    double temp = sc5.nextDouble();

    if (wybor == 1) {
        double f = temp * 9 / 5 + 32;
        System.out.println("Temperatura w Fahrenheitach: " + f);
    } else if (wybor == 2) {
        double c2 = (temp - 32) * 5 / 9;
        System.out.println("Temperatura w Celsjuszach: " + c2);
    } else {
        System.out.println("Niepoprawny wybór.");
    }
    //9
    Scanner sc6 = new Scanner(System.in);
    System.out.print("Podaj a: ");
    double a3 = sc6.nextDouble();
    System.out.print("Podaj b: ");
    double b3 = sc6.nextDouble();

    if (a == 0) {
        if (b3 == 0) System.out.println("Nieskończenie wiele rozwiązań");
        else System.out.println("Brak rozwiązań");
    } else {
        double x2 = -b3 / a3;
        System.out.println("Rozwiązanie: x = " + x2);
    }
    //10
    Scanner sc7 = new Scanner(System.in);
    System.out.print("Podaj bok x: ");
    double x3 = sc7.nextDouble();
    System.out.print("Podaj bok y: ");
    double y3 = sc7.nextDouble();
    System.out.print("Podaj bok z: ");
    double z3 = sc7.nextDouble();
    double obwod = x3 + y3 + z3;
    System.out.println("Obwód trójkąta: " + obwod);
    //11
    Scanner sc8 = new Scanner(System.in);
    System.out.print("Podaj bok a: ");
    double a4 = sc8.nextDouble();
    System.out.print("Podaj bok b: ");
    double b4 = sc8.nextDouble();

    double pole = a4 * b4;
    System.out.println("Pole prostokąta: " + pole);
    //12
    Scanner sc9 = new Scanner(System.in);
    System.out.print("Podaj a: ");
    double a5 = sc9.nextDouble();
    System.out.print("Podaj b: ");
    double b5 = sc9.nextDouble();
    System.out.print("Podaj c: ");
    double c5 = sc9.nextDouble();

    double delta = b5 * b5 - 4 * a5 * c5;

    if (a == 0) {
        System.out.println("To nie jest równanie kwadratowe.");
    } else if (delta > 0) {
        double x1 = (-b - Math.sqrt(delta)) / (2 * a);
        double x2 = (-b + Math.sqrt(delta)) / (2 * a);
        System.out.println("Dwa rozwiązania: x1 = " + x1 + ", x2 = " + x2);
    } else if (delta == 0) {
        double x4 = -b5 / (2 * a5);
        System.out.println("Jedno rozwiązanie: x = " + x4);
    } else {
        System.out.println("Brak rozwiązań rzeczywistych.");
    }
}
