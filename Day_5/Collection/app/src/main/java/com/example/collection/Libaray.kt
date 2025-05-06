package com.example.collection
// Base Class Library
open class LibraryItem(
    val title: String,
    val isbn: String,
    val publication: String,
    val numberOfPages: Int,
    var isAvailable: Boolean = true
) {
}

// Subclasses for specific Library Items
class Book(
    title: String,
    isbn: String,
    publication: String,
    numberOfPages: Int
) : LibraryItem( title, isbn, publication, numberOfPages)

class Magazine(
    title: String,
    isbn: String,
    publication: String,
    numberOfPages: Int
) : LibraryItem( title, isbn, publication, numberOfPages)

class Journal(

    title: String,
    isbn: String,
    publication: String,
    numberOfPages: Int
) : LibraryItem(title, isbn, publication, numberOfPages)


// Base class Person
open class Person(
    val name: String,
    val id: String
)
// Subclasses
class Librarian(
    name: String,
    id: String,
    val password: String
) : Person(name, id)


class User(
    name: String,
    id: String,
    val job: String
) : Person(name, id)


class LibraryDatabase(private val currentLibrarian: Librarian) {
    private val books : MutableList<LibraryItem> = mutableListOf<LibraryItem>()  // All library items
    private val borrowedBooks : MutableMap<LibraryItem,User> = mutableMapOf<LibraryItem, User>()  // Borrowed books and their borrowers

    // Add a new book to the library
    fun addBook(book: LibraryItem) {
        books.add(book)
        println("Added ${book.title} to the library.")
    }

    // Lend a book to a user
    fun lendBook(isbn: String, user: User) {
        val book = books.find { it.isbn == isbn }
        when {
            book == null -> println("Book not found!")
            !book.isAvailable -> println("The book '${book.title}' is already borrowed by ${borrowedBooks[book]?.name}.")
            else -> {
                book.isAvailable = false
                borrowedBooks[book] = user
                println("The book '${book.title}' has been lent to ${user.name}.")
            }
        }
    }

    // View available books
    fun viewAvailableBooks() {
        val availableBooks = books.filter { it.isAvailable }
        if (availableBooks.isEmpty()) {
            println("No available books.")
        } else {
            println("Available Books:")
            availableBooks.forEach { println("${it.title} ") }
        }
    }

    // Search for a book by title
    fun searchForABook(title: String) {
        val foundBooks = books.filter { it.title.contains(title, ignoreCase = true) }
        if (foundBooks.isEmpty()) {
            println("No books found with the title containing '$title'.")
        } else {
            println("Found Books:")
            foundBooks.forEach { println("- ${it.title}") }
        }
    }

    // Receive a book back from a borrower
    fun receiveBookFromBorrower(isbn: String) {
        val book = books.find { it.isbn == isbn }
        if (book != null && !book.isAvailable) {
            book.isAvailable = true
            borrowedBooks.remove(book)
            println("The book '${book.title}' has been returned.")
        } else {
            println("This book was not borrowed or does not exist.")
        }
    }

    // Show current librarian details
    fun showCurrentLibrarian() {
        println("Current Librarian: ${currentLibrarian.name}, ID: ${currentLibrarian.id}")
    }
}
fun main() {

    val librarian = Librarian(name = "Fatma", id = "L001", password = "librarian123")
    val library = LibraryDatabase(currentLibrarian = librarian)

    // Create users
    val user1 = User(name = "Mohamed", id = "U102", job = "Engineer")
    val user2 = User(name = "Ahmed", id = "U103", job = "Student")

    // Show current librarian
    library.showCurrentLibrarian()

    // Add books to the library
    library.addBook(Book("The Hobbit", "978-0547928227", "HarperCollins", 310))
    library.addBook(Book("1984", "978-0451524935", "Signet Classic", 328))
    library.addBook(Magazine("Time Magazine", "ISSN-0040781X", "Time Inc.", 55))

    // View available books

    library.viewAvailableBooks()

    // Search for a book
    println("\nSearching for books with 'hobbit':")
    library.searchForABook("hobbit")

    // Lend a book to a user
    println("\nLending 'The Hobbit' to Mohamed:")
    library.lendBook("978-0547928227", user1)

    // View available books after lending
    println("\nAvailable Books after lending:")
    library.viewAvailableBooks()

    // Lend another book to a user
    println("\nLending '1984' to Ahmed:")
    library.lendBook("978-0451524935", user2)

    // Receive a book back from a borrower
    println("\nReceiving 'The Hobbit' back from Ahmed:")
    library.receiveBookFromBorrower("978-0547928227")

    // View available books after receiving
    println("\nAvailable Books after receiving back:")
    library.viewAvailableBooks()
}