import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Stream<Person> a = persons.stream();
        persons.stream().filter(personAge -> personAge.getAge() < 18);
        persons.stream().count();
        System.out.println(a);

        Stream<Person> b = persons.stream();
        persons.stream().filter(personAge -> personAge.getAge() > 18 && personAge.getAge() < 27);
        persons.stream().filter(personSex -> personSex.getSex().equals(Sex.MAN));
        persons.stream().map(Person -> String.valueOf(Person));
        persons.stream().collect(Collectors.toList());
        System.out.println(b);

        Stream<Person> c = persons.stream();
        persons.stream().filter(personEducation -> personEducation.getEducation().equals(Education.HIGHER));
        persons.stream().filter(personAge -> personAge.getAge() > 18);
        persons.stream().filter(personEducation -> personEducation.getEducation().equals(Education.HIGHER));
        persons.stream().filter(Person::strong);
        persons.stream().sorted(Comparator.comparing(Person::getFamily));
        persons.stream().collect(Collectors.toList());
    }
}