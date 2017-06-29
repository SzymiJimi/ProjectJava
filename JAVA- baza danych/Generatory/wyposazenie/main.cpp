#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>

using namespace std;

void generuj(ofstream *plik)
{
    int id_wyp, los, poduszki;
	srand(time(NULL));
	(*plik).open("wyposazenie.csv");
	for (int i = 0; i < 400; i++)
	{
	    poduszki= rand()%15;
		id_wyp = i+1;
		*plik << id_wyp << ";" << poduszki;
		for(int l=1; l<36; l++){
                los=rand()%2;
                *plik << ";" << los;
		}
		*plik << endl;
    }

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;

    return 0;
}
