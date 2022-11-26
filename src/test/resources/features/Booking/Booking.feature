Feature: Booking tickets
  Background:
    Given I already on log in page
    And I input email "aariuser@guntour.com"
    And I input password "P4assword"
    And I click login button
    And I click pop up success message login button

  @positive @booking
  Scenario: Book ticket with a product
    When I click on book now button on selected product
    Then Product added to booking now with message "Added to Booking Now"
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    And I do scroll down
    And I add quantity on selected product
    And I add quantity on selected product
    Then The quantity products is "3"
    When I click minus icon on selected product
    Then The quantity products is "2"
    When I click booked now button
    And I see pop up confirmation "Are you sure the data is correct?"
    And I click yes sure on alert pop up
    Then I redirected to confirmation page
    When I click on confirm button
    Then I see pop up message "Confirmation Successful"
    And I redirected to booking history page

  @positive @booking
  Scenario: Book ticket without product and cancel on confirm page
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    And I click booked now button
    Then I see pop up message "Are you sure the data is correct?"
    When I click yes sure on alert pop up
    Then I redirected to confirmation page
    When I click on cancel button
    Then I redirected to booking page

  @positive @booking
  Scenario: Book ticket with all valid value but cancel on confirm alert
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    And I click booked now button
    Then I see pop up message "Are you sure the data is correct?"
    When I click cancel on alert pop up
    Then I redirected to booking page

  @positive @booking
  Scenario: Book ticket with all valid value without input product
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    When I click booked now button
    Then I see pop up message "Are you sure the data is correct?"
    When I click yes sure on alert pop up
    Then I redirected to confirmation page
    When I click on confirm button
    Then I see pop up message "Confirmation Successful"
    And I redirected to booking history page

  @positive @booking
  Scenario: Book ticket without input rangers or products
    When I click on book now button on other selected product
    Then Product added to booking now with message "Added to Booking Now"
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
    And I empty rangers
    And I click remove product on booking page
    Then I see alert message "Remove Success!"
    When I click booked now button
    Then I see pop up message "Are you sure the data is correct?"
    When I click yes sure on alert pop up
    Then I redirected to confirmation page
    When I click on confirm button
    Then I see pop up message "Confirmation Successful"
    And I redirected to booking history page

  @positive @booking
  Scenario: Book ticket without input rangers and add quantity product
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
    And I empty rangers
    And I click booked now button
    Then I see pop up message "Are you sure the data is correct?"
    When I click yes sure on alert pop up
    Then I redirected to confirmation page
    When I click on confirm button
    Then I see pop up message "Confirmation Successful"
    And I redirected to booking history page

  @negative @booking
  Scenario: Book ticket without input from date
    When I click on booking now button
    And I empty from date
    And I input to date "11192022"
    Then I see pop up message "tanggal From & To harus di isi"
    When I click OK on alert pop up
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    When I click booked now button
    Then I see pop up message "Data cannot be empty !"
    When I click OK on alert pop up
    Then I redirected to booking page

  @negative @booking
  Scenario: Book ticket without input To date
    When I click on booking now button
    And I input from date "11172022"
    And I empty to date
    And I select entrance "Entrance Cibodas"
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    When I click booked now button
    Then I see pop up message "Data cannot be empty !"
    When I click OK on alert pop up
    Then I redirected to booking page

  @negative @booking
  Scenario: Book ticket without input Entrance
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I empty entrance
    And I select number of person "2"
#    And I select ranger "Fajar Nugraha"
    When I click booked now button
    Then I see pop up message "Data cannot be empty !"
    When I click OK on alert pop up
    Then I redirected to booking page

  @negative @booking
  Scenario: Book ticket without input Tickets
    When I click on booking now button
    And I input from date "11172022"
    And I input to date "11192022"
    And I select entrance "Entrance Salabintana"
    And I empty tickets
#    And I select ranger "Fajar Nugraha"
    When I click booked now button
    Then I see pop up message "Data cannot be empty !"
    When I click OK on alert pop up
    Then I redirected to booking page

  @negative @booking
  Scenario: Book ticket without input any form
    When I click on booking now button
    And I empty from date
    And I empty to date
    And I empty entrance
    And I empty tickets
    And I empty rangers
    And I do scroll down
    When I click booked now button
    Then I see pop up message "Data cannot be empty !"
    When I click OK on alert pop up
    Then I redirected to booking page

  @negative @booking
  Scenario: Book product by click on book now button twice
    When I click on book now button on selected product
    Then Product added to booking now with message "Added to Booking Now"
    When I click on book now button on the same product
    Then I see pop up message "Product are already in Booking Now!"
