import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Adam", 40, "ATL");
    }

    @Test
    void getName() {
        assertEquals("Adam", student.getName());
    }

    @Test
    void setName() {
        student.setName("Everett");
        assertEquals("Everett", student.getName(), "Set Name Failed...");
    }

    @Test
    void getAge() {
        assertEquals(40, student.getAge());
    }

    @Test
    void setAge() {
        student.setAge(25);
        assertEquals(25, student.getAge());
    }

    @Test
    void groupedAssertions() {
        student.setName("Lindsay");
        student.setAge(25);

        assertAll("Test Props",
                () -> assertEquals("Lindsay", student.getName(), "First Name Failed"),
                () -> assertEquals(25, student.getAge(), "Wrong Age"),
                () -> assertEquals("ATL", student.getAddress(), "Wrong Address"));
    }

}
