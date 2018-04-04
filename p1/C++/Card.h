#ifndef CARD_H
#define CARD_H
#include <cstring>
#include <sstream>
#include <iostream>

using namespace std;

class Card
{
public:
    string naipe;
    int valor;

    Card(int n,int val);
    string toString();
};

#endif // CARD_H
