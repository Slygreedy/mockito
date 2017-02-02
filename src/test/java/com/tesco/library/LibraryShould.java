package com.tesco.library;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;



import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LibraryShould {

    @Test
    public void allow_to_enrol_users() {
        Library library = new Library();
        User newUser = new User("Simon", "Read");

        library.enroll(newUser);
        User user = library.findUser(newUser);

        assertThat(user, is(newUser));
    }

    @Test
    public void allow_users_to_borrow_books() {
        Library library = new Library();
        User user = new User("Simon", "Read");
        Book someBook = new Book("title", "author");
        Book anotherBook = new Book("another title", "author");

        library.borrowBooks(user, someBook, anotherBook);
        List<Book> borrowedBooks = library.borrowedBooksBy(user);

        assertThat(borrowedBooks, IsIterableContainingInOrder.contains(someBook, anotherBook));
    }
}
