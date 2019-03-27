package com.js284;

import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

class DiscountCalculator {

    public int Calculate(int _units, String _paymentType, String _companyType){
        if ( _paymentType.equals("on") && _companyType.equals("not_wholesale")){
            //_units<50 ? return 2 : return 4;
            if(_units<50)
                return 2;
            return 4;            
        }

        if ( _paymentType.equals("on") && _companyType.equals("wholesale")){
            if(_units<50)
                return 4;
            return 6;            
                
        }

        if ( _paymentType.equals("before") && _companyType.equals("not_wholesale")){
            if(_units<50)
                return 0;
            return 2;            
        }

        if ( _paymentType.equals("before") && _companyType.equals("wholesale")){
            if(_units<50)
                return 2;
            return 4;            
        }

        return 0;
    }
    
}



public class Stepdefs {

    int _units;
    String _paymentType;
    String _companyType;
    int _calculatedDiscount;

    @Given("^(\\d+) of units$")
    public void of_units(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this._units = arg1;
    }

    @Given("^cash \"([^\"]*)\" delivery$")
    public void cash_delivery(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this._paymentType = arg1;
    }

    @Given("^company type is a \"([^\"]*)\"$")
    public void company_type_is_a(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        this._companyType = arg1;
    }

    @When("^calculating the discount$")
    public void calculating_the_discount() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        DiscountCalculator DC = new DiscountCalculator();
        this._calculatedDiscount = DC.Calculate(this._units, this._paymentType, this._companyType);
    }

    @Then("^the discount is (\\d+)$")
    public void the_discount_is(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(arg1, this._calculatedDiscount);
    }

}