
#1. Add_First_2nd_OR_3rd_PaymentCards_VehiclesForNewUser
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

 #--------------------------------------------------------------------------------------------------------------
# 2. Get_Payment_Cards_Ids_And_Vehicles_Ids
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


@Get_PaymentCardId_VehcileId_For_Reservations	
# Get Payment Card Id for reservations with different probabilities
Scenario Outline: Verify to get payment card Ids for Reservations with different probabilities
    Given Add and Get Payment Card for Reservations
	When user calls PaymentCards Vehicles for Reservations "getPaymentCards" with "GET" http request
	Then the API PaymentCardsVehicles call got success with status code 200
	And Add Payment Cards using addPaymentCardAPI "addPaymentCards" with "POST" with parameters "<paymentCardType>" "<lastFourDigits>" <expirationMonth> <expirationYear> "<postalCode>" "<authorizationToken>"	
Examples:
	|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |
	|Visa           |0020          |12             |2024         |75026     |pX6b9Q08b1EdIESACv5Z1111|
	
@Get_PaymentCardId_VehcileId_For_Reservations
# Get Vehciles Id for reservations with different probabilities
Scenario Outline: Verify to get Vehciels Ids for Reservations with different probabilities
    Given Add and Get Vehicles Ids for Reservations
	When user calls PaymentCards Vehicles for Reservations "getVehicles" with "GET" http request
	Then the API PaymentCardsVehicles call got success with status code 200
	And Add Vehciles using addVehiclesAPI "addVehicles" with "POST" with parameters "<vehicleType>" "<licensePlate>" "<licensedState>" "<make>" "<model>" "<color>" "<numberOfPassengers>" "<alias>"	
Examples:
	|vehicleType |licensePlate|licensedState|make     |model    |color        |numberOfPassengers|alias    |
	|standardAuto|us-120023   |UP           |SPlusMake|SPLUsModel|SPPlus+Color|1                 |SPLusAlia|
#-----------------------------------------------------------------------------------------------------------

#3.Guest_User_End_To_End_New_Reservations_For_Microsites
Feature: Validating new order,checkOut and refund API's
@GuestUser_End_to_End
Scenario Outline: Verify if newOrder is being Succesfully created using newOrderAPI
	Given New Order Payload with <userDevice> <orderType> <locationCode> "<startAt>" "<stopAt>" <quantity>
	When user Guest User calls "newOrderAPI" with "POST" http request
	Then the guest user API call got success with status code 200
	And the response key "workflowState" in response body is "editing"
	And verify Microsite_Order_id "id" and reservationsToken "reservationToken" created using newOrderAPI
Examples:
	|userDevice 	 |orderType |locationCode|startAt                   |stopAt                   |quantity|
	|2               |2         |32899       |2023-01-11T22:00:00-05:00|2023-01-11T22:30:00-05:00|1       |

@GuestUser_End_to_End
#checkOutAPI
Scenario Outline: Verify if checkOut is being Succesfully created using checkOutAPI
	Given CheckOut Payload with <userDevice> <purchaseType> <locationCode> "<startAt>" "<stopAt>" <quantity> "<reserToken>" "<isArriveIntegrationAbsent>" "<vehicleType>" "<licensePlate>" "<licensedState>" "<make>" "<model>" "<color>" "<alias>" "<isDefault>" <numberOfPassengers> "<paymentCardType>" "<lastFourDigits>" "<expirationMonth>" "<expirationYear>" "<postalCode>" "<authorizationToken>" "<email>" "<firstName>" "<lastName>" "<phone>"
	When user Guest User calls "checkOutAPI" with "PUT" http request
	Then the guest user API call got success with status code 200
	And the response key "workflowState" in response body is "finished"
	And verify actualKeys "id" "reservationToken" is displayed in checkOutAPIBody is matching with expectedKey is generated in newOrderAPI using checkOutAPI
Examples:
|userDevice|purchaseType|locationCode|startAt                  |stopAt                   |quantity|reserToken|isArriveIntegrationAbsent|vehicleType|licensePlate|licensedState|make         |model         |color         |alias         |isDefault|numberOfPassengers|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |email             |firstName   |lastName  |phone     |
|2         |2           |32899       |2023-01-11T22:00:00-05:00|2023-01-11T22:30:00-05:00|1       |          |true                     |Standardauto|sp+test    |SP           |sp+test+Make1|sp+test+Model1|sp+test+Color1|sp+test+Alias1|true     |1                 |masterCard     |0016          |02             |2025          |13797     |pX6b9Q08b1EdIESACv5Z1111|skmanu12@gmail.com|sp+firstName|sp+LasName|9535478066|  	

@GuestUser_End_to_End
#refundAPI
Scenario: Verify if refund is being Succesfully created using refundAPI
	Given Cancelling the Order using Refund API with Order Id
	When user Guest User calls "refundAPI" with "PUT" http request
	Then the guest user API call got success with status code 200
	And the response key "workflowState" in response body is "refunded"
#---------------------------------------------------------------------------
#4. Registered_User_End_To_End_New_Reservations_For_Microsites	
Feature: Validating new order,checkOut and refund API's

@RegisteredUser_Reservations
# Sign in with valid credentials
Scenario Outline: Verify if Sign In with valid credentials is being Successfully created using signInAPI
    Given Sign In Payload with "<email>" "<password>"
	When user calls "signInAPI" with "POST" http request
	Then the API call got success with status code 200
	And Verify the id_token "id_token" is generated	
Examples:
	|email                                                                   |password    |
	|skmanu100043@mailinator.com                                             |Parking@1   |


