package tdd.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	private final int UPPER_LIMIT = 1000;

	public int add(String arguments){
		int result = 0;
		List<String> separators = new ArrayList<>(Arrays.asList(","));
		String separator = separators.get(0);
		if(arguments.isEmpty())
			return result;

		List<String> lineList = new ArrayList<>(Arrays.asList(arguments.split("\n")));

		if (lineList.get(0).contains("//")) {
			 separator = lineList.get(0).substring(2);
			if (!separator.isEmpty()) {
				separators = Arrays.asList(separator.split(""));
			}
			lineList.remove(0);
		}

		List<String> stringNumbers = retriveStringNumbers(lineList, separator);

		result = calculateResultFromStringNumbers(result, stringNumbers);

		return result;
	}

	private List<String> retriveStringNumbers(List<String> lines, String separator) {
		List<String> stringNumbers = new ArrayList<>();
		for(String line : lines){
			checkForIllegalSeparators(line, separator);
			stringNumbers.addAll(Arrays.asList(line.split("[^0-9-]+")));
		}
		return stringNumbers;
	}

	private void checkForIllegalSeparators(String line, String separators) {
		if(line.replaceAll("[0-9-"+separators+"]+","").length() > 0)
			throw new IllegalArgumentException("Delimiters outside of list used");
	}

	private int calculateResultFromStringNumbers(int result, List<String> stringNumbers) {
		int numberFromString;
		List<Integer> negatives = new ArrayList<>();
		for(String stringNumber : stringNumbers){
			numberFromString = Integer.parseInt(stringNumber);

			retriveNegatives(numberFromString, negatives);

			if (ignoreValuesGreaterOrEqualToUpperLimit(numberFromString))
				continue;
			result += numberFromString;
		}
		throwExceptionWhenNegativesFound(negatives);

		return result;
	}

	private void retriveNegatives(int numberFromString, List<Integer> negatives) {
		if (numberFromString < 0) {
			negatives.add(numberFromString);
		}
	}

	private boolean ignoreValuesGreaterOrEqualToUpperLimit(int numberFromString) {
		if (numberFromString >= UPPER_LIMIT){
			return true;
		}
		return false;
	}

	private void throwExceptionWhenNegativesFound(List<Integer> negatives) {
		if (!negatives.isEmpty()){
			String negativesToString = negatives.stream().map(Object::toString).collect(Collectors.joining(", "));
			throw new IllegalArgumentException("negatives not allowed: " + negativesToString);
		}
	}
}
