package com.java.springbootapplication.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.java.springbootapplication.security.ApplicationUserRole.*;

@Repository("fakeRepository")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> userName.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "patryk",
                        passwordEncoder.encode("admin"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        TESTER.getGrantedAuthorities(),
                        "mark",
                        passwordEncoder.encode("tester"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        USER.getGrantedAuthorities(),
                        "susan",
                        passwordEncoder.encode("user"),
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }
}