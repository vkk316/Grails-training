package box

class Author {

    String titleTH
    String titleENG
    int age

    static hasMany = [books: Book] // from book perspective

    static constraints = {
    }
}