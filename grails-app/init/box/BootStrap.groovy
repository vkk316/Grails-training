package box
import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        def book1 = new Book([
                titleTH: "ทดสอบ1",
                titleENG: "test1",
                author: "James",
                price: 3000,
                since: LocalDate.of(2020,8,9),
            ]).save(flush: true)
        def book2 = new Book([
                titleTH: "ทดสอบ2",
                titleENG: "test2",
                author: "Jane",
                price: 5000,
                since: LocalDate.of(2020,5,1)
            ]).save(flush: true)
        def book3 = new Book([
                titleTH: "ทดสอบ3",
                titleENG: "test3",
                author: "John",
                price: 2000,
                since: LocalDate.of(2016,3,15)
            ]).save(flush: true)
         def book4 = new Book([
                titleTH: "ทดสอบ4",
                titleENG: "test4",
                author: "Joe",
                price: 4000,
                since: LocalDate.of(2018,5,20)
            ]).save(flush: true)
         def book5 = new Book([
                titleTH: "ทดสอบ5",
                titleENG: "test5",
                author: "Job",
                price: 6500,
                since: LocalDate.of(2001,1,13)
            ]).save(flush: true)
    }

    def destroy = {
    }
}
