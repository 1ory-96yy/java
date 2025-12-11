import java.util.*;

// ---------------------------------------------------------
// ZADANIE 1 – klasa abstrakcyjna + dziedziczenie
// ---------------------------------------------------------

abstract class ElectronicDevice {
    protected String manufacturer;
    protected String model;
    protected int productionYear;

    public ElectronicDevice(String manufacturer, String model, int productionYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

class Smartphone extends ElectronicDevice {
    public Smartphone(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }
    @Override
    public void turnOn() {
        System.out.println("Smartphone " + model + " włącza się.");
    }
    @Override
    public void turnOff() {
        System.out.println("Smartphone " + model + " wyłącza się.");
    }
}

class Television extends ElectronicDevice {
    public Television(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }
    @Override
    public void turnOn() {
        System.out.println("Telewizor " + model + " włącza się.");
    }
    @Override
    public void turnOff() {
        System.out.println("Telewizor " + model + " wyłącza się.");
    }
}

class Laptop extends ElectronicDevice {
    public Laptop(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }
    @Override
    public void turnOn() {
        System.out.println("Laptop " + model + " włącza się.");
    }
    @Override
    public void turnOff() {
        System.out.println("Laptop " + model + " wyłącza się.");
    }
}


// ---------------------------------------------------------
// ZADANIE 2 – Student + Comparatory
// ---------------------------------------------------------

class Student {
    private int id;
    private String name;
    private double averageGrade;

    public Student(int id, String name, double averageGrade) {
        this.id = id;
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getAverageGrade() { return averageGrade; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + averageGrade;
    }
}

class AverageGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
    }
}

class IdComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getId(), s2.getId());
    }
}


// ---------------------------------------------------------
// ZADANIE 5 – własny wyjątek
// ---------------------------------------------------------

class NiepoprawnyFormatDanychException extends Exception {
    public NiepoprawnyFormatDanychException(String msg) {
        super(msg);
    }
}


// ---------------------------------------------------------
// GŁÓWNA KLASA
// ---------------------------------------------------------

public class Main {

    // ---------------------- Zadanie 3 ----------------------
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Wiek musi być >= 18! Podano: " + age);
        }
    }

    // ---------------------- Zadanie 5 ----------------------
    public static void sprawdzFormatDanych(String dane)
            throws NiepoprawnyFormatDanychException {

        if (!dane.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new NiepoprawnyFormatDanychException("Niepoprawny adres e-mail!");
        }
    }

    // ---------------------- MAIN ---------------------------
    public static void main(String[] args) {

        System.out.println("========== ZADANIE 1 ==========");
        ArrayList<ElectronicDevice> devices = new ArrayList<>();
        devices.add(new Smartphone("Samsung", "Galaxy S20", 2020));
        devices.add(new Television("LG", "OLED55", 2021));
        devices.add(new Laptop("Dell", "XPS 13", 2019));
        devices.add(new Smartphone("Apple", "iPhone 14", 2022));
        devices.add(new Television("Sony", "Bravia", 2018));

        for (ElectronicDevice d : devices) {
            d.turnOn();
            d.turnOff();
            System.out.println();
        }


        System.out.println("========== ZADANIE 2 ==========");
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Anna", 4.7));
        students.add(new Student(1, "Jan", 4.9));
        students.add(new Student(5, "Ola", 4.7));
        students.add(new Student(2, "Piotr", 3.8));
        students.add(new Student(4, "Kasia", 5.0));

        students.sort(new AverageGradeComparator().thenComparing(new IdComparator()));
        students.forEach(System.out::println);


        System.out.println("\n========== ZADANIE 3 ==========");
        int[] ages = {15, 20, 10};
        for (int a : ages) {
            try {
                checkAge(a);
                System.out.println("Wiek poprawny: " + a);
            } catch (IllegalArgumentException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        }


        System.out.println("\n========== ZADANIE 4 ==========");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Podaj pierwszą liczbę: ");
                int a = scanner.nextInt();

                System.out.print("Podaj drugą liczbę: ");
                int b = scanner.nextInt();

                System.out.println("Wynik: " + (a / b));
                break;

            } catch (ArithmeticException e) {
                System.out.println("Błąd: Dzielenie przez zero!");
            } catch (InputMismatchException e) {
                System.out.println("Błąd: Wprowadzono nie liczbę!");
                scanner.nextLine(); // czyszczenie bufora
            }
        }


        System.out.println("\n========== ZADANIE 5 ==========");
        scanner.nextLine(); // czyszczenie bufora po liczbach

        System.out.print("Podaj adres email: ");
        String email = scanner.nextLine();

        try {
            sprawdzFormatDanych(email);
            System.out.println("Email poprawny.");
        } catch (NiepoprawnyFormatDanychException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        scanner.close();
    }
}
