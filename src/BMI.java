import java.util.Scanner;
public class BMI {
    public static double getValidWeight(Scanner scanner) {
        double weight = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your weight: ");
            try {
                weight = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return weight;
    }

    public static double getValidHeight(Scanner scanner) {
        double height = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your height: ");
            try {
                height = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return height;
    }

    public static String getValidUnit(Scanner scanner, String prompt, String unit1, String unit2) {
        String unit = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            unit = scanner.next().toLowerCase();
            if (unit.equals(unit1) || unit.equals(unit2)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter '" + unit1 + "' or '" + unit2 + "'.");
            }
        }

        return unit;
    }


    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertCentimetersToMeters(double centimeters) {
        return centimeters / 100;
    }

    public static double calculateBMI(double weight, double height,String heightUnit){
        //Converts cm to Meters than calculate the BMI
        if(heightUnit.equalsIgnoreCase("cm")){
            height = convertCentimetersToMeters(height);
        }

        return weight / Math.pow(height,2);
    }

    public static String weightStatus(double bmi) {
        //Prints out Weight status base on what the user BMI is
        return (bmi < 18.5) ? "Underweight" :
               (bmi >= 18.5 && bmi < 24.9) ? "Normal weight" :
               (bmi >= 24.9 && bmi < 29.9) ? "Overweight" : "Obese";

    }
}