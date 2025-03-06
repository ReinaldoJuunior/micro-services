package com.devsuperior.hrpayroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.devsuperior.hrpayroll.entities.Payment;

@SpringBootTest
class HrPayrollApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testPaymentCalculation() {
		Payment payment = new Payment("John", 10.0, 4);
		assertEquals(40.0, payment.getTotal());
	}

	@Test 
	void testPaymentWorkerData() {
		Payment payment = new Payment("Alice", 20.0, 5);
		assertEquals("Alice", payment.getName());
		assertEquals(20.0, payment.getDailyIncoming());
		assertEquals(5, payment.getDays());
	}

	@Test
	void testPaymentNegativeDays() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Payment("Bob", 15.0, -1);
		});
	}

	@Test
	void testPaymentZeroDailyIncome() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Payment("Junior", 0.0, 3);
		});
	}

	@Test
	void testPaymentNegativeDailyIncome() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Payment("Junior", -10.0, 3);
		});
	}

	@Test
	void testPaymentZeroDays() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Payment("Charlie", 25.0, 0);
		});
	}

	@Test
	void testPaymentSetters() {
		Payment payment = new Payment("Dave", 30.0, 5);
		payment.setName("David");
		payment.setDailyIncoming(35.0);
		payment.setDays(6);
		
		assertEquals("David", payment.getName());
		assertEquals(35.0, payment.getDailyIncoming());
		assertEquals(6, payment.getDays());
		assertEquals(210.0, payment.getTotal());
	}

	@Test
	void testPaymentDefaultConstructor() {
		Payment payment = new Payment();
		payment.setName("Eve");
		payment.setDailyIncoming(40.0);
		payment.setDays(3);
		
		assertEquals("Eve", payment.getName());
		assertEquals(40.0, payment.getDailyIncoming());
		assertEquals(3, payment.getDays());
		assertEquals(120.0, payment.getTotal());
	}

}
