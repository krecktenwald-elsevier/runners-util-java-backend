package com.krecktenwald.runnersutil.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krecktenwald.runnersutil.domain.Run;
import com.krecktenwald.runnersutil.repositories.RunRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/runs")
public class RunController {

	private final RunRepository runRepository;

	public RunController(RunRepository runRepository) {
		this.runRepository = runRepository;
	}

	@GetMapping
	public List<Run> getRuns() {
		return runRepository.findAll();
	}

	@GetMapping("/{id}")
	public Run getRun(@PathVariable Long id) {
		return runRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity createRun(@RequestBody Run run) throws URISyntaxException {
		Run savedRun = runRepository.save(run);
		return ResponseEntity.created(new URI("/runs/" + savedRun.getId())).body(savedRun);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateRun(@PathVariable Long id, @RequestBody Run run) {
		Run currentRun = runRepository.findById(id).orElseThrow(RuntimeException::new);

		currentRun.setDateTime(run.getDateTime());
		currentRun.setDuration(run.getDuration());
		currentRun.setDistance(run.getDistance());

		currentRun = runRepository.save(run);

		return ResponseEntity.ok(currentRun);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteRun(@PathVariable Long id) {
		runRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
