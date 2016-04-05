import java.lang.reflect.Method;

import org.junit.Test;

import static org.junit.Assert.*;


public class PinningTests {
	
	@Test
	//Test to see if 0 will be converted appropriately with newly refactored method
	public void testConvertToIntZero() {
		try {
			int zero = 0;
			MainPanel mainPanel = new MainPanel(15);
			Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
			convertToInt.setAccessible(true);
			int out = (int) convertToInt.invoke(mainPanel, zero);
			assertEquals(zero, out);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	//Test to see if MAX INT will be converted appropriately with newly refactored method
	public void testConvertToIntPositive() {
		try {
			int in = Integer.MAX_VALUE;
			MainPanel mainPanel = new MainPanel(15);
			Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt",  int.class);
			convertToInt.setAccessible(true);
			int out = (int) convertToInt.invoke(mainPanel, in);
			assertEquals(in, out);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	//Test to see if negative MAX INT will be converted appropriately with newly refactored method
	public void testConvertToIntNegative() {
		try {
			int in = Integer.MIN_VALUE;
			MainPanel mainPanel = new MainPanel(15);
			Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
			convertToInt.setAccessible(true);
			int out = (int) convertToInt.invoke(mainPanel, in);
			assertEquals(in, out);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	//Test to determine if the constructor (with a live cell) will still have an 'x' in the middle
	public void testToStringCellConstructorAlive() {
		Cell cell = new Cell(true);
		String x = cell.toString();
		assertEquals(x, "X");
	}
	
	@Test
	//Test to determine if the constructor (with a dead cell) will still have a '.' in the middle
	public void testToStringCellConstructorDead() {
		Cell cell = new Cell(false);
		String period = cell.toString();
		assertEquals(period, ".");
	}
	
	@Test
	//Test to make sure that, even after mutating cell, toString still gives correct string value
	public void testToStringCellMutatorAlive() {
		Cell cell = new Cell(false);
		cell.setAlive(true);
		String x = cell.toString();
		assertEquals(x, "X");
	}
}