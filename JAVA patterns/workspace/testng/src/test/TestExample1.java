package test;


import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import fwk.Beopt;



public class TestExample1
{
	@Test()
	@Beopt("20110101")
	public void test1_1()
	{
		System.out.println("test1_1 - 20110101. Thread: " + Thread.currentThread().getId());
	}

	@Test
	@Beopt("20160101")
	@Configuration
		public void test1_2()
	{
		System.out.println("test1_2 - 20160101. Thread: " + Thread.currentThread().getId());
	}
	
	@Test
	public void test1_3()
	{
		System.out.println("test1_3. Thread: " + Thread.currentThread().getId());
	}
}
