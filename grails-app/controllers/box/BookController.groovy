package box


import grails.rest.*
import grails.converters.*

class BookController {
	static responseFormats = ['json']
	
    def index() { 
        def result = [valid: false]
        def books = Book.list()

        def totalcount = Book.count()
        result.data = books
        result.count = totalcount
        result.valid = true
        render(result as JSON)
    }
}
