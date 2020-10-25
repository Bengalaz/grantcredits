package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReportDetail {
    Page<ReportDetail> getAllReportsDetails(Pageable pageable);
    ReportDetail getReportDetailById(Long reportdetailId);
    ReportDetail createReportDetail(ReportDetail reportDetail);
    ReportDetail updateReportDetail(Long reportDetailId, ReportDetail reportDetailRequest);
    ResponseEntity<?> deleteReportDetail(Long reportDetailId);
}