@RegisteredUser_Reservations	
# Get Payment Card Id for reservations with different probabilities
Scenario Outline: Verify to get payment card Ids for Reservations with different probabilities
    Given Add and Get Payment Card for Reservations
	When user calls PaymentCards Vehicles for Reservations "getPaymentCards" with "GET" http request
	Then the API PaymentCardsVehicles call got success with status code 200
	And Add Payment Cards using addPaymentCardAPI "addPaymentCards" with "POST" with parameters "<paymentCardType>" "<lastFourDigits>" <expirationMonth> <expirationYear> "<postalCode>" "<authorizationToken>"
Examples:
	|paymentCardType|lastFourDigits|expirationMonth|expirationYear|postalCode|authorizationToken      |
	|Visa           |0023          |11             |2024         |75026     |pX6b9Q08b1EdIESACv5Z1111|
	
	
@RegisteredUser_Reservations
# Get Vehciles Id for reservations with different probabilities
Scenario Outline: Verify to get Vehciels Ids for Reservations with different probabilities
    Given Add and Get Vehicles Ids for Reservations
	When user calls PaymentCards Vehicles for Reservations "getVehicles" with "GET" http request
	Then the API PaymentCardsVehicles call got success with status code 200
	And Add Vehciles using addVehiclesAPI "addVehicles" with "POST" with parameters "<vehicleType>" "<licensePlate>" "<licensedState>" "<make>" "<model>" "<color>" "<numberOfPassengers>" "<alias>"	
Examples:
	|vehicleType |licensePlate|licensedState|make     |model    |color        |numberOfPassengers|alias    |
	|standardAuto|us-120007   |SA           |SPlusMake|SPLUsModel|SPPlus+Color|1                 |SPLusAlia|


@RegisteredUser_Reservations
Scenario Outline: Verify if newOrder is being Succesfully created using newOrderAPI
	Given New Order RegisteredUser Payload with <deviceType> <orderType> <saleType> <locationCode> "<startAt>" "<stopAt>" <quantity>
	When user Registered User calls "newOrderAPI" with "POST" http request
	Then the registered user API call got success with status code 200
	And the Registered user workflowState key "workflowState" in response body is "editing"
	And Verify microsite_Order_id "id" and reservationsToken "reservationToken" created using newOrderAPI for Registered		
Examples:
	|deviceType|orderType|saleType|locationCode|startAt                  |stopAt                   |quantity|
	|2         |  2      |3       |32899       |2023-02-11T22:00:00-05:00|2023-02-11T22:30:00-05:00|1       |


@RegisteredUser_Reservations
Scenario Outline: Verify if checkOut is being Succesfully created using checkOutAPI
	Given CheckOut Registered Payload with <deviceType> <orderType> <saleType> <locationCode> <quantity> "<startAt>" "<stopAt>" "<reservationToken>" "<isArriveIntegrationAbsent>"
	When user Registered User calls "checkOutAPI" with "PUT" http request
	Then the registered user API call got success with status code 200
	And the Registered user workflowState key "workflowState" in response body is "finished"
	And verify Registered user orderId, reservationToken keys "id" "reservationToken" is displayed in checkOutAPIBody is matching with expectedKey is generated in newOrderAPI using checkOutAPI	
Examples:
|deviceType|orderType|saleType|locationCode|quantity|startAt                  |stopAt                    |reservationToken|isArriveIntegrationAbsent|
|2         |2        |   3     |32899       |1       |2023-02-11T22:00:00-05:00|2023-02-11T22:30:00-05:00|                |true                     |
#-------------------------------------------------------------------------------------------------------------------
#5. SignAccount
Feature: validating SignUp APIs SignIn APIs 

@SignUp
# Enter the new user details and validate user able to create the account
Scenario Outline: Verify if SignUp is being Succesfully created using signUpAPI 
	Given Sign Up Payload with "<firstName>" "<lastName>" "<email>" "<password>" "<confirmPassword>"
	When user calls "signUpAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And Verify the "email" is created matching "<email>"	
Examples:
	|firstName|lastName|email                         |password |confirmPassword|
	|Manappa  |sk      |skmanu100048@mailinator.com   |Parking@1|Parking@1|
	
	
@SignUp
# Enter the new user details and validate user able to create the account
Scenario Outline: Verify if SignUp with already existing user and expect error message using signUpAPI 
	Given Sign Up Payload with "<firstName>" "<lastName>" "<email>" "<password>" "<confirmPassword>"
	When user calls "signUpAPI" with "POST" http request 
	Then Verify the actual error "errors[0]" message matching with expected error message "<ExpectedMessage>"		
Examples:
	|firstName|lastName|email                         |password |confirmPassword|ExpectedMessage|
	|Manappa  |sk      |skmanu100042@mailinator.com   |Parking@1|Parking@1|Your account already exists. Please login using your email.|
	
	
@SignIn
# Sign in with valid credentials
Scenario Outline: Verify if Sign In with valid credentials is being Successfully created using signInAPI
    Given Sign In Payload with "<email>" "<password>"
	When user calls "signInAPI" with "POST" http request
	Then the API call got success with status code 200
	And Verify the id_token "id_token" is generated		
Examples:
	|email                         |password |
	|skmanu100041@mailinator.com   |Parking@1|
	
	
@SignIn
# Sign in with  invalid credentials
Scenario Outline: Verify if Sign In with In-Valid credentials,Expect error message and Validate the message signInAPI
    Given Sign In Payload with "<email>" "<password>"
	When user calls "signInAPI" with "POST" http request
	Then Verify the Error "errors[0]" Message is displayed for Invalid Credentials "<ExpectedMessage>" message	
Examples:
	|email                         |password |ExpectedMessage                                                    |
	|skmanu@gmail.com              |Parking@1|Your email address and/or password are incorrect. Please try again.|
	|skmanu12gmail.com             |Parking@1|Invalid Email Format.                                              |







 
