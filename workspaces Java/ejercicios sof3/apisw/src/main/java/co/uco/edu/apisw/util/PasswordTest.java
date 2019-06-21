package co.uco.edu.apisw.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    public static void main(String [] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        for(int i = 0; i < 10; i ++) {
            System.out.println(bCrypt.encode("1234"));
        }



    }

}
