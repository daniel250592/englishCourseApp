package sda.ispeak.prework.models.emails;

import sda.ispeak.prework.models.users.User;

public class EmailGenerator {

    public static MyEmail generateEmail(User user) {
        return MyEmail.builder()
                .recipient(user.getEmail())
                .subject("Witaj " + user.getUserName() + " w aplikacji do nauki angielskiego")
                .message("Cieszymy się, że jestes z nami!!! \n Aktywuj swoje konto klikając w link: http://localhost:8080/user/activate-your-account" + user.getId() +
                        "\n I ciesz się nauką :)")
                .build();


    }

}
