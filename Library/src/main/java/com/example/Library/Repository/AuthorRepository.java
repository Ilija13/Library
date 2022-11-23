package com.example.Library.Repository;
import com.example.Library.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value =
            "SELECT FIRST_NAME, LAST_NAME, DOB, CONCAT ('this is the authors id : ',AUTHORID) , " +
                    "COUNT(BOOK_AUTHOR.AUTHOR_AUTHORID) as ac " +
                    "FROM AUTHOR\n" +
                    "LEFT OUTER JOIN BOOK_AUTHOR ON AUTHOR.AUTHORID = BOOK_AUTHOR.AUTHOR_AUTHORID\n" +
                    "GROUP  BY AUTHORID\n" +
                    "ORDER BY ac DESC\n" +
                    "LIMIT 5",
            nativeQuery = true
    )
    public List<Object> mostPopular();
}
