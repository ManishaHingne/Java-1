#include<iostream>
using namespace std;
int get_hashcode( int data )	//Hash Function
{
	int result = 1;
	const int PRIME = 31;
	result = result * data + PRIME * data;
	return result;
}
int main( void )
{
	for( int count = 1; count <= 500; ++ count )
	{
		int data = count;
		int hashcode = get_hashcode( data );
		int slot =  hashcode % 7;
		cout<<data<<"	"<<hashcode<<"	"<<slot<<endl;
	}
	return 0;
}
