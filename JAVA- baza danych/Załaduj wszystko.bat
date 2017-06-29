echo 

sqlldr system/sys control=osoby.ctl
sqlldr system/sys control=adresy.ctl
sqlldr system/sys control=stanowiska.ctl
sqlldr system/sys control=klienci.ctl
sqlldr system/sys control=opis.ctl
sqlldr system/sys control=wyposazenie.ctl
sqlldr system/sys control=pracownicy.ctl
sqlldr system/sys control=samochody.ctl
sqlldr system/sys control=sprzedane.ctl
sqlldr system/sys control=na_stanie.ctl

pause
cls