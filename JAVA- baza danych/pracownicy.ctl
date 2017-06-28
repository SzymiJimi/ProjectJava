load data
infile 'dane\pracownicy.csv'
into table pracownicy
replace
fields terminated by ';' 
( pracownik_id char,
wynagrodzenie char,
data_zatrudnienia date 'DD/MM/YYYY',
urlop char,
osoba_id char,
stanowisko_id char,
adres_id char,
zatrudniony char,
DATA_ZWOLNIENIA char
)