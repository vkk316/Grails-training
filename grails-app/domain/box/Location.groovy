package box

class Location {

    String title
    String code

    static hasMany = [books: Book]

    static constraints = {
    }
}