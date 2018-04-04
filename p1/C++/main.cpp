#include <iostream>
#include <Blackjack.h>
#include <math.h>
#include <ctime>
#include <cstdlib>

using namespace std;

void testcards();
void test1();
void test2();
void test4();
void test5();
void test6();
void testbj1();
void testbj2();
void testbj3();
void testbj4();

int main()
{
    //testcards();
    //test1();
    //test2();
    //test4();
    //test5();
    //test6();
    //testbj1();
    //testbj2();
    //testbj3();
    //testbj4();
    Blackjack blackj;
    blackj.game();
    return 0;
}

void testcards()
{
    Card c0(0,1);
    Card c1(1,10);
    Card c2(2,11);
    Card c3(3,13);
    cout << "" << c0.toString() << " " << c1.toString() << " " << c2.toString() << " " << c3.toString();
}

void test1()
{
    Deck d;
    cout << d.toString() << endl;
}

void test2()
{
    Deck d;
    cout << "Drawn cards: " << endl;
    for (int i=0; i<52; i++) cout << d.draw().toString() << endl;
    cout << endl;
}

void test4()
{
    int c[3] = {0,26,52};
    for (int i=0; i<=2; i++)
    {
        cout << "Cut: " << c[i] << endl;
        Deck d;
        list<Card> l = d.split(&d.cl,c[i]);
        cout << "First heap: ";
        list<Card> aux = l;
        list<Card> aux2 = d.cl;
        int lsize = aux.size();
        int dsize = aux2.size();
        for (int i=0; i<lsize; i++)
        {
            Card actual = aux.front();
            cout << actual.toString() << " ";
            aux.pop_front();
        }
        cout << endl;
        cout << "Second heap: ";
        for (int i=0; i<dsize; i++)
        {
            Card actual = aux2.front();
            cout << actual.toString() << " ";
            aux2.pop_front();
        }
        cout << endl;
    }
}

void test5()
{
    Deck d;
    list<Card> l = d.split(&d.cl,26);
    list<Card> aux = l;
    list<Card> aux2 = d.cl;
    list<Card> aux3 = d.riffle(l,d.cl);
    int lsize = aux.size();
    int dsize = aux2.size();
    int rsize = aux3.size();
    cout << "First heap: ";
    for (int i=0; i<lsize; i++)
    {
        Card actual = aux.front();
        cout << actual.toString() << " ";
        aux.pop_front();
    }
    cout << endl;
    cout << "Second heap: ";
    for (int i=0; i<dsize; i++)
    {
        Card actual = aux2.front();
        cout << actual.toString() << " ";
        aux2.pop_front();
    }
    cout << endl;
    cout << "Riffle result: ";
    for (int i=0; i<rsize; i++)
    {
        Card actual = aux3.front();
        cout << actual.toString() << " ";
        aux3.pop_front();
    }
    cout << endl;
}

void test6()
{
    Deck d;
    cout << d.toString() << endl;
    d.riffleShuffle(7);
    cout << d.toString() << endl;
}

void testbj1()
{
    Card c0(0,1);
    Card c1(0,7);
    Card c2(1,10);
    Card c3(2,11);
    Card c4(3,13);
    Blackjack bj;
    cout << bj.getPoints(c0) << endl;
    cout << bj.getPoints(c1) << endl;
    cout << bj.getPoints(c2) << endl;
    cout << bj.getPoints(c3) << endl;
    cout << bj.getPoints(c4) << endl;
}

void testbj2()
{
    list<Card> l;
    Card c0(0,1);
    l.push_back(c0);
    Card c1(1,10);
    l.push_back(c1);
    Card c2(2,11);
    l.push_back(c2);
    Card c3(3,13);
    l.push_back(c3);
    Blackjack bj;
    cout << bj.getScore(l) << endl;
}

void testbj3()
{
    Deck d;
    d.riffleShuffle(15);
    Blackjack bj;
    bj.humanPlayer(&d);
}

void testbj4()
{
    Deck d;
    d.riffleShuffle(15);
    Blackjack bj;
    bj.computerPlayer(&d,17);
    bj.computerPlayer(&d,18);
    bj.computerPlayer(&d,19);
}

