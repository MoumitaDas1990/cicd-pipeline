package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.MessageService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestMessageService {

	private MessageService ms = new MessageService();
	
	@Test
	public void testMessage() {
		System.out.println("hello");
		Assertions.assertEquals(ms.sayHello(), "hello");
	}
	
	@Test
	public void testMessage1() {
		System.out.println("Bootcamp");
		Assertions.assertEquals(ms.sayBootcamp(), "Bootcamp");
	}
	
	@Test
	public void testMessage2() {
		System.out.println(10);
		Assertions.assertEquals(ms.sayAddition(8,2), 10);
	}
	
	@Test
	public void testMessage3() {
		System.out.println("40");
		Assertions.assertEquals(ms.saySubtraction(100,60), 40);
	}
	
	@Test
	public void testMessage4() {
		System.out.println(36);
		Assertions.assertEquals(ms.sayMultiplication(6,6), 36);
	}
	
	private MessageServiceExtended ms1 = new MessageServiceExtended();
	
	@Test
	public void testMessage5() {
		System.out.println(90);
		Assertions.assertEquals(ms1.sayDivision(180,2), 90);
	}
	
	
	@Test
	public void testMessage6() {
		System.out.println(70);
		Assertions.assertEquals(ms1.sayAddition(35,10,25), 70);
	}
	
	@Test
	public void testMessage7() {
		System.out.println("10");
		Assertions.assertEquals(ms1.saySubtraction(40,20,10), 10);
	}
	
	@Test
	public void testMessage8() {
		System.out.println(729);
		Assertions.assertEquals(ms1.sayMultiplication(9,9,9), 729);
	}
	
	@Test
	public void testMessage9() {
		System.out.println(240);
		Assertions.assertEquals(ms1.sayMix(40,20,10), 240);
	}
	
	
}
