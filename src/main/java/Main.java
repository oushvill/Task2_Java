
public class Main {

    public static void main(String[] args) {
        System.out.println("\t[[ 1-4 ЗАДАНИЕ ]]");
        // STRING
        String str = new String("$$$ ");
        System.out.println("№1. Введеная строка [ "+str+"] повторяется n раз.");
        try {
            String repeatedStr = StringProcessor.repeatString(str,5);
            System.out.println("Полученная строка повторилась : '" + repeatedStr + "'.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Введено отрицательное число n");
        }
        System.out.println();


        System.out.println("№2. Ищется количество вхождений подстроки в строку.");
        String initStr = new String ("розовые розы розовеют на морозе");
        String substr = "роз";
        int numOfEnterence = StringProcessor.containNum( initStr, substr );
        System.out.println("Строка '" + substr + "' входит в строку '" + initStr + "' " + numOfEnterence + " раз.");
        System.out.println();

        System.out.println("№3. Заменем числа 1, 2, 3 на строки.");
        String numString = new String("1234567890");
        String changedString = StringProcessor.replaceSubString(numString);
        System.out.println("Исходная строка: '" + numString + "'.");
        System.out.println("Изменённая строка: '" + changedString + "'.");

        System.out.println("№4. Удаление каждого второго символа.");
        StringBuilder binaryString = new StringBuilder("10101010101010101");
        System.out.println("Исходная строка: '" + binaryString + "'.");
        StringProcessor.deleteSecondChar(binaryString);
        System.out.println("Изменённая строка: '" + binaryString + "'.");
        System.out.println();


        System.out.println("\n\n\t[[ 7-11 ЗАДАНИЕ ]]");
        // PAYMENT/FINANCE/FINANCEPROCESSOR
        FinanceReport report0= new FinanceReport(3);
        int reportsCount = report0.getQuantityOfReports();
        System.out.println("Класс Payment/Finance: ");
        // Данные о составителе
        report0.setFioA("Федоровна Екатерина Георгиевна");
        report0.setDay(12);
        report0.setMonth(12);
        report0.setYear(2021);

        // Ввод данных плательщиков
        Payment payer1 = new Payment("Пуненко Алексей Сергеевич", 13, 12, 1987, 100);
        Payment payer2 = new Payment("Бекмухан Адиль Амантаевич", 5, 11, 2019, 36000);
        Payment payer3 = new Payment("Жижикин Никита Сергеевич", 22, 5, 2020, 150229);

        // Заполнение таблицы платежей
        report0.setReports(payer1, 0);
        report0.setReports(payer2, 1);
        report0.setReports(payer3, 2);
        String repOut = report0.toString();
        System.out.println("Количество платежей: " + reportsCount);
        System.out.println(repOut);


        // Получение сводки о конкретном платеже
        Payment payInfo = report0.getReports(2);
        System.out.println("Вызванный платёж [" + payInfo + "]\n");

        // Хэшкоды плательщиков
        System.out.println("Проверка платежей на совпадение");
        int h1 = payer1.hashCode();
        System.out.printf("Код плательщика #1 %s: %d\n", payer1.getFioP(), h1);
        int h2 = payer2.hashCode();
        System.out.printf("Код плательщика #2 %s: %d\n",  payer2.getFioP(), h2);

        if (payer1.equals(payer2)) {
            System.out.println("Платежи совпадают!");
        }
        else {
            System.out.println("Платежи не совпадают!");
        }
        System.out.println();

        // Копирование исходного массива платежей
        FinanceReport report2 = new FinanceReport(report0);

        System.out.println("\nКопия таблицы платежей:");
        String reportCopy = report2.toString();
        System.out.println(reportCopy);
        System.out.println();

        System.out.println("Класс FinanceProcessor: ");
        FinanceReport CharRep = FinanceReportProcessor.CharReport(report0, 'П');
        System.out.println("\t\t\t 1.Фамилии плательщиков, которые начинаются на указанные символ:");
        String reportChar = CharRep.toString();
        System.out.println(reportChar);
        System.out.println();
        FinanceReport SumRep = FinanceReportProcessor.SumReport(report0, 50000);
        System.out.println("\t\t\t 2.Платежи, чья сумма меньше указанной:");
        String reportSum = SumRep.toString();
        System.out.println(reportSum);

    }
}
