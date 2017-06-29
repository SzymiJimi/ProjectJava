load data
infile 'dane\stanowiska.csv'
into table stanowiska
replace
fields terminated by ';' 
( stanowisko_id char,
nazwa char,
stopien char
)