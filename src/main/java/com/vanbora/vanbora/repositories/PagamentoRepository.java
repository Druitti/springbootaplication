package com.vanbora.vanbora.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vanbora.vanbora.models.Pagamento;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {

   
   
   
   
    
}
