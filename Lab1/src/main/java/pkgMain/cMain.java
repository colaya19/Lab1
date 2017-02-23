/*
 * Lab1: Connor Olaya, Wyatt Mccabe, Thanh Tung Trinh, Ian Mears
 */
package pkgMain;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.*;

public class cMain 
{
	static Scanner scanns = new Scanner(System.in);
	
	static int yrswork = 0;
	static int annreturn1 = 0;
	static int yrsretire = 0;
	static int annreturn2 = 0;
	static int mincash = 0;
	static int SSI = 0;
	static double difference = 0.0;
	static double rate1 = 0.0;
	static double rate2 = 0.0;
	static double pv = 0.0;
	static double pmt = 0.0;
	
	public static void main(String[] args) 
	{
		System.out.println("How many years do you plan to work?");
		yrswork = scanns.nextInt();
		
		System.out.println("What do you expect your annual return on investments will be during this time?");
		annreturn1 = scanns.nextInt();
		rate1 = (annreturn1/100.0)/12.0;
		
		System.out.println("How many years do you plan on being retired?");
		yrsretire = scanns.nextInt();
		
		System.out.println("What do you expect your annual return on investments to be during this time?");
		annreturn2 = scanns.nextInt();
		rate2 = (annreturn2/100.0)/12.0;

		System.out.println("How much money will you need a month to survive during retirement?");
		mincash = scanns.nextInt();
		
		System.out.println("What do you expect to recieve from SSI during retirement?");
		SSI = scanns.nextInt();
		
		difference = (mincash - SSI)*-1;
		
		pv = FindPV(rate2, yrsretire*12.0,difference,0,false);
		pmt = Math.abs(FindPMT(rate1, yrswork*12.0, 0, pv, false));
		
		System.out.printf("You must save this much a month while working: $%.2f \n", pmt);
		System.out.printf("In order to have this much when you're retired $%.2f \n" , pv);
		

	}
	
	public static double FindPMT(double r, double n, double p, double f, boolean t) ///Periodic Payment
	{
		return FinanceLib.pmt(r, n, p, f, t);
	}
	
	
	public static double FindPV(double r, double n, double y, double f, boolean t)///Present Value
	{
		return FinanceLib.pv(r, n, y, f, t);
		//PV will get you second green number
	}

	/*
	 * p = present value
	 * f = future value
	 * n = number of payments
	 * y = payment (in each period)
	 * r = rate
	 * */
}
