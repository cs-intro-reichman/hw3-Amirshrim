// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
	}

	
	private static double endBalance(double loan, double rate, int n, double payment) {	
	    double r = rate / 100.0;   
	    double balance = loan;

	    for (int i = 0; i < n; i++) {
	        balance = (balance - payment) * (1 + r);
	    }
	    return balance;
	}
	
	// Brute-force sequential search
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;

		double g = loan / n;

		while (endBalance(loan, rate, n, g) > 0) {
			g += epsilon;
			iterationCounter++;
		}
		return g;
    }
    
    // Bisection search
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;

		double L = 0;
		double H = loan;
		double g = (L + H) / 2;

		while ((H - L) > epsilon) {
			iterationCounter++;
			g = (L + H) / 2.0;

			double bal = endBalance(loan, rate, n, g);

			if (bal > 0) {
				L = g;     
			} else {
				H = g;     
			}
		}
		return g;
    }
}