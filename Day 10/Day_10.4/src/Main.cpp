#include<iostream>
#include<list>
using namespace std;
int main( void )
{
	list<int> numbers;
	numbers.push_back(10);
	numbers.push_back(20);
	numbers.push_back(30);

	list<int>::iterator itrStart = numbers.begin();
	list<int>::iterator itrEnd = numbers.end();
	while( itrStart != itrEnd )
	{
		cout<< *itrStart <<endl;
		++ itrStart;
	}
	return 0;
}
