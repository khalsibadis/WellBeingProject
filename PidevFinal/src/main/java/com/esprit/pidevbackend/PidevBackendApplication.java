package com.esprit.pidevbackend;

import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Repository.CompetitionRepository;
import com.esprit.pidevbackend.Repository.RoomRepository;
import com.esprit.pidevbackend.Repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
public class PidevBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PidevBackendApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    @Value("${timeTable.demoData:SMALL}")
    private DemoData demoData;
/*

       @Bean
    public CommandLineRunner demoData(
            TimeslotRepository timeslotRepository,
            RoomRepository roomRepository,
            CompetitionRepository competitionRepository) {
        return (args) -> {
            if (demoData == DemoData.NONE) {
                return;
            }

            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            if (demoData == DemoData.LARGE) {
                timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            }

            roomRepository.save(new Room("Room A"));
            roomRepository.save(new Room("Room B"));
            roomRepository.save(new Room("Room C"));
            if (demoData == DemoData.LARGE) {
                roomRepository.save(new Room("Room D"));
                roomRepository.save(new Room("Room E"));
                roomRepository.save(new Room("Room F"));
            }

            competitionRepository.save(new Competition("ia competition", "P.Ons", "Java Team"));
            competitionRepository.save(new Competition("ia competition", "P.Ons", "Java Team"));
            competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Java Team"));
            competitionRepository.save(new Competition("Web Competition", "P.Yosra", "Java Team"));
            competitionRepository.save(new Competition("Mobile Competition", "P.Mounir", "Java Team"));
            competitionRepository.save(new Competition("History", "P.Taher", "Java Team"));
            competitionRepository.save(new Competition("English", "P.Taher", "Java Team"));
            competitionRepository.save(new Competition("English", "P.Taher", "Java Team"));
            competitionRepository.save(new Competition("Astro", "P.Ahmed", "Java Team"));
            competitionRepository.save(new Competition("Astro", "P.Ahmed", "Java Team"));
            if (demoData == DemoData.LARGE) {
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Java Team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Java Team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Java Team"));
                competitionRepository.save(new Competition("Java Competiton", "P.Ons", "Java Team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Java Team"));
                competitionRepository.save(new Competition("Geography", "P.Mounir", "Java Team"));
                competitionRepository.save(new Competition("Data Strtucture Competiton", "P.Mounir", "Java Team"));
                competitionRepository.save(new Competition("History", "P.Taher", "Java Team"));
                competitionRepository.save(new Competition("English", "P.Taher", "Java Team"));
                competitionRepository.save(new Competition("Memory Competiton", "P.Taher", "Java Team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Java Team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Java Team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Java Team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Java Team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Java Team"));
            }

            competitionRepository.save(new Competition("ia competition", "P.Ons", ".Net team"));
            competitionRepository.save(new Competition("ia competition", "P.Ons", ".Net team"));
            competitionRepository.save(new Competition("ia competition", "P.Ons", ".Net team"));
            competitionRepository.save(new Competition("Data Competition", "P.Yosra", ".Net team"));
            competitionRepository.save(new Competition("Web Competition", "P.Yosra", ".Net team"));
            competitionRepository.save(new Competition("French", "P.Yosra", ".Net team"));
            competitionRepository.save(new Competition("Geography", "P.Mounir", ".Net team"));
            competitionRepository.save(new Competition("History", "P.Taher", ".Net team"));
            competitionRepository.save(new Competition("English", "P.Ahmed", ".Net team"));
            competitionRepository.save(new Competition("Astro", "P.Ahmed", ".Net team"));
            if (demoData == DemoData.LARGE) {
                competitionRepository.save(new Competition("ia competition", "P.Ons", ".Net team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", ".Net team"));
                competitionRepository.save(new Competition("Java Competiton", "P.Ons", ".Net team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", ".Net team"));
                competitionRepository.save(new Competition("Mobile Competition", "P.Mounir", ".Net team"));
                competitionRepository.save(new Competition("Data Strtucture Competiton", "P.Mounir", ".Net team"));
                competitionRepository.save(new Competition("History", "P.Taher", ".Net team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", ".Net team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", ".Net team"));
                competitionRepository.save(new Competition("Memory Competiton", "P.Taher", ".Net team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", ".Net team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", ".Net team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", ".Net team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", ".Net team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", ".Net team"));

                competitionRepository.save(new Competition("ia competition", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("Java Competiton", "P.Ons", "Web team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Web team"));
                competitionRepository.save(new Competition("Web Competition", "P.Yosra", "Web team"));
                competitionRepository.save(new Competition("French", "P.Yosra", "Web team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Web team"));
                competitionRepository.save(new Competition("Geography", "P.Mounir", "Web team"));
                competitionRepository.save(new Competition("Mobile Competition", "P.Mounir", "Web team"));
                competitionRepository.save(new Competition("Data Strtucture Competiton", "P.Mounir", "Web team"));
                competitionRepository.save(new Competition("History", "P.Taher", "Web team"));
                competitionRepository.save(new Competition("History", "P.Taher", "Web team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Web team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Web team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Web team"));
                competitionRepository.save(new Competition("Astro", "P.Ahmed", "Web team"));
                competitionRepository.save(new Competition("Memory Competiton", "P.Ahmed", "Web team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Web team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Web team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Web team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Web team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Web team"));

                competitionRepository.save(new Competition("ia competition", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("ia competition", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("Java Competiton", "P.Ons", "Iot team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Iot team"));
                competitionRepository.save(new Competition("Web Competition", "P.Yosra", "Iot team"));
                competitionRepository.save(new Competition("French", "P.Yosra", "Iot team"));
                competitionRepository.save(new Competition("Data Competition", "P.Yosra", "Iot team"));
                competitionRepository.save(new Competition("Geography", "P.Mounir", "Iot team"));
                competitionRepository.save(new Competition("Mobile Competition", "P.Mounir", "Iot team"));
                competitionRepository.save(new Competition("Data Strtucture Competiton", "P.Mounir", "Iot team"));
                competitionRepository.save(new Competition("History", "P.Taher", "Iot team"));
                competitionRepository.save(new Competition("History", "P.Taher", "Iot team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Iot team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Iot team"));
                competitionRepository.save(new Competition("English", "P.Ahmed", "Iot team"));
                competitionRepository.save(new Competition("Astro", "P.Ahmed", "Iot team"));
                competitionRepository.save(new Competition("Memory Competiton", "P.Ahmed", "Iot team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Iot team"));
                competitionRepository.save(new Competition("Art", "P.Ben Ammar", "Iot team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Iot team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Iot team"));
                competitionRepository.save(new Competition("Spring Competiton", "P.Mrabet", "Iot team"));
            }

            Competition competition = competitionRepository.findAll(Sort.by("id")).iterator().next();
            competition.setTimeslot(timeslotRepository.findAll(Sort.by("id")).iterator().next());
            competition.setRoom(roomRepository.findAll(Sort.by("id")).iterator().next());
            competitionRepository.save(competition);
        };
    }


*/

    public enum DemoData {
        NONE,
        SMALL,
        LARGE
    }




























/*
    @Bean
    CommandLineRunner run (UserService userService){
        return args -> {
          userService.saveRole(new Role(null,"ROLE_USER"));
          userService.saveRole(new Role(null,"ROLE_MANAGER"));
          userService.saveRole(new Role(null,"ROLE_ADMIN"));
          userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null,"Jhon travolta","jhon","1234","picture",new ArrayList<>()));
          userService.saveUser(new User(null,"Whill Smith","will","1234","picture",new ArrayList<>()));
          userService.saveUser(new User(null,"Jim Carry","jim","1234","picture",new ArrayList<>()));
          userService.saveUser(new User(null,"Arnold Shwarzeneger","arnold","1234","picture",new ArrayList<>()));


          userService.addRoleToUser("jhon","ROLE_USER");
          userService.addRoleToUser("will","ROLE_MANAGER");
          userService.addRoleToUser("jim","ROLE_ADMIN");
          userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
          userService.addRoleToUser("arnold","ROLE_ADMIN");
          userService.addRoleToUser("arnold","ROLE_USER");

        };
    }*/
}
