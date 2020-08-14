package com.kiseok.springbootmongo;

import com.kiseok.springbootmongo.account.Account;
import com.kiseok.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootMongoApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner()    {
        return args -> {
            Account account = new Account();
            account.setUsername("username");
            account.setEmail("email@email.com");

//            1
//            mongoTemplate.insert(account);
            System.out.println("finished");

//            2
            accountRepository.insert(account);
            System.out.println("finished2");

        };
    }
}
