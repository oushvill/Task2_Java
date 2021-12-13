import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @org.junit.Test
    public void CharReportTest1() {
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
                "  ФИО плательщика: Плательщик отсутствует., дата: 7.7.7, Сумма платежа:  0руб. и 0коп..\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n";
        assertEquals(expected, FinanceReportProcessor.CharReport(test1, 'П').toString());
    }

    @org.junit.Test
    public void CharReportTest2() {
        Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 31, 12, 2021, 5099);
        Payment payer2 = new Payment("Путин Станислав Станиславович", 1, 5, 2002, 9222000);
        Payment payer3 = new Payment("Жижикин Никита Сергеевич", 22, 5, 2020, 150229);
        Payment payer4 = new Payment("Петранян Армен Рубикович", 12, 10, 1999, 750);
        FinanceReport test1 = new FinanceReport(4);
        test1.setFioA("Федоровна Екатерина Георгиевна");
        test1.setDay(12);
        test1.setMonth(12);
        test1.setYear(2021);
        test1.setReports(payer1, 0);
        test1.setReports(payer2, 1);
        test1.setReports(payer3, 2);
        test1.setReports(payer4, 3);
        String expected = "\t\t\t Автор: Федоровна Екатерина Георгиевна, дата: 12.12.2021. \n" +
                "______________________________________________________________________________________________________________________________________________________________________\n"+
                "  ФИО плательщика: Пуненко Игорь Алексеевич, дата: 31.12.2021, Сумма платежа:  50руб. и 99коп..\n" +
                "  ФИО плательщика: Путин Станислав Станиславович, дата: 1.5.2002, Сумма платежа:  92220руб. и 0коп..\n" +
                "  ФИО плательщика: Плательщик отсутствует., дата: 7.7.7, Сумма платежа:  0руб. и 0коп..\n" +
                "  ФИО плательщика: Петранян Армен Рубикович, дата: 12.10.1999, Сумма платежа:  7руб. и 50коп..\n" +
                "______________________________________________________________________________________________________________________________________________________________________\n";
        assertEquals(expected, FinanceReportProcessor.CharReport(test1, 'п').toString());
    }

    @org.junit.Test
    public void CharReportTest3() {
        try {
            Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 5, 11, 2019, 36000);
            Payment payer2 = new Payment("Путин Станислав Станиславович", 1, 5, 2002, 9222000);
            Payment payer3 = new Payment("", 5, 3, 2004, 6000);

            FinanceReport test1 = new FinanceReport(3);
            test1.setFioA("Федоровна Екатерина Георгиевна");
            test1.setDay(12);
            test1.setMonth(12);
            test1.setYear(2021);
            test1.setReports(payer1, 0);
            test1.setReports(payer2, 1);
            test1.setReports(payer3, 2);
        } catch (IllegalArgumentException err) {
            System.err.println("Ошибка! Не у всех плательщиков указано имя.");
        }
    }

    @org.junit.Test
    public void SumReport() {
        Payment payer1 = new Payment("Пуненко Игорь Алексеевич", 5, 11, 2019, 36);
        Payment payer2 = new Payment("Путин Станислав Станиславович", 1, 5, 2002, 924);
        Payment payer3 = new Payment("Жижикин Никита Сергеевич", 22, 5, 2020, 0);
        Payment payer4 = new Payment("Бекмухан Адиль Амантаевич", 5, 11, 2019, 100);
        Payment payer5 = new Payment();

        FinanceReport test2 = new FinanceReport(5);
        test2.setFioA("Федоровна Екатерина Георгиевна");
        test2.setDay(10);
        test2.setMonth(12);
        test2.setYear(2021);
        test2.setReports(payer1, 0);
        test2.setReports(payer2, 1);
        test2.setReports(payer3, 2);
        test2.setReports(payer4, 3);
        test2.setReports(payer5, 4);
        int sum = 1000;
        String expected = "\t\t\t Автор: Федоровна Екатерина Георгиевна, дата: 12.12.2021. \n" +
                "______________________________________________________________________________________________________________________________________________________________________\n"+
                "  ФИО плательщика: Пуненко Игорь Алексеевич, дата: 5.11.2019, Сумма платежа:  0руб. и 36коп..\n"+
                "  ФИО плательщика: Путин Станислав Станиславович, дата: 1.5.2002, Сумма платежа:  9руб. и 24коп..\n" +
                "  ФИО плательщика: Жижикин Никита Сергеевич, дата: 22.5.2020, Сумма платежа:  0руб. и 0коп..\n" +
                "  ФИО плательщика: Бекмухан Адиль Амантаевич, дата: 5.11.2019, Сумма платежа:  1руб. и 0коп..\n" +
                "  ФИО плательщика: Плательщик отсутствует, дата: 0.0.0, Сумма платежа:  0руб. и 0коп..\n"+
                "______________________________________________________________________________________________________________________________________________________________________\n";
        assertEquals(expected,FinanceReportProcessor.SumReport(test2, sum).toString());
    }
}