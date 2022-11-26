Feature: homepage user

  Background: login pendaki
    Given user already login


    Scenario: user wanted to book a products
      When user choose one product to book
      Then Product added to booking now with message "Added to Booking Now"
      And user choose a second product
      Then Product added to booking now with message "Product Added to Booking Now"
      When user choose a third product
      Then Product added to booking now with message "Product Added to Booking Now"


    Scenario: user wanted to see product detail
      When user click on product picture
      Then should be directed to product detail page