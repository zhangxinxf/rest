package com.zx.service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author 2013
 * 
 */
@Path("/userService")
public class UserService {

   @GET
   @Path("/name/{i}")
   @Produces(MediaType.APPLICATION_JSON)
   public String findByUserName(@PathParam("i") String name) {
      // 接下来创建User实例，并生成JSON数据

      ObjectMapper mapper = new ObjectMapper();
      UserName userName = new UserName();
      userName.setFirstname("Katamreddy");
      userName.setMiddlename("Siva");
      userName.setLastname("PrasadReddy");
      User user = new User();
      user.setUserId("1");
      user.setUserName(userName);
      user.setDob(new Date());

      Writer strWriter = new StringWriter();
      try {
         mapper.writeValue(strWriter, user);

      } catch (JsonGenerationException e) {
         e.printStackTrace();
      } catch (JsonMappingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            strWriter.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      String userDataJSON = strWriter.toString();
      System.out.println(userDataJSON);
      return userDataJSON;
   }

   public class UserName {
      private String firstname;
      private String middlename;
      private String lastname;

      public String getFirstname() {
         return firstname;
      }

      public void setFirstname(String firstname) {
         this.firstname = firstname;
      }

      public String getMiddlename() {
         return middlename;
      }

      public void setMiddlename(String middlename) {
         this.middlename = middlename;
      }

      public String getLastname() {
         return lastname;
      }

      public void setLastname(String lastname) {
         this.lastname = lastname;
      }

   }

   public class User {
      private String userId;
      private UserName userName;
      private Date dob;

      public String getUserId() {
         return userId;
      }

      public void setUserId(String userId) {
         this.userId = userId;
      }

      public UserName getUserName() {
         return userName;
      }

      public void setUserName(UserName userName) {
         this.userName = userName;
      }

      public Date getDob() {
         return dob;
      }

      public void setDob(Date dob) {
         this.dob = dob;
      }
   }
}
