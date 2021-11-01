package JC_Lesson4;

public class PhoneBookMain {
    public static void main(String[] args){

        PhoneBook phonebook = new PhoneBook();

        //Заполнение телефонной книги
        phonebook.add("Лебедева", "9876");
        phonebook.add("Уткина", "9877");
        phonebook.add("Гусев", "9845");
        phonebook.add("Гусев", "98123");
        phonebook.add("Курицына", "9823");
        phonebook.add("Куропаткин", "9844");

        //Вывести телефон по фамилии через get
        System.out.println("Содержимое телефонной книги");
        System.out.print("Лебедева, телефон(ы) ");
        System.out.println(phonebook.get("Лебедева"));
        System.out.print("Уткина, телефон(ы) ");
        System.out.println(phonebook.get("Уткина"));
        System.out.print("Гусев, телефон(ы) ");
        System.out.println(phonebook.get("Гусев"));
        System.out.print("Курицына, телефон(ы) ");
        System.out.println(phonebook.get("Курицына"));
        System.out.print("Куропаткин, телефон(ы) ");
        System.out.println(phonebook.get("Куропаткин"));

    }
}
