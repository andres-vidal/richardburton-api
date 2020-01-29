package br.edu.ifrs.canoas.richardburton.tests.users;

import br.edu.ifrs.canoas.richardburton.users.User;
import br.edu.ifrs.canoas.richardburton.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.edu.ifrs.canoas.richardburton.users.EmailFormatException;
import br.edu.ifrs.canoas.richardburton.users.UserDAO;
import br.edu.ifrs.canoas.richardburton.users.UserService;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalMatchers.not;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceAuthenticateTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService = new UserService();

    private User user;

    @Before
    public void setup() {

        user = new User();
        user.setEmail("user@example.com");
        user.setAuthenticationString(Strings.digest("abcd"));

        when(userDAO.retrieve(eq(user.getEmail()))).thenReturn(user);
        when(userDAO.retrieve(not(eq(user.getEmail())))).thenReturn(null);

    }

    @Test(expected = EmailFormatException.class)
    public void failEmailInvalid() throws EmailFormatException {

        userService.authenticate("a", "");
    }

    @Test
    public void failUserDoesNotExist() throws EmailFormatException {

        User user = userService.authenticate("other@example.com", "");
        assertNull(user);
    }

    @Test
    public void failWrongPassword() throws EmailFormatException {

        User user = userService.authenticate(this.user.getEmail(), "aaaa");
        assertNull(user);
    }

    @Test
    public void success() throws EmailFormatException {

        User user = userService.authenticate(this.user.getEmail(), "abcd");
        assertEquals(this.user, user);
    }

}