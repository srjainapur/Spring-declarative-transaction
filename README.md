Here we will see a basic example of spring transaction management using spring boot. Also, we will see how to use @Transactional annotation.

Different ways of the transaction management-
    Programmatic transaction management.
    Declarative transaction management.

Programmatic transaction management – Here we need to write some extra code for transaction management. When we say some extra code what does it mean? We need to take care of –
    Creating Transaction reference
    Begin transaction
    Commit or rollback of the transaction

	Transaction transactionRef = entityManager.getTransaction()                  
	try {  
		transactionRef.begin();                   
		// business logic                   
		transactionRef .commit();  
	} catch(Exception e) {                     
		transactionRef.rollback();  
		e.printStackTrace();                 
	}
	
Declarative transaction management – No need to write extra code for getting a transaction, we can use annotations or XML-based approach to manage the transactions and we can avoid unnecessary code. If we use annotation based approach we can use @Transactional and if we use the XML-based approach we need to configure DataSourceTransactionManager or any other transaction manager in XML as a bean. In this article and the next upcoming article, we will see the annotation based approach.
Sample code for annotation based declarative transaction management –

@Transactional(readOnly=true, propagation = Propagation.REQUIRES_NEW)
public Book findOneString objectId) {
	return repository.findOne(objectId);
}

propagation – propagation can have different possible value as below.

    Propagation.REQUIRED – Support a current transaction, create a new one if none exists.
    Propagation.REQUIRES_NEW – Always create a new transaction and suspend the current transaction if already exist.
    Propagation.MANDATORY – Support a current transaction, throw an exception if none exists.
    Propagation.NESTED – Execute within a nested transaction if a current transaction exists.
    Propagation.NEVER – Execute non-transactionally, throw an exception if a transaction exists.
    Propagation.NOT_SUPPORTED – Execute non-transactionally, suspend the current transaction if one exists.
    Propagation.SUPPORTS – Support a current transaction, execute non-transactionally if none exists.

	
isolation – isolation can have different possible value as below.

    Isolation.READ_UNCOMMITTED – It allows dirty reads, non-repeatable reads, and phantom reads.
    Isolation.READ_COMMITTED – Dirty reads is prevented, allows non-repeatable and phantom reads.
    Isolation.REPEATABLE_READ – Dirty reads and non-repeatable prevented, phantom reads allowed.
    Isolation.SERIALIZABLE – Dirty reads, non-repeatable reads, and phantom reads are prevented.



1. With below configuration even though there is a ArithmeticException exception after saving book transaction will not be rolled back. Because noRollbackFor = ArithmeticException

@Override
@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class, noRollbackFor=ArithmeticException.class)
public void saveBook(Book book) {
	LOG.log(Level.INFO, "BEGIN :: saveBook()");
		
	bookRepository.save(book);
	
	// No Rollback even after Arithmetic exception
	int a = 10/0;
	LOG.log(Level.INFO, " Dividing by zero Arithmetic Exception a " + a);
	LOG.log(Level.INFO, "END :: saveBook()");
}

2. With below configuration when there is a ArithmeticException exception after saving book transaction will be rolled back.

@Override
@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
public void saveBook(Book book) {
	LOG.log(Level.INFO, "BEGIN :: saveBook()");
		
	bookRepository.save(book);
	
	// No Rollback even after Arithmetic exception
	int a = 10/0;
	LOG.log(Level.INFO, " Dividing by zero Arithmetic Exception a " + a);
	LOG.log(Level.INFO, "END :: saveBook()");
}

