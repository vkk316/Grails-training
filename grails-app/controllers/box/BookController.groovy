package box

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*
import java.time.LocalDate
// Before Refactor code

class BookController {
	static responseFormats = ['json']
	
    def index() { 
        def result = [valid: false]

        def qp = params

        def filter = new BookFilter()

        bindData(filter, qp.filter)

        filter = filter.properties

        def booksCriteria = Book.where{}.build {

            if(filter.titleEng__ilike){
                ilike 'titleEng', "%${filter.titleEng__ilike}%"
            }
            
            if(filter.price__gt){
                gt 'price', filter.price__gt
            }

            if(filter.isRead != null){
                eq 'isRead', filter.isRead
            }

            if(filter.since){
                gt 'since', filter.since
            }

            if(filter.since1 && filter.since2){
                between 'since', filter.since1, filter.since2
            }

            if(filter.bookCateId){
                eq 'category.id', filter.bookCateId
            }

            if(filter.authorTitle){
                authors {
                    author {
                        ilike 'titleEng', "%${filter.authorTitle}%"
                    }
                }
            }
            
        }

        result.data = booksCriteria.list(offset: qp.offset ?: 0, max: qp.max ?: 10)
        result.totalCount = booksCriteria.count()
        result.valid = true

        render(result as JSON)
    }
    def show(Long id){
        def result = [valid: false]
        def book = Book.get(id) // get book ตาม id ที่ clien ขอ

        result.data = book
        result.valid = true 

        render(result as JSON)
    }

    def save(Book book){
        def result = [valid: false]
        book.save(failOnError: true)
        result.data = book
        result.valid = true
        render(result as JSON) 
    }

    @Transactional
    def update(Book book){
        /* 
        1. get book following id
        2. new data from clien to replace rpevious data
        3. save it 
        */

        def result = [valid: false]
        bindData(book, request.JSON)

        book.save(failOnError: true)

        result.data = book
        result.valid = true

        render(result as JSON)
    }

    @Transactional //Asyncroniuos
    def delete(Long id){
        def result = [valid: false]
        try{
            def book = Book.get(id)
            if(!book){
                throw new Exception("not found book id: {id}")
            }
            book.delete()
            result.valid = true
        }catch(error){
            result.reason = error.message
        }
        render(result as JSON)
    }
}

class BookFilter {
    String titleEng__ilike
    Double price__gt
    Boolean isRead
    LocalDate since
    LocalDate since1
    LocalDate since2
    String authorTitle
    Long bookCateId 
}