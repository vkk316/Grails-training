package box

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*

class BookController {
	static responseFormats = ['json']
	
    def index() { 
        //Groovy เป็น lang ที่เป็น dynamic datatype

        // [ key: value ] <--- เรียกว่า Map คล้ายๆ Hash Table ใน C
        def result = [valid: false]  // เป็น convention ของ Bonmek
        def books = Book.list() // method list :: docs --> http://docs.grails.org/3.1.1/ref/Domain%20Classes/list.html 

        def totalcount = Book.count() // Returns the total number of rows in the domain class table
        // ที่ เอาค่าต่างๆ มาแมบ
        result.data = books // เอา books ไปใส่ใน value ของ key "data" 
        result.count = totalcount // เอา books ไปใส่ใน value ของ key "count" 
        result.valid = true

        render(result as JSON) // เอาท์พุต result เป็น json ที่ฝั่ง clien
    }

    def show(){
        def result = [valid: false]
        def id = params.id as long //casting params.id เป็น long :: docs -> http://docs.grails.org/3.3.11/ref/Controllers/params.html
        def book = Book.get(id) // get book ตาม id ที่ clien ขอ

        result.data = book
        result.valid = true 

        render(result as JSON)
    }

    def save(){
        def result = [valid: false]
        def book = new Book(request.JSON)
        book.save(failOnError: true)

        result.data = book
        result.valid = true

        render(result as JSON) 
    }

    @Transactional
    def update(){
        /* 
        1. get book following id
        2. new data from clien to replace rpevious data
        3. save it 
        */

        def result = [valid: false]
        def book = Book.get(params.id as long)
        bindData(book, request.JSON)

        book.save(failOnError: true)

        result.data = book
        result.valid = true

        render(result as JSON)
        
    }
}
