package box

class BookAuthor {
    
    static belongsTo = [book: Book, author: Author]

    static constraints = {
    }
}