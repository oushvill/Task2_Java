public class FinanceReportProcessor {

    public static FinanceReport CharReport(FinanceReport reports, char c) {
        FinanceReport conf = new FinanceReport(reports.getQuantityOfReports());
        for (int i = 0; i < reports.getQuantityOfReports(); i++) {
            if (reports.getReports(i).getFioP().equals(""))
                throw new IllegalArgumentException("Строка ФИО пуста.");
            if (Character.toLowerCase(reports.getReports(i).getFioP().charAt(0)) == Character.toLowerCase((char) c)) {
                conf.setReports(reports.getReports(i), i);
            }
        }
        conf.setFioA("Федоровна Екатерина Георгиевна");
        conf.setDay(12);
        conf.setMonth(12);
        conf.setYear(2021);
        return conf;
    }

    public static FinanceReport SumReport(FinanceReport report, double a) {
        FinanceReport conf = new FinanceReport(report.getQuantityOfReports());
        for (int i = 0; i < report.getQuantityOfReports(); i++) {
            if (Double.compare(a, report.getReports(i).getSumPayment()) > 0) {
                conf.setReports(report.getReports(i), i);
            }
        }
        conf.setFioA("Федоровна Екатерина Георгиевна");
        conf.setDay(12);
        conf.setMonth(12);
        conf.setYear(2021);
        return conf;
    }
}