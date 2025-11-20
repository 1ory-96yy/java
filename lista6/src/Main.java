/* ===========================
       ========== ZADANIE 1 =======
       =========================== */
static class Matrix {
    private final int rows;
    private final int cols;
    private final int[][] data;

    public Matrix(int r, int c) {
        rows = r;
        cols = c;
        data = new int[r][c];
    }

    public void fillRandom() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = rand.nextInt(10);
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.cols != B.rows) {
            throw new IllegalArgumentException("Nie można mnożyć macierzy: złe wymiary!");
        }

        Matrix result = new Matrix(A.rows, B.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.cols; j++) {
                int sum = 0;
                for (int k = 0; k < A.cols; k++) {
                    sum += A.data[i][k] * B.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    public void print() {
        for (int[] row : data) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}

/* ===========================
   ========== ZADANIE 2 =======
   =========================== */
static class BinaryU2 {
    public static int fromU2(String bin) {
        int n = bin.length();
        if (bin.charAt(0) == '0') {
            return Integer.parseInt(bin, 2);
        } else {
            return Integer.parseInt(bin, 2) - (1 << n);
        }
    }

    public static String toU2(int value, int bits) {
        if (value >= 0) {
            String s = Integer.toBinaryString(value);
            return "0".repeat(bits - s.length()) + s;
        } else {
            int max = 1 << bits;
            int u2 = max + value;
            String s = Integer.toBinaryString(u2);
            return "0".repeat(bits - s.length()) + s;
        }
    }
}

/* ===========================
   ========== ZADANIE 3 =======
   =========================== */
static class Car {
    String brand;
    String model;
    int speed;

    public Car(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public void accelerate(int value) {
        speed += value;
    }

    public void decelerate(int value) {
        speed = Math.max(0, speed - value);
    }

    public String toString() {
        return brand + " " + model + " | prędkość: " + speed;
    }
}

/* ===========================
   ========== ZADANIE 4 =======
   =========================== */
static class BankAccount {
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Brak środków!");
    }

    public String toString() {
        return "Saldo: " + balance;
    }
}

/* ===========================
   ========== ZADANIE 5 =======
   =========================== */
static class Player {
    String nazwisko;
    int wiek;
    double wzrost;

    public Player(String nazwisko, int wiek, double wzrost) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.wzrost = wzrost;
    }

    public String toString() {
        return nazwisko + " | wiek: " + wiek + " | wzrost: " + wzrost;
    }
}

static class PlayerList {
    List<Player> players = new ArrayList<>();

    public void add(Player p) {
        players.add(p);
    }

    public void remove(String nazwisko) {
        players.removeIf(p -> p.nazwisko.equals(nazwisko));
    }

    public void sortByHeight() {
        players.sort(Comparator.comparingDouble(p -> p.wzrost));
    }

    public void clear() {
        players.clear();
    }

    public void print() {
        players.forEach(System.out::println);
    }
}

/* ===========================
   ========== ZADANIE 6 =======
   =========================== */
static class Uczestnik {
    String nazwisko;
    int wiek;

    public Uczestnik(String n, int w) {
        nazwisko = n;
        wiek = w;
    }

    public String toString() {
        return nazwisko + " (wiek: " + wiek + ")";
    }
}

static class BazaNarty {
    List<Uczestnik> lista = new ArrayList<>();

    public void add(Uczestnik u) {
        lista.add(u);
    }

    public void print() {
        lista.forEach(System.out::println);
    }

    public Uczestnik znajdzKierownika() {
        return lista.stream().max(Comparator.comparingInt(u -> u.wiek)).orElse(null);
    }
}

    /* ===========================
       ========== MAIN – TESTY =====
       =========================== */

public static void main(String[] args) {

    System.out.println("=== Zadanie 1: mnożenie macierzy ===");
    Matrix A = new Matrix(2, 3);
    Matrix B = new Matrix(3, 2);
    A.fillRandom();
    B.fillRandom();
    A.print(); System.out.println();
    B.print(); System.out.println("Wynik:");
    Matrix C = Matrix.multiply(A, B);
    C.print();

    System.out.println("\n=== Zadanie 2: U2 ===");
    String bin = "11110101";
    int dec = BinaryU2.fromU2(bin);
    System.out.println(bin + " = " + dec);
    System.out.println("−11 w U2 (8 bitów) = " + BinaryU2.toU2(-11, 8));

    System.out.println("\n=== Zadanie 3: Car ===");
    Car car = new Car("Toyota", "Corolla", 50);
    car.accelerate(20);
    car.decelerate(30);
    System.out.println(car);

    System.out.println("\n=== Zadanie 4: BankAccount ===");
    BankAccount acc = new BankAccount(1000);
    acc.deposit(200);
    acc.withdraw(500);
    System.out.println(acc);

    System.out.println("\n=== Zadanie 5: Lista zawodników ===");
    PlayerList team = new PlayerList();
    team.add(new Player("Nowak", 22, 180));
    team.add(new Player("Kowalski", 25, 175));
    team.add(new Player("Lewandowski", 30, 185));
    System.out.println("Lista:");
    team.print();
    System.out.println("Po sortowaniu:");
    team.sortByHeight();
    team.print();

    System.out.println("Po usunięciu Kowalskiego:");
    team.remove("Kowalski");
    team.print();

    System.out.println("Usuwam całą listę...");
    team.clear();

    System.out.println("\n=== Zadanie 6: Baza uczestników na narty ===");
    BazaNarty baza = new BazaNarty();
    baza.add(new Uczestnik("Nowak", 30));
    baza.add(new Uczestnik("Kowal", 55));
    baza.add(new Uczestnik("Zając", 40));

    System.out.println("Lista uczestników:");
    baza.print();

    Uczestnik kierownik = baza.znajdzKierownika();
    System.out.println("\nKierownik (najstarszy): " + kierownik);
}