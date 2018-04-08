import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    private List<Person> people = Arrays.asList(
            new Person(1, "Anna", "Nowak", 23),
            new Person(2, "Michał", "Kowalczyk", 25),
            new Person(3, "Aneta", "MIelczarek", 26),
            new Person(4, "Adam", "Nowakowa", 27)
    );

    @Test
    public void filtering() {
        String commas = people.stream()
                .filter(x -> x.getName().length() == 4)
                .map(e -> e.getName())
                .collect(Collectors.joining(", "));
        System.out.println(commas);

        String commasDistinc = people.stream()
                .filter(x -> x.getName().length() == 4)
                .map(e -> e.getName())
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(commasDistinc);
    }

    @Test
    public void sorting() {
        List<Person> list = people.stream()
                .sorted((a, b) -> a.getAge().compareTo(b.getAge()))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void collectors() {
        Map<String, Long> map = people.stream()
                .collect(Collectors.toMap(e -> e.getId(), e->));
        
    }


}
