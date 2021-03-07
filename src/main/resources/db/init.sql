create schema ispeak collate utf16_polish_ci;
CREATE USER 'prework'@'%' IDENTIFIED BY 'prework';
# dla wersji produkcyjnej ustawic wlasciwe uprawnienia
GRANT ALL PRIVILEGES ON * . * TO 'prework'@'%';
