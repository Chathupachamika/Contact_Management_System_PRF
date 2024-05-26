
import java.time.LocalDate;
import java.util.Scanner;

class ContactList {

    private static Contact[] contactsArray;
    private int nextIndex;
    private int size;
    private int loadfactor;

    ContactList(int size, int loadfactor) {
        contactsArray = new Contact[size];
        nextIndex = 0;
        this.size = size;
        this.loadfactor = loadfactor;
    }

    private boolean isFull() {
        return nextIndex >= size;
    }

    // -------------------GENERATE ID----------------
    public static String generateId() {
        if (contactsArray.length == 0) {
            return "C0001";
        } else {
            return String.format("C%04d", (contactsArray.length + 1));
        }

    }

    // ---------------------------SEARCH METHOD--------------------------
    public int searchByNameOrPhoneNumber(String nameOrPhone) {
        for (int i = 0; i < nextIndex; i++) {
            if (contactsArray[i].getName().equals(nameOrPhone) || contactsArray[i].getPhoneNumber().equals(nameOrPhone)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return nextIndex;
    }

    public Contact[] tempArray() {
        Contact[] tempContactsArray = new Contact[size];
        for (int i = 0; i < nextIndex; i++) {
            tempContactsArray[i] = contactsArray[i];
        }
        contactsArray = tempContactsArray;
        return tempContactsArray;
    }

    private void extendArrays() {
        Contact[] tempContactsArray = new Contact[size + loadfactor];
        System.arraycopy(contactsArray, 0, tempContactsArray, 0, contactsArray.length);
        contactsArray = tempContactsArray;
    }
    // ---------------------------DELETE-------------------------------

    public void delete(int index) {
        Contact[] tempContactsArray = new Contact[contactsArray.length];
        for (int i = index; i < contactsArray.length - 1; i++) {
        }
        for (int i = 0; i < contactsArray.length - 1; i++) {
            tempContactsArray[i] = contactsArray[i];
        }
        contactsArray = tempContactsArray;
    }

//--------------------ADD METHOD--------------------------- 
    public void add(Contact contact) {
        if (isFull()) {
            extendArrays();
        }
        contactsArray[nextIndex++] = contact;
    }

    public void updatePhonenumber(int index, String PhoneNumber) {
        contactsArray[index].setPhoneNumber(PhoneNumber);
    }

    public void updateSalary(int index, double newSalary) {
        contactsArray[index].setSalary(newSalary);
    }

    public void updateCompanyName(int index, String CompanyName) {
        contactsArray[index].setCompanyname(CompanyName);
    }

    public void updateName(int index, String name) {
        contactsArray[index].setName(name);
    }
}

class Contact {

    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    Contact(String id, String name, String phoneNumber, String companyName, double salary, String birthday) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salary = salary;
        this.birthday = birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCompanyname(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(double newSalary) {
        this.salary = salary;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getSalary() {
        return salary;
    }

    public String getBirthday() {
        return birthday;
    }
}

class Demo {

    //public static Contact[] contactArray = new Contact[0];
    public static ContactList contactList = new ContactList(100, 50);// ----------------------CLEAR CONSOLE --------------------

    // ----------------------CLEAR CONSOLE --------------------
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    // -----------------MAIN METHOD--------------------
    public static void main(String[] args) {
        homepage();
    }

    // -----------------HOME PAGE--------------------
    public static void homepage() {
        Scanner input = new Scanner(System.in);
        System.out.println("              __  ________  _______    _______ _________ __    ___ _______  ");
        System.out.println("             |  \\/$$$$$$$$ /$$$$$$$\\  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$\\");
        System.out.println("              \\$$| $$_____/  $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
        System.out.println("             |  \\| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
        System.out.println("             | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
        System.out.println("             | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
        System.out.println("             | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
        System.out.println("             | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
        System.out.println("             |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/");
        System.out.println("\n\n");
        System.out.println("  _____            _             _             ____                        _");
        System.out.println(" / ____|          | |           | |           / __ \\                      (_)");
        System.out.println("| |     ___  _ __ | |_ __ _  ___| |_ ____    | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
        System.out.println(
                "| |    / _ \\| '_ \\| __/ _` |/ __| __/ ___|   | |  | | '__/ _` |/ _` | `_ \\| |_  / _ \\ '__|");
        System.out.println("| |___| (_) | | | | || |_| | |__| |_\\___ \\   | |  | | | | |_| | |_| | | | | |/ /  __/ |");
        System.out.println(
                " \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|____/    \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|");
        System.out.println("                                                          __/ |");
        System.out.println("                                                         |___/");
        System.out.println(
                "\n==========================================================================================");
        System.out.println("\n\n[01] ADD Contacts");
        System.out.println("\n[02] UPDATE Contacts");
        System.out.println("\n[03] DELETE Contacts");
        System.out.println("\n[04] SEARCH Contacts");
        System.out.println("\n[05] LIST Contacts");
        System.out.println("\n[06] Exit");

        System.out.print("\nEnter an option to continue ->");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                addContacts();
                break;
            case 2:
                updateContacts();
                break;
            case 3:
                deleteContacts();
                break;
            case 4:
                searchContacts();
                break;
            case 5:
                listContacts();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Invalid option...");
                break;
        }

    }

    // ------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    // -------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    // -------------------BIRTHDAY VALIDATION----------------
    public static boolean isValidBirthday(String birthday) {
        String y = birthday.substring(0, 4);
        int year = Integer.parseInt(y);
        String m = birthday.substring(5, 7);
        int month = Integer.parseInt(m);
        String d = birthday.substring(8, 10);
        int day = Integer.parseInt(d);
        LocalDate currentDate = LocalDate.now();
        int currentMonthValue = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int currentMonthDate = currentDate.getDayOfMonth();

        if (year % 4 != 0 & month == 2) {
            if (day > 28) {
                return false;
            } else {
                return true;
            }
        }
        if (year % 4 == 0 & month == 2) {
            if (day > 29) {
                return false;
            } else {
                return true;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31) {
                return false;
            }
        }
        if (month > 12) {
            return false;
        }
        if (year < currentYear) {
            return true;
        } else if (year == currentYear) {

            if (month > currentMonthValue) {
                return true;
            } else if (month == currentMonthValue) {

                if (day <= currentMonthDate) {
                    return true;
                }
            }
        }
        return false;
    }
    // -----------------ADD CONTACTS--------------------

    public static void addContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n+----------------------------------+");
            System.out.println("|    Add contact to the list       |");
            System.out.println("+----------------------------------+\n\n");
            String id = ContactList.generateId();
            System.out.println("\n" + id);
            System.out.println("=============");
            System.out.print("Name : ");
            String name = input.next();
            String phoneNumber;
            L1:
            do {
                System.out.print("Phone Number : ");
                phoneNumber = input.next();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("\n\tInvalid phone number...");
                    System.out.print("\nDo you want to input phone number again : ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L1;
                    } else if (ch == 'N' || ch == 'n') {
                        clearConsole();
                        homepage();
                    }
                }

            } while (!isValidPhoneNumber(phoneNumber));

            System.out.print("Company Name : ");
            String companyName = input.next();
            double salary;

            L2:
            do {
                System.out.print("Salary : ");
                salary = input.nextDouble();
                if (!isValidSalary(salary)) {
                    System.out.println("\n\tInvalid salary...");
                    System.out.print("\nDo you want to input salary again : ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L2;
                    } else if (ch == 'N' || ch == 'n') {
                        clearConsole();
                        homepage();
                    }
                }

            } while (!isValidSalary(salary));
            String birthday;

            L3:
            do {
                System.out.print("Birthday : ");
                birthday = input.next();
                if (!isValidBirthday(birthday)) {
                    System.out.println("\n\tInvalid birthday...");
                    System.out.print("\nDo you want to input birthday again : ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L3;
                    } else if (ch == 'N' || ch == 'n') {
                        clearConsole();
                        homepage();
                    }
                }

            } while (!isValidBirthday(birthday));

            //extendArrays();
            Contact contact = new Contact(id, name, phoneNumber, companyName, salary, birthday);
            contactList.add(contact);
            //contactArray[contactArray.length - 1] = contact;

            System.out.println("\n\tContact has been added successfully...");
            System.out.print("\nDo you want to add another contact : ");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                clearConsole();
                addContacts();
            } else if (ch == 'N' || ch == 'n') {
                clearConsole();
                homepage();
            }

        } while (true);

    }

    // --------------------------PRINT DETAILS---------------------------
    public static void printDetails(int index) {
        System.out.println("Contact Id : " + contactList.tempArray()[index].getId());
        System.out.println("Name : " + contactList.tempArray()[index].getName());
        System.out.println("Phone Number : " + contactList.tempArray()[index].getPhoneNumber());
        System.out.println("Company Name : " + contactList.tempArray()[index].getCompanyName());
        System.out.println("Salary : " + contactList.tempArray()[index].getSalary());
        System.out.println("Birthday : " + contactList.tempArray()[index].getBirthday());
    }

    // --------------------------SEARCH CONTACT-------------------------
    public static void searchContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|            Search Contact           |");
            System.out.println("+-------------------------------------+\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone = input.next();
            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);

            if (index == -1) {
                System.out.println("\n\tNo contact found for " + nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    searchContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }
            } else {
                printDetails(index);
                System.out.print("\nDo you want to search another contact : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    searchContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }
            }

        } while (true);
    }

    // --------------------------UPDATE NAME----------------------------
    public static void updateName(int index) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n Update Name");
        System.out.println("===================");
        System.out.print("\nInput new name : ");
        String newName = input.next();
        contactList.updateName(index, newName);
    }

    // --------------------------UPDATE Phonenumber----------------------------
    public static void updatePhoneNumber(int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n Update Phonenumber");
        System.out.println("========================");
        System.out.print("\nInput new phone number : ");
        String newPhoneNumber = input.next();
        contactList.updatePhonenumber(index, newPhoneNumber);
    }

    // --------------------------UPDATE Company name----------------------------
    public static void updateCompanyName(int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n Update Company Name");
        System.out.println("===========================");
        System.out.print("\nInput new company name : ");
        String newCompanyName = input.next();
        contactList.updateCompanyName(index, newCompanyName);
    }

    // --------------------------UPDATE Salary----------------------------
    public static void updateSalary(int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n Update Salary");
        System.out.println("==================");
        System.out.print("\nInput new salary : ");
        double newSalary = input.nextDouble();
        contactList.updateSalary(index, newSalary);
    }

    // --------------------------UPDATE CONTACTS-----------------------
    public static void updateContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n+---------------------------------+");
            System.out.println("|        Update Contact           |");
            System.out.println("+---------------------------------+\n\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone = input.next();
            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);

            if (index == -1) {
                System.out.println("\n\tNo contact found for " + nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    updateContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }
            } else {
                printDetails(index);

                System.out.println("\nWhat do you want to update");
                System.out.println("\n\t[01] Name");
                System.out.println("\t[02] Phone number");
                System.out.println("\t[03] Company Name");
                System.out.println("\t[04] Salary");
                System.out.println("\nEnter an option to continue...");
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        updateName(index);
                        break;
                    case 2:
                        updatePhoneNumber(index);
                        break;
                    case 3:
                        updateCompanyName(index);
                        break;
                    case 4:
                        updateSalary(index);
                        break;
                    default:
                        System.out.println("\n\tInvalid option...");
                }
                System.out.println("\nContact has been update successfully.");
                System.out.print("\nDo you want to update another contact : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    updateContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }
            }
        } while (true);
    }

    // --------------------------DELETE CONTACTS-----------------------
    public static void deleteContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n+---------------------------------+");
            System.out.println("|          Delete Contact         |");
            System.out.println("+---------------------------------+\n\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone = input.next();
            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);

            if (index == -1) {
                System.out.println("\n\tNo contact found for " + nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    deleteContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }
            } else {
                printDetails(index);
                L1:
                do {
                    System.out.print("\nDo you want to delete this contact : ");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        delete(index);
                        System.out.println("\nContact has been deleted successfully...");
                        break L1;
                    } else if (ch == 'N' || ch == 'n') {
                        break L1;
                    }

                } while (true);

                System.out.println("\nDo you want to delete another contact : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    deleteContacts();
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    homepage();
                }

            }

        } while (true);

    }

    // --------------------------LIST CONTACTS------------------------
    public static void listContacts() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Sort Contact          |");
        System.out.println("+---------------------------------+\n");
        System.out.println("\n[01] Sorting by name");
        System.out.println("\n[02] Sorting by salary");
        System.out.println("\n[03] Sorting by birthday");
        System.out.print("\nEnter option to continue : ");
        int option = input.nextInt();
        switch (option) {
            case 1:
                sortByName();
                break;
            case 2:
                sortBySalary();
                break;
            case 3:
                sortByBirthday();
                break;
            default:
                System.out.println("\n\tInvalid option...");
        }

    }

    // --------------------------SORT BY NAME-------------------------
    public static void sortByName() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n|=========Listing Contacts by Name=======|");
            System.out.println("+----------------------------------------+\n");

            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|  Contact Id    |     Name       |  Phone Number  |    Company     |     Salary     |     Birthday   |");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");

            sortingByName();

            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                clearConsole();
                homepage();
            } else if (ch == 'N' || ch == 'n') {
                clearConsole();
                listContacts();
            }

        } while (true);
    }

    // --------------------------SORT BY SALARY-------------------------
    public static void sortBySalary() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n|======Listing Contacts by Salary========|");
            System.out.println("+----------------------------------------+\n");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|  Contact Id    |     Name       |  Phone Number  |    Company     |     Salary     |     Birthday   |");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");

            sortingBySalary();

            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                clearConsole();
                homepage();
            } else if (ch == 'N' || ch == 'n') {
                clearConsole();
                listContacts();
            }

        } while (true);
    }

    // --------------------------SORT BY BIRTHDAY-------------------------
    public static void sortByBirthday() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n|======Listing Contacts by Birthday=========|");
            System.out.println("+-------------------------------------------+\n");

            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|  Contact Id    |     Name       |  Phone Number  |    Company     |     Salary     |     Birthday   |");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");

            sortingByBirthday();

            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                clearConsole();
                homepage();
            } else if (ch == 'N' || ch == 'n') {
                clearConsole();
                listContacts();
            }

        } while (true);
    }

    // -------------------------NAME SORT---------------------------
    public static void sortingByName() {
        Contact[] tempContactsArray = new Contact[contactList.getSize()];

        for (int i = 0; i < tempContactsArray.length; i++) {
            tempContactsArray[i] = contactList.tempArray()[i];
        }
        for (int j = 1; j < tempContactsArray.length; j++) {
            for (int i = 0; i < tempContactsArray.length - j; i++) {
                if (tempContactsArray[i].getName().compareTo(tempContactsArray[i + 1].getName()) > 0) {
                    Contact tempContact = tempContactsArray[i];
                    tempContactsArray[i] = tempContactsArray[i + 1];
                    tempContactsArray[i + 1] = tempContact;

                }
            }
        }

        for (int i = 0; i < tempContactsArray.length; i++) {
            System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15.2f| %-15s|\n", tempContactsArray[i].getId(), tempContactsArray[i].getName(),
                    tempContactsArray[i].getPhoneNumber(), tempContactsArray[i].getCompanyName(), tempContactsArray[i].getSalary(), tempContactsArray[i].getBirthday());
        }

    }

    // -------------------------SALARY SORT---------------------------
    public static void sortingBySalary() {
        Contact[] tempContactsArray = new Contact[contactList.getSize()];

        for (int i = 0; i < tempContactsArray.length; i++) {
            tempContactsArray[i] = contactList.tempArray()[i];
        }
        for (int j = 1; j < tempContactsArray.length; j++) {
            for (int i = 0; i < tempContactsArray.length - j; i++) {
                if (tempContactsArray[i].getSalary() > tempContactsArray[i + 1].getSalary()) {
                    Contact tempContact = tempContactsArray[i];
                    tempContactsArray[i] = tempContactsArray[i + 1];
                    tempContactsArray[i + 1] = tempContact;
                }
            }
        }

        for (int i = 0; i < tempContactsArray.length; i++) {
            System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15.2f| %-15s|\n", tempContactsArray[i].getId(), tempContactsArray[i].getName(),
                    tempContactsArray[i].getPhoneNumber(), tempContactsArray[i].getCompanyName(), tempContactsArray[i].getSalary(), tempContactsArray[i].getBirthday());
        }

    }

    // -------------------------BIRTHDAY SORT---------------------------
    public static void sortingByBirthday() {
        Contact[] tempContactsArray = new Contact[contactList.getSize()];

        for (int i = 0; i < tempContactsArray.length; i++) {
            tempContactsArray[i] = contactList.tempArray()[i];
        }
        for (int j = 1; j < tempContactsArray.length; j++) {
            for (int i = 0; i < tempContactsArray.length - j; i++) {
                if (tempContactsArray[i].getBirthday().compareTo(tempContactsArray[i + 1].getBirthday()) > 0) {
                    Contact tempContact = tempContactsArray[i];
                    tempContactsArray[i] = tempContactsArray[i + 1];
                    tempContactsArray[i + 1] = tempContact;
                }
            }
        }

        for (int i = 0; i < tempContactsArray.length; i++) {
            System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15.2f| %-15s|\n", tempContactsArray[i].getId(), tempContactsArray[i].getName(),
                    tempContactsArray[i].getPhoneNumber(), tempContactsArray[i].getCompanyName(), tempContactsArray[i].getSalary(), tempContactsArray[i].getBirthday());
        }
    }

    // -----------------------EXIT--------------------------
    public static void exit() {
        System.exit(0);
    }

    private static void delete(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
