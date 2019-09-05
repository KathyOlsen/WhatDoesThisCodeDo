import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double loanAmt = 0;
        double intRateAnnual = 0;
        double minMonthlyPaymt = 0;
        double totalPayableToBank = 0;
        int termYears;

        System.out.printf("Enter the loan amount: ");
        loanAmt = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        intRateAnnual = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        termYears = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        minMonthlyPaymt = processSomething(loanAmt, intRateAnnual, termYears);
        //this is calculated separately below
        totalPayableToBank = minMonthlyPaymt * (termYears*12);
        //this is total principal and interest the mortgagee will pay to bank if mortgagee does not pay off loan early
        System.out.format("%-30s$%-+10.2f%n", "Total you will pay to bank (if you maintain mortgage for full term of loan): ", totalPayableToBank);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", minMonthlyPaymt);
    }


    public static double processSomething(double loanAmt, double intRateAnnual, int termYears) {
        // calculates the minimum monthly payment
        double intRateMonthly = (intRateAnnual/ 100) / 12;
        double base = (1 + intRateMonthly);
        double termMonths = termYears * 12;
        double minMonthlyPaymt = 0.0;
        minMonthlyPaymt = ((intRateMonthly * loanAmt) / (1 - Math.pow(base, -termMonths)));

        return minMonthlyPaymt;
    }
}