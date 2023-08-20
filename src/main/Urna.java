package main;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Urna {
	public static void main(String[] args) throws InterruptedException {
		int[] array = {1, 2, 3, 4, 5};
		String[] op = {"Dep.Estadual", "Dep.Federal", "Senador", "Governador", "Presidente"};
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("\nCaso queira cancelar digite: 0\n\n", op[0]);
		
		System.out.printf("Voto para %s: [5 dígitos] ", op[0]);
		Integer depEstadual = input.nextInt();
		EstadualRun voto = new EstadualRun(depEstadual);
		Thread votoEst = new Thread(voto, "1");
		
		votoEst.run();
		
		System.out.printf("Voto para %s: [4 dígitos] ", op[1]);
		int depFederal = input.nextInt();
		EstadualRun votoFederal = new EstadualRun(depFederal);
		Thread votoFed = new Thread(votoFederal);

		votoFed.run();

		
		System.out.printf("Voto para %s: [3 dígitos] ", op[2]);
		int senador = input.nextInt();
		EstadualRun votoSenador = new EstadualRun(senador);
		Thread votoSen = new Thread(votoSenador);

		votoSen.run();
		
		System.out.printf("Voto para %s: [2 dígitos] ", op[3]);
		int governador = input.nextInt();
		EstadualRun votoGovernador = new EstadualRun(governador);
		Thread votoGov = new Thread(votoGovernador);

		votoGov.run();
		
		System.out.printf("Voto para %s: [2 dígitos] ", op[4]);
		int presidente = input.nextInt();
		EstadualRun votoPresidente = new EstadualRun(presidente);
		Thread votoPre = new Thread(votoPresidente);

		votoPre.run();

		if(presidente == 22) presidente = 13;
		
		System.out.println("Seus votos: ");
		System.out.printf("%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n", op[0], depEstadual, op[1], depFederal, op[2], senador, op[3], governador, op[4], presidente);
	}
	
	private static class EstadualRun implements Runnable {
		private Integer voto;
		
		public EstadualRun(Integer voto) {
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
				System.out.printf("Zé de Neinha\n\n");
				break;
			case 45123:
				System.out.printf("João Neves\n\n");
				break;
			case 1234:
				System.out.printf("Luca Perdosa\n\n");
				break;
			case 4545:
				System.out.printf("Junior Campos\n\n");
				break;
			case 123:
				System.out.printf("Luciano Juba\n\n");
				break;
			case 454:
				System.out.printf("Geraldo Campos\n\n");
				break;
			case 45:
				System.out.printf("João Campos\n\n");
				break;
			case 12:
				System.out.printf("Mario Ricardo\n\n");
				break;
			case 13:
				System.out.printf("Luiz Inacio Lula\n\n");
				break;
			case 22:
				System.out.printf("Jair Messias Bolsonaro\n\n");
				break;
			default:
				System.out.printf("Nulo\n\n");
				break;
			}
		}
		
	}
}
