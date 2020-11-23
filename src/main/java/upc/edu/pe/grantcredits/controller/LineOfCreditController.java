package upc.edu.pe.grantcredits.controller;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;
import upc.edu.pe.grantcredits.domain.service.LineOfCreditService;
import upc.edu.pe.grantcredits.resource.LineOfCreditResource;
import upc.edu.pe.grantcredits.resource.SaveLineOfCredit;
import javax.validation.Valid;

@Tag(name = "LineOfCredit", description = "LineOfCredit API")
@RestController
@RequestMapping("/api")
public class LineOfCreditController {
    @Autowired
    LineOfCreditService lineOfCreditService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/lineOfCredits")
    public Page<LineOfCreditResource> getAllLineOfCredits(Pageable pageable) {
        Page<LineOfCredit> lineofcreditspage = lineOfCreditService.getAllLinesOfCredits(pageable);
        List<LineOfCreditResource> resources = lineofcreditspage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/lineOfCredits/{lineOfCreditId}")
    public LineOfCreditResource getLineOfCreditById(@PathVariable(value = "lineOfCreditId") Long lineOfCreditId) {
        return convertToResource(lineOfCreditService.getLineOfCreditById(lineOfCreditId));
    }

    @PostMapping("/lineOfCredits")
    public LineOfCreditResource createLineOfCredit(
            @Valid @RequestBody SaveLineOfCredit resource) {
        LineOfCredit lineOfCredit = convertToEntity(resource);
        return convertToResource(lineOfCreditService.createLineOfCredit(lineOfCredit));
    }

    @PutMapping("/lineOfCredits/{lineOfCreditId}")
    public LineOfCreditResource updateLineOfCredit(@PathVariable Long lineOfCreditId,
                                                   @Valid @RequestBody SaveLineOfCredit resource) {
        LineOfCredit lineOfCredit = convertToEntity(resource);
        return convertToResource(
                lineOfCreditService.updateLineOfCredit(lineOfCreditId, lineOfCredit));
    }

    @DeleteMapping("/lineOfCredits/{lineOfCreditId}")
    public ResponseEntity<?> deleteLineOfCredit(@PathVariable Long lineOfCreditId) {
        return lineOfCreditService.deleteLineOfCredit(lineOfCreditId);
    }

    private LineOfCredit convertToEntity(SaveLineOfCredit resource) {

        return mapper.map(resource, LineOfCredit.class);
    }

    private LineOfCreditResource convertToResource(LineOfCredit entity) {
        return mapper.map(entity, LineOfCreditResource.class);
    }
}
