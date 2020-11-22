package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.LineOfCreditDetail;

public interface LineOfCreditDetailService {
    Page<LineOfCreditDetail> getAllLineOfCreditDetails(Pageable pageable);
    LineOfCreditDetail getLineOfCreditDetailById(Long lineofcreditdetailId);
    LineOfCreditDetail createLineOfCreditDetail(LineOfCreditDetail lineofcreditdetail);
    LineOfCreditDetail updateLineOfCreditDetail(Long lineofcreditdetailId, LineOfCreditDetail lineofcreditdetailRequest);
    ResponseEntity<?> deleteLineOfCreditDetail(Long lineofcreditdetailId);
}
