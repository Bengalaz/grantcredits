package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.Report;
import upc.edu.pe.grantcredits.domain.model.ReportDetail;
import upc.edu.pe.grantcredits.domain.repository.ReportDetailRepository;
import upc.edu.pe.grantcredits.domain.repository.ReportRepository;
import upc.edu.pe.grantcredits.domain.service.ReportDetailService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class ReportDetailServiceImpl implements ReportDetailService {

    @Autowired
    private ReportDetailRepository reportDetailRepository;

    @Autowired
    private ReportRepository reportRepository;

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
    public ReportDetail createReportDetail(Long reportId, ReportDetail reportDetail) {
        return reportRepository.findById(reportId).map(report -> {
            reportDetail.setReport(report);
            return reportDetailRepository.save(reportDetail);
        }).orElseThrow(() -> new ResourceNotFoundException("Report","Id", reportId));
    }

    @Override
    public ReportDetail updateReportDetail(Long reportDetailId, ReportDetail reportDetailRequest) {

        ReportDetail reportDetail = reportDetailRepository.findById(reportDetailId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ReportDetail", "Id", reportDetailId));
        return reportDetailRepository.save(
                reportDetail.setExpires_at(reportDetailRequest.getExpires_at())
                        .setDescription(reportDetailRequest.getDescription()));
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
