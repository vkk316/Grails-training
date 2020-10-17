package box
import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        def cate1 = new BookCategory([
                title: "Special",
                code: "ss1",
                description: "for study social media",
                borrowingDays: 10,
                findRatePerDay: 20
            ]).save(flush: true)
            
            def cate2 = new BookCategory([
                title: "Sci",
                code: "sc1",
                description: "for study science",
                borrowingDays: 5,
                findRatePerDay: 30
            ]).save(flush: true)

            def author1 = new Author([
                titleTH: "เจเจ",
                titleENG: "JJ",
                age: 100
            ]).save(flush: true)

            def author2 = new Author([
                titleTH: "ท่อ",
                titleENG: "Tor",
                age: 30
            ]).save(flush: true)

            def book1 = new Book([
                titleTH: "ทดสอบ1",
                titleENG: "test1",
                author: "James",
                price: 3000,
                since: LocalDate.of(2020,8,9),
                category: cate1
            ]).save(flush: true)

            def bookAuthor1 = new BookAuthor([
                book: book1,
                author: author1
            ]).save(flush: true)

            def book2 = new Book([
                titleTH: "ทดสอบ2",
                titleENG: "test2",
                author: "Jane",
                price: 5000,
                since: LocalDate.of(2020,5,1),
                category: cate2
            ]).save(flush: true)

            def bookAuthor2 = new BookAuthor([
                book: book2,
                author: author1
            ]).save(flush: true)

            def book3 = new Book([
                titleTH: "ทดสอบ3",
                titleENG: "test3",
                author: "John",
                price: 2000,
                since: LocalDate.of(2016,3,15),
                category: cate1
            ]).save(flush: true)

            def bookAuthor3 = new BookAuthor([
                book: book3,
                author: author2
            ]).save(flush: true)

            def book4 = new Book([
                titleTH: "ทดสอบ4",
                titleENG: "test4",
                author: "Joe",
                price: 4000,
                since: LocalDate.of(2018,5,20),
                category: cate1
            ]).save(flush: true)
            
            def bookAuthor4 = new BookAuthor([
                book: book4,
                author: author2
            ]).save(flush: true)

            def book5 = new Book([
                titleTH: "ทดสอบ5",
                titleENG: "test5",
                author: "Job",
                price: 6500,
                since: LocalDate.of(2001,1,13),
                category: cate2
            ]).save(flush: true)

            def bookAuthor5 = new BookAuthor([
                book: book5,
                author: author1
            ]).save(flush: true)
    }

    def destroy = {
    }
}
