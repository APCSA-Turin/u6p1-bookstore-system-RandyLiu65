package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[] books = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    // public  getName() {}
    public String getName() {
        return name;
    }

    // public  setName() {}
    public void setName(String newName) {
        name = newName;
    }

    // public  getId() {}
    public String getId() {
        return Id;
    }

    // public void setId() {}
    public void setId(String newId) {
        Id = newId;
    }

    // public getBooks() {}
    public Book[] getBooks() {
        return books;
    }

    // public setBooks() {}
    public void setBooks(Book[] newBooks) {
        books = newBooks;
    }

    // public String bookListInfo(){} //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo(Book[] books) {
        String str = "";
        for (int i = 0; i < 5; i++) {
            if (books[i] == null) {
                str += "empty\n";
            } else {
                str += books[i].bookInfo() + "\n";
            }
        }
        return str;

        }

    // public String userInfo(){} //returns  "Name: []\nID: []\nBooks:\n[]"
       public String userInfo() {
        return "Name: " + getName() + "\nId: " + getId() + "\nBooks: " + "\n" + bookListInfo(books);
    }
}