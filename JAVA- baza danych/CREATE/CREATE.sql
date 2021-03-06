DROP TABLE NA_STANIE CASCADE CONSTRAINTS;
DROP TABLE SPRZEDANE CASCADE CONSTRAINTS;
DROP TABLE SAMOCHODY CASCADE CONSTRAINTS;
DROP TABLE PRACOWNICY CASCADE CONSTRAINTS;
DROP TABLE WYPOSAZENIE CASCADE CONSTRAINTS;
DROP TABLE OPIS CASCADE CONSTRAINTS;
DROP TABLE KLIENCI CASCADE CONSTRAINTS;
DROP TABLE STANOWISKA CASCADE CONSTRAINTS;
DROP TABLE ADRESY CASCADE CONSTRAINTS;
DROP TABLE OSOBY CASCADE CONSTRAINTS;




CREATE TABLE OSOBY(
OSOBA_ID NUMBER(5) CONSTRAINT OSOBY_PK PRIMARY KEY,
IMIE VARCHAR2(20),
NAZWISKO VARCHAR2(20),
NIP VARCHAR2(13),
PESEL VARCHAR2(11)
);


CREATE TABLE ADRESY(
ADRES_ID NUMBER(5) CONSTRAINT ADRESY_PK PRIMARY KEY,
NR_DOMU NUMBER(3),
MIEJSCOWOSC VARCHAR2(30),
KOD_POCZTOWY VARCHAR2(6),
POCZTA VARCHAR2(30),
NR_MIESZKANIA NUMBER(3),
ULICA VARCHAR2(30)
);

CREATE TABLE STANOWISKA(
STANOWISKO_ID NUMBER(5) CONSTRAINT STANOWISKA_PK PRIMARY KEY,
NAZWA VARCHAR2(25),
STOPIEN NUMBER(1)
);

CREATE TABLE KLIENCI(
KLIENT_ID NUMBER(5) CONSTRAINT KLIENCI_PK PRIMARY KEY,
DATA_P_ZAKUP DATE,
PLEC VARCHAR2(1),
OSOBA_ID NUMBER(5) NOT NULL CONSTRAINT KLIENCI_FK1 REFERENCES OSOBY(OSOBA_ID),
ADRES_ID NUMBER(5) NOT NULL CONSTRAINT KLIENCI_FK2 REFERENCES ADRESY(ADRES_ID)
);

CREATE TABLE OPIS(
OPIS_ID NUMBER(5) CONSTRAINT OPIS_PK PRIMARY KEY,
SKRZYNIA_BIEGOW VARCHAR(15),
STAN_POJAZDU VARCHAR2(15),
NADWOZIE VARCHAR2(15),
KRAJ_POCHODZENIA VARCHAR2(20),
SERWISOWANY NUMBER(1),
DOD_OPIS VARCHAR2(200)
);



CREATE TABLE WYPOSAZENIE(
WYPOSAZENIE_ID NUMBER(5) CONSTRAINT WYPOSAZENIE_PK PRIMARY KEY,
PODUSZKI_POW NUMBER(2),
ABS_ NUMBER(1),
ESP NUMBER(1),
WSP_KIER NUMBER(1),
BLUETOOTH NUMBER(1),
CZ_ZMIERZCH NUMBER(1),
CZ_PARK NUMBER(1),
CZ_DESZCZ NUMBER(1),
EL_LUSTERKA NUMBER(1),
EL_SZYBY_P NUMBER(1),
EL_SZYBY_T NUMBER(1),
PODGRZ_LUST_BOK NUMBER(1),
PODGRZ_SIEDZ_P NUMBER(1),
PODGRZ_SIEDZ_T NUMBER(1),
PODGRZ_KIER NUMBER(1),
IMMOBILIZER NUMBER(1),
ALARM NUMBER(1),
CENTRALNY_ZAM NUMBER(1),
PILOT NUMBER(1),
MP3 NUMBER(1),
GN_AUX NUMBER(1),
RADIO_FABR NUMBER(1),
CD NUMBER(1),
KOMP_POKLAD NUMBER(1),
GNIAZDO_12V NUMBER(1),
TEMPOMAT NUMBER(1),
AKTYW_TEMPOMAT NUMBER(1),
LINE_ASIST NUMBER(1),
KURTYNY_POW NUMBER(1),
ISOFIX NUMBER(1),
CIEMN_SZYBY NUMBER(1),
ALUFELGI NUMBER(1),
RELINGI NUMBER(1),
SW_LED NUMBER(1),
SW_XENON NUMBER(1),
SW_DZIEN NUMBER(1)
);


