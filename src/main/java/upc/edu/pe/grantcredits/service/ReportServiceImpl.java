package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.LineOfCreditDetail;
import upc.edu.pe.grantcredits.domain.model.Report;
import upc.edu.pe.grantcredits.domain.repository.CompanyRepository;
import upc.edu.pe.grantcredits.domain.repository.ReportRepository;
import upc.edu.pe.grantcredits.domain.service.ReportService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Report> getAllReports(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Report", "Id", reportId));
    }

    @Override
    public Report createReport(Long companyId, Report report) {
        return companyRepository.findById(companyId).map(company -> {
            report.setCompany(company);
            return reportRepository.save(report);
        }).orElseThrow(() -> new ResourceNotFoundException("Company","Id", companyId));
    }

    @Override
    public Report updateReport(Long reportId, Report reportRequest) {

        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Report", "Id", reportId));
        return reportRepository.save(
                report.setTotalmoney(reportRequest.getTotalmoney())
                .setTime(reportRequest.getTime())
                .setCoin_type(reportRequest.getCoin_type()));
    }

    @Override
    public ResponseEntity<?> deleteReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Report", "Id", reportId));
        reportRepository.delete(report);
        return ResponseEntity.ok().build();
    }
}
