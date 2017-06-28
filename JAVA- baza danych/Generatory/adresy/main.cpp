#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>

using namespace std;

void generuj(ofstream *plik)
{
    string miasta[] = {"Kielce", "Warszawa", "Wroc�aw", "Ostrowiec �wi�tokrzyski", "Mas��w",
    "Brzeziny", "Opat�w", "Ko�skie", "Krak�w", "Bodzentyn", "Sandomierz", "Ba�t�w", "Ch�ciny", "W�oszczowa",
    "Busko Zdr�j" };

    string kody[] ={"25-306", "02-496", "52-114", "27-400", "26-001", "28-225", "27-501", "26-200",
    "30-009", "26-010", "27-601", "24-103", "26-060", "29-100", "28-101"};

    string ulice[] = {"Warszawska", "�l�ska", "Adama Mickiewicza", "I maja", "Wikaryjska", "M�chocka",
    "Jana Paw�a II", "Powstania listopadowego", "Mieszka I", "Ogrodowa", "Spokojna", "Sosnowa",
    "Tadeusza Ko�ciuszki", "Miko�aja Reja", "Senatorska", "Poselska", "Wiejska",
    "Jana Kochanowskiego", "C. K. Norwida", "Juliusza S�owackiego", "Stefana �eromskiego", "P. �ciegiennego"};
	srand(time(NULL));
	int id_zaliczenia, nr_domu, nr_mieszkania, los, ul;
	(*plik).open("adresy.csv");
	for (int i = 0; i < 200; i++)
	{
	    los=rand()%15;
	    ul=rand()%22;
		id_zaliczenia = i+1;
        nr_domu = rand()%300;
        nr_mieszkania=rand()%30;

		*plik << id_zaliczenia << ";" << nr_domu <<";" << miasta[los] << ";"<< kody[los] << ";"<<
        miasta[los] << ";" <<  nr_mieszkania << ";"<< ulice[ul] << endl;
	}
}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;

    return 0;
}
