package org.example;

import org.apache.commons.lang3.StringUtils;

public class Test {
    private String login;

    private String email;

    public Test() {
    }

    public Test(String login, String email) {

        if (!StringUtils.containsAny("@", email) || !StringUtils.containsAny(".", email)) {
            throw new RuntimeException("Некорректный email");
        } else if (login.equals(email)) {
            throw new RuntimeException("Логин и email одинаковые");
        }
        this.login = login;
        this.email = email;

    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
