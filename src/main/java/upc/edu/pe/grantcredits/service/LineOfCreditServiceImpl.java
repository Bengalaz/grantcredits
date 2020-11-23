package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;
import upc.edu.pe.grantcredits.domain.repository.CustomerRepository;
import upc.edu.pe.grantcredits.domain.repository.LineOfCreditRepository;
import upc.edu.pe.grantcredits.domain.service.LineOfCreditService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class LineOfCreditServiceImpl implements LineOfCreditService {

    @Autowired
    private LineOfCreditRepository lineOfCreditRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<LineOfCredit> getAllLinesOfCredits(Pageable pageable) {
        return lineOfCreditRepository.findAll(pageable);
    }

    @Override
    public LineOfCredit getLineOfCreditById(Long lineOfCreditId) {
        return lineOfCreditRepository.findById(lineOfCreditId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCredit", "Id", lineOfCreditId));
    }

    @Override
    public LineOfCredit createLineOfCredit(Long customerId, LineOfCredit lineOfCredit) {
        return customerRepository.findById(customerId).map(customer -> {
            lineOfCredit.setCustomer(customer);
            return lineOfCreditRepository.save(lineOfCredit);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer","Id", customerId));
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
