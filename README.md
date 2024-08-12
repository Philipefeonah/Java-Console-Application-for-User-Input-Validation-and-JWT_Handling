# Java-Console-Application-for-User-Input-Validation-and-JWT-Handling

## Project Description
 This project is a Java console application that performs the following tasks:

* Collects user inputs: username, email, password, and date of birth.
* Validates the inputs based on specified criteria.
* Generates a signed JWT token if all validations pass.
* Verifies the signed JWT token.
* Includes JUnit test cases to test the token verification method for valid and invalid tokens.

## Technologies Used
* Java
* JJWT (Java JWT library)
* JUnit 5

## Validation Criteria
##### Username:
* Not empty
* Minimum 4 characters
##### Email:

  * Not empty
  * Valid email address format
##### Password:
  * Not empty
  * At least 8 characters, at least 1 uppercase letter, at least 1 special character (e.g., !@#$%^&*)
  * At least 1 number

##### Date of Birth:
 * Not empty
 * Should be 16 years or older

## JWT Generation and Verification
 * ### JWT Generation

   * The JwtUtil.generateJwtToken method generates a signed JWT token with the username, email, and password as claims.
   The token is signed using a secret key.

 * ### JWT Verification
   * The JwtUtil.verifyJwtToken method verifies a given JWT token and checks if the username, email, and password in the token match the expected values. 
   It also checks if the token has expired. The expiration duration can be adjusted according to project specification requirement.

 * ### JUnit Test Cases
   * The JwtUtilTest class includes JUnit test cases to test the token verification method for valid and invalid tokens. The tests cover the following scenarios:
      ###### Valid JWT token
      ###### Invalid JWT token


## Usage Instructions

* <strong>Run the application</strong>:
 Run the Main class to start the console application. You will be prompted to enter the username, email, password, and date of birth.

* <strong>Input validation</strong>:
The application will validate each input according to the criteria specified in the Validation Criteria section. If any input fails validation, the application will output the validation error messages.

* <strong>JWT token generation</strong>:
If all inputs pass validation, the application will generate a signed JWT token and output it.

* <strong>JWT token verification</strong>:
The application can also verify a given JWT token and output whether the verification passed or failed.

### Contact
If you have any questions or need further assistance, please contact me at:

* Email:  onyemax247@gmail.com
* GitHub: maxiflexy