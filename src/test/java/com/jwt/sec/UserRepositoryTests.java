package com.jwt.sec;

import static org.assertj.core.api.Assertions.assertThat;

import com.jwt.sec.model.User;
import com.jwt.sec.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired private UserRepo repo;

    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("drake");

        User newUser = new User("gin@gmail.com", password);
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}

