import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    
    public static void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name))
            if(phoneBook.get(name).contains(phoneNum))
            {
                System.out.println("Данный номер уже содержиться в контакте");
            }
            else phoneBook.get(name).add(phoneNum);
        else {
            ArrayList<Integer> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void find(String name) {
        if (phoneBook.containsKey(name) & !phoneBook.isEmpty()) System.out.println(phoneBook.get(name));
        else System.out.println("Контакт не найден");
    }
    public void remove(String name) {
        if (phoneBook.containsKey(name)) phoneBook.remove(name);
        else System.out.println("Данного контакта нет в телефонной книге");
    }

    public static void printPhoneBook() {
        /* Пришлось подсмотреть в ChatGPT не совсем понимаю как это работает
         не моего уровня код, если подскажете как можно реализовать данный
        вывод попроще буду благодарен
        */
        if (phoneBook.isEmpty()) System.out.println("Телефонная книга пуста");
        else {
            phoneBook.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                    .forEach(entry -> {
                        String key = entry.getKey();
                        ArrayList<Integer> values = entry.getValue();
                        System.out.printf("%s: %s ", key, values);
                    });
        }
    }
}
class  setContact{
    public static String nameContact () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название контакта");
        String name = scanner.next();
        return  name;
    }
    public static Integer numberContact () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер");
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Не валидный номер");
                numberContact();
            }
        }
        return number;
    }
}

public class Main {
    public static void main(String[] args) {
        String name;
        int number;
        PhoneBook PhoneBook = new PhoneBook();
        System.out.println("\nДоступные команды:" +
                "\na - добавить контакт;" +
                " r - удалить контакт;"  +
                " f - найти контакт;" +
                " p - список контактов;" +
                " q - выйти.");
        System.out.println("Введите команду: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input) {
            case "a":
                name = setContact.nameContact();
                number = setContact.numberContact();
                PhoneBook.add(name,number);
                break;
            case "r":
                name = setContact.nameContact();
                PhoneBook.remove(name);
                break;
            case "f":
                name = setContact.nameContact();
                PhoneBook.find(name);
                break;
            case "p":
                PhoneBook.printPhoneBook();
                break;
            case "q":
                System.exit(0);
                break;
        }
        main(args);
        System.out.println("----------------------------");
    }
}