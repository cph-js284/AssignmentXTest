Feature: Calculate the discount 

   # Scenario: Calculate_discount_test
   # Given 50 units or more
   # Given cash is paid "on_delivery"
   # Given the company is of type ""wholesale""
   # When calculating the discount
   # Then the discount is 6



   Scenario Outline: 
   Given <number> of units
   Given cash <"on"> delivery
   Given company type is a <typeofcompany> 
   When calculating the discount
   Then the discount is <discount>

   Examples:
   | number | "on" | typeofcompany | discount |
   | 49 | "before" | "not_wholesale" | 0 |
   | 49 | "before" | "wholesale" | 2 |
   | 49 | "on" | "not_wholesale" | 2 |
   | 49 | "on" | "wholesale" | 4 |
   | 50 | "before" | "not_wholesale" | 2 |
   | 50 | "before" | "wholesale" | 4 |
   | 50 | "on" | "not_wholesale" | 4 |
   | 50 | "on" | "wholesale" | 6 |
