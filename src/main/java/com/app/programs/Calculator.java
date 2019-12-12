
/* @Copyright,2019 YBM Inc.  Disclosing valuable information should be avoided. 
 * All the rights are reserved by YBM Inc. 
 * Terms and condition will apply.
 */

package com.app.programs;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;



public class Calculator {

	static Logger logger = Logger.getLogger(Calculator.class);

	private void calculate(int num1, int num2) {

		String s1 = null;
		logger.debug("Calculator.calculate()-starts");

		logger.info("Num1:" + num1 + " Num2:" + num2);

		if (num2 == 0) {
			logger.warn("Donot divide by num2.");
		}

		try {
			int res = num1 / num2;
			logger.info("Result:" + res);
			// throw new IOException();
			// s1.charAt(0); NPE
			// InputStream is=new FileInputStream("sandip.txt");
			Class.forName("Sandip");
		} catch (ArithmeticException ae) {
			logger.error("Arithmatica exceptions", ae);
		} catch (Exception e) {
			logger.fatal("Unknown exception", e);
		}

		logger.debug("Calculator.calculate()-ends");

	}

	public static void main(String[] args) {

		PropertyConfigurator.configure(Calculator.class.getResourceAsStream("/log4j_development.properties"));

		MDC.put("client1", "abc");
		MDC.put("city", "bhd");

		logger.debug("Calculator.main()--starts");
		logger.debug("Programs started...");
		long t1 = System.currentTimeMillis();
		Calculator calculator = new Calculator();
		calculator.calculate(10, 0);

		long t2 = System.currentTimeMillis();
		logger.debug("Calculator.main()--ends In:(t2-t1):" + (t2 - t1));
		logger.debug("------------------------------------------------------------------");
	}
}
