Feature: Verify SignIn,Add Paymen Cards,Get payment Cards,Add Vehicles,Get Vehicles


@SignIn
# Sign in with valid credentials
Scenario Outline: Verify if Sign In with valid credentials is being Successfully created using signInAPI
    Given Sign In Payload with "<email>" "<password>"
	When user calls "signInAPI" with "POST" http request
	Then the API call got success with status code 200
	And Verify the id_token "id_token" is generated
		
Examples:
	|email                                                                   |password    |
	|skmanu100041@mailinator.com                                             |Parking@1   |
	
	
@AddFirst_Card_And_Vehicle_ForNewUser=True
# Add one payment card for new user and verify the IsDefault should be True in Response body
Scenario Outline: Verify to Add First Payment Card for New User and Verify the IsDefault field should be True in Response body
    Given Add First Payment Card for New User with Payload "<paymentCardType>" "<lastFourDigits>" <expirationMonth> <expirationYear> "<postalCode>" "<authorizationToken>"
	When user calls for account "addPaymentCards" with "POST" http request
	Then the account API call got success with status code 200
	And Verify the actual "lastFourDigits" matching with expected "<lastFourDigits>" 
	And Verify the actual "isDefault" matching with expected "true"
Examples:
	|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |
	|Visa           |0016          |12             |2025          |75026     |pX6b9Q08b1EdIESACv5Z1111|
	
@AddFirst_Card_And_Vehicle_ForNewUser=True
# Add one Vehicle for new user and verify the IsDefault should be True in Response body
Scenario Outline: Verify to Add First Vehicle for New User and Verify the IsDefault field should be True in Response body
    Given Add First Vehicle for New User with Payload "<vehicleType>" "<licensePlate>" "<licensePlate>" "<make>" "<model>" "<color>" "<numberOfPassengers>" "<alias>"
	When user calls for account "addVehicles" with "POST" http request
	Then the account API call got success with status code 200
	And Verify the actual "value.vehicleType" matching with expected "<vehicleType>" 
	And Verify the actual "value.licensePlate" matching with expected "<licensePlate>" 
	And Verify the actual "value.isDefault" matching with expected "true"
Examples:
	|vehicleType |licensePlate|licensedState|make     |model    |color        |numberOfPassengers|alias    |
	|standardAuto|us-120005   |US           |SPlusMake|SPLUsModel|SPPlus+Color|1                 |SPLusAlia|
	
@Add2Nd_OR_3rd_Card_And_Vehicle_ForNewUser=false
# Add 2nd or 3rd payment cards for new user and verify the IsDefault should be false in Response body
Scenario Outline: Verify to Add 2nd OR 3rd Payment Cards for New User and Verify the IsDefault field should be false in Response body
    Given Add 2nd OR 3rd Payment Card for New User with Payload "<paymentCardType>" "<lastFourDigits>" <expirationMonth> <expirationYear> "<postalCode>" "<authorizationToken>"
	When user calls for account "addPaymentCards" with "POST" http request
	Then the account API call got success with status code 200
	And Verify the actual "lastFourDigits" matching with expected "<lastFourDigits>" 
	And Verify the actual "isDefault" matching with expected "false"
Examples:
	|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |
	|Visa           |0018          |12             |2025          |75026     |pX6b9Q08b1EdIESACv5Z1111|

@Add2Nd_OR_3rd_Card_And_Vehicle_ForNewUser=false
# Add 2nd or 3rd Vehicles for new user and verify the IsDefault should be false in Response body
Scenario Outline: Verify to Add 2nd OR 3rd Vehicles for New User and Verify the IsDefault field should be false in Response body
   Given Add 2nd OR 3rd Vehicle for New User with Payload "<vehicleType>" "<licensePlate>" "<licensePlate>" "<make>" "<model>" "<color>" "<numberOfPassengers>" "<alias>" 
	When user calls for account "addVehicles" with "POST" http request
	Then the account API call got success with status code 200
	And Verify the actual "value.vehicleType" matching with expected "<vehicleType>" 
	And Verify the actual "value.licensePlate" matching with expected "<licensePlate>" 
	And Verify the actual "value.isDefault" matching with expected "false"
Examples:
	|vehicleType |licensePlate|licensedState|make     |model    |color        |numberOfPassengers|alias    |
	|standardAuto|us-120006   |US           |SPlusMake|SPLUsModel|SPPlus+Color|1                 |SPLusAlia|
	
	
@AddExistingPaymentCardsAndVehicles
# Try to Add Existing Vehicles for user and verify Expected message as Vehicle Already exists in Response body
Scenario Outline: Verify to add Existing Vehicles for user and verify User and Verify the Vehicle Already Exist error message in Response body
    Given Add Existing Vehicles for user User with Payload "<vehicleType>" "<licensePlate>" "<licensedState>" "<make>" "<model>" "<color>" "<numberOfPassengers>" "<alias>" 
	When user calls for account "addVehicles" with "POST" http request
	Then Verify the Existing Acual Error "errors[0]" with Expected Error Message "A vehicle with license plate '<licensePlate>' and state '<licensedState>' already exists in your list."
	
Examples:
	|vehicleType |licensePlate|licensedState|make     |model    |color        |numberOfPassengers|alias    |
	|standardAuto|us-120006   |US           |SPlusMake|SPLUsModel|SPPlus+Color|1                 |SPLusAlia|
	
@AddExistingPaymentCardsAndVehicles
# Try to Add Existing Payment cards for user and verify Expected message as Payment card Already exists in Response body
Scenario Outline: Verify to add Existing Payment Card for user and verify User and Verify the Payment Card Already Exist error message in Response body
    Given Add Existing Payment Card for User with Payload "<paymentCardType>" "<lastFourDigits>" <expirationMonth> <expirationYear> "<postalCode>" "<authorizationToken>"
	When user calls for account "addPaymentCards" with "POST" http request
	Then Verify the Existing Acual Error "errors[0]" with Expected Error Message "A credit card ending in '<lastFourDigits>' and expiration '<expirationMonth>/25' already exists in your list."
Examples:
	|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |
	|Visa           |0018          |12             |2025          |75026     |pX6b9Q08b1EdIESACv5Z1111|
	
	
