public class FinanceReport {
    private final Payment[] reports;
    private int quantityOfReports;
    private int day, month, year;
    private String fioA;

    public FinanceReport(int n) {
        reports = new Payment[n];
        quantityOfReports = n;
        for (int i = 0; i < quantityOfReports; i++) {
            reports[i] = new Payment("Плательщик отсутствует.", 7, 7, 7, 0);
        }
    }

    public FinanceReport() {
        this.quantityOfReports = 0;
        reports = new Payment[quantityOfReports];
        this.fioA = "UnknownFormer";
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public FinanceReport(FinanceReport report) {
        this.quantityOfReports = report.getQuantityOfReports();
        this.reports = report.getReports();
        this.day = report.getDay();
        this.month = report.getMonth();
        this.year = report.getYear();
        this.fioA = report.getFioA();
    }

    public Payment getReports(int i) {
        return reports[i];
    }
    public void setReports(Payment report, int i) {
        this.reports[i] = report;
    }

    public String getFioA() {
        return fioA;
    }
    public void setFioA(String fioA) {
        this.fioA = fioA;
    }

    public int getDay() { return day; }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantityOfReports() {
        return quantityOfReports;
    }
    public Payment[] getReports(){
        return reports;
    }


    @Override
    public boolean equals(Object rep) {
        if (this == rep) return true;
        if (!(rep instanceof FinanceReport)) return false;
        FinanceReport rep1 = (FinanceReport) rep;
        return  getQuantityOfReports() == rep1. getQuantityOfReports()
                && getDay() == rep1.getDay()
                && getMonth() == rep1.getMonth()
                && getYear() == rep1.getYear()
                && getFioA().equals(rep1.getFioA());
    }

    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        String head = "\t\t\t Автор: %s, дата: %d.%d.%d. \n";
        String pFirst = "  ФИО плательщика: %s, дата: %d.%d.%d, Сумма платежа:  %dруб. и %dкоп..\n";
        String pLast = "  ФИО плательщика: %s, дата: %d.%d.%d, Сумма платежа:  %dруб. и %dкоп..\n";
        String line="______________________________________________________________________________________________________________________________________________________________________\n";

        n.append(String.format(head, getFioA(), getDay(), getMonth(), getYear()));
        n.append(String.format("%s", line));
        for (int i = 0; i < quantityOfReports; i++) {
            if (i == quantityOfReports - 1) {
                n.append(String.format(pFirst, reports[i].getFioP(), reports[i].getDay(), reports[i].getMonth(), reports[i].getYear(), reports[i].getSumPayment()/100, reports[i].getSumPayment()%100));
            } else {
                n.append(String.format(pLast, reports[i].getFioP(), reports[i].getDay(), reports[i].getMonth(), reports[i].getYear(), reports[i].getSumPayment()/100, reports[i].getSumPayment()%100));
            }
        }
        n.append(String.format("%s", line));
        return n.toString();
    }
}