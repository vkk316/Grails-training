package box

import java.time.LocalDate

class Book {
    //การตังชื่อ property ตัวพิมพ์เล็ก-พิมพ์ใหญ่สำคัญมากๆๆๆๆ
    //ซิึ่งการชือ property ต้องงงง ขึ้นต้นด้วยตัวพิมพ์ใหญ่เท่านั้น

    //อ้างอิงจาก doc ของ Groovy lang
    String title_TH
    String title_Eng
    String author
    double price
    LocalDate since

    static constraints = {
        //ไว้เรื่องหลัง ๆ ครับ
    }
}
