import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String answer;


        while (true) {
            System.out.print("Do you want to calculate BMI? (Yes/No): ");
            answer = scanner.next();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                double weight = BMI.getValidWeight(scanner);
                String weightUnit = BMI.getValidUnit(scanner, "Enter your weight unit (kg or lb): ", "kg", "lb");
                double height = BMI.getValidHeight(scanner);
                String heightUnit = BMI.getValidUnit(scanner, "Enter your height unit (m or cm): ", "m", "cm");



                /* weightInKg: if the unit is kg(Kilograms) the weight remains the same and if its in pounds the
                number then we convert it to Kilograms

                   heightInMeters: If the unit is cm(Centimeters) height remains the same else we convert the user
                   input which will be in meters(m) and convert in to centimeters(cm)

                 */
                double weightInKg = weightUnit.equalsIgnoreCase("kg") ? weight : BMI.convertPoundsToKilograms(weight);

                double heightInMeters = heightUnit.equalsIgnoreCase("cm") ? height : BMI.convertCentimetersToMeters(height);

                double bmi = BMI.calculateBMI(weightInKg, heightInMeters,heightUnit);


                String BMI_Status = BMI.weightStatus(bmi);


                System.out.printf("Your BMI is:  %.2f",bmi);
                System.out.println(" Weight Status: " + "(" + BMI_Status + ")");


                break;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                System.out.println("Exiting BMI Calculator. Thank you!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
            }
        }

        scanner.close();
    }
}
