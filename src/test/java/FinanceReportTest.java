import static org.junit.Assert.*;

public class FinanceReportTest {

    @org.junit.Test // Тест конструктора с параметрами
    public void FinanceReportParamTest() {
        Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 31, 12, 2021, 5099);
        Payment payer2 = new Payment();
        FinanceReport test1 = new FinanceReport(2);
        test1.setFioA("Федоровна Екатерина Георгиевна");
        test1.setDay(12);
        test1.setMonth(12);
        test1.setYear(2021);
        test1.setReports(payer1, 0);
        test1.setReports(payer2, 1);
        String expected = "\t\t\t Автор: Федоровна Екатерина Георгиевна, дата: 12.12.2021. \n" +
                "______________________________________________________________________________________________________________________________________________________________________\n"+
                "  ФИО плательщика: Пуненко Игорь Алексеевич, дата: 31.12.2021, Сумма платежа:  50руб. и 99коп..\n" +
                "  ФИО плательщика: Плательщик отсутствует, дата: 0.0.0, Сумма платежа:  0руб. и 0коп..\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n";
        assertEquals(expected, test1.toString());
    }

    @org.junit.Test // Тест конструктора по умолчанию
    public void FinanceReportDefaultTest() {
        FinanceReport test1 = new FinanceReport();
        String expected = "  ФИО плательщика: Плательщик отсутствует, дата: 0.0.0, Сумма платежа:  0руб. и 0коп..\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n";
        assertEquals(expected, test1.toString());
    }

    @org.junit.Test // Тест конструктора копирования
    public void FinanceReportCopyTest() {
        Payment human1 = new Payment("Пуненко Игорь Алексеевич", 31, 12, 2021, 5099);
        Payment human2 = new Payment();
        FinanceReport test3 = new FinanceReport(2);
        test3.setFioA("Федоровна Екатерина Георгиевна");
        test3.setDay(12);
        test3.setMonth(12);
        test3.setYear(2021);
        test3.setReports(human1, 0);
        test3.setReports(human2, 1);
        FinanceReport test3Copy = new FinanceReport(test3);
        assertEquals(true, test3.equals(test3Copy));
    }

    @org.junit.Test // Тест записи в i-ый платеж
    public void setReportsTest() {
        Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 31, 12, 2021, 5099);
        Payment payer2 = new Payment();
        FinanceReport test1 = new FinanceReport(2);
        test1.setFioA("Федоровна Екатерина Георгиевна");
        test1.setDay(12);
        test1.setMonth(12);
        test1.setYear(2021);
        test1.setReports(payer1, 0);
        test1.setReports(payer2, 1);
        test1.setReports(payer1, 1);
        String expected = "\t\t\t Автор: Федоровна Екатерина Георгиевна, дата: 12.12.2021. \n" +
        "______________________________________________________________________________________________________________________________________________________________________\n"+
                "  ФИО плательщика: Пуненко Игорь Алексеевич, дата: 31.12.2021, Сумма платежа:  50руб. и 99коп..\n" +
                "  ФИО плательщика: Пуненко Игорь Алексеевич, дата: 31.12.2021, Сумма платежа:  50руб. и 99коп..\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n";

        assertEquals(expected, test1.toString());
    }

    @org.junit.Test // Тест чтения i-ого платежа
    public void getReportsTest() {
        Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 31, 12, 2021, 5099);
        FinanceReport test5 = new FinanceReport(2);
        test5.setFioA("Федоровна Екатерина Георгиевна");
        test5.setDay(12);
        test5.setMonth(12);
        test5.setYear(2021);
        test5.setReports(payer1, 0);
        test5.setReports(payer1, 1);
        assertEquals(true, payer1.equals(test5.getReports(0)));
    }

    @org.junit.Test // Тест подсчета количества платежей
    public void getPaymentsTest() {
        FinanceReport test6 = new FinanceReport(2);
        assertEquals(2, test6.getQuantityOfReports());
    }
}