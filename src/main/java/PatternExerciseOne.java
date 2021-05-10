package main.java;

public class PatternExerciseOne {

    public static void main(String[] args) {
        Receiver receiver = new Receiver(false, true, true);

        PaymentHandler bankPaymentHandler = new BankPaymentHandler();
        PaymentHandler moneyPaymentHandler = new MoneyPaymentHandler();
        PaymentHandler paypalPaymentHandler = new PayPalPaymentHandler();
        bankPaymentHandler.Successor = paypalPaymentHandler;
        paypalPaymentHandler.Successor = moneyPaymentHandler;

        bankPaymentHandler.Handle(receiver);
    }
}

class Receiver{
    public boolean BankTransfer;
    public boolean MoneyTransfer;
    public boolean PayPalTransfer;

    public Receiver(boolean bt, boolean mt, boolean ppt){
        BankTransfer = bt;
        MoneyTransfer = mt;
        PayPalTransfer = ppt;
    }

    public boolean isBankTransfer() {
        return BankTransfer;
    }

    public void setBankTransfer(boolean bankTransfer) {
        BankTransfer = bankTransfer;
    }

    public boolean isMoneyTransfer() {
        return MoneyTransfer;
    }

    public void setMoneyTransfer(boolean moneyTransfer) {
        MoneyTransfer = moneyTransfer;
    }

    public boolean isPayPalTransfer() {
        return PayPalTransfer;
    }

    public void setPayPalTransfer(boolean payPalTransfer) {
        PayPalTransfer = payPalTransfer;
    }
}

abstract class PaymentHandler{
    public PaymentHandler Successor;

    public abstract void Handle(Receiver receiver);

    public PaymentHandler getSuccessor() {
        return Successor;
    }

    public void setSuccessor(PaymentHandler successor) {
        Successor = successor;
    }
}

class BankPaymentHandler extends PaymentHandler{
    @Override
    public void Handle(Receiver receiver){
        if(receiver.BankTransfer == true){
            System.out.println("Выполняем банковский перевод.");
        } else if(Successor != null){
            Successor.Handle(receiver);
        }
    }
}

class PayPalPaymentHandler extends PaymentHandler{
    @Override
    public void Handle(Receiver receiver){
        if(receiver.PayPalTransfer == true){
            System.out.println("Выполняем перевод через PayPal.");
        } else if(Successor != null){
            Successor.Handle(receiver);
        }
    }
}

class MoneyPaymentHandler extends PaymentHandler{
    @Override
    public void Handle(Receiver receiver){
        if(receiver.MoneyTransfer == true){
            System.out.println("Выполняем перевод через системы денежных переводов.");
        } else if(Successor != null){
            Successor.Handle(receiver);
        }
    }
}

