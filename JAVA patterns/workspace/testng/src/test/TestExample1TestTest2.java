package test;


import static org.junit.Assert.*;

import org.junit.Test;

import fwk.Beopt;



public class TestExample1TestTest2 {

	@org.testng.annotations.Test
	@Test
	@Beopt("20160101")
	public void test() {
		System.out.println("20160101. Thread: " + Thread.currentThread().getId());
		
		
	}

}
