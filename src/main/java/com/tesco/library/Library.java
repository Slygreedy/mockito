package com.tesco.library;

import java.util.*;

public class Library {

    private final HashMap<String, User> users = new HashMap<>();
    private final HashMap<User, List<Book>> borrowedBooks = new HashMap<>();

    public void enroll(User newUser) {
        users.put(newUser.getSurName(), newUser);
    }

    public User findUser(User userToFind) {
        return users.get(userToFind.getSurName());
    }

    public void borrowBooks(User user, Book... booksToBorrow) {
        borrowedBooks.computeIfAbsent(user, key -> new ArrayList<>());
        //if (borrowedBooks.get(user) == null) {
        //    borrowedBooks.put(user, new ArrayList<>());
        //}
        borrowedBooks.get(user).addAll(Arrays.asList(booksToBorrow));
    }

    public List<Book> borrowedBooksBy(User user) {
        return borrowedBooks.getOrDefault(user, Collections.emptyList());
    }
}
