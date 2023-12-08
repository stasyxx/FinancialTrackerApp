package com.pingwit.financialTrackerApp.component;

import com.pingwit.financialTrackerApp.entity.User;
import org.hibernate.criterion.IdentifierProjection;

import java.util.UUID;


public class UserIDCreator {
        private UUID id;
        private String username;

       public UserIDCreator(String username) {
            this.id = UUID.randomUUID();
            this.username = username;
        }

        public UUID getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

       /* public static void main(String[] args) {

            User newUser = new User(id, "john doe"); // ?????
            IdentifierProjection generatedUserId = newUser.getId();
            System.out.println(generatedUserId);
        } */

    }


