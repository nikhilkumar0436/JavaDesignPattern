package com.pratice;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactoryBuilder abstractFactoryBuilder = new AbstractFactoryBuilder();
        AbstractFactory bankFactory = abstractFactoryBuilder.getFactory("bank");
        Bank bank = bankFactory.getBank("hdfc");
        System.out.println(bank.getBankName());
        AbstractFactory loanFactory = abstractFactoryBuilder.getFactory("loan");
        Loan loan = loanFactory.getLoan("homeloan");
        loan.getInterestRate();
        System.out.println(loan.calculatePremium(100000, 5));

    }
}

//Expected outcomes
//HDFC
//5750.0
interface Bank {
    String getBankName();
}

class Hdfc implements Bank {
    @Override
    public String getBankName() {
        return "HDFC";
    }
}

class Icici implements Bank {
    @Override
    public String getBankName() {
        return "ICICI";
    }
}

abstract class Loan {
    protected double interestRate;

    abstract void getInterestRate();

    public double calculatePremium(int amount, int years) {
        //add logic
        //just putting dummy values
        return 5750;
    }
}

class HomeLoan extends Loan {

    @Override
    void getInterestRate() {
        interestRate = 9.00;
    }
}

class CarLoan extends Loan {

    @Override
    void getInterestRate() {
        interestRate = 12.00;
    }
}

abstract class AbstractFactory {
    abstract Bank getBank(String bankName);

    abstract Loan getLoan(String loanName);
}

class BankFactory extends AbstractFactory {

    @Override
    Bank getBank(String bankName) {
        if (bankName.equalsIgnoreCase("hdfc")) {
            return new Hdfc();

        } else if (bankName.equalsIgnoreCase("icici")) {
            return new Icici();
        }
        return null;
    }

    @Override
    Loan getLoan(String LoanName) {
        return null;
    }
}

class LoanFactory extends AbstractFactory {

    @Override
    Loan getLoan(String loanName) {
        if (loanName.equalsIgnoreCase("homeloan")) {
            return new HomeLoan();

        } else if (loanName.equalsIgnoreCase("carloan")) {
            return new CarLoan();
        }
        return null;
    }

    @Override
    Bank getBank(String bankName) {
        return null;
    }
}

class AbstractFactoryBuilder {
    public AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase("bank")) {
            return new BankFactory();
        } else if (factoryName.equalsIgnoreCase("loan")) {
            return new LoanFactory();
        }
        return null;
    }
}