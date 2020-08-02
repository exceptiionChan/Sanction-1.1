package sanction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sanction.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findByTransacRef(String transacRef); 
	List<Transaction> findByStatus(String status);	
	
	List<Transaction> findByIdGreaterThanEqual(long startId);	
	
//	@Query("Select t from transactions t where t.id >= ?1 and t.status = ?2")
//	List<Transaction> findFileFiltered(long startId, String status);
}
