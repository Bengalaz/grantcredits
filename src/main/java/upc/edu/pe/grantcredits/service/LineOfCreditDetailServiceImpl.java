package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;
import upc.edu.pe.grantcredits.domain.model.LineOfCreditDetail;
import upc.edu.pe.grantcredits.domain.repository.LineOfCreditDetailRepository;
import upc.edu.pe.grantcredits.domain.repository.LineOfCreditRepository;
import upc.edu.pe.grantcredits.domain.service.LineOfCreditDetailService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class LineOfCreditDetailServiceImpl implements LineOfCreditDetailService {

    @Autowired
    private LineOfCreditDetailRepository lineOfCreditDetailRepository;

    @Autowired
    private LineOfCreditRepository lineOfCreditRepository;
    @Override
    public Page<LineOfCreditDetail> getAllLineOfCreditDetails(Pageable pageable) {
        return lineOfCreditDetailRepository.findAll(pageable);
    }

    @Override
    public LineOfCreditDetail getLineOfCreditDetailById(Long lineofcreditdetailId) {
        return lineOfCreditDetailRepository.findById(lineofcreditdetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCreditDetail", "Id", lineofcreditdetailId));
    }

    @Override
    public LineOfCreditDetail createLineOfCreditDetail(Long lineOfCreditId,
        LineOfCreditDetail lineOfCreditDetail){
        return lineOfCreditRepository.findById(lineOfCreditId).map(lineOfCredit -> {
        lineOfCreditDetail.setLineOfCredit(lineOfCredit);
        return lineOfCreditDetailRepository.save(lineOfCreditDetail);
    }).orElseThrow(() -> new ResourceNotFoundException("LineOfCredit","Id", lineOfCreditId));
    }

    @Override
    public LineOfCreditDetail updateLineOfCreditDetail(Long lineofcreditdetailId, LineOfCreditDetail lineofcreditdetailRequest) {
        LineOfCreditDetail lineOfCreditDetail = lineOfCreditDetailRepository.findById(lineofcreditdetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCreditDetail", "Id", lineofcreditdetailId));
        return lineOfCreditDetailRepository.save(
                lineOfCreditDetail.setExpires_at(lineofcreditdetailRequest.getExpires_at())
                        .setDescription(lineofcreditdetailRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteLineOfCreditDetail(Long lineofcreditdetailId) {
        LineOfCreditDetail lineOfCreditDetail = lineOfCreditDetailRepository.findById(lineofcreditdetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "LineOfCreditDetail", "Id", lineofcreditdetailId));
        lineOfCreditDetailRepository.delete(lineOfCreditDetail);
        return ResponseEntity.ok().build();
    }
}
