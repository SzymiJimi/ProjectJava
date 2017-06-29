#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>

using namespace std;
/*
P * KLIENT_ID NUMBER (5)
DATA_P_ZAKUP DATE
PLEC VARCHAR2 (1)
F * OSOBA_ID NUMBER (5)
F * ADRES_ID NUMBER (5)
*/
void generuj(ofstream *plik)
{
	srand(time(NULL));
	int id_zaliczenia ,tmp,dzien,miesiac,rok,tmp2=0, los;
	char plec;
	(*plik).open("klienci.csv");
	for (int i = 0; i < 150; i++)
	{
		id_zaliczenia = i+1;
		los=rand()%2;
		if(los==0){
            plec='K';
		}
		else
            plec='M';
		tmp = rand() % 3 ;
		miesiac = rand() % 12 + 1;
		tmp2 = 0;
		while (tmp2 == 0)
		{
			dzien = rand() % 31 + 1;
			if ((miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) && dzien > 30)
			{
				tmp2 = 0;
			}
			else {
				if (miesiac == 2&&dzien>28)
				{
					tmp2 = 0;
				}
				else {
					tmp2 = 1;
				}
			}

		}
		rok = rand() % 3 + 2015;
		*plik << id_zaliczenia << ";" << dzien<<"/"<<miesiac<<"/"<<rok << ";" << plec << ";" << id_zaliczenia + 50 << ";" << id_zaliczenia+50 << endl;
	}

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
