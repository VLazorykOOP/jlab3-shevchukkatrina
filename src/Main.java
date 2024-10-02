import java.util.ArrayList;
import java.util.List;

class Detail {
    protected String name;
    protected String material;
    protected double weight;

    public Detail(String name, String material, double weight) {
        this.name = name;
        this.material = material;
        this.weight = weight;
    }

    public void show() {
        System.out.println("Detail Name: " + name + ", Material: " + material + ", Weight: " + weight + " kg");
    }
}

class Assembly extends Detail {
    protected int assemblyNumber;
    protected int numberOfDetails;

    public Assembly(String name, String material, double weight, int assemblyNumber, int numberOfDetails) {
        super(name, material, weight);
        this.assemblyNumber = assemblyNumber;
        this.numberOfDetails = numberOfDetails;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Assembly Number: " + assemblyNumber + ", Number of Details: " + numberOfDetails);
    }
}

class Mechanism extends Assembly {
    protected String mechanismType;
    protected String purpose;

    public Mechanism(String name, String material, double weight, int assemblyNumber, int numberOfDetails, String mechanismType, String purpose) {
        super(name, material, weight, assemblyNumber, numberOfDetails);
        this.mechanismType = mechanismType;
        this.purpose = purpose;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Mechanism Type: " + mechanismType + ", Purpose: " + purpose);
    }
}

class Product extends Mechanism {
    protected String productName;
    protected double price;

    public Product(String name, String material, double weight, int assemblyNumber, int numberOfDetails, String mechanismType, String purpose, String productName, double price) {
        super(name, material, weight, assemblyNumber, numberOfDetails, mechanismType, purpose);
        this.productName = productName;
        this.price = price;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Product Name: " + productName + ", Price: " + price + " UAH");
    }
}

abstract class Root {
    public abstract void calculateRoots();
    public abstract void printRoots();
}

// Похідний для лінійних рівнянь (ax + b = 0)
class LinearAbstract extends Root {
    private double a;
    private double b;
    private Double root;

    public LinearAbstract(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void calculateRoots() {
        if (a != 0) {
            root = -b / a;
        } else {
            root = null;
        }
    }

    @Override
    public void printRoots() {
        if (root != null) {
            System.out.println("Linear equation root: x = " + root);
        } else {
            System.out.println("No valid root for this linear equation.");
        }
    }

    @Override
    public String toString() {
        return "Linear Equation: " + a + "x + " + b + " = 0";
    }
}

// Похідний для квадратних рівнянь (ax^2 + bx + c = 0)
class SquareAbstract extends Root {
    private double a;
    private double b;
    private double c;
    private Double root1;
    private Double root2;

    public SquareAbstract(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void calculateRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
        } else {
            root1 = root2 = null;
        }
    }

    @Override
    public void printRoots() {
        if (root1 != null && root2 != null) {
            if (root1.equals(root2)) {
                System.out.println("Square equation root: x = " + root1);
            } else {
                System.out.println("Square equation roots: x1 = " + root1 + ", x2 = " + root2);
            }
        } else {
            System.out.println("No real roots for this square equation.");
        }
    }

    @Override
    public String toString() {
        return "Square Equation: " + a + "x^2 + " + b + "x + " + c + " = 0";
    }
}

interface RootInterfaceLinear {
    void calculateRoots();  
    void printRoots();
}

interface RootInterfaceSquare {
    void calculateRoots(); 
    void printRoots();      
}

//для лінійних рівнянь (ax + b = 0), що реалізує RootInterfaceLinear
class Linear implements RootInterfaceLinear {
    private double a;
    private double b;
    private Double root;

    public Linear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void calculateRoots() {
        if (a != 0) {
            root = -b / a;
        } else {
            root = null; // Немає кореня (рівняння не має сенсу)
        }
    }

    @Override
    public void printRoots() {
        if (root != null) {
            System.out.println("Linear equation root: x = " + root);
        } else {
            System.out.println("No valid root for this linear equation.");
        }
    }

    @Override
    public String toString() {
        return "Linear Equation: " + a + "x + " + b + " = 0";
    }
}

//для квадратних рівнянь (ax^2 + bx + c = 0), що реалізує RootInterfaceSquare
class Square implements RootInterfaceSquare {
    private double a;
    private double b;
    private double c;
    private Double root1;
    private Double root2;

    public Square(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void calculateRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
        } else {
            root1 = root2 = null; // Корені є комплексними
        }
    }

    @Override
    public void printRoots() {
        if (root1 != null && root2 != null) {
            if (root1.equals(root2)) {
                System.out.println("Square equation root: x = " + root1);
            } else {
                System.out.println("Square equation roots: x1 = " + root1 + ", x2 = " + root2);
            }
        } else {
            System.out.println("No real roots for this square equation.");
        }
    }

    @Override
    public String toString() {
        return "Square Equation: " + a + "x^2 + " + b + "x + " + c + " = 0";
    }
}

// Головний
public class Main {
    public static void main(String[] args) {
        List<Detail> details = new ArrayList<>();
        details.add(new Detail("Bolt", "Steel", 0.1));
        details.add(new Assembly("Bearing", "Metal", 0.5, 101, 3));
        details.add(new Mechanism("Transmission", "Aluminum", 3.5, 202, 10, "Drive", "Torque Transmission"));
        details.add(new Product("Car Engine", "Cast Iron", 150.0, 303, 50, "Engine", "Power Generation", "V8 Engine", 50000));

        System.out.println("\nDetails, Assemblies, Mechanisms, and Products:");
        for (Detail detail : details) {
            detail.show();
            System.out.println();
        }

        System.out.println("\nLinear Equation Example (Abstract Class):");
        LinearAbstract linearEquation = new LinearAbstract(2, 4);
        linearEquation.calculateRoots();
        linearEquation.printRoots();

        System.out.println("\nSquare Equation Example (Abstract Class):");
        SquareAbstract squareEquation = new SquareAbstract(1, -3, 2);
        squareEquation.calculateRoots();
        squareEquation.printRoots();

        System.out.println("\nUsing Interfaces for Equations:");
        RootInterfaceLinear linearInterface = new Linear(2, 4);
        linearInterface.calculateRoots();
        linearInterface.printRoots();

        System.out.println("\nUsing Interfaces for Equations:");
        RootInterfaceSquare squareInterface = new Square(1, -3, 2);
        squareInterface.calculateRoots();
        squareInterface.printRoots();
    }
}
