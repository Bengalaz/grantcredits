package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.Customer;

public interface LineOfCredit {
    Page<LineOfCredit> getAllLinesOfCredits(Pageable pageable);
    LineOfCredit getLineOfCreditById(Long lineofcreditId);
    LineOfCredit createLineOfCredit(LineOfCredit lineOfCredit);
    LineOfCredit updateLineOfCredit(Long lineOfCreditId, LineOfCredit lineOfCreditRequest);
    ResponseEntity<?> deleteLineOfCredit(Long lineOfCreditId);
}
