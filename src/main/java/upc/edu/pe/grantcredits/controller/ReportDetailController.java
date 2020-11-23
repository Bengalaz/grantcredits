package upc.edu.pe.grantcredits.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.grantcredits.domain.model.ReportDetail;
import upc.edu.pe.grantcredits.domain.service.ReportDetailService;
import upc.edu.pe.grantcredits.resource.ReportDetailResource;
import upc.edu.pe.grantcredits.resource.SaveReportDetailResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "ReportDetail", description = "ReportDetail API")
@RestController
@RequestMapping("/api")
public class ReportDetailController {
    @Autowired
    ReportDetailService reportDetailService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/reportdetails")
    public Page<ReportDetailResource> getAllReportdetails(Pageable pageable){
        Page<ReportDetail> reportdetailPage = reportDetailService.getAllReportsDetails(pageable);
        List<ReportDetailResource> resources = reportdetailPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/reportdetails/{reportdetailId}")
    public ReportDetailResource getCompanyById(@PathVariable(value = "reportdetailId") Long reportdetailId){
        return convertToResource(reportDetailService.getReportDetailById(reportdetailId));
    }

    @PostMapping("/reportdetails")
    public ReportDetailResource createCompany(
            @Valid @RequestBody SaveReportDetailResource resource){
        ReportDetail reportDetail = convertToEntity(resource);
        return convertToResource(reportDetailService.createReportDetail(reportDetail));
    }

    @PutMapping("/reportdetails/{reportdetailId}")
    public ReportDetailResource updateCompany(@PathVariable Long reportdetailId,
                                         @Valid @RequestBody SaveReportDetailResource resource){
        ReportDetail reportDetail = convertToEntity(resource);
        return convertToResource(
                reportDetailService.updateReportDetail(reportdetailId,reportDetail));
    }

    @DeleteMapping("/reportdetails/{reportdetailId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long reportdetailId){return reportDetailService.deleteReportDetail(reportdetailId);}



    private ReportDetail convertToEntity(SaveReportDetailResource resource)
    {
        return mapper.map(resource,ReportDetail.class);
    }

    private ReportDetailResource convertToResource(ReportDetail entity){
        return mapper.map(entity, ReportDetailResource.class);
    }
}
