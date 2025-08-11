package LabSession2ndAug;
//write a java program to create a basic thread that prints "Hello WOrld!" when executed
 class Print extends Thread {
	public void run() {
		System.out.println("Hello , World!");
	}
	

}

class Program1{
	public static void main(String[] args) {
		Print p=new Print();
		p.start();
		
		
	}
}
