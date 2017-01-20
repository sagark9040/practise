package test;

import java.util.HashMap;

public class SymbolConverter {

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
	
	//112 - aab, kb, al
	// Trie ds? - 
	//1 -- end(a), 
	//a,b
	//
	// Print out all combinations of an n-digit lock given possible numbers of each digit.  
	
	public static void main(String args[]) {
		
		HashMap<String, Character> combos = new HashMap<String, Character>();
		combos.put("2",'a');
		combos.put("22",'b');
		combos.put("222",'c');
		combos.put("3",'d');
		combos.put("33",'e');
		combos.put("333",'f');
		combos.put("4",'g');
		combos.put("44",'h');
		combos.put("444",'i');
		combos.put("5",'j');
		combos.put("55",'k');
		combos.put("555",'l');
		combos.put("6",'m');
		combos.put("66",'n');
		combos.put("666",'o');
		combos.put("7",'p');
		combos.put("77",'q');
		combos.put("777",'r');
		combos.put("7777",'s');
		combos.put("8",'t');
		combos.put("88",'u');
		combos.put("888",'v');
		combos.put("9",'w');
		combos.put("99",'x');
		combos.put("999",'y');
		combos.put("9999",'z');
		
		String num = "3129729421";
		
		for(int len = 1; len <= num.length(); len++) {
			for(int i=0;i<num.length();i++) {
				
				if(i+len < num.length()+1) {
					int a = Integer.valueOf(num.substring(i,i+len));
					Character tmp = null;
					if(combos.containsKey(String.valueOf(a))) {
						tmp = combos.get(String.valueOf(a));			
						System.out.print(tmp + " ");
					}
				}				
			}
		}
	}
	
	/*
	 * Set the status of the customer services by email and cc token. 
	 * Should always be true!
	 * False will equal to the customer services being down.
	 */
	public void setCustomerServiceStatus(boolean customerServiceStatus) {
		this.customerServiceStatus = customerServiceStatus;
	}
	public boolean isEmailServiceStatus() {
		return emailServiceStatus;
	}
	
}
