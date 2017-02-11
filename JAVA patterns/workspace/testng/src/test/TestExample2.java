package test;


import org.testng.annotations.Test;

import fwk.Beopt;

public class TestExample2
{
	@Test
	@Beopt("20110101")
	public void test2_1()
	{
		System.out.println("test2_1 - 20110101. Thread: " + Thread.currentThread().getId());
	}

	@Test
	@Beopt("20110101")
	public void test2_2()
	{
		System.out.println("test2_2 - 20110101. Thread: " + Thread.currentThread().getId());
	}
	
	@Test
	@Beopt("20110101")
	public void test2_3()
	{
		System.out.println("test2_3 - 20110101. Thread: " + Thread.currentThread().getId());
	}
	@Test
	@Beopt("20160101")
	public void test2_4()
	{
		System.out.println("test4_4 - 20160101. Thread: " + Thread.currentThread().getId());
	}
}
