package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.SubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.TaskDao;
import ba.unsa.etf.rpr.dao.TaskDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private UserManager userManager;
    private User user;
    private TaskDaoSQLImpl taskDao;


    @BeforeEach
    public void initializeObjectsWeNeed() {
        userManager = Mockito.mock(UserManager.class);
        user = new User();
        user.setUsername("user");
        user.setPassword("123456");

        taskDao = Mockito.mock(TaskDaoSQLImpl.class);
    }

    @Test
    public void validPasswordLength() throws PlanerException {
        assertFalse(Mockito.doCallRealMethod().when(userManager).validatePasswordLength("123456"));
    }

    @Test
    public void newUsernameAddUsernameExists() throws PlanerException {
        UserManager userManager = new UserManager();
        assertTrue(userManager.validateNewUsernameExist("user"));
    }

    @Test
    public void hasDuplicateSubject() throws PlanerException {
        SubjectManager subjectManager = new SubjectManager();
        assertTrue(subjectManager.hasDuplicateSubjectUser(1,"matematika"));
    }

    @Test
    public void validateDateToday() throws PlanerException, ParseException {
        Date today = new Date();
        assertTrue(DaoFactory.taskDao().checkDate(today));
    }

    @Test
    public void validateDatePast() throws PlanerException, ParseException {
        String date = "2020-03-01";
        Date past = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        assertFalse(DaoFactory.taskDao().checkDate(past));
    }

    @Test
    public void subjectNameSetterAndGetter() throws PlanerException, ParseException {
        Subject s = new Subject("ime","akronim","boja",2,0);
        s.setName("drugo ime");
        assertEquals(s.getName(),"drugo ime");
    }

    @Test
    public void userGenderSetterAndGetter() throws PlanerException, ParseException {
        User u = new User();
        u.setGender("Male");
        assertNotEquals(u.getGender(),"Female");
    }

    @Test
    public void validatePasswordFromDB() throws PlanerException, ParseException {
        User u = new User();
        u.setUsername("user");
        u.setPassword("123456");
        assertTrue(DaoFactory.userDao().validPassword(u.getUsername(),u.getPassword()));
    }

    @Test
    public void taskGetterAndSetter() throws PlanerException, ParseException {
        Task task = new Task();
        task.setTaskText("aaaa");
        assertEquals("aaaa",task.getTaskText());
    }



}
