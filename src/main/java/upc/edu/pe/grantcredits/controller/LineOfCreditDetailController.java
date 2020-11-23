package upc.edu.pe.grantcredits.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.grantcredits.domain.model.LineOfCreditDetail;
import upc.edu.pe.grantcredits.domain.service.LineOfCreditDetailService;
import upc.edu.pe.grantcredits.resource.LineOfCreditDetailResource;
import upc.edu.pe.grantcredits.resource.SaveLineOfCreditDetail;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "LineOfCreditDetail", description = "LineOfCreditDetail API")
@RestController
@RequestMapping("/api")
public class LineOfCreditDetailController {
    @Autowired
    LineOfCreditDetailService lineOfCreditDetailService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/lineOfCreditdetails")
    public Page<LineOfCreditDetailResource> getAllLineOfCreditDetail(Pageable pageable) {
        Page<LineOfCreditDetail> lineofcreditsdetailpage = lineOfCreditDetailService.getAllLineOfCreditDetails(pageable);
        List<LineOfCreditDetailResource> resources = lineofcreditsdetailpage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/lineOfCreditdetails/{lineOfCreditdetailsId}")
    public LineOfCreditDetailResource getLineOfCreditDetailById(@PathVariable(value = "lineofcreditId") Long lineOfCreditdetailsId) {
        return convertToResource(lineOfCreditDetailService.getLineOfCreditDetailById(lineOfCreditdetailsId));
    }

    @PostMapping("/lineOfCreditdetails")
    public LineOfCreditDetailResource createLineOfCreditDetail(
            @Valid @RequestBody SaveLineOfCreditDetail resource) {
        LineOfCreditDetail lineOfCreditdetail = convertToEntity(resource);
        return convertToResource(lineOfCreditDetailService.createLineOfCreditDetail(lineOfCreditdetail));
    }

    @PutMapping("/lineOfCreditdetails/{lineOfCreditdetailId}")
    public LineOfCreditDetailResource updateLineOfCreditDetail(@PathVariable Long lineOfCreditdetailId,
                                                   @Valid @RequestBody SaveLineOfCreditDetail resource) {
        LineOfCreditDetail lineOfCreditdetail = convertToEntity(resource);
        return convertToResource(
                lineOfCreditDetailService.updateLineOfCreditDetail(lineOfCreditdetailId, lineOfCreditdetail));
    }

    @DeleteMapping("/lineOfCreditdetails/{lineOfCreditdetailId}")
    public ResponseEntity<?> deleteLineOfCreditDetail(@PathVariable Long lineOfCreditdetailId) {
        return lineOfCreditDetailService.deleteLineOfCreditDetail(lineOfCreditdetailId);
    }




    private LineOfCreditDetail convertToEntity(SaveLineOfCreditDetail resource) {
        return mapper.map(resource, LineOfCreditDetail.class);
    }

    private LineOfCreditDetailResource convertToResource(LineOfCreditDetail entity) {
        return mapper.map(entity, LineOfCreditDetailResource.class);
    }
}
