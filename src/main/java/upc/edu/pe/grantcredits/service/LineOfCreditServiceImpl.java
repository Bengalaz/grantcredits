package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;
import upc.edu.pe.grantcredits.domain.repository.LineOfCreditRepository;
import upc.edu.pe.grantcredits.domain.service.LineOfCreditService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class LineOfCreditServiceImpl implements LineOfCreditService {

    @Autowired
    private LineOfCreditRepository lineOfCreditRepository;

    @Override
    public Page<LineOfCredit> getAllLinesOfCredits(Pageable pageable) {
        return lineOfCreditRepository.findAll(pageable);
    }

    @Override
    public LineOfCredit getLineOfCreditById(Long lineofcreditId) {
        return lineOfCreditRepository.findById(lineofcreditId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCredit", "Id", lineofcreditId));
    }

    @Override
    public LineOfCredit createLineOfCredit(LineOfCredit lineOfCredit) {
        return lineOfCreditRepository.save(lineOfCredit);
    }

    @Override
    public LineOfCredit updateLineOfCredit(Long lineOfCreditId, LineOfCredit lineOfCreditRequest) {
        LineOfCredit lineOfCredit = lineOfCreditRepository.findById(lineOfCreditId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCredit", "Id", lineOfCreditId));
        return lineOfCreditRepository.save(
                lineOfCredit.setMoneybalance(lineOfCreditRequest.getMoneybalance())
                        .setType_rate(lineOfCreditRequest.getType_rate())
                        .setMaintenance(lineOfCreditRequest.getMaintenance())
                        .setTime_maintenance(lineOfCreditRequest.getTime_maintenance())
                        .setInterest_rate(lineOfCreditRequest.getInterest_rate())
                        .setDelivery(lineOfCreditRequest.getDelivery())
                        .setDelivery_time(lineOfCreditRequest.getDelivery_time()));
    }

    @Override
    public ResponseEntity<?> deleteLineOfCredit(Long lineOfCreditId) {
        LineOfCredit lineOfCredit = lineOfCreditRepository.findById(lineOfCreditId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCredit", "Id", lineOfCreditId));
        lineOfCreditRepository.delete(lineOfCredit);
        return ResponseEntity.ok().build();
    }
}
