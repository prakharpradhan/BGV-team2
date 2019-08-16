package com.cg.backgroundverification.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.service.BgvService;
import com.cg.backgroundverification.service.EmployeeService;
import com.cg.backgroundverification.service.LoginService;

/**
 * controller class for mapping Request
 * 
 * @author Prakhar
 *
 */
@CrossOrigin(origins = { "*" })
@RestController
public class BackgroundVerificationController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private BgvService bgvService;

	Logger logger = LoggerFactory.getLogger(BackgroundVerificationController.class);

	/**
	 * Method to map login request
	 * 
	 * @param loginDto
	 * @return Logindto
	 * @throws BackgroundVerificationException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public LoginDto login(@RequestBody LoginDto loginDto) throws BackgroundVerificationException {

		logger.info("Entered login method");
		LoginDto dto = new LoginDto();
		dto = loginService.login(loginDto);

		logger.info("Out Of Login Method");
		return dto;
	}

	/**
	 * method to map upload file request
	 * 
	 * @param file
	 * @throws BackgroundVerificationException
	 */
	@PostMapping(path = "/upload", produces = "application/json")
	public void handleDocumentUpload(@RequestParam("file") MultipartFile file) throws BackgroundVerificationException {

		logger.info("Entered Handle Document Upload method");
		employeeService.storeDocument(file);
		logger.info("Out of Handle Document Upload method");
	}

	/**
	 * method to map upload document
	 * 
	 * @param employeeDocumentDTO
	 * @return List
	 * @throws BackgroundVerificationException
	 */

	@PostMapping(path = "/uploadDocument", produces = "application/json")
	public List<String> uploadDocumentDetails(@RequestBody EmployeeDocumentDTO employeeDocumentDTO)
			throws BackgroundVerificationException {

		logger.info("Entered handle Document Method ");
		String uploadMessage = employeeService.storeFileDetails(employeeDocumentDTO);
		List<String> strings = new ArrayList<String>();
		strings.add(uploadMessage);
		logger.info("Out of handle Document Method");
		return strings;
	}

	/**
	 * Method to map view status request
	 * 
	 * @param empId
	 * @return List
	 */
	@GetMapping(path = "/viewStatus/{empId}", produces = "application/json")
	public List<String> viewStatus(@PathVariable("empId") int empId) {
		logger.info("Entered viewStatus method");
		return employeeService.viewStatus(empId);
	}

	/**
	 * Searching employee by id
	 * 
	 * @param id
	 * @return List
	 * @throws BackgroundVerificationException
	 */
	@GetMapping(value = "/emp/{id}", produces = "application/json")
	public List<EmployeeDocumentDTO> searchById(@PathVariable("id") int id) throws BackgroundVerificationException {
		logger.info("Entered searchById method");
		return bgvService.getById(id);
	}

	/**
	 * searching employee by name
	 * 
	 * @param name
	 * @return List
	 * @throws BackgroundVerificationException
	 */
	@GetMapping(value = "/emp/get/{name}", produces = "application/json")
	public List<EmployeeDocumentDTO> searchByName(@PathVariable("name") String name)
			throws BackgroundVerificationException {
		logger.info("Entered searchByName method");
		return bgvService.getByName(name);

	}

	/**
	 * dowmload a document for a employee
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @throws BackgroundVerificationException
	 */

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") int id) throws BackgroundVerificationException {
		EmployeeDocumentDTO employeeDocumentDTO = bgvService.getDocument(id);
		logger.info("Entered downloadFile method");
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg"))
				.body(new ByteArrayResource(employeeDocumentDTO.getData()));
	}

	/**
	 * approve status mapping
	 * 
	 * @param id
	 * @throws BackgroundVerificationException
	 */

	@GetMapping("/approvestatus/{id}")
	public void approveStatus(@PathVariable("id") int id) throws BackgroundVerificationException {
		logger.info("Entered approveStatus method");
		bgvService.approveStatus(id);
	}

	/**
	 * reject status mapping
	 * 
	 * @param id
	 * @throws BackgroundVerificationException
	 */
	@GetMapping("/rejectstatus/{id}")
	public void rejectStatus(@PathVariable("id") int id) throws BackgroundVerificationException {
		logger.info("Entered rejectStatus method");
		bgvService.rejectStatus(id);
	}

}
