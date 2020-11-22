package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.ReportDetail;
import upc.edu.pe.grantcredits.domain.repository.ReportDetailRepository;
import upc.edu.pe.grantcredits.domain.service.ReportDetailService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class ReportDetailServiceImpl implements ReportDetailService {

    @Autowired
    private ReportDetailRepository reportDetailRepository;

    @Override
    public Page<ReportDetail> getAllReportsDetails(Pageable pageable) {
        return reportDetailRepository.findAll(pageable);
    }

    @Override
    public ReportDetail getReportDetailById(Long reportdetailId) {
        return reportDetailRepository.findById(reportdetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ReportDetail", "Id", reportdetailId));
    }

    @Override
    public ReportDetail createReportDetail(ReportDetail reportDetail) {
        return reportDetailRepository.save(reportDetail);
    }

    @Override
    public ReportDetail updateReportDetail(Long reportDetailId, ReportDetail reportDetailRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteReportDetail(Long reportDetailId) {
        ReportDetail reportDetail = reportDetailRepository.findById(reportDetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ReportDetail", "Id", reportDetailId));
        reportDetailRepository.delete(reportDetail);
        return ResponseEntity.ok().build();
    }
}
