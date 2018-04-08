import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lambdas {
    private List<String> animals = Arrays.asList("Cat", "Dog", "rat", "mouse", "pig", "bird", "elephant", "giraffe", "parrot");


    @Test
    public void LambdasOne() {
        int i = 1;
        for (String animal : animals) {
            System.out.print(animal + (i == animals.size() ? "\n" : ", "));
            i++;
        }

        animals.forEach(element -> System.out.print(element + ", "));
        System.out.println();
        animals.stream().map(e -> e.toUpperCase()).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println(animals.stream().collect(Collectors.joining(", ")));

        animals.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println();

        animals.sort((a, b) -> a.compareTo(b));
        animals.sort(String::compareTo);
        animals.sort(Comparator.naturalOrder());

    }

    public interface OurChecker {
        boolean check (Integer value);
    }

    private OurChecker isDivisibleBy3WithAnonymusClass = new OurChecker() {
        @Override
        public boolean check(Integer value) {
            return value % 3==0;
        }
    };

    private OurChecker getIsDivisibleBy3WitchLambda = val -> val % 3 ==0;

    @Test
    public void checking(){
        System.out.println(isDivisibleBy3WithAnonymusClass.check(122));
        System.out.println(isDivisibleBy3WithAnonymusClass.check(5));
        System.out.println(getIsDivisibleBy3WitchLambda.check(122));
        System.out.println(getIsDivisibleBy3WitchLambda.check(5));
    }
}
