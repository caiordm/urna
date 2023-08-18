package main;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Urna {
	public static void main(String[] args) throws InterruptedException {
		int[] array = {1, 2, 3, 4, 5};
		String[] op = {"Dep. Estadual", "Dep. Federal", "Senador", "Governador", "Presidente"};
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.printf("Voto para %s\nCaso queira cancelar digite: 0\n", op[0]);
		Integer depEstadual = input.nextInt();
		Voto voto = new Voto(depEstadual);
		Thread votoCarrega = new Thread(voto, "1");
		
		votoCarrega.start();
		
		System.out.printf("Voto para %s\nCaso queira cancelar digite: 0\n", op[1]);
		int depFederal = input.nextInt();
		Voto voto1 = new Voto(depEstadual);
		Thread votoCarrega1 = new Thread(voto, "1");
		
		votoCarrega1.run();
		
		System.out.printf("Voto para %s\nCaso queira cancelar digite: 0\n", op[2]);
		int senador = input.nextInt();
		Voto voto2 = new Voto(depEstadual);
		Thread votoCarrega2 = new Thread(voto, "2");
		
		votoCarrega2.start();
		
		System.out.printf("Voto para %s\nCaso queira cancelar digite: 0\n", op[3]);
		int governador = input.nextInt();
		Voto voto3 = new Voto(depEstadual);
		Thread votoCarrega3 = new Thread(voto, "3");
		
		votoCarrega3.start();
		
		System.out.printf("Voto para %s\nCaso queira cancelar digite: 0\n", op[4]);
		int presidente = input.nextInt();
		Voto voto4 = new Voto(depEstadual);
		Thread votoCarrega4 = new Thread(voto, "4");
		
		votoCarrega2.start();
		
		if(presidente == 22) presidente = 13;
		
		System.out.println("Seus votos: ");
		System.out.printf("%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n", array[0], depEstadual, array[1], depFederal, array[2], senador, array[3], governador, array[4], presidente);
	}
	
	private static class Voto implements Runnable {
		private Integer voto;
		
		public Voto(Integer voto) {
			this.voto = voto;
		}
		
		@Override
		public void run() {
	       try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (voto) {
			case 12345:
				System.out.println("Zé de Neinha");
				break;
			case 45123:
				System.out.println("João Neves");
				break;
			case 1234:
				System.out.println("Luca Perdosa");
				break;
			case 4545:
				System.out.println("Junior Campos");
				break;
			case 123:
				System.out.println("Luciano Juba");
				break;
			case 454:
				System.out.println("Geraldo Campos");
				break;
			case 45:
				System.out.println("João Campos");
				break;
			case 12:
				System.out.println("Mario Ricardo");
			default:
				break;
			}
		}
		
	}
}
