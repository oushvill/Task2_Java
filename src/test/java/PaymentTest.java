import static org.junit.Assert.*;

public class PaymentTest {

    @org.junit.Test
    public void PaymentTest() {
        Payment test = new Payment();
        assertEquals("Плательщик: Плательщик отсутствует, дата: 0.0.0, Сумма платежа: 0 руб. 0 коп.", test.toString());
    }

    @org.junit.Test
    public void PaymentTestParametr1() {
        try {
            Payment test = new Payment("Щербаков Алексей Сергеевич", 0, 12, 1987, 100);
        } catch (IllegalArgumentException err) {
            System.err.println("День введен не правильно.");
        }
    }
    @org.junit.Test
    public void PaymentTestParametr2() {
        try {
            Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 0, 1987, 100);
        } catch (IllegalArgumentException err) {
            System.err.println("Месяц введен не правильно.");
        }
    }
    @org.junit.Test
    public void PaymentTestParametr3() {
        try {
            Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, -4, 100);
        } catch (IllegalArgumentException err) {
            System.err.println("Год введен не правильно.");
        }
    }


    @org.junit.Test
    public void getFioPTest() {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(test.getFioP(), "Щербаков Алексей Сергеевич");
    }
    @org.junit.Test
    public void getDayTest() {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(test.getDay(), 13);
    }
    @org.junit.Test
    public void getMonthTest() {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(test.getMonth(), 12);
    }
    @org.junit.Test
    public void getYearTest() {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(test.getYear(), 1987);
    }


    @org.junit.Test
    public void equalsTest() {
        Payment test1 = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        Payment test2 = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(true, test1.equals(test2));
    }
    @org.junit.Test
    public void hashCodeTest() {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals(-1024749047, test.hashCode());
    }
    @org.junit.Test
    public void toStringTest() throws IllegalArgumentException {
        Payment test = new Payment("Щербаков Алексей Сергеевич", 13, 12, 1987, 100);
        assertEquals("Плательщик: Щербаков Алексей Сергеевич, дата: 13.12.1987, Сумма платежа: 1 руб. 0 коп.", test.toString());
    }
}
