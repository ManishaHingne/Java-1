#include<iostream>
using namespace std;

class Collections
{
public:
	static int linearSearch( int *collection, const int size, const int key )
	{
		for( int index = 0; index < size; ++ index )
		{
			if( collection[ index ] == key )
				return index;
		}
		return -1;
	}
	static int binarySearch( int *collection, const int size, const int key )
	{
		int leftIndex  = 0;
		int rightIndex = size - 1;
		int middleIndex;
		while( leftIndex <= rightIndex )
		{
			middleIndex = ( leftIndex + rightIndex ) / 2;
			if( key == collection[ middleIndex ] )
				return middleIndex;
			if( key > collection[ middleIndex ] )
				leftIndex = middleIndex + 1;
			else
				rightIndex = middleIndex - 1;
		}
		return -1;
	}
};
int linear_search( int *collection, const int size, const int key )
{
	for( int index = 0; index < size; ++ index )
	{
		if( collection[ index ] == key )
			return index;
	}
	return -1;
}
int binary_search( int *collection, const int size, const int key )
{
	int leftIndex  = 0;
	int rightIndex = size - 1;
	while( leftIndex <= rightIndex )
	{
		int middleIndex = ( leftIndex + rightIndex ) / 2;
		if( key == collection[ middleIndex ] )
			return middleIndex;
		if( key > collection[ middleIndex ] )
			leftIndex = middleIndex + 1;
		else
			rightIndex = middleIndex - 1;
	}
	return -1;
}
int main( void )
{
	int key = 40;
	int collection[  ] = { 10, 20, 30, 40, 50, 60, 70 };
	//int index = linear_search( collection, 7, key );
	//int index = Collections::linearSearch( collection, 7, key );
	//int index = binary_search( collection, 7, key );
	int index = Collections::binarySearch( collection, 7, key );
	if( index != -1 )
		cout<<key<<" found at index "<<index<<endl;
	else
		cout<<key<<" not found"<<endl;
	return 0;
}
