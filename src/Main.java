import java.util.*;
import java.util.stream.Collectors;

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
        long a = persons.stream()
                .filter(personAge -> personAge.getAge() < 18)
                .count();
        System.out.println(a);

        List<String> b = persons.stream()
                .filter(personAge -> personAge.getAge() > 18 && personAge.getAge() < 27)
                .filter(personSex -> personSex.getSex().equals(Sex.MAN))
                .map(Person -> String.valueOf(Person))
                .collect(Collectors.toList());
        System.out.println(b);


        List<Person> c = persons.stream()
                .filter(personEducation -> personEducation.getEducation().equals(Education.HIGHER))
                .filter(personAge -> personAge.getAge() > 18)
                .filter(personEducation -> personEducation.getEducation().equals(Education.HIGHER))
                .filter(Person :: strong )
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(c);
    }

}