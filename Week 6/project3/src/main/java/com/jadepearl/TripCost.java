package com.jadepearl;

public class TripCost {

    private double distance;
    private double gas;
    private double miles;
    private int days;
    private double hotel;
    private double food;
    private double attractions;

    public TripCost(double distance, double gas, double miles, int days, double hotel, double food, double attractions) {
        this.distance = distance;
        this.gas = gas;
        this.miles = miles;
        this.days = days;
        this.hotel = hotel;
        this.food = food;
        this.attractions = attractions;
    }

    public double totalCost() {
        if(distance >= 0 && gas >= 0 && miles >= 0 && days >= 0 && hotel >= 0 && food >= 0 && attractions >= 0) {
            //calculate total cost of gas
            double gasTotal = (distance/miles) * gas;
            double total = gasTotal + (hotel+food) * days + attractions;
            return total;
        }
        return 0.0;
    }
}