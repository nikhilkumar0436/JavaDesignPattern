package com.pratice;

public class FactoryDesignPattern {
    public static void main(String... args) {
        Plan homeplan = new HomePlan();
        Plan commercialPlan = new CommercialPlan();
        Plan subSidyPlan = new SubsidyPlan();
        homeplan.getRate();
        commercialPlan.getRate();
        subSidyPlan.getRate();
        System.out.println("Electricity Bill for Home plan of 500 unit is " + homeplan.CalculateBill(500));
        System.out.println("Electricity Bill for Commercial plan of 500 unit is " + commercialPlan.CalculateBill(500));
        System.out.println("Electricity Bill for Subsidy plan of 500 unit is " + subSidyPlan.CalculateBill(500));
    }

}
//Expected Results
//Electricity Bill for Home plan of 500 unit is 2750.0
//Electricity Bill for Commercial plan of 500 unit is 5250.0
//Electricity Bill for Subsidy plan of 500 unit is 250.0
abstract class Plan {
    protected double rate;

    public abstract void getRate();

    public double CalculateBill(int units) {
        return Math.round(units * rate);
    }
}

class HomePlan extends Plan {
    @Override
    public void getRate() {
        rate = 5.50;
    }
}

class CommercialPlan extends Plan {
    @Override
    public void getRate() {
        rate = 10.50;
    }
}

class SubsidyPlan extends Plan {
    @Override
    public void getRate() {
        rate = 0.50;
    }
}