#include<iostream>
#include<string>
using namespace std;

class Account
{
private:
	int accNumber;
	string accType;
	float balance;
public:
	Account( int accNumber = 0, string accType = "", float balance = 0 )
	{
		this->accNumber = accNumber;
		this->accType = accType;
		this->balance = balance;
	}
	int getAccNumber( )
	{
		return this->accNumber;
	}
	void setAccNumber( int accNumber )
	{
		this->accNumber = accNumber;
	}
	string getAccType( void )
	{
		return this->accType;
	}
	void setAccType( string accType )
	{
		this->accType = accType;
	}
	double getBalance( void )
	{
		return this->balance;
	}
	void setBalance( double balance )
	{
		this->balance = balance;
	}
	int getHashCode( void  )
	{
		int PRIME = 31;
		int result = 1;
		result = result * this->accNumber + PRIME * this->accNumber;
		return result;
	}
	friend ostream& operator<<( ostream& cout, Account &other )
	{
		cout<<other.accNumber<<"	"<<other.accType<<"	"<<other.balance;
		return cout;
	}
};
class Customer
{
private:
	string name;
	string address;
	string email;
public:
	Customer( string name = "", string address = "", string email = "" )
	{
		this->name = name;
		this->address = address;
		this->email = email;
	}
	string getName( void )
	{
		return this->name;
	}
	void setName( string name )
	{
		this->name = name;
	}
	string getAddress( void )
	{
		return this->address;
	}
	void setAddress( string address )
	{
		this->address = address;
	}
	string getEmail( void )
	{
		return this->email;
	}
	void setEmail( string email )
	{
		this->email = email;
	}
	friend ostream& operator<<( ostream &cout, Customer &other )
	{
		cout<<other.name<<"	"<<other.address<<"	"<<other.email;
		return cout;
	}
};
class Dictionary
{
private:
	Account key;
	Customer value;
public:
	Dictionary( void )
	{	}
	Dictionary( Account key, Customer value )
	{
		this->key = key;
		this->value = value;
	}
	Account getKey( void )
	{
		return this->key;
	}
	void setKey( Account key )
	{
		this->key = key;
	}
	Customer getValue( void )
	{
		return this->value;
	}
	void setValue( Customer value )
	{
		this->value = value;
	}
	friend ostream& operator<<( ostream& cout, Dictionary &other )
	{
		cout<<other.key<<"	"<<other.value;
		return cout;
	}
};
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
template< class T>
class LinkedList;

template<class T>
class Iterator;

template<class T>
class Node
{
private:
	T data;
	Node *next;
public:
	Node( T data )
	{
		this->data = data;
		this->next = NULL;
	}
	friend class LinkedList<T>;
	friend class Iterator<T>;
};
template<class T>
class Iterator
{
private:
	Node<T> *ptr;
public:
	Iterator( Node<T> *ptr )
	{
		this->ptr = ptr;
	}
	bool operator!=( Iterator &other )
	{
		return this->ptr != other.ptr;
	}
	T operator*( void )
	{
		return this->ptr->data;
	}
	void operator++( void )
	{
		this->ptr = this->ptr->next;
	}
};
template< class T>
class LinkedList
{
private:
	Node<T> *head;
	Node<T> *tail;
public:
	LinkedList( void )
	{
		this->head = NULL;
		this->tail = NULL;
	}
	LinkedList( const LinkedList &other )
	{
		this->head = this->tail = NULL;
		Node<T> *trav = other.head;
		while( trav != NULL )
		{
			this->addLast(trav->data );
			trav = trav->next;
		}
	}
	bool empty( void )
	{
		return this->head == NULL;
	}
	void addFirst( T data )throw( bad_alloc )
	{
		Node<T> *newNode = new Node<T>( data );
		if( this->empty( ) )
			this->tail = newNode;
		else
			newNode->next = this->head;
		this->head = newNode;
	}
	void addLast( T data )
	{
		Node<T> *newNode = new Node<T>( data );
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
			Node<T> *ptrNode = this->head;
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
			Node<T> *trav = this->head;
			while( trav->next != this->tail )
				trav = trav->next;
			delete this->tail;
			this->tail = trav;
			this->tail->next = NULL;
		}
	}
	Iterator<T> begin( void )
	{
		Iterator<T> itr( this->head );
		return itr;
	}
	Iterator<T> end( void )
	{
		Iterator<T> itr( NULL );
		return itr;
	}
	~LinkedList( void )
	{
		while( !this->empty( ) )
			this->removeFirst( );
	}
};
class HashTable
{
private:
	LinkedList<Dictionary> **arr;
	int capacity;
public:
	HashTable( void )
	{
		this->capacity = 0;
		this->arr = NULL;
	}
	HashTable( int capacity )
	{
		this->capacity = capacity;
		this->arr = new LinkedList<Dictionary>*[ capacity ];
		for( int index = 0; index < this->capacity; ++ index )
			this->arr[ index ] = NULL;
	}
	void put( Account key, Customer value )
	{
		int hashcode = key.getHashCode();
		int slot = hashcode % this->capacity;
		if( this->arr[ slot ] == NULL )
			this->arr[ slot ] = new LinkedList<Dictionary>();
		Dictionary data( key, value);
		this->arr[ slot ]->addLast( data);
	}
	~HashTable( void )
	{
		if( this->arr != NULL )
		{
			for( int index = 0; index < this->capacity; ++ index )
				delete this->arr[ index ];
			delete[] this->arr;
			this->arr = NULL;
		}
	}
};
int main( void )
{
	HashTable ht( 5 );
	ht.put(Account(101,"Saving",50000), Customer("Rahul","Pune","rahul@gmail.com"));
	return 0;
}




