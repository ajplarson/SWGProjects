package org.swg.students;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();
        //TODO: Print students from 
        //students.stream().filter(p -> p.getCountry().equals("Argentina")).sorted((a, b) -> a.getGpa().compareTo(b.getGpa())).forEach(Main::println);
        //TODO: Print students from Argentina, ordered by GPA
        //students.stream().filter(p -> p.getCountry().equals("Argentina")).sorted((a, b) -> a.getGpa().compareTo(b.getGpa())).forEach(Main::println);
        //TODO: Print the 4th - 6th ranked students by GPA from Argentina
        /*students.stream().filter(p -> p.getCountry().equals("Argentina")).
                sorted((b, a) -> a.getGpa().compareTo(b.getGpa())).
                skip(3).limit(3).forEach(Main::println);*/
        //TODO: Is anyone from Maldives?
//        if(students.stream().anyMatch(p -> p.getCountry().equals("Maldives"))) {
//            System.out.println("True");
//        }
//        else {
//            System.out.println("False");
//        }
        //TODO: Print students who aren't currently registered for a class.
        //students.stream().filter(p -> p.getRegistrations().
        //TODO: Print students who are registered for the class "Literary Genres".
      
        //TODO: Who has the highest GPA?
       // double max = students.stream().mapToDouble(p -> p.getGpa().doubleValue()).max().orElse(0);
//       Map<String, Long> countPerCountry = ds.all().stream()
//                .collect(Collectors.groupingBy(
//                        p -> p.getCountry(),
//                        Collectors.minBy(person -> person.))
//                );
        //TODO: Print every class students are registered for including repeats.
        //Map<String, Double> maxGpaByCountry = students.stream()
        //        .collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.maxBy(person.getGpa().doubleValue())));
        //TODO: Print a distinct list of classes students are registered for.
        //TODO: Print a distinct list of classes students are registered for, ordered by name.
        //TODO: Count registrations per class.
        //TODO: Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //      Map Students to StudentSummary, then filter by IQ (low, high, or whatever seems fun).
        //TODO: What is the average GPA per country (remember, it's random fictional data).
       Map<String, Double> avgGpaPerCountry = students.stream().collect(Collectors.groupingBy
        (p -> p.getCountry(), 
                Collectors.averagingDouble(m -> m.getGpa().doubleValue())));
       avgGpaPerCountry.keySet().forEach(q -> System.out.println(q + " has a GPA of " + avgGpaPerCountry.get(q)));
        //TODO: What is the maximum GPA per country?
//        Map<String, Optional<BigDecimal>> maxGpaPerCountry = students.stream()
//                .collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.mapping(m -> m.getGpa(), Collectors.maxBy(BigDecimal::compareTo))));
//        maxGpaPerCountry.keySet().forEach(q -> System.out.println(q + " has a GPA of " + maxGpaPerCountry.get(q)));
        
        //TODO: Print average IQ per Major ordered by IQ ascending.
    }

    static void println(Student s) {
        System.out.println(s);
    }

}
