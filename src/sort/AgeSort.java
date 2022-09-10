package sort;

import java.util.Comparator;
import model.Person;
import sort.PersonSort;

public class AgeSort implements OnlyAgeSort{

    @Override
    public Person[] sort(Person[] people) {
        quickSort(people, 0, people.length-1);
        return people;
    }


    private static void quickSort(Person[] people, int begin, int end ) {
        if(begin<end) {
            int p = partinion(begin, end, people);
            quickSort(people, begin, p-1);
            quickSort(people, p+1, end);
        }

    }

    private static int partinion(int  begin, int end, Person[] people) {
        int pivot = people[end].getAge();
        int i=begin;
        for(int j=i; j<end; j++) {
            if(compare(people[j].getAge(), pivot)<0) {
                swap(people, i, j);
                i++;
            }
        }
        swap(people, i, end);
        return i;
    }
    private static int compare(int i, int j){
        return Integer.compare(i, j);
    }


    private static void swap(Person[] people, int i, int j) {
        Person temp = people[i];
        people[i] = people[j];
        people[j] = temp;
    }
}
