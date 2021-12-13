import java.util.Objects;

public class Payment {
    private String fioP;
    private int day;
    private int month;
    private int year;
    private int SumPayment;

    public Payment() {
        this.fioP = "Плательщик отсутствует";
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.SumPayment = 0;
    }

    public Payment(String fioP, int d, int m, int y, int sum) {
        this.fioP = fioP;
        boolean flag;
        if (((year % 4 == 0) && (year % 100) != 0) || (year % 400 == 0)) {
            this.year = y;
            flag = false;
        }
        else if (year > 0) {
            this.year = y;
            flag = true;
        } else {
            throw new IllegalArgumentException("Некорректно введен год");
        }
        if (1 <= m && m <= 12) month = m;
        else throw new IllegalArgumentException("Некорректно введен месяц");
        if (month == 2 && flag == true) {
            if (1 <= d && d <= 29) day = d;
            else throw new IllegalArgumentException("Некорректно введен день");
        }
        else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 <= d && d <= 31) day = d;
                else throw new IllegalArgumentException("Некорректно введен день!");
            }
            else {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (1 <= d && d <= 30) day = d;
                    else throw new IllegalArgumentException("Некорректно введен день!");
                }
            }
        }
        this.SumPayment = sum;
    }


    // Сеттеры и геттеры
    public String getFioP() {return fioP;}

    public int getDay() {return day;}

    public int getMonth() {return month;}

    public int getYear() {return year;}

    public int getSumPayment() {return SumPayment;}

    @Override
    public boolean equals(Object h) {
        if (this == h) return true;
        if (h == null || getClass() != h.getClass()) return false;
        Payment payment = (Payment) h;
        return day == payment.day
                && month == payment.month && year == payment.year
                && Double.compare(payment.SumPayment, SumPayment) == 0
                && Objects.equals(fioP, payment.fioP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fioP, day, month, year, SumPayment);
    }

    @Override
    public String toString() {
        return "Плательщик: " + fioP +
                ", дата: " + day + '.' + month + '.' + year +
                ", Сумма платежа: " + SumPayment / 100 + " руб. " + SumPayment % 100 + " коп.";
    }
}
