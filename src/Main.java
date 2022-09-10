import model.Person;
import sort.*;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
        new Person(130, 50, 19),
        new Person(145, 70, 24),
        new Person(140, 50, 11),
        new Person(145, 70, 33),
        new Person(170, 90, 19),
        new Person(150, 70, 16),
        new Person(185, 110, 22),
        new Person(170, 100, 24),
        new Person(150, 100, 21),
        new Person(185, 110, 18),
        new Person(190, 110, 20),
        new Person(195, 110, 36)
    };
    PersonSort personSort = new QuickSort(); // для сортування по будь яких параметрах
    OnlyAgeSort personSortByAge = new AgeSort(); // сортування за віком

    Person[] result = personSortByAge.sort(people);

    System.out.println("Sort only by age");
    for(Person person: result)
        System.out.println(person);

    result = personSort.sort(people, Comparator.comparingInt(Person::getWeight));

    System.out.println("\nSort by Weight (can be by height) using custom Quick sort");
    for(Person person: result)
        System.out.println(person);


    //long before = System.currentTimeMillis();
    int x = CountingPeople.countPeople(result);
    // Єдине що є двозначна ситуація коли є, наприклад, три людини з однаковою вагою,
    // у двох з них однаковий зріст, і тут можна рахувати цих людей по різному
    // Даний алгоритм у цьому випадку порахує одну людину, бо ЇЇ зріст не повторюється в інших двох
    System.out.println("\nThe amount of users with the same weight and different height: " + x);
    }




}