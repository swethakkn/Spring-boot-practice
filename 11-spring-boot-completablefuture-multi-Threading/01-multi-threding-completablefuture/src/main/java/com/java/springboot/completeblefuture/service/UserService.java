package com.java.springboot.completeblefuture.service;

import com.java.springboot.completeblefuture.entity.User;
import com.java.springboot.completeblefuture.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository repository;
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Async
    public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception {
        long startTime = System.currentTimeMillis();
        List<User> users = parseCsvFile(file);
        logger.info("saving List of Users of size {}",users.size()+" " +Thread.currentThread().getName());
        users = repository.saveAll(users);
        long endTime = System.currentTimeMillis();
        logger.info("Total time {}",(endTime-startTime));
        return CompletableFuture.completedFuture(users);
    }
    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get the list of users by " + Thread.currentThread().getName());
        List<User> users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }
    private List<User> parseCsvFile(final MultipartFile file) throws Exception{
        final List<User> users = new ArrayList<>();
        try{
            try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                String line;
                while((line=br.readLine()) != null){
                    final String[] data=line.split(",");
                    final User user= new User();

                    user.setEmail(data[0]);
                    user.setFirstName(data[1]);
                    user.setLastName(data[2]);
                    users.add(user);
                }
                return users;
            }
        } catch (final Exception e) {
            logger.error("Failed to parse CSV file {}",file.getName() ,e);
            throw new Exception("Unable to parse CSV file {}",e);
        }
    }
}
