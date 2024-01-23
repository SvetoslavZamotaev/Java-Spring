package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    //Поле по дз
    @Autowired
    private UserService userService;
    //Поле по дз
    @Autowired
    private NotificationService notificationService;


    // метод по дз
    public void processRegistration(String name , int age , String email){
        User createUser = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(createUser);
        notificationService.sendNotification("Пользователь сохранен в список");
    }
}
