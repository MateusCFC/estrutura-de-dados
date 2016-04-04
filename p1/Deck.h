#ifndef DECK_H
#define DECK_H
#include <list>
#include <Card.h>
#include <ctime>
#include <cstdlib>
#include <cmath>

using namespace std;

class Deck
{
public:
    list<Card> cl;

    Deck();
    string toString();
    Card draw();
    int cut(int n);
    list<Card> split(list<Card>* l,int c);
    list<Card> riffle(list<Card> l1,list<Card> l2);
    void riffleShuffle(int n);
};

#endif // DECK_H
