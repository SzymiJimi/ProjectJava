load data
infile 'dane\osoby.csv'
into table osoby
replace
fields terminated by ';' 
( osoba_id char,
imie char,
nazwisko char,
nip char,
pesel char
)