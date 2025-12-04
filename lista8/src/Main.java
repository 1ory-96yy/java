import java.util.*;

    public static void main(String[] args) {

        // ODKOMENTUJ wybrane zadanie:

        // zadanie1();
        // zadanie2();
        // zadanie3_4();
        // zadanie5();
        // zadanie6();
    }

    // ============================================
    // =============== ZADANIE 1 ==================
    // ============================================
    // Policz ile liczb spełnia warunek 3k < ak < k!
    public static void zadanie1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj n: ");
        int n = sc.nextInt();

        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        int count = 0;

        for (int k = 1; k <= n; k++) {
            long factorial = factorial(k);
            if (3 * k < a[k] && a[k] < factorial) {
                count++;
            }
        }

        System.out.println("Liczb spełniających warunek: " + count);
    }

    public static long factorial(int x) {
        long f = 1;
        for (int i = 2; i <= x; i++) f *= i;
        return f;
    }

    // ============================================
    // =============== ZADANIE 2 ==================
    // ============================================
    // Tablica 50 liczb -> policz ile jest liczb pierwszych
    public static void zadanie2() {
        int[] tab = new int[50];
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj 50 liczb:");

        for (int i = 0; i < 50; i++) {
            tab[i] = sc.nextInt();
        }

        int count = 0;
        for (int x : tab) {
            if (isPrime(x)) count++;
        }

        System.out.println("Liczb pierwszych: " + count);
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // ============================================
    // ============ ZADANIE 3 i 4 =================
    // ============================================
    // Klasa Player + próba zmiany pól + dodanie getter/setter
    public static void zadanie3_4() {
        Player[] players = new Player[3];
        players[0] = new Player("Adam", 22, "Poland");
        players[1] = new Player("Mark", 30, "USA");
        players[2] = new Player("Ivan", 25, "Ukraine");

        // Możemy zmieniać:
        players[0].name = "NoweImie";     // publiczne pole – OK
        players[1].age = 99;             // bez modyfikatora – OK w tym samym pakiecie

        // players[2].nationality = "Spain";  // BŁĄD – pole prywatne

        players[2].setNationality("Spain");

        for (Player p : players) {
            System.out.println(p.name + " " + p.age + " " + p.getNationality());
        }
    }

    static class Player {
        public String name;
        int age;
        private String nationality;

        public Player(String n, int a, String nat) {
            this.name = n;
            this.age = a;
            this.nationality = nat;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }
    }

    // ============================================
    // =============== ZADANIE 5 ==================
    // ============================================
    // Car + konstruktory + ArrayList samochodów
    public static void zadanie5() {
        Scanner sc = new Scanner(System.in);

        // a) Trzy samochody z trzech konstruktorów
        Car c1 = new Car();  // domyślny

        System.out.print("Podaj markę: ");
        String b = sc.nextLine();
        System.out.print("Podaj model: ");
        String m = sc.nextLine();
        Car c2 = new Car(b, m);  // 2 argumenty

        System.out.print("Podaj markę: ");
        String b2 = sc.nextLine();
        System.out.print("Podaj model: ");
        String m2 = sc.nextLine();
        System.out.print("Podaj rok: ");
        int y2 = sc.nextInt();
        sc.nextLine();
        Car c3 = new Car(b2, m2, y2);   // 3 argumenty

        System.out.println("\nSamochody:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // c) Dowolna liczba samochodów
        ArrayList<Car> list = new ArrayList<>();

        System.out.print("\nIle samochodów chcesz dodać? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nSamochód " + (i + 1));

            System.out.print("Marka: ");
            String brand = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Rok: ");
            int year = sc.nextInt();
            sc.nextLine();

            list.add(new Car(brand, model, year));
        }

        System.out.println("\nLista samochodów:");
        for (Car c : list) System.out.println(c);
    }

    static class Car {
        String brand;
        String model;
        int productionYear;

        public Car() {
            this.brand = "Unknown";
            this.model = "Unknown";
            this.productionYear = 0;
        }

        public Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
            this.productionYear = 0;
        }

        public Car(String brand, String model, int productionYear) {
            this.brand = brand;
            this.model = model;
            this.productionYear = productionYear;
        }

        public String toString() {
            return brand + " " + model + " (" + productionYear + ")";
        }
    }

    // ============================================
    // =============== ZADANIE 6 ==================
    // ============================================
    // Rectangle: pola prywatne, get/set, area, perimeter
    public static void zadanie6() {
        Rectangle r = new Rectangle(5, 7);
        System.out.println("Width = " + r.getWidth());
        System.out.println("Height = " + r.getHeight());
        System.out.println("Area = " + r.area());
        System.out.println("Perimeter = " + r.perimeter());
    }

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }
    }
