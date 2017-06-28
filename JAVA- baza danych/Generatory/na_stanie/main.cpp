#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>
#include <string>

using namespace std;

void generuj(ofstream *plik)
{
	srand(time(NULL));
	int id_zaliczenia, kwota, nr=1,pozycja =1, mias;

	string miasta[] = {"Kielce", "Warszawa", "Wrocław", "Ostrowiec Świętokrzyski", "Masłów",
    "Brzeziny", "Opatów", "Końskie", "Kraków", "Bodzentyn", "Sandomierz", "Bałtów", "Chęciny", "Włoszczowa",
    "Busko Zdrój" };

	(*plik).open("na_stanie.csv");
	for (int i = 0; i < 250; i++)
	{

		id_zaliczenia = i+1;
		kwota = 5000+rand()%665*100;

		mias=rand()%15;

		*plik << id_zaliczenia <<  ";" << kwota << ";" << miasta[mias] << ";" << nr
		<< ";" << pozycja << ";" << id_zaliczenia+150 <<  endl;

        pozycja++;
        if(pozycja==10){
            pozycja=1;
            nr++;
        }


	}

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
