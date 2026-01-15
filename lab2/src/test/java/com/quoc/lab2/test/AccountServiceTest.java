package com.quoc.lab2.test;

import com.quoc.lab2.AccountService;
import org.junit.jupiter.api.Assertions;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @Test
    public void testRegisterAccountWithCSVData() throws Exception {

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("test-data.csv");

        Assertions.assertNotNull(is, "CSV not found");


        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            String username = data[0];
            String password = data[1];
            String email = data[2];
            boolean expected = Boolean.parseBoolean(data[3]);

            boolean actual = accountService.registerAccount(username, password, email);

            Assertions.assertEquals(expected, actual,
                    "Failed for: username=" + username
                    + ", password=" + password
                    + ", email=" + email);
        }
    }
}
