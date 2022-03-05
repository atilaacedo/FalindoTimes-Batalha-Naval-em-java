package BatalhaNaval;

import java.util.ArrayList;
import java.util.Scanner;

public class FalindoTimesPrincipalMain {
	
	GameHelper helper = new GameHelper();
	ArrayList<FalindoTimesPrincipal> timeList = new ArrayList<FalindoTimesPrincipal>();
	int numOfGuess = 0;
	static Scanner entrada = new Scanner(System.in);
	

	void setUpGame() {
		FalindoTimesPrincipal time1 = new FalindoTimesPrincipal();
		FalindoTimesPrincipal time2 = new FalindoTimesPrincipal();
		FalindoTimesPrincipal time3 = new FalindoTimesPrincipal();
		
		System.out.println("Digita ai os times que voce quer falir meu patrao ");
		time1.name = entrada.nextLine();
		time2.name = entrada.nextLine();
		time3.name = entrada.nextLine();
		timeList.add(time1);
		timeList.add(time2);
		timeList.add(time3);
		
		System.out.println("Seu objetivo é falir três times");
		System.out.println(time1.name+ " " +time2.name + " "+ time3.name);
		System.out.println("Tente eliminar com o menor numero de palpites: ");
		for(FalindoTimesPrincipal cell:timeList) {
			ArrayList<String> newLocation = helper.posicaoTime(3);
			cell.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!timeList.isEmpty()) {
			System.out.println("Insira um palpite aqui: ");
			String userGuess = entrada.next();
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuess++;
		String result = "Errado";
		for(FalindoTimesPrincipal falindoTestes:timeList) {
			result = falindoTestes.checkYourself(userGuess);
			if(result.equals("correto")) {
				break;
			}
			if(result.equals("eliminar")) {
				timeList.remove(falindoTestes);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("Parabens, agora só sobrou o gigante para apavorar toda Rj ou perder o titulo pro madureira");
		System.out.println("Madureira se tu ganhar ja sabe ne, ira ser falida");
		if(numOfGuess <=18) {
			System.out.println("Você só usou " + numOfGuess + " palpites para confirmar a hegemonia pro gigante");
		}else {
			System.out.println("Demorou demais "+numOfGuess+" tentativas, quase que o vasco cai pra serie B do estadual");
			System.out.println("Melhore");
		}
	}
	public static void main(String[] args) {
		FalindoTimesPrincipalMain times = new FalindoTimesPrincipalMain();
		
		times.setUpGame();
		times.startPlaying();
		entrada.close();
	
	}
}
