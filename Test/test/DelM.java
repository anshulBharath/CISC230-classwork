package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelM {

	public static void main(String[] args) {
		
		//getNumOperations(6);
		//System.out.println(getSummation(15,30));
		System.out.println(getNum(2437,875));
		
	}
	
	public static void getNumOperations(int n) {
		int p = 1;
		int numOperations = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j < n + 1 - i; j++) {
				p = p + 2 * i;
				numOperations += 3;
			}
		}
		
		System.out.println(""+ p + " " + numOperations);
	}
	
	public static double getSummation(int x, int y) {
		double ret = 0;
		
		for(int i = x; i <= y; i++) {
			ret = ret + Math.pow(x, 2);
		}
		return ret;
	}
	
	public static List<Integer> getSummation(List<Integer> a, List<Integer> b){
		List<Integer> temp = new ArrayList<Integer>();
        temp.add(0);
        temp.add(0);
        
        for(int i = 0; i < a.size(); i++){
            if(a.get(i)>b.get(i)){
                int num = 1;
                num = num + temp.get(0);
                temp.add(0, num);;
            }
            else if(a.get(0)<b.get(0)){
                int num = 1;
                num = num + temp.get(1);
                temp.add(1,num);
            
            }
            else{
                
            }
        }
        retunr null;
	}
	
	public static int getNum(int a, int b) {
		int x  = a;
		int y = b;
		while(a != b) {
			if(a > b) {
				int temp = a - b;
				a = temp;
			}
			else if(a < b) {
				int temp = b - a;
				b = temp;
			}
		}
		return a;
	}
	
	if(this.isVisible) {
		
		if(this.elements.size() > 0) {
			if((this.elements.get(this.elements.size()-1) instanceof Jarvis || this.elements.get(this.elements.size()-1) instanceof HomeworkTrap) && this.isVisible){
				return this.elements.get(this.elements.size()-1).toString();
			}
			else if(this.isVisible) {
				return this.elements.get(this.elements.size()-1).toString();
			}
			else {
				return "#";
			}
		}
		else if(!this.isVisible) {
			return "#";
		}
		else //if(this.elements.isEmpty()) {
		{		return " ";
		}

}
