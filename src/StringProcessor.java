import java.util.*;
import java.util.function.*;

public class StringProcessor {
	public static void processStrings(List<String> strings,
			Predicate<String> filter,
			Function<String, String> transformer,
			Consumer<String> printer) {
		for (String str : strings) {
			if (filter.test(str)) {
				String transformed = transformer.apply(str);
				printer.accept(transformed);
			}
		}
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Programmchlal", "Code");

		Predicate<String> longerThan5 = s -> s.length() > 5;

		Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();

		Consumer<String> printHeadline = s -> System.out.println("GARSHIL: " + s.toUpperCase());

		processStrings(words, longerThan5, reverse, printHeadline);
	}
}
