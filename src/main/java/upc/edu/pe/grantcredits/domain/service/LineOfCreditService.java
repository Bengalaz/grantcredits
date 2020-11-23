package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;

public interface LineOfCreditService {
    Page<LineOfCredit> getAllLinesOfCredits(Pageable pageable);
    LineOfCredit getLineOfCreditById(Long lineOfCreditId);
    LineOfCredit createLineOfCredit(LineOfCredit lineOfCredit);
    LineOfCredit updateLineOfCredit(Long lineOfCreditId, LineOfCredit lineOfCreditRequest);
    ResponseEntity<?> deleteLineOfCredit(Long lineOfCreditId);
}
