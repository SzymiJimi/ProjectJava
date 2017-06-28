load data
infile 'dane\samochody.csv'
into table samochody
replace
fields terminated by ';' 
( samochod_id char,
marka char,
model_auta char,
rok_produkcji char,
vin char,
przebieg char,
moc char,
typ_silnika char,
pojemnosc char,
wyposazenie_id char,
opis_id char,
dodajacy_prac_id char
)