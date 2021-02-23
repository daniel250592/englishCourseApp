# englishCourseApp
App for English language learners

## Tech stack:
* Java 15
* Spring/Spring Boot
* MySql
* JPA
* JUnit/AssertJ
* Maven
* GitHub
* Angular 8

repozytorium front end: https://github.com/daniel250592/englishCourseAppAngular

## Wymagania
Aplikacja pomaga w przygotowywaniu się do pierwszych zajęć z jezyka angielskiego. Nie jest to kurs, a pre-work przed właściwym kursem.
Początkowe wypełnienie to lorem ipsum.
Po developmencie minimum viable product'u  lektor języka angielskiego wraz z programistą doda kontent do aplikacji.

Aplikacja powinna być tak zbudowana, aby treść lekcji była zapisana w kodzie aplikacji.
Aplikacja składa się z dwóch modułów. Pierwszy jest to panel administratora o scieżce /admin dostępny po zalogowaniu się użytkownika z uprawnieniami ADMIN
Moduł administratora pozawalający na operacje CRUD na pytaniach wraz z odpowiedziami.


Drugi to panel ucznia o scieżce /(!admin)** dostępnej po zalogowaniu sie uzytkownika z uprawnieniami USER
Panel ucznia pozwalający na odczytanie treści lekcji oraz rozwiązanie quizu, który dostępny jest po każdej lekcji.
Uczeń ma możliwość założenia konta na swój własny email. Założenie konta jest możliwe dla wszystkich.
Wielu użytkowników może korzystać z aplikacji w tym samym momencie.
Uczeń ma dostęp do całej treści i może wieloktornie podchodzić do quizu.
Użytkownik widzi swój postęp po wylogowaniu zapisany po strone servera.
Pytania w quizie są grupowane na podstawie tematu lekcji.

## Rejestracja użytkowników
Formularz rejestracji zawierający: \
login (email) – sprawdzenie pod kątem poprawności emaila, \
hasło – musi mieć przynajmniej 8 znaków, ale nie więcej niż 30 (użytkownik powinien potwierdzić wpisane hasło) \
nazwę do wyświetlania – pole nie może być puste ani zawierać samych białych znaków, a maksymalna długość to 50 znaków. \
Użytkownik o danym emailu może zarejestrować się tylko raz.
Z użytkownikiem powinny być powiązane role w systemie, które będą obejmować przynajmniej dwa przypadki: admin oraz zwykły użytkownik. Każda rejestrująca się osoba dostaje zawsze rolę USER.
Hasło jest trzymane w bazie danych w postaci uniemożliwiającej podejrzenie/odzyskanie.

## Logowanie użytkownika
formularz logowania zawierający login oraz hasło.
logowanie z wykorzystaniem Spring Security (do stworzenia odpowiednia konfiguracja).
po poprawnym zalogowaniu użytkownik powinien zostać przekierowany na stronę główną, gdzie zamiast przycisków zaloguj/zarejestruj wyświetli się informacja typu: „Zalogowany jako: email”.

## Dodanie nowego pytania i odpowiedzi
Pytanie zawiera cztery odpowiedzi z czego jedna jest prawidłowa. 
Temat pytania zostanie zapisany w Enumie w kodzie aplikacji.
Treść pytania musi być dłuższa niż 10 znaków i nie dłuższa niż 200 znakow.
Treść odpowiedzi musi być dłuższa niz 1 znak i nie dłuższa niż 100 znaków.
Na każdym z pytań i odpowiedzi możliwy jest CRUD na specjalnym formularzu

## API dla innych serwisów
API powinno spełniać zasady REST,
umożliwiać pobieranie listy wszystkich pytań wraz z odpowiedziami,
umożliwiać pobieranie danego pytania wraz z odpowiedziami 
i dodatkowo umożliwiać filtrowanie zwracanych pytań po temacie.

Aplikacja wyświetlająca wydarzenia pobrane z API
Należy zbudować drugą aplikację (z wykorzystaniem Spring + Angular), która skonsumuje API i wygeneruje widok lekcji oraz quizów.


