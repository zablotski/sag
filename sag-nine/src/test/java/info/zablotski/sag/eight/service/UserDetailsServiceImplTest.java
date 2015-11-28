package info.zablotski.sag.nine.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest extends TestCase {
    @Mock
    private UserService userServiceMock;

    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        assertEquals("user1", userDetailsService.loadUserByUsername("user1").getUsername());

        assertSame(new UsernameNotFoundException(""), userDetailsService.loadUserByUsername("ZZZZZZZ").getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameFailed() throws Exception {
         userDetailsService.loadUserByUsername("ZZZZZZZ").getUsername();
    }
}