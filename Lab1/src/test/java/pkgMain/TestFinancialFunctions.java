package pkgMain;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

public class TestFinancialFunctions {

	@Test 
	public void TestPV()
	{
		double r = 0.02/12;
		double n = 20 * 12;
		double y = -7358.00;
		double f = 0;
		boolean t = false;		
		double  expected = 1454485.55;
		double pv = cMain.FindPV(r, n, y, f, t);
		assertEquals(expected, pv,0.01);
		System.out.printf("$%.2f \n",pv);	

		r = 0.07/12;
		n = 40 * 12;
		
		double pmt = cMain.FindPMT(r, n, 0, pv, t);
		
		System.out.printf("$%.2f \n",Math.abs(pmt));
		
	}
}
