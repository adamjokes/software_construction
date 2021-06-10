package springbootvisitormanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootvisitormanagementsystem.exception.ResourceNotFoundException;
import springbootvisitormanagementsystem.model.Visitor;
import springbootvisitormanagementsystem.repository.VisitorRepository;

@RestController
@RequestMapping("")
public class VisitorController {
	@Autowired
	private VisitorRepository visitorRespository;

	@GetMapping("/visitors")
	public List<Visitor> getAllVisitors() {
		return visitorRespository.findAll();
	}

	@GetMapping("/visitors/{id}")
	public ResponseEntity<Visitor> getVisitorById(@PathVariable(value = "id") Long visitorId)
			throws ResourceNotFoundException {
		Visitor visitor = visitorRespository.findById(visitorId)
				.orElseThrow(() -> new ResourceNotFoundException("Visitor not found for this id :: " + visitorId));
		return ResponseEntity.ok().body(visitor);
	}

	@PostMapping("/visitors")
	public Visitor createVisitor(Visitor visitor) {
		return visitorRespository.save(visitor);
	}

	@PutMapping("/visitors/{id}")
	public ResponseEntity<Visitor> updateVisitor(@PathVariable(value = "id") Long visitorId,
			Visitor visitorDetails) throws ResourceNotFoundException {
		Visitor visitor = visitorRespository.findById(visitorId)
				.orElseThrow(() -> new ResourceNotFoundException("Visitor not found for this id :: " + visitorId));

		visitor.setEmailId(visitorDetails.getEmailId());
		visitor.setLastName(visitorDetails.getLastName());
		visitor.setFirstName(visitorDetails.getFirstName());
		visitor.setTemperature(visitorDetails.getTemperature());
		visitor.setDOB(visitorDetails.getDOB());
		final Visitor updatedVisitor = visitorRespository.save(visitor);
		return ResponseEntity.ok(updatedVisitor);
	}

	@DeleteMapping("/visitors/{id}")
	public Map<String, Boolean> deleteVisitor(@PathVariable(value = "id") Long visitorId)
			throws ResourceNotFoundException {
		Visitor visitor = visitorRespository.findById(visitorId)
				.orElseThrow(() -> new ResourceNotFoundException("Visitor not found for this id :: " + visitorId));

		visitorRespository.delete(visitor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
