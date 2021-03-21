package sda.ispeak.prework.models.emails;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.entities.users.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmailGeneratorTest {

    @Test
    public void shouldGenerateEmail() {
        User user = User.builder()
                .id(1L)
                .email("example@email.com")
                .userName("ExampleName")
                .password("password")
                .role("USER")
                .active(false)
                .build();

         MyEmail myEmail = MyEmail.builder()
                .recipient(user.getEmail())
                .subject("Witaj " + user.getUserName() + " w aplikacji do nauki angielskiego")
                .message("Cieszymy się, że jestes z nami!!! \n Aktywuj swoje konto klikając w link: http://localhost:8080/user/activate-account/" + user.getId() +
                        "\n I ciesz się nauką :)")
                .build();

         assertThat(myEmail.getRecipient()).isEqualTo("example@email.com");
         assertThat(myEmail.getSubject()).isEqualTo("Witaj ExampleName w aplikacji do nauki angielskiego");
         assertThat(myEmail.getMessage()).isEqualTo("Cieszymy się, że jestes z nami!!! \n Aktywuj swoje konto klikając w link: http://localhost:8080/user/activate-account/1\n I ciesz się nauką :)");
         assertThat(myEmail.getMessage()).isEqualTo("Cieszymy się, że jestes z nami!!! \n Aktywuj swoje konto klikając w link: http://localhost:8080/user/activate-account/" + user.getId() +
                 "\n I ciesz się nauką :)");
    }
}
