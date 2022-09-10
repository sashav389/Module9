package sort;

import model.Person;

public  class CountingPeople {
    //важливою умовою є те, що масив вже відсортовано по вазі
    //в такому випадку значно зростає щвидкість роботи

    public static int countPeople(Person[] people){
        int count = 1;
        int[] countMas = new int[people.length];

        // першим єтапом є складання новго масиву
        // якщо вага певного об'єкта повторюється - то в новому масиві заміть нуля стає один
        // на місцях однакових за вагою людей
        for(int i = 0; i<people.length-1; i++){
            if(countMas[i] > 0) continue;
            int j = i + 1;
            while(j < countMas.length && compareWeight(people[i], people[j])){
                if(compareWeight(people[i], people[j])){
                    if(countMas[i] == 0){
                        countMas[i] = count;
                    }
                        countMas[j] = count;
                }
                j++;
            }

        }
        //best case => O(n)
        //worst case => O(n*n)

        //далі перевіряємо по зросту
        //якщо зрість повторюється - то елнменти більше не враховуються

        for(int i = 0; i < countMas.length; i++){
            if(countMas[i] == 0) continue;
            int j = i+1;
            while(j < countMas.length && compareWeight(people[i], people[j])){
                if(compareHeight(people[i], people[j])){
                    countMas[i] = 0;
                    countMas[j] = 0;
                }
                j++;
            }
        }
        //best case => O(n)
        //worst case => O(n*n)
        //на виході маємо масив з одиничками лише на тих місцях, де вага однакова, а зріст різний

        count = 0;
        for(int i: countMas){
            if(i > 0) count++;
        }
        //O(n)
        return count;
    }
    private static boolean compareWeight(Person person1, Person person2){
        return person1.getWeight() == person2.getWeight() ;
    }
    private static boolean compareHeight(Person person1, Person person2){
        return person1.getHeight() == person2.getHeight();
    }
}
