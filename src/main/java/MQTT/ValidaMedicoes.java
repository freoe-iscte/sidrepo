package MQTT;

import java.util.Collections;
import java.util.LinkedList;

public class ValidaMedicoes {

	private LinkedList<Double> ultimasMedicoes = new LinkedList<>();
	private static final int size = 5;
	private double max;
	private double min;
	private String tipo;

	public ValidaMedicoes(String tipo) {
		this.tipo = tipo;
	}

	private void putMedicao(double valor) {
		if (ultimasMedicoes.size() == size) {
			ultimasMedicoes.poll();
		}
		ultimasMedicoes.add(valor);
		if (ultimasMedicoes.size() == size) {
			getMaxMedianaMin();
		}
	}

	private void getMaxMedianaMin() {
		LinkedList<Double> list = new LinkedList<>();
		for (Double doubl : ultimasMedicoes) {

			list.add(doubl);

		}
		Collections.sort(list);
		max = list.getLast();
		min = list.getFirst();
	}

	public char getValidacao(double valorMedicao) {
		if (tipo.equals("L")) {
			return 'v';
		} else {
			if (ultimasMedicoes.size() != size) {
				putMedicao(valorMedicao);
				return 'v';
			} else {
				if (valorMedicao > (min - 1) && valorMedicao < (max + 1)) {
					putMedicao(valorMedicao);
					return 'v';
				} else {
					return 'i';
				}
			}
		}
	}

	public void clear() {
		ultimasMedicoes.clear();
	}

	public static void main(String[] args) {
		LinkedList<Integer> arrayList = new LinkedList<>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(4);
		Collections.sort(arrayList);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}
}
