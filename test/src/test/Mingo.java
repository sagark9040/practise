package test;

/*
The game of Mingo involves a 100 X 100 board with unique positive whole numbers in the range from 1 to 1,000,000 randomly distributed in the cells. 
Unique numbers are "called" one at a time and the goal is to have a "Mingo", which is an entire row or column of cells with numbers that have been called; 
one might also form a diagonal from corner to corner with numbers that have been called. 
Write a function that takes as parameters a square array of 100 X 100 positive whole numbers and list of "called" numbers. 
Your function will report whether a "Mingo" occurs, and after how many called numbers the first Mingo occurs. You may assume valid input.
 */

/**
 * This controller accepts a (valid) email address in UTF-8 format and few other mandatory and optional parameters.
 * The resultant output is a Customer Wrapper object that may contain a valid customer object list,
 * or a wrapper object containing one or more errors.
 */

public class Mingo {

	//HashMap of numbers with mapped cells. Number n - is in cells x,y,z. In O(mn) time and O(mn) space.
	//10 for rows, 10 for columns, 2 hashsets for diagonals  --> O(4xm): space O(m), increment every single time for a new entry. And first occurrence of m is the answer.
	//Total time: O(mn) and Space O(mn)
	
	/**
     * Points to the API home page
     * @return
     */
     public String homePageAPI() {  
                     return "api";
     }
    
     /**
     * All the examples of the customer search API can be found here
     * @return
     */
     public String customerAPI() {
                     return "customer";
     }
    
     /**
     * All the examples of the email/opt status lookup API can be found here
     * @return
     */
     public String optStatusAPI() {
                     return "email";
     }
     public void setCustomerServiceStatus(boolean customerServiceStatus) {
 		this.customerServiceStatus = customerServiceStatus;
 	}
 	public boolean isEmailServiceStatus() {
 		return emailServiceStatus;
 	}
 	
 	/*
 	 * IMPORTANT:
 	 * These boolean values represent the running statuses of the email and the customer services.
 	 * They should ideally ALWAYS be true unless stated by the other teams to kill them, i.e. turn the value to false. 
 	 */
 	
 	private boolean customerServiceStatus = true;
 	private boolean emailServiceStatus = true;
 	
 	public boolean isCustomerServiceStatus() {
 		return customerServiceStatus;
 	}
 	
 	/**
      * All the examples of the customer search API can be found here
      * @return
      */
     
      public String customerAPI2() {
                      return "customer";
      }
     
      /**
      * All the examples of the email/opt status lookup API can be found here
      * @return
      */
      
      public String optStatusAPI2() {
                      return "email";
      }
}
