
public class BankAccount {
        private double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void deposit(double sum) {
            setAmount(getAmount() + sum);
        }

        public void withDraw(int sum) throws LimitException {
            if (sum > getAmount()) {
                throw new LimitException("Ошибка. У вас на счете: " + getAmount() + ". В указали сумму: " + sum, amount);
            } else {
                setAmount(getAmount() - sum);
            }
        }
    }
