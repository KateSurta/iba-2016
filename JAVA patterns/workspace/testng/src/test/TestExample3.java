package test;


import org.testng.annotations.Test;

import fwk.Beopt;


public class TestExample3
{
	@Test
	@Beopt("20160101")
	public void test3_1()
	{
		System.out.println("test3_1 - 20160101. Thread: " + Thread.currentThread().getId());
	}

	@Test
	@Beopt("20160101")
	public void test3_2()
	{
		System.out.println("test3_2 - 20160101. Thread: " + Thread.currentThread().getId());
	}
	
	@Test
	@Beopt("20160829")
	public void test3_3()
	{
		System.out.println("test3_3 - 20160829. Thread: " + Thread.currentThread().getId());
	}
	@Test(groups = {"20160829"})
	@Beopt("20160829")
	public void test3_4()
	{
		System.out.println("test3_4 - 20160829. Thread: " + Thread.currentThread().getId());
	}
}
