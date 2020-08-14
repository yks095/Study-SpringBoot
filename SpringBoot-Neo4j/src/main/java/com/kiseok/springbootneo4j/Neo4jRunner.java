package com.kiseok.springbootneo4j;

import com.kiseok.springbootneo4j.account.Account;
import com.kiseok.springbootneo4j.account.AccountRepository;
import com.kiseok.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("kiseok");
        account.setEmail("kiseok@email.com");

        Role role = new Role();
        role.setName("admin");

        account.getRoles().add(role);

//        1
//        Session session = sessionFactory.openSession();
//        session.save(account);
//        sessionFactory.close();

//        2
        accountRepository.save(account);

        System.out.println("finished");
    }
}
