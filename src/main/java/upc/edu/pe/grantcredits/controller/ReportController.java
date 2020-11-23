package upc.edu.pe.grantcredits.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.grantcredits.domain.model.Report;
import upc.edu.pe.grantcredits.domain.service.ReportService;
import upc.edu.pe.grantcredits.resource.ReportResource;
import upc.edu.pe.grantcredits.resource.SaveReportResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Report", description = "Report API")
@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/reports")
    public Page<ReportResource> getAllReports(Pageable pageable){
        Page<Report> reportsPage = reportService.getAllReports(pageable);
        List<ReportResource> resources = reportsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/reports/{reportId}")
    public ReportResource getCompanyById(@PathVariable(value = "reportId") Long reportId){
        return convertToResource(reportService.getReportById(reportId));
    }

    @PostMapping("/companies/{companyId}/reports")
    public ReportResource createReport( @PathVariable(value = "companyId") Long companyId,
            @Valid @RequestBody SaveReportResource resource){
        Report report = convertToEntity(resource);
        return convertToResource(reportService.createReport(companyId, report));
    }

    @PutMapping("/reports/{reportId}")
    public ReportResource updateReport(@PathVariable Long reportId,
                                         @Valid @RequestBody SaveReportResource resource){
        Report report = convertToEntity(resource);
        return convertToResource(
                reportService.updateReport(reportId,report));
    }

    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<?> deleteReport(@PathVariable Long reportId){return reportService.deleteReport(reportId);}


    private Report convertToEntity(SaveReportResource resource)
    {
        return mapper.map(resource,Report.class);
    }
    private ReportResource convertToResource(Report entity){
        return mapper.map(entity, ReportResource.class);
    }
}
