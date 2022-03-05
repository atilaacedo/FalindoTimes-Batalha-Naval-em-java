package BatalhaNaval;

import java.util.ArrayList;

public class FalindoTimesPrincipal {
	
	private ArrayList<String> locationCells;
	public String name;
	
	
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
	
	public void setName(String n) {
		name = n;
	}

	public String checkYourself(String userInput) {
		String result = "errado";
		int index = locationCells.indexOf(userInput);
		if(index >= 0) {
			locationCells.remove(index);
			
			if(locationCells.isEmpty()) {
				result = "eliminar";
				System.out.println("Parabens por falir o "+name+"  : ) ");
			}else {
				result = "correto";
			}
		}
		
		
		return result;
	}

}
