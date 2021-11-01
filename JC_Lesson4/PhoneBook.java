package JC_Lesson4;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> book;

    public PhoneBook(){
        this.book = new HashMap<>();
    }

    public void add(String surname, String number) {
        List<String> numbers;
        if (book.containsKey(surname)) {
            numbers = book.get(surname);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(number);
        book.put(surname, numbers);
    }

    public List<String> get(String surname){
        if(book.containsKey(surname)){
            return book.get(surname);
        } else {
            return new ArrayList<>();
        }
    }

}
