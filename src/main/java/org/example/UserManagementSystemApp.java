package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class User {
    private String name;
    private String bookName;
    private String phoneNumbers;

    public User(String name, String bookName, String phoneNumbers) {
        this.name = name;
        this.bookName = bookName;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

class UserManagementSystem {
    private List<User> users;

    public UserManagementSystem() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("The User and details is added successfully.");
    }

    public void searchUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + user.getName());
                System.out.println("bookName: " + user.getBookName());
                System.out.println("Phone Numbers: " + user.getPhoneNumbers());
                return;
            }
        }
        System.out.println("Sorry could not find any user.");
    }

    public void searchBook(String bookName) {
        for (User user : users) {
            if (user.getBookName().equalsIgnoreCase(bookName)){
                System.out.println("Name: " + user.getName());
                System.out.println("bookName: " + user.getBookName());
                System.out.println("Phone Numbers: " + user.getPhoneNumbers());
                return;
            }
        }
    }

    public void updateUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new bookName: ");
                String bookName = scanner.nextLine();
                user.setBookName(bookName);
                System.out.println("User details updated successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void deleteUser(String name) {
        User foundUser = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                foundUser = user;
                break;
            }
        }
        if (foundUser != null) {
            users.remove(foundUser);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Book name: " + user.getBookName());
            System.out.println("Phone Numbers: " + user.getPhoneNumbers());
            System.out.println("---------------------");
        }
    }
}

public class UserManagementSystemApp {
    public static void main(String[] args) {
        UserManagementSystem system = new UserManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new user");
            System.out.println("2. Search user");
            System.out.println("3. Update user details");
            System.out.println("4. Delete user");
            System.out.println("5. Display all users");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter bookName: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter phone number ");
                    String phoneNumbers = scanner.nextLine();
                    User newUser = new User(name, bookName, phoneNumbers);
                    system.addUser(newUser);
                    break;

                case 2:
                     System.out.print("Enter name to search: ");
                     String searchName = scanner.nextLine();
                     system.searchUser(searchName);

                    if(Objects.equals(searchName, "name")){
                        system.searchUser(searchName);
                    }
                    else
                        System.out.print("invalid name ");
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    system.updateUser(updateName);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    system.deleteUser(deleteName);
                    break;

                case 5:
                    system.displayAllUsers();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}