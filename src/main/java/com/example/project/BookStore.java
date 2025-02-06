package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];
    //requires 1 empty constructor
    public BookStore() {}

    // public getUsers(){}
    public User[] getUsers() {
        return users;
    }
    // public setUsers(){}
    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    // public  getBooks(){}
    public Book[] getBooks() {
        return books;
    }

    // public void addUser(User user){} 
    public void addUser(User user) {
        // checks for the first null value in the array
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                // sets that null value to the provided user object and returns to terminate the method
                users[i] = user;
                return;
            }
        }
    }

    // public void removeUser(User user){}
    public void removeUser(User user) {
        // creates variables
        int index = -1;
        int count = 0;
        // determines the index the user to be removed is at in the array. 
        // If not found then terminate
        while (index == -1) {
            if (users[count] == user) {
                index = count;
            }
            if (count < users.length) {
                count++;
            } else {
                return;
            }
        }
        // Creates a new user array
        User[] newUsers = new User[users.length];
        // Adds all original users to new user array except the flagged one
        int count2 = 0;
        for (int i = 0; i < users.length; i++) {
            if (i != index) {
                newUsers[count2] = users[i];
                count2++;
            }
        }
        // sets new user array to user variable;
        users = newUsers;
    }

    // public void consolidateUsers(){}
    public void consolidateUsers() {
        User temp;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                temp = users[i];
                removeUser(temp);
                addUser(temp);
            }
        }
    }

    // public void addBook(Book book){}
    public void addBook(Book book) {
        // instance variable for original array length
        int booksLength = books.length;
        // new Book array
        Book[] newBookArray = new Book[booksLength + 1];
        // copies all original Book objects into new array
        for (int i = 0; i < books.length; i++) {
            newBookArray[i] = books[i];
        }
        // adds new Book object to end of new array
        newBookArray[booksLength] = book;
        // sets old array to new array
        books = newBookArray;
    }

    // public void insertBook(Book book, int index){}
    public void insertBook(Book book, int index) {
        // creates a new book array that has one more element than the original book list
        Book[] newBooks = new Book[books.length + 1];
        // inserts the new book to the provided index
        newBooks[index] = book;
        // adds each original book BEFORE the new inserted book
        for (int b = 0; b < index; b++) {
            newBooks[b] = books[b];
        }
        // adds each original book AFTER the new inserted book
        for (int a = index + 1; a < newBooks.length; a++) {
            newBooks[a] = books[a - 1];
        }
        // sets the new book array to the instance variable books
        books = newBooks;
    }

    // public void removeBook(Book book){}
    public void removeBook(Book book) {
        // variable for index of book to be deleted
        int index = -1;
        // finds the index of the book to be deleted
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                index = i;
            }
        }
        // if the index of the book is not found (book is not in the array) then terminate the method
        if (index == -1) {
            return;
        } else {
            // Checks if there is only 1 copy left of the book, and removes the book from the array if so
            if (books[index].getQuantity() == 1) {
                // creates a new book array with one less element as the original book array
                Book[] newBooks = new Book[books.length - 1];
                // adds all the books BEFORE the "deleted" book
                for (int b = 0; b < index; b++) {
                    newBooks[b] = books[b];
                }
                // adds all the books AFTER the "deleted" book
                for (int a = index; a < newBooks.length; a++) {
                    newBooks[a] = books[a + 1];
                }
                // sets the new book array to the book array variable
                books = newBooks;
            } else {
                // removes a copy of the book
                books[index].setQuantity(books[index].getQuantity() - 1);
            }
        }
    }
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes
    public String bookStoreBookInfo(int index) {
        return books[index].bookInfo();
    }

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes
    public String bookStoreUserInfo(int index) {
        return users[index].userInfo();

    }

}   