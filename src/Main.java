public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withDraw(10000);
                System.out.println("Успешно. Вывелось 10000 сом. Оставшаяся сумма: " + account.getAmount() + " сом.");
            } catch (LimitException e) {
                System.out.println("Попытка вывести больше оставшейся суммы. Оставшаяся сумма: " + e.getRemainingAmount() + " сом.");
                try {
                    account.withDraw(((int)e.getRemainingAmount()));
                    System.out.println("Остаток снят со счета. \nСумма на счете: " + account.getAmount() + " сом.");
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }

        }
    }
}