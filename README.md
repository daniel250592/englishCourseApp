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
### Ogólna charakterystyka
Aplikacja pomaga w przygotowywaniu się do pierwszych zajęć z jezyka angielskiego. Nie jest to kurs, a pre-work przed właściwym kursem.
Materiał jest zorganizowany w:
- tematy (składające z ogólnego opisu i właściwej treści)
- quizy dodane do wybranych tematów, składających się z dowolnej liczby pytań. Każde z pytań zawiera 1 poprawną odpowiedź z 4

Za przygotowanie materiałów odpowiada użytkownik z uprawnieniami ADMIN.
Zarejestrowany użytkownik bez tych uprawnień ma dostęp do wyżej wymienionych materiów. 
Jedyną akcją zmieniającą stan jest uruchomienie wybranego quizu. System pamięta jego odpowiedzi i prezentuje wynik procentowy na koniec.

Początkowe wypełnienie to lorem ipsum.
Po developmencie minimum viable product'u  lektor języka angielskiego wraz z programistą doda kontent do aplikacji.

### Struktura aplikacji

Aplikacja powinna być tak zbudowana, aby treść lekcji była zapisana w kodzie aplikacji ale mogła być modyfikowana.
Aplikacja składa się z dwóch modułów funkcjonalnych. 

Pierwszy jest to panel administratora o scieżce /admin dostępny po zalogowaniu się użytkownika z uprawnieniami ADMIN.
Moduł administratora pozawalający na operacje CRUD na pytaniach wraz z odpowiedziami.

Drugi to panel ucznia o scieżce /(!admin)** dostępnej po zalogowaniu sie uzytkownika z uprawnieniami USER.
Uczeń ma możliwość założenia konta na swój własny email. Założenie konta jest możliwe dla wszystkich.
Wielu użytkowników może korzystać z aplikacji w tym samym momencie.
Uczeń ma dostęp do całej treści i może wieloktornie podchodzić do quizu.
Użytkownik widzi swój postęp po zalogowaniu zapisany po strone servera.
Pytania w quizie są grupowane na podstawie tematu lekcji.

Powyższe moduły funkcjonalne zaimplementowane są w dwóch modułach technicznych. 

Niniejszy realizuje logikę w postaci obsługi zapytań RestFULL. Dane zapisane są w bazie danych MySQL.

### Szczegółowe wymagania
#### Role w systemi
W aktualnej wersji systemu istnieją dwie role:\
USER \
ADMIN\
#### Rejestracja użytkowników
Rejestracja użytkownika odbywa się po stronie UI w formularzu.
Formularz rejestracji zawierający: \
login (email) – sprawdzenie pod kątem poprawności emaila, \
hasło – musi mieć przynajmniej 8 znaków, ale nie więcej niż 30 (użytkownik powinien potwierdzić wpisane hasło) \
nazwę do wyświetlania – pole nie może być puste ani zawierać samych białych znaków, a maksymalna długość to 50 znaków. \
Użytkownik o danym emailu może zarejestrować się tylko raz.

Istnieje endpoint za pomocą którego powyższe dane użytkownika są wprowadzane do systemu.

Użytkownik zarejestrowany z wykorzystaniem powyższego formularza ma jedynie uprawnienia USER. 
Zmiana uprawniania na ADMIN odbywa się poprzez ręczną edycję bazy danych.
Dla nowej instalacji tworzony jest domyślny użytkownik o uprawnieniach ADM.
Z użytkownikiem powinny być powiązane role w systemie, które będą obejmować przynajmniej dwa przypadki: admin oraz zwykły użytkownik. Każda rejestrująca się osoba dostaje zawsze rolę USER.
Hasło jest trzymane w bazie danych w postaci uniemożliwiającej podejrzenie/odzyskanie.

#### Logowanie użytkownika
Zarejestrowany użytkownik może użyć formularza logowania zawierającego login oraz hasło aby uzyskać dostęp do materiałów.
Istnieje endpoint, który z wykorzystaniem Spring Security wykonuje autoryzację i autentykazję użytkownika.
UI: po poprawnym zalogowaniu użytkownik powinien zostać przekierowany na stronę główną, gdzie zamiast przycisków zaloguj/zarejestruj wyświetli się informacja typu: „Zalogowany jako: email”.

