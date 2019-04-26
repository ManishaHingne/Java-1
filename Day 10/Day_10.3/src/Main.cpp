#include<iostream>
#include<string>
using namespace std;

class Exception
{
private:
	string message;
public:
	Exception( string message )
	{
		this->message = message;
	}
	string getMessage( void )
	{
		return this->message;
	}
};
class LinkedList;
class Iterator;
class Node
{
private:
	int data;
	Node *next;
public:
	Node( int data )
	{
		this->data = data;
		this->next = NULL;
	}
	friend class LinkedList;
	friend class Iterator;
};
class Iterator
{
private:
	Node *ptr;
public:
	Iterator( Node *ptr )
	{
		this->ptr = ptr;
	}
	bool operator!=( Iterator &other )
	{
		return this->ptr != other.ptr;
	}
	int operator*( void )
	{
		return this->ptr->data;
	}
	void operator++( void )
	{
		this->ptr = this->ptr->next;
	}
};
class LinkedList
{
private:
	Node *head;
	Node *tail;
public:
	LinkedList( void )
	{
		this->head = NULL;
		this->tail = NULL;
	}
	bool empty( void )
	{
		return this->head == NULL;
	}
	void addFirst( int data )throw( bad_alloc )
	{
		Node *newNode = new Node( data );
		if( this->empty( ) )
			this->tail = newNode;
		else
			newNode->next = this->head;
		this->head = newNode;
	}
	void addLast( int data )
	{
		Node *newNode = new Node( data );
		if( this->empty() )
			this->head = newNode;
		else
			this->tail->next = newNode;
		this->tail = newNode;
	}
	void removeFirst( void )throw( Exception )
	{
		if( this->empty( ) )
			throw Exception("Linked List is empty");
		else if( this->head == this->tail )
		{
			delete this->head;
			this->head = this->tail = NULL;
		}
		else
		{
			Node *ptrNode = this->head;
			this->head = this->head->next;
			delete ptrNode;
		}
	}
	void removeLast( void )throw( Exception )
	{
		if( this->empty( ) )
			throw Exception("Linked List is empty");
		else if( this->head == this->tail )
		{
			delete this->head;
			this->head = this->tail = NULL;
		}
		else
		{
			Node *trav = this->head;
			while( trav->next != this->tail )
				trav = trav->next;
			delete this->tail;
			this->tail = trav;
			this->tail->next = NULL;
		}
	}
	Iterator begin( void )
	{
		Iterator itr( this->head );
		return itr;
	}
	Iterator end( void )
	{
		Iterator itr( NULL );
		return itr;
	}
	~LinkedList( void )
	{
		while( !this->empty( ) )
			this->removeFirst( );
	}
};
void accept_record( int &data )
{
	cout<<"Enter data	:	";
	cin>>data;
}
int main( void )
{
	LinkedList list;
	list.addLast( 10 );
	list.addLast( 20 );
	list.addLast( 30 );

	Iterator itrStart = list.begin();
	Iterator itrEnd = list.end();
	while( itrStart != itrEnd )//itrStart.operator!=( itrEnd )
	{
		cout<<( *itrStart )<<endl;	//itrStart.operator*( )
		++ itrStart;	//itrStart.operator++( )
	}
	return 0;
}




