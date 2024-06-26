package src.system.compensation;

import src.system.user.Customer;
import src.system.user.CustomerListImpl;

import java.text.NumberFormat;


public class Compensation {

    private  long compensationId;
    private long insuranceId;


    private long customerId;
    private Customer customer;

    private double money;

    public long getCompensationId() {
        return compensationId;
    }

    public void setCompensationId(long compensationId) {
        this.compensationId = compensationId;
    }

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Compensation(double money, long customerId, CustomerListImpl customerList) {
        this.money = money;
        this.customerId = customerId;
        this.customer = customerList.get(customerId);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(0);
        return
                "보상아이디: '" + compensationId + '\'' +
                "고객아이디: '" + customerId + '\'' +
                ", 보상금: '" + nf.format(money)+ '\'' ;
    }


    public void finalize() throws Throwable {

    }


    public boolean pay() {
        if(customer.getAccount() == null){
            return false;
        }
        return  true;
    }

}
