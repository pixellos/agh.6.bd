#  AGH 6 - Bazy Danych

- [AGH 6 - Bazy Danych](#agh-6---bazy-danych)
  - [Uczestnicy](#uczestnicy)
  - [Technologie](#technologie)
  - [Metodyka](#metodyka)
  - [Uruchamianie](#uruchamianie)
    - [Wymagania](#wymagania)
  - [Developowanie](#developowanie)

## Dokumentacja

- [Strona główna (PDF)](https://github.com/pixellos/agh.6.bd/blob/master/pdfs/index.pdf)
- [Docker / Docker-Compose / CI/CD (PDF)](https://github.com/pixellos/agh.6.bd/blob/master/pdfs/docker.pdf)

## Uczestnicy

Kamil Glinski

Mateusz Popielarz

Michal Flak

## Technologie
1. PostgreSql
2. Hibernate
3. Java 8
4. Spring boot
5. GitHub Actions
6. Docker

## Metodyka

Baza danych zostala utworzona za pomoca PostgreSql.

Mapowanie ORM tabeli na encje w aplikacji zostalo osiagniete za pomoca frameworka Hibernate.

Wstrzykiwanie zaleznosci oraz konfiguracja warstwy backendowej zostalo zaimplementowane za pomoca Spring Boot.

Jako jezyk programowania zastosowalismy Java w wersji 8.

## Uruchamianie
### Wymagania
- Docker for windows
- WSL2

Wykonujemy `initialize.ps1` i działa ;)



## Developowanie
Odpal Powershell i wywołaj
```
Set-HostsEntry -IPAddress 0.0.0.0 -HostName 'northwind' -Description "Alias na baze danych"
```
