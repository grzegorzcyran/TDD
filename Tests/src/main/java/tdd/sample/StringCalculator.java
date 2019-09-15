package tdd.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	public int add(String arguments){
		int result = 0;
		String separator = ",";
		if(arguments.isEmpty())
			return result;

		List<String> lineList = new ArrayList<>(Arrays.asList(arguments.split("\n")));

		if (lineList.get(0).contains("//")) {
			separator = lineList.get(0).substring(2);
			lineList.remove(0);
		}

		List<String> stringNumbers = retriveStringNumbers(lineList, separator);

		result = calculateResultFromStringNumbers(result, stringNumbers);

		return result;
	}

	private List<String> retriveStringNumbers(List<String> lines, String separator) {
		List<String> stringNumbers = new ArrayList<>();
		for(String line : lines){
			stringNumbers.addAll(Arrays.asList(line.split(separator)));
		}
		return stringNumbers;
	}

	private int calculateResultFromStringNumbers(int result, List<String> stringNumbers) {
		for(String stringNumber : stringNumbers){
			result += Integer.parseInt(stringNumber);
		}
		return result;
	}
}
