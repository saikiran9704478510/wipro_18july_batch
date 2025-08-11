package LabSession2ndAug;

//print odd and even using threading concept

class Even extends Thread{
	public void run() {
		System.out.println("even no printing");
		for(int i=2;i<=10;i=i+2) {
			System.out.println(i);
		}
		
	}
	
}

class odd extends Thread{
	public void run() {
		System.out.println("even no printing");
		for(int i=1;i<=10;i=i+2) {
			System.out.println(i);
		}
		
	}
}


public class Program2 {
	public static void main(String[] args) {
		Even e=new Even();
		odd o=new odd();
		 e.start();
		 o.start();
		 
	}

	
	

}