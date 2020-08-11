// Windows 10 - JavaSE 14

import java.lang.Thread;
import java.time.LocalTime;

class DigitalClock {
	
	public static void cls() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			else
				System.out.print("\033\143");
		} catch(Exception E) {
			System.out.println(E);
		}
	}
	
	public static void display(int hour, int min, int sec){
		cls();
		System.out.printf("%d:%d:%d%n", hour, min, sec);
	}
	
	public static void main(String[] args) throws InterruptedException {
		LocalTime thisSec;

		for (;;) {
			thisSec = LocalTime.now();
			display(thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
			Thread.sleep(1000);
		}
	}
}