CREATE TABLE PRACOWNICY(
PRACOWNIK_ID NUMBER(5) CONSTRAINT PRACOWNICY_PK PRIMARY KEY,
WYNAGRODZENIE NUMBER(5),
DATA_ZATRUDNIENIA DATE,
URLOP NUMBER(1),
OSOBA_ID NUMBER(5) NOT NULL CONSTRAINT PRACOWNICY_FK1 REFERENCES OSOBY(OSOBA_ID),
STANOWISKO_ID NUMBER(5) NOT NULL CONSTRAINT PRACOWNICY_FK2 REFERENCES STANOWISKA(STANOWISKO_ID),
ADRES_ID NUMBER(5) NOT NULL CONSTRAINT PRACOWNICY_FK3 REFERENCES ADRESY(ADRES_ID),
ZATRUDNIONY NUMBER(1),
DATA_ZWOLNIENIA DATE
);

CREATE TABLE SAMOCHODY(
SAMOCHOD_ID NUMBER(5) CONSTRAINT SAMOCHODY_PK PRIMARY KEY,
MARKA VARCHAR2(15),
MODEL_AUTA VARCHAR2(15),
ROK_PRODUKCJI NUMBER,
VIN  VARCHAR2(17),
PRZEBIEG  NUMBER(6),
MOC  NUMBER(6),
TYP_SILNIKA VARCHAR2(15),
POJEMNOSC  NUMBER(3,1),
WYPOSAZENIE_ID NUMBER(5) NOT NULL CONSTRAINT SAMOCHODY_FK1 REFERENCES WYPOSAZENIE(WYPOSAZENIE_ID),
OPIS_ID NUMBER(5) NOT NULL CONSTRAINT SAMOCHODY_FK2 REFERENCES OPIS(OPIS_ID),
DODAJACY_PRAC_ID NUMBER(5) NOT NULL CONSTRAINT SAMOCHODY_FK3 REFERENCES PRACOWNICY(PRACOWNIK_ID)
);

CREATE TABLE SPRZEDANE(
ID_SPRZEDAZY NUMBER(5) CONSTRAINT SPRZEDANE_PK PRIMARY KEY,
DATA_SPRZEDAZY DATE,
KWOTA_SPRZED NUMBER(7),
SAMOCHOD_ID NUMBER(5) NOT NULL CONSTRAINT SPRZEDANE_FK1 REFERENCES SAMOCHODY(SAMOCHOD_ID),
KLIENT_ID NUMBER(5) NOT NULL CONSTRAINT SPRZEDANE_FK2 REFERENCES KLIENCI(KLIENT_ID),
SPRZED_PRACOW_ID NUMBER(5) NOT NULL CONSTRAINT SPRZEDANE_FK3 REFERENCES PRACOWNICY(PRACOWNIK_ID)
);


CREATE TABLE NA_STANIE(
ID_STANU NUMBER(5) CONSTRAINT NA_STANIE_PK PRIMARY KEY,
WARTOSC NUMBER(7),
MIEJSCOWOSC VARCHAR2(30),
NR_GARAZU VARCHAR2(2),
POZYCJA VARCHAR2(3),
SAMOCHOD_ID NUMBER(5) NOT NULL CONSTRAINT NA_STANIE_FK1 REFERENCES SAMOCHODY(SAMOCHOD_ID)
);


Drop sequence samseq;
Drop sequence wypseq;
Drop sequence opisseq;
Drop sequence stanseq;
Drop sequence clientseq;
Drop sequence personseq;
Drop sequence sellseq;

CREATE SEQUENCE OPISSEQ START WITH 401;
CREATE SEQUENCE SAMSEQ START WITH 401;
CREATE SEQUENCE WYPSEQ START WITH 401;

Create sequence stanseq 
minvalue 401
maxvalue 99999
start with 401
increment by 1;


Create sequence clientseq 
minvalue 151
maxvalue 99999
start with 151
increment by 1;


Create sequence personseq 
minvalue 201
maxvalue 99999
start with 201
increment by 1;

Create sequence sellseq 
minvalue 151
maxvalue 99999
start with 151
increment by 1;

