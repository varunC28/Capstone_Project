package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.ResourceUnAvailableException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.repository.AppointmentRepository;
import com.upgrad.bookmyconsultation.repository.UserRepository;
import com.upgrad.bookmyconsultation.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	
	
	//mark it autowired
	//create an instance of AppointmentRepository called appointmentRepository
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;


	//create a method name appointment with the return type of String and parameter of type Appointment
	//declare exceptions 'SlotUnavailableException' and 'InvalidInputException'
		//validate the appointment details using the validate method from ValidationUtils class
		//find if an appointment exists with the same doctor for the same date and time
		//if the appointment exists throw the SlotUnavailableException
		//save the appointment details to the database
		//return the appointment id

	public String appointment(Appointment appointment) throws SlotUnavailableException, InvalidInputException {
		ValidationUtils.validate(appointment);
		Optional<Appointment> existingAppointment = appointmentRepository.findByDoctorIdAndTimeSlotAndAppointmentDate
				(appointment.getDoctorId(), appointment.getTimeSlot(), appointment.getAppointmentDate() );
		if (existingAppointment.isPresent()) {
			throw new SlotUnavailableException();
		}

		Appointment savedAppointment = appointmentRepository.save(appointment);
		return savedAppointment.getAppointmentId();
	}


	//create a method getAppointment of type Appointment with a parameter name appointmentId of type String
		//Use the appointmentid to get the appointment details
		//if the appointment exists return the appointment
		//else throw ResourceUnAvailableException
		//tip: use Optional.ofNullable(). Use orElseThrow() method when Optional.ofNullable() throws NULL

	public Appointment getAppointment(String appointmentId) throws ResourceUnAvailableException {
		// Use the appointmentId to get the appointment details
		return Optional.ofNullable(appointmentRepository.findById(appointmentId).orElse(null))
				.orElseThrow(() -> new ResourceUnAvailableException("Appointment not found with ID: " + appointmentId));
	}

	
	public List<Appointment> getAppointmentsForUser(String userId) {
		return appointmentRepository.findByUserId(userId);
	}
}
