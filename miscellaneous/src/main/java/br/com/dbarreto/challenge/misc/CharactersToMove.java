package br.com.dbarreto.challenge.misc;

public class CharactersToMove {

	public int getDistance(String instructions) {
		
		int direction = 1;
		int distance = 0;
		int speed = 1;
		for (int i = 0; i < instructions.length(); i++) {
			char command = instructions.charAt(i);
			if (command == 'A') {
				distance += speed * direction;
				speed = speed * 2;
			} else if (command == 'R') {
				speed = 1;
				direction = -direction;
			}
		}
		
		return distance;
	}
	
	public String getInstructions(int distance) {
		
		StringBuilder builder = new StringBuilder();
		int n = distance;
		while (n != 0) {
			System.out.println("Distance = " + n);
			int qtd = log2(n+1);
			System.out.println("qtd = " + qtd);
			for (int i = 0; i < qtd; i++) {
				builder.append("A");
			}

			System.out.println("String = " + builder.toString());
			int sum = pow2(qtd) - 1;
			int diff = n - sum; 
			System.out.println("Diff (" + n + " - " + sum + ") = " + diff);
			if (diff != 0) {
				builder.append("R");
				builder.append("R");
			}
			
			n = diff;
		}
		
		return builder.toString();
	}
	
	private int log2(int n) {
        return (int)(Math.log(n) / Math.log(2));
	}
	
	private int pow2(int n) {
		return 1 << n;
	}
}