#### Prezentacja tematów
Istnieje endpoint, który przekaże listę wszystki dostępnych tematów w określonej konfiguracji.
Lista taka jest prezentowana w UI zarejestrowanemu użytkownikowi.
Jeżeli w systmie nie ma jeszcze żadnych tematów, endpoint zwróci pustą listę.
Endpoint ma być dostępny jedynie dla zarejestrowanych użytkowników.

#### Prezentacja zawartości wybranego tematu.
Z listy wszystkich tematów użytkownik może wybrać dowolny i wyświetlić jego zawartość.
Istnieje endpoint, który przekaże zawartość wybranego tematu. 
Jeżeli nie ma wybranego tematu zwrócony zostanie komunikat o błędzie: Brak zawartości.
Endpoint ma być dostępny jedynie dla zarejestrowanych użytkowników.

#### Uruchomienie quiz'u
Zarejestrowany użytkownik po wybraniu tematu może aktywować quiz dostępny dla tego tematu.
Po aktywowaniu quizu system pokazuje zawsze pierwsze pytanie quizu, nawet jeżeli wcześniej quiz był już wykonany.
Użytkownik musi zaznaczyć jedną z odpowiedzi zanim przejdzie do kolejnego pytania. Po zaznaczeniu odpowiedzi aktywuje akcję dalej.
Istnieje kilka endpointów w systemie:
- pierwszy wyświetla pierwsze pytanie w quizie na bazie wybranego tematu oraz numer kolejnego pytania. Jeżeli kolejnego pytania nie ma w systemie to podaje w numerze wartość -100.
- drugi rejestruje odpowiedź i wyświetla wyświetla kolejne w oparciu o podany numerze. Jeżeli kolejnego pytania nie ma w systemie to podaje w numerze wartość -100.
- trzeci prezentuje wynik całego quizu. 
Za wywołanie odpowiednich endpointów odpowiada UI.
Endpointy mają być dostępne jedynie dla zarejestrowanych użytkowników.
  
#### Dodanie nowego pytania i odpowiedzi
Użytkownik zarejestrowany jako ADMIN ma dostęp do ednpointu za pomocą którego może utworzyć pytanie z przypisanymi odpowiedziami
W trakcie zapisywania należy sprawdzić czy dane do zapisu są poprawne:
- Pytanie musi być skojarzone z istniejącym tematem  
- Pytanie zawiera cztery odpowiedzi z czego jedna jest prawidłowa. 
- Treść pytania musi być dłuższa niż 10 znaków i nie dłuższa niż 200 znakow.
- Treść odpowiedzi musi być dłuższa niz 1 znak i nie dłuższa niż 100 znaków.
W trakcie należy przekształcić obiekt zawierający dane wejściwe do odpowiednich klas reprezentujących entity.
W wyniku operacji CRUD mają powstać zapisy w odpowiednich tabelach bazy danych.

#### Kasowanie pytania
Użytkownik zarejestrowany jako ADMIN ma dostęp do ednpointu za pomocą którego może skasować pytanie z przypisanymi odpowiedziami.
W parametrach endpointu należy podać dane które pozwolą jednoznaczenie wybrać pytanie (numer tematu, numer pytania). Skojarzone z pytaniem odpowiedzi system znajdzie sam.


#### Uwagi końcowe
W pierwszej wersji tematy i ich zawartość będzie wpisywana ręcznie z wykorzystaniem SQL. Endpointy do obsługi tego typu działań będą dodane w kolejnej wersji.


## API dla innych serwisów
API powinno spełniać zasady REST,
umożliwiać pobieranie listy wszystkich pytań wraz z odpowiedziami,
umożliwiać pobieranie danego pytania wraz z odpowiedziami 
i dodatkowo umożliwiać filtrowanie zwracanych pytań po temacie.

Aplikacja wyświetlająca wydarzenia pobrane z API
Należy zbudować drugą aplikację (z wykorzystaniem Spring + Angular), która skonsumuje API i wygeneruje widok lekcji oraz quizów.